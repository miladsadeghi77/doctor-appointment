package com.blubank.doctorappointment.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor

public class GetAppointmentListResponseDAO {
    private String startTime;
    private String endTime;
    private Date insertDate;
    private String appointmentCode;
    private boolean isTaken;
    private String patientName;
    private String patientPhoneNumber;

    public GetAppointmentListResponseDAO(String startTime, String endTime, Date insertDate, String appointmentCode, boolean isTaken, String patientName, String patientPhoneNumber) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.insertDate = insertDate;
        this.appointmentCode = appointmentCode;
        this.isTaken = isTaken;
        this.patientName = patientName;
        this.patientPhoneNumber = patientPhoneNumber;
    }

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
