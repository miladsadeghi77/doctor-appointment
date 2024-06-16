package com.blubank.doctorappointment.service;

import com.blubank.doctorappointment.dto.*;
import com.blubank.doctorappointment.model.ResponseModel;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService  {

    ResponseModel insertAppointment(InsertAppointmentRequestDTO insertAppointmentRequestDTO);
    ResponseModel deleteAppointment(DeleteAppointmentRequestDTO deleteAppointmentRequestDTO);

    ResponseModel takeOpenAppointment(TakeOpenAppointmentRequestDTO takeOpenAppointmentRequestDTO);

    ResponseModel openAppointmentList(OpenAppointmentListRequestDTO openAppointmentListRequestDTO);
}
