package com.blubank.doctorappointment.model;

public class DoctorAppointment {

    private Long appointmentId;
    private String startTime;
    private String endTime;

    public DoctorAppointment() {
    }

    public DoctorAppointment(Long appointmentId, String startTime, String endTime) {
        this.appointmentId = appointmentId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "DoctorAppointment{" +
                "appointment Id=" + appointmentId +
                ", start Time='" + startTime + '\'' +
                ", end Time='" + endTime + '\'' +
                '}';
    }
}
