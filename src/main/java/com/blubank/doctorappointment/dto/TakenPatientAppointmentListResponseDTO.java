package com.blubank.doctorappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TakenPatientAppointmentListResponseDTO {

    private String startTime;
    private String endTime;
    private String insertDate;
    private String appointmentCode;

    @Override
    public String toString() {
        return "TakenPatientAppointmentListResponseDTO{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", insertDate='" + insertDate + '\'' +
                ", appointmentCode='" + appointmentCode + '\'' +
                '}';
    }
}
