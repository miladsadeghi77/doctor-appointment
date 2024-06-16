package com.blubank.doctorappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAppointmentListRequestDTO {

    private String appointmentDate;

    @Override
    public String toString() {
        return "OpenAppointmentListRequestDTO{" +
                "appointmentDate='" + appointmentDate + '\'' +
                '}';
    }
}
