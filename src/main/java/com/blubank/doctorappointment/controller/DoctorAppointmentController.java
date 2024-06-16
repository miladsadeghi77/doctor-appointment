package com.blubank.doctorappointment.controller;

import com.blubank.doctorappointment.dto.DeleteAppointmentRequestDTO;
import com.blubank.doctorappointment.dto.GetAppointmentListResponseDTO;
import com.blubank.doctorappointment.dto.InsertAppointmentRequestDTO;
import com.blubank.doctorappointment.dto.TakeOpenAppointmentRequestDTO;
import com.blubank.doctorappointment.model.ResponseModel;
import com.blubank.doctorappointment.service.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        HttpStatus o = (HttpStatus) responseModel.getData().get(0);

        return new ResponseEntity(responseModel,null, o);
    }

    @RequestMapping(path = "/takeOpenAppointmentList",method = RequestMethod.GET)
    public ResponseEntity takeOpenAppointmentList(@RequestBody TakeOpenAppointmentRequestDTO appointmentDTO){
        //todo
        System.out.println("POST Request.... " + appointmentDTO.toString());
        ResponseModel responseModel = doctorAppointmentService.takeOpenAppointment(appointmentDTO);

        return new ResponseEntity(responseModel,null, HttpStatus.OK);
    }
}
