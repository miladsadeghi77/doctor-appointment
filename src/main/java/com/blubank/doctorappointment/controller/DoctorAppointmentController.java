package com.blubank.doctorappointment.controller;

import com.blubank.doctorappointment.dto.request.DeleteAppointmentRequestDTO;
import com.blubank.doctorappointment.dto.request.InsertAppointmentRequestDTO;
import com.blubank.doctorappointment.model.ResponseModel;
import com.blubank.doctorappointment.service.appointment.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/v1/doctor-appointment")
@RestController
public class DoctorAppointmentController {

    @Autowired
    AppointmentServiceImpl doctorAppointmentService;

    @RequestMapping(path = "/insertAppointment",method = RequestMethod.POST)
    public ResponseEntity insertAppointment(@RequestBody InsertAppointmentRequestDTO insertAppointment){

        System.out.println("POST Request.... " + insertAppointment.toString());
        ResponseModel responseModel = doctorAppointmentService.insertAppointment(insertAppointment);

        return new ResponseEntity(responseModel,null, HttpStatus.OK);
    }

   /* @RequestMapping(path = "/getAppointmentList",method = RequestMethod.GET)
    public ResponseEntity getAppointmentList(){
        //todo
        ResponseModel responseModel = doctorAppointmentService.getAppointmentList();

        return new ResponseEntity(responseModel,null, HttpStatus.OK);
    }*/

    @RequestMapping(path = "/deleteOpenAppointment",method = RequestMethod.DELETE)
    public ResponseEntity deleteOpenAppointment(@RequestBody DeleteAppointmentRequestDTO appointmentRequestDTO){
        //todo
        System.out.println("POST Request.... " + appointmentRequestDTO.toString());
        ResponseModel responseModel = doctorAppointmentService.deleteAppointment(appointmentRequestDTO);
        HttpStatus httpStatus = (HttpStatus) responseModel.getData().get(0);

        return new ResponseEntity(responseModel,null, httpStatus);
    }


}
