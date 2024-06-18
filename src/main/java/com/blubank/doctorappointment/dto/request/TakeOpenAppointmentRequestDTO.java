package com.blubank.doctorappointment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TakeOpenAppointmentRequestDTO {
    private String appointmentCode;
    private String name;
    private String phoneNumber;


    @Override
    public String toString() {
        return "TakeOpenAppointmentRequestDTO{" +
                "appointmentCode=" + appointmentCode +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
