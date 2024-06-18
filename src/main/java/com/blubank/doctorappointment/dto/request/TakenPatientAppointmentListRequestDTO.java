package com.blubank.doctorappointment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TakenPatientAppointmentListRequestDTO {

    private String phoneNumber;

    @Override
    public String toString() {
        return "TakenPatientAppointmentListRequestDTO{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
