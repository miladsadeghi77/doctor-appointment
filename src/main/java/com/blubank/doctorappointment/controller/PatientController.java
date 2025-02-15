package com.blubank.doctorappointment.controller;

import com.blubank.doctorappointment.dto.request.OpenAppointmentListRequestDTO;
import com.blubank.doctorappointment.dto.request.TakeOpenAppointmentRequestDTO;
import com.blubank.doctorappointment.dto.request.TakenPatientAppointmentListRequestDTO;
import com.blubank.doctorappointment.model.response.ResponseModel;
import com.blubank.doctorappointment.service.appointment.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/v1/patient")
@RestController
public class PatientController {

    AppointmentServiceImpl doctorAppointmentService;
    @Autowired
    public PatientController(AppointmentServiceImpl doctorAppointmentService) {
        this.doctorAppointmentService = doctorAppointmentService;
    }

    @RequestMapping(path = "/getOpenAppointmentList",method = RequestMethod.GET)
    public ResponseEntity getOpenAppointmentList(@RequestBody OpenAppointmentListRequestDTO openAppointmentList){

        ResponseModel responseModel = doctorAppointmentService.getOpenAppointmentList(openAppointmentList);
        return new ResponseEntity(responseModel,null, HttpStatus.OK);
    }

    @RequestMapping(path = "/takeOpenAppointment",method = RequestMethod.POST)
    public ResponseEntity takeOpenAppointment(@RequestBody TakeOpenAppointmentRequestDTO appointmentDTO){

        ResponseModel responseModel = doctorAppointmentService.takeOpenAppointment(appointmentDTO);
        return new ResponseEntity(responseModel,null, HttpStatus.OK);
    }
    @RequestMapping(path = "/getTakenPatientAppointmentList",method = RequestMethod.GET)
    public ResponseEntity getTakenPatientAppointmentList(
            @RequestBody TakenPatientAppointmentListRequestDTO takenPatientAppointmentListRequestDTO){

        ResponseModel responseModel = doctorAppointmentService.getTakenPatientAppointmentList(takenPatientAppointmentListRequestDTO);
        return new ResponseEntity(responseModel,null, HttpStatus.OK);
    }
}
