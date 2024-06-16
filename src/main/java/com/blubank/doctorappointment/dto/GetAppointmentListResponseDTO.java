package com.blubank.doctorappointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAppointmentListResponseDTO {
    private String startTime;
    private String endTime;
    private String insertDate;
    private String appointmentCode;
    private boolean isTaken;
    private String patientName;
    private String patientPhoneNumber;

    @Override
    public String toString() {
        return "GetAppointmentListResponseDTO{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", insertDate='" + insertDate + '\'' +
                ", appointmentCode='" + appointmentCode + '\'' +
                ", isTaken=" + isTaken +
                ", patientName='" + patientName + '\'' +
                ", patientPhoneNumber='" + patientPhoneNumber + '\'' +
                '}';
    }
}
