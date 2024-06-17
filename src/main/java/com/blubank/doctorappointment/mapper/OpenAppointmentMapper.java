package com.blubank.doctorappointment.mapper;

import com.blubank.doctorappointment.dao.GetOpenAppointmentListDAO;
import com.blubank.doctorappointment.dto.GetOpenAppointmentListResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAppointmentMapper {

    @Autowired
    private ModelMapper modelMapper;
    public GetOpenAppointmentListResponseDTO convertToDTO(GetOpenAppointmentListDAO appointmentListDAO){
        return modelMapper.map(appointmentListDAO , GetOpenAppointmentListResponseDTO.class);
    }

    public GetOpenAppointmentListDAO convertToDAO(GetOpenAppointmentListResponseDTO appointmentListDTO){
        return modelMapper.map(appointmentListDTO , GetOpenAppointmentListDAO.class);
    }
}
