package com.blubank.doctorappointment.service.appointment.impl;

import com.blubank.doctorappointment.dao.GetOpenAppointmentListDAO;
import com.blubank.doctorappointment.dao.TakenPatientAppointmentListDao;
import com.blubank.doctorappointment.dto.*;
import com.blubank.doctorappointment.enums.ResponseStatus;
import com.blubank.doctorappointment.mapper.TakenPatientAppointmentListMapper;
import com.blubank.doctorappointment.model.Appointment;
import com.blubank.doctorappointment.model.Patient;
import com.blubank.doctorappointment.model.ResponseModel;
import com.blubank.doctorappointment.repository.appointment.impl.AppointmentRepoImpl;
import com.blubank.doctorappointment.service.appointment.AppointmentService;
import com.blubank.doctorappointment.service.patient.impl.PatientServiceImpl;
import com.blubank.doctorappointment.util.AppointmentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepoImpl appointmentRepoImpl;
    private PatientServiceImpl patientServiceImpl;
    private TakenPatientAppointmentListMapper takenPatientAppointmentListMapper;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepoImpl appointmentRepoImpl, PatientServiceImpl patientServiceImpl, TakenPatientAppointmentListMapper takenPatientAppointmentListMapper) {
        this.appointmentRepoImpl = appointmentRepoImpl;
        this.patientServiceImpl = patientServiceImpl;
        this.takenPatientAppointmentListMapper = takenPatientAppointmentListMapper;
    }

    private final int THIRTY_MINUTES_PERIODS = 30;

    @Transactional
    @Override
    public ResponseModel insertAppointment(InsertAppointmentRequestDTO insertAppointmentRequestDTO) {
        ResponseModel responseModel = new ResponseModel();
        List<Appointment> appointmentList = new ArrayList<>();
        String date = insertAppointmentRequestDTO.getInsertDate();
        Date insertDate = AppointmentUtil.dateToString(date);

        LocalTime startTime = LocalTime.parse(insertAppointmentRequestDTO.getStartTime());
        LocalTime endTime = LocalTime.parse(insertAppointmentRequestDTO.getEndTime());

        if (startTime.isAfter(endTime) || (startTime.compareTo(endTime) == 0)) {
            responseModel.setData(null);
            responseModel.setStatus(ResponseStatus.ERROR.getStatus());
            responseModel.setMessage("Start Time is After or same as End time");
            return responseModel;
        }
        long remindMinuteTime = Duration.between(startTime, endTime).toMinutes();
        long countOfAppointment = remindMinuteTime / THIRTY_MINUTES_PERIODS;

        LocalTime tempStartTime = startTime;
        LocalTime tempEndTime = tempStartTime.plusMinutes(THIRTY_MINUTES_PERIODS);

        for (int i = 0; i < countOfAppointment; i++) {
            Appointment appointment =
                    new Appointment(
                            tempStartTime.toString(),
                            tempEndTime.toString(),
                            AppointmentUtil.generatedAppointmentCode(),
                            false,
                            insertDate
                    );
            appointmentList.add(appointment);

            tempStartTime = tempStartTime.plusMinutes(THIRTY_MINUTES_PERIODS);
            tempEndTime = tempStartTime.plusMinutes(THIRTY_MINUTES_PERIODS);
        }

        boolean isInsertedAllAppointments = appointmentRepoImpl.insertAllAppointment(appointmentList);
        if (!isInsertedAllAppointments) {
            responseModel.setData(null);
            responseModel.setStatus(ResponseStatus.ERROR.getStatus());
            responseModel.setMessage("All Appointments was not inserted!");
            return responseModel;
        }

        responseModel.setData(null);
        responseModel.setMessage(countOfAppointment + " Appointment was added");
        responseModel.setStatus(ResponseStatus.SUCCESS.getStatus());
        return responseModel;
    }

    @Override
    public ResponseModel deleteAppointment(DeleteAppointmentRequestDTO deleteAppointmentRequestDTO) {
        ResponseModel responseModel = new ResponseModel();

        String appointmentCode = deleteAppointmentRequestDTO.getAppointmentCode();
        Optional<Appointment> openAppointment = appointmentRepoImpl.findAppointmentByAppointmentCode(appointmentCode);

        if (openAppointment.isPresent() && !openAppointment.get().isTaken()) {
            appointmentRepoImpl.deleteOpenAppointmentById(openAppointment.get().getId());
            responseModel.setData(Collections.singletonList(HttpStatus.OK));
            responseModel.setMessage("Appointment was Deleted");
            responseModel.setStatus(ResponseStatus.SUCCESS.getStatus());

        } else if (openAppointment.isPresent() && openAppointment.get().isTaken()) {
            responseModel.setData(Collections.singletonList(HttpStatus.NOT_ACCEPTABLE));
            responseModel.setMessage("Not Found Open Appointment");
            responseModel.setStatus(ResponseStatus.SUCCESS.getStatus());

        } else {
            responseModel.setData(Collections.singletonList(HttpStatus.NOT_FOUND));
            responseModel.setMessage("Not Found Appointment With The Appointment Code ");
            responseModel.setStatus(ResponseStatus.SUCCESS.getStatus());
        }
        return responseModel;

    }

    @Async
    @Transactional
    @Override
    public ResponseModel takeOpenAppointment(TakeOpenAppointmentRequestDTO takeOpenAppointmentRequestDTO) {
        ResponseModel responseModel = new ResponseModel();
        Optional<Appointment> openAppointment =
                appointmentRepoImpl.findAppointmentByAppointmentCode(takeOpenAppointmentRequestDTO.getAppointmentCode());

        if (openAppointment.isPresent() && openAppointment.get().isTaken()) {
            responseModel.setData(null);
            responseModel.setMessage("Not Found Open Appointment");
            responseModel.setStatus(ResponseStatus.SUCCESS.getStatus());
            return responseModel;

        } else if (!openAppointment.isPresent()) {
            responseModel.setData(null);
            responseModel.setMessage("Not Found Appointment With The Appointment Code ");
            responseModel.setStatus(ResponseStatus.SUCCESS.getStatus());
            return responseModel;
        }

        Patient patient = insertPatient(takeOpenAppointmentRequestDTO);
        openAppointment.get().setTaken(true);
        openAppointment.get().setPatient(patient);
        appointmentRepoImpl.insertAppointment(openAppointment.get());
        String insertDate = AppointmentUtil.dateToString(openAppointment.get().getInsertDate());
        StringBuilder sb = new StringBuilder();
        sb.append(" Patient take appointment: ")
                .append(openAppointment.get().getStartTime())
                .append(" - ")
                .append(openAppointment.get().getEndTime())
                .append(" On ")
                .append(insertDate);

        responseModel.setData(null);
        responseModel.setMessage(sb.toString());
        responseModel.setStatus(ResponseStatus.SUCCESS.getStatus());
        return responseModel;
    }


    @Override
    public ResponseModel getOpenAppointmentList(OpenAppointmentListRequestDTO openAppointmentListRequestDTO) {
        ResponseModel responseModel = new ResponseModel();
        List<GetOpenAppointmentListDAO> appointmentList = new ArrayList<>();
        String date = openAppointmentListRequestDTO.getAppointmentDate();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date insertDate = null;
        try {
            insertDate = formatter.parse(date);
            appointmentList = appointmentRepoImpl.getOpenAppointmentList(insertDate);

        } catch (ParseException ignore) {
        }
        responseModel.setData(appointmentList);
        responseModel.setMessage("Open Appointment list");
        responseModel.setStatus(ResponseStatus.SUCCESS.getStatus());
        return responseModel;
    }

    @Override
    public ResponseModel getTakenPatientAppointmentList(
            TakenPatientAppointmentListRequestDTO takenPatientAppointmentListRequestDTO) {
        ResponseModel responseModel = new ResponseModel();
        List<TakenPatientAppointmentListResponseDTO> appointmentDTOList = new ArrayList<>();

        Optional<Patient> patient = patientServiceImpl.findPatientByPhoneNumber(takenPatientAppointmentListRequestDTO.getPatientName());
        if (patient.isPresent()) {
            List<TakenPatientAppointmentListDao> appointmentDAOList =
                    appointmentRepoImpl.findAppointmentByPatient(patient.get());

            for (TakenPatientAppointmentListDao appointmentDAO : appointmentDAOList) {
                appointmentDTOList.add(takenPatientAppointmentListMapper.convertToDTO(appointmentDAO));
            }

            responseModel.setMessage("Found " + appointmentDTOList.size() + " Number");
        } else {
            responseModel.setMessage("Not Found Any Appointment With phoneNumber ");
        }
        responseModel.setData(appointmentDTOList);
        responseModel.setStatus(ResponseStatus.SUCCESS.getStatus());
        return responseModel;
    }

    private Patient insertPatient(TakeOpenAppointmentRequestDTO takeOpenAppointmentRequestDTO) {
        Patient patientBeforeInsert = new Patient();
        patientBeforeInsert.setName(takeOpenAppointmentRequestDTO.getName());
        patientBeforeInsert.setPhoneNumber(takeOpenAppointmentRequestDTO.getPhoneNumber());
        return patientServiceImpl.insertPatient(patientBeforeInsert);
    }

}
