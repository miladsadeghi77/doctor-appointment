package com.blubank.doctorappointment.repository.appointment.impl;

import com.blubank.doctorappointment.dao.GetAppointmentListResponseDAO;
import com.blubank.doctorappointment.dao.GetOpenAppointmentListDAO;
import com.blubank.doctorappointment.dao.TakenPatientAppointmentListDao;
import com.blubank.doctorappointment.model.Appointment;
import com.blubank.doctorappointment.model.Patient;
import com.blubank.doctorappointment.repository.appointment.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class AppointmentRepoImpl {

    private AppointmentRepo appointmentRepo;

    @Autowired
    public AppointmentRepoImpl(@Lazy AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    public Appointment insertAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public boolean insertAllAppointment(List<Appointment> appointmentList) {
        boolean flag = false;
        try {
            appointmentRepo.saveAll(appointmentList);
            flag = true;
        } catch (Exception ignore) {
        } finally {
            return flag;
        }
    }

    public List<GetOpenAppointmentListDAO> getOpenAppointmentList(Date insertDate) {
        List<GetOpenAppointmentListDAO> appointmentList = appointmentRepo.findByTakenFalseAndInsertDate(insertDate);
        return appointmentList;
    }

    public Optional<Appointment> findAppointmentByAppointmentCode(String appointmentCode) {
        Optional<Appointment> appointment = appointmentRepo.findAppointmentByAppointmentCode(appointmentCode);
        return appointment;
    }

    public List<TakenPatientAppointmentListDao> findAppointmentByPatient(Patient patient) {
        return appointmentRepo.findAppointmentByPatient(patient);
    }

    public void deleteOpenAppointmentById(Long appointmentId) {
        try {
            appointmentRepo.deleteById(appointmentId);
        } catch (Exception ignore) {
        }
    }

    public List<GetAppointmentListResponseDAO> getAppointmentByInsertDate(Date insertDate) {
        return appointmentRepo.getAppointmentByInsertDate(insertDate);
    }
}
