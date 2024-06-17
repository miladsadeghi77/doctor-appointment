package com.blubank.doctorappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TakenPatientAppointmentListRequestDTO {

    private String patientName;

    @Override
    public String toString() {
        return "TakenPatientAppointmentListRequestDTO{" +
                "patientName='" + patientName + '\'' +
                '}';
    }
}
