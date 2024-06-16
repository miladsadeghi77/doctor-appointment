package com.blubank.doctorappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TakeOpenAppointmentRequestDTO {
    private Long appointmentId;
    private String name;
    private String phoneNumber;


    @Override
    public String toString() {
        return "TakeOpenAppointmentRequestDTO{" +
                "appointmentId=" + appointmentId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
