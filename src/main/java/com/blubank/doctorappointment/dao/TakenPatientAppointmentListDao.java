package com.blubank.doctorappointment.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TakenPatientAppointmentListDao {

    private String startTime;
    private String endTime;
    private Date insertDate;
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
