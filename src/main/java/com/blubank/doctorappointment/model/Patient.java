package com.blubank.doctorappointment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "patient")
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "phoneNumber_unique",columnNames = "phone_number")
        }
)
public class Patient {
    @Id
    @SequenceGenerator(
            name = "PATIENT_SEQ",
            sequenceName = "PATIENT_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PATIENT_SEQ"
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
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "phone_number",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String phoneNumber;

    public Patient(Long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Patient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
