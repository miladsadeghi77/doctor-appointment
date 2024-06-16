package com.blubank.doctorappointment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertAppointmentRequestDTO {
    private String startTime;
    private String endTime;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd")
    private String insertDate;


    @Override
    public String toString() {
        return "InsertAppointmentRequestDTO{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", insertDate='" + insertDate + '\'' +
                '}';
    }
}
