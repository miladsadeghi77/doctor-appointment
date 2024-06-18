package com.blubank.doctorappointment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOpenAppointmentListResponseDTO {
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
