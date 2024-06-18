package com.blubank.doctorappointment.mapper;

import com.blubank.doctorappointment.dao.TakenPatientAppointmentListDao;
import com.blubank.doctorappointment.dto.response.TakenPatientAppointmentListResponseDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TakenPatientAppointmentListMapper {
    @Autowired
    private ModelMapper modelMapper;

    public TakenPatientAppointmentListResponseDTO convertToDTO(TakenPatientAppointmentListDao appointmentListDAO){

        TypeMap<TakenPatientAppointmentListDao, TakenPatientAppointmentListResponseDTO> propertyMapper =
               modelMapper.createTypeMap(TakenPatientAppointmentListDao.class, TakenPatientAppointmentListResponseDTO.class);
        propertyMapper.addMapping(TakenPatientAppointmentListDao::getInsertDate, TakenPatientAppointmentListResponseDTO::setInsertDate);
       
        return modelMapper.map(appointmentListDAO , TakenPatientAppointmentListResponseDTO.class);
    }

    public TakenPatientAppointmentListDao convertToDAO(TakenPatientAppointmentListResponseDTO appointmentListDTO){
        return modelMapper.map(appointmentListDTO , TakenPatientAppointmentListDao.class);
    }
}
