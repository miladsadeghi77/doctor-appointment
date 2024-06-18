package com.blubank.doctorappointment.mapper;

import com.blubank.doctorappointment.dao.GetAppointmentListResponseDAO;
import com.blubank.doctorappointment.dto.response.GetAppointmentListResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAppointmentListMapper {

    private ModelMapper modelMapper;
    @Autowired
    public GetAppointmentListMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GetAppointmentListResponseDTO convertToDTO(GetAppointmentListResponseDAO appointmentListDAO){
        return modelMapper.map(appointmentListDAO , GetAppointmentListResponseDTO.class);
    }


    public GetAppointmentListResponseDAO convertToDAO(GetAppointmentListResponseDTO appointmentListDTO){
        return modelMapper.map(appointmentListDTO , GetAppointmentListResponseDAO.class);
    }
}
