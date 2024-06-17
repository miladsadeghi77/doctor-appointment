package com.blubank.doctorappointment.repository.patient.impl;

import com.blubank.doctorappointment.model.Patient;
import com.blubank.doctorappointment.repository.patient.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PatientRepoImpl {

    private PatientRepo patientRepo;

    @Autowired
    public PatientRepoImpl(@Lazy PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient insertPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public Optional<Patient> findPatientByPhoneNumber(String phoneNumber){
       return patientRepo.findByPhoneNumber(phoneNumber);
    }
}
