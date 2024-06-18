package com.blubank.doctorappointment.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAppointmentListResponseDAO {
    private String startTime;
    private String endTime;
    private Date insertDate;
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
