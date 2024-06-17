package com.blubank.doctorappointment.service.appointment;

import com.blubank.doctorappointment.dto.DeleteAppointmentRequestDTO;
import com.blubank.doctorappointment.dto.InsertAppointmentRequestDTO;
import com.blubank.doctorappointment.dto.OpenAppointmentListRequestDTO;
import com.blubank.doctorappointment.dto.TakeOpenAppointmentRequestDTO;
import com.blubank.doctorappointment.model.ResponseModel;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService  {

    ResponseModel insertAppointment(InsertAppointmentRequestDTO insertAppointmentRequestDTO);
    ResponseModel deleteAppointment(DeleteAppointmentRequestDTO deleteAppointmentRequestDTO);

    ResponseModel takeOpenAppointment(TakeOpenAppointmentRequestDTO takeOpenAppointmentRequestDTO);

    ResponseModel openAppointmentList(OpenAppointmentListRequestDTO openAppointmentListRequestDTO);
}
