package com.blubank.doctorappointment.repository.patient.impl;

import com.blubank.doctorappointment.model.Patient;
import com.blubank.doctorappointment.repository.patient.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepoImpl {

    private PatientRepo patientRepo;

    @Autowired
    public PatientRepoImpl(@Lazy PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient insertPatient(Patient patient) {s
        return patientRepo.save(patient);
    }
}
