package com.blubank.doctorappointment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity(name = "appointment")
@Table(
        name = "appointment",
        uniqueConstraints = {
                @UniqueConstraint(name = "appointment_code_unique",columnNames = "appointment_code")
        }
)
public class Appointment {

    @Id
    @SequenceGenerator(
            name = "APPOINTMENT_SEQ",
            sequenceName = "APPOINTMENT_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "APPOINTMENT_SEQ"
    )
    @Column(
            name = "id",
            updatable = false,
            unique = true,
            nullable = false
    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    @Column(
            name = "start_time",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String startTime;

    @Column(
            name = "end_time",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String endTime;

    @Column(
            name = "appointment_code",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String appointmentCode;

    @Column(
            name = "is_taken",
            nullable = false
    )
    private boolean isTaken;


    @Column(
            name = "insert_date",
            nullable = false
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "patient_id",
            referencedColumnName = "id"
    )
    private Patient patient;


    public Appointment() {
    }


    public Appointment(String startTime, String endTime, String appointmentCode, boolean isTaken, Date insertDate) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.appointmentCode = appointmentCode;
        this.isTaken = isTaken;
        this.insertDate = insertDate;
    }

    public Appointment(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Appointment(String startTime, String endTime, String appointmentCode, boolean isTaken, Date insertDate, Patient patient) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.appointmentCode = appointmentCode;
        this.isTaken = isTaken;
        this.insertDate = insertDate;
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getAppointmentCode() {
        return appointmentCode;
    }

    public void setAppointmentCode(String appointmentCode) {
        this.appointmentCode = appointmentCode;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long appointmentId) {
        this.id = appointmentId;
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

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", appointmentCode='" + appointmentCode + '\'' +
                ", isTaken=" + isTaken +
                ", insertDate=" + insertDate +
                ", patient=" + patient +
                '}';
    }
}
