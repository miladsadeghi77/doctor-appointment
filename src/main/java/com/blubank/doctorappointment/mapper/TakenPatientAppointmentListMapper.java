package com.blubank.doctorappointment.mapper;

import com.blubank.doctorappointment.dao.TakenPatientAppointmentListDao;
import com.blubank.doctorappointment.dto.TakenPatientAppointmentListResponseDTO;
import com.blubank.doctorappointment.util.AppointmentUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TakenPatientAppointmentListMapper {
    @Autowired
    private ModelMapper modelMapper;

    public TakenPatientAppointmentListResponseDTO convertToDTO(TakenPatientAppointmentListDao appointmentListDAO){
        String insertDate = AppointmentUtil.dateToString(appointmentListDAO.getInsertDate());

        TypeMap<TakenPatientAppointmentListDao, TakenPatientAppointmentListResponseDTO> propertyMapper =
               modelMapper.createTypeMap(TakenPatientAppointmentListDao.class, TakenPatientAppointmentListResponseDTO.class);
        propertyMapper.addMapping(TakenPatientAppointmentListDao::getInsertDate, TakenPatientAppointmentListResponseDTO::setInsertDate);
       
        return modelMapper.map(appointmentListDAO , TakenPatientAppointmentListResponseDTO.class);
    }

    public TakenPatientAppointmentListDao convertToDAO(TakenPatientAppointmentListResponseDTO appointmentListDTO){
        return modelMapper.map(appointmentListDTO , TakenPatientAppointmentListDao.class);
    }
}
