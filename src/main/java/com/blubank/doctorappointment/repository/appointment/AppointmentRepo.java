package com.blubank.doctorappointment.repository.appointment;

import com.blubank.doctorappointment.dao.GetAppointmentListResponseDAO;
import com.blubank.doctorappointment.dao.GetOpenAppointmentListDAO;
import com.blubank.doctorappointment.dao.TakenPatientAppointmentListDao;
import com.blubank.doctorappointment.model.Appointment;
import com.blubank.doctorappointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

   @Query("select  new com.blubank.doctorappointment.dao.GetAppointmentListResponseDAO (" +
            "a.startTime, a.endTime, a.appointmentCode, a.isTaken, p.name, p.phoneNumber)" +
            " from appointment a left join patient p on a.patient.id = p.id " +
            "where a.insertDate = :insertDate")
    List<GetAppointmentListResponseDAO> getAppointmentByInsertDate(Date insertDate);

    @Query("select new com.blubank.doctorappointment.dao.GetOpenAppointmentListDAO( " +
            " a.startTime, a.endTime, a.appointmentCode)  from appointment a where a.isTaken = false and a.insertDate = :insertDate")
    List<GetOpenAppointmentListDAO> findByTakenFalseAndInsertDate(Date insertDate);

   /* @Query("DELETE from appointment a where a.isTaken = false And a.appointmentCode = :appointmentCode")
    Boolean removeAppointmentByAppointmentCode(String appointmentCode)*/

    @Query("select a from appointment a where a.appointmentCode = :appointmentCode ")
    Optional<Appointment> findAppointmentByAppointmentCode(String appointmentCode);

    @Query("select new com.blubank.doctorappointment.dao.TakenPatientAppointmentListDao( " +
            " a.startTime, a.endTime, a.insertDate, a.appointmentCode) from appointment a where a.patient = :patient")
    List<TakenPatientAppointmentListDao> findAppointmentByPatient(Patient patient);
}
