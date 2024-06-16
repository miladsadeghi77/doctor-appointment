package com.blubank.doctorappointment.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOpenAppointmentListDAO {
    private String startTime;
    private String endTime;
    private String appointmentCode;

    @Override
    public String toString() {
        return "GetOpenAppointmentListDAO{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", appointmentCode='" + appointmentCode + '\'' +
                '}';
    }
}
