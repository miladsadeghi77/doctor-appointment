package com.blubank.doctorappointment.service.patient.impl;

import com.blubank.doctorappointment.model.Patient;
import com.blubank.doctorappointment.repository.patient.impl.PatientRepoImpl;
import com.blubank.doctorappointment.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepoImpl patientRepoImpl;

    @Autowired
    public PatientServiceImpl(PatientRepoImpl patientRepoImpl) {
        this.patientRepoImpl = patientRepoImpl;
    }

    public Patient insertPatient(Patient patient){
        return  patientRepoImpl.insertPatient(patient);
    }

    public Patient insertPatient(String name, String phoneNumber){
        Patient patientBeforeInsert = new Patient();
        patientBeforeInsert.setName(name);
        patientBeforeInsert.setPhoneNumber(phoneNumber);
        return  patientRepoImpl.insertPatient(patientBeforeInsert);
    }

    public Optional<Patient> findPatientByPhoneNumber(String phoneNumber){
        return patientRepoImpl.findPatientByPhoneNumber(phoneNumber);
    }
}
