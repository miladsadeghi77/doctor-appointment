package com.blubank.doctorappointment.controller;

import com.blubank.doctorappointment.dto.DeleteAppointmentRequestDTO;
import com.blubank.doctorappointment.dto.InsertAppointmentRequestDTO;
import com.blubank.doctorappointment.dto.OpenAppointmentListRequestDTO;
import com.blubank.doctorappointment.dto.TakeOpenAppointmentRequestDTO;
import com.blubank.doctorappointment.model.ResponseModel;
import com.blubank.doctorappointment.service.impl.AppointmentServiceImpl;
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

    @Autowired
    AppointmentServiceImpl doctorAppointmentService;

    @RequestMapping(path = "/getDoctorOpenAppointmentList",method = RequestMethod.GET)
    public ResponseEntity getDoctorOpenAppointmentList(@RequestBody OpenAppointmentListRequestDTO openAppointmentList){

        System.out.println("POST Request.... " + openAppointmentList.toString());
        ResponseModel responseModel = doctorAppointmentService.openAppointmentList(openAppointmentList);

        return new ResponseEntity(responseModel,null, HttpStatus.OK);
    }

}
