package com.blubank.doctorappointment.service.patient.impl;

import com.blubank.doctorappointment.model.Patient;
import com.blubank.doctorappointment.repository.patient.impl.PatientRepoImpl;
import com.blubank.doctorappointment.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
