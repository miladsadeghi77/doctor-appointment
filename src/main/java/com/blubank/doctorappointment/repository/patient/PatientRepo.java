package com.blubank.doctorappointment.repository.patient;

import com.blubank.doctorappointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {

    Optional<Patient> findByPhoneNumber(String phoneNumber);
}
