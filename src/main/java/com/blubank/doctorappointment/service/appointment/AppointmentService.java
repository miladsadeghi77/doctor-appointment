package com.blubank.doctorappointment.service.appointment;

import com.blubank.doctorappointment.dto.request.*;
import com.blubank.doctorappointment.model.response.ResponseModel;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService  {

    ResponseModel insertAppointment(InsertAppointmentRequestDTO insertAppointmentRequestDTO);
    ResponseModel deleteAppointment(DeleteAppointmentRequestDTO deleteAppointmentRequestDTO);
    ResponseModel getAppointmentList(OpenAppointmentListRequestDTO openAppointmentListRequestDTO);
    ResponseModel takeOpenAppointment(TakeOpenAppointmentRequestDTO takeOpenAppointmentRequestDTO);
    ResponseModel getOpenAppointmentList(OpenAppointmentListRequestDTO openAppointmentListRequestDTO);
    ResponseModel getTakenPatientAppointmentList(TakenPatientAppointmentListRequestDTO takenPatientAppointmentListRequestDTO);
}
