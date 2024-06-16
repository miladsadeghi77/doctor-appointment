package com.blubank.doctorappointment.repository;

import com.blubank.doctorappointment.dao.GetAppointmentListResponseDAO;
import com.blubank.doctorappointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

    @Query("select  new com.blubank.doctorappointment.dao.GetAppointmentListResponseDAO (" +
            "a.startTime, a.endTime, a.insertDate, a.appointmentCode, a.isTaken, p.name, p.phoneNumber)" +
            " from appointment a left join patient p on a.appointmentCode = p.appointment.appointmentCode " +
            "where a.insertDate = :insertDate")
    GetAppointmentListResponseDAO getByInsertDate(LocalDate insertDate);

    @Query("select a from appointment a where a.isTaken = false and a.insertDate = :insertDate")
    List<Appointment> findByTakenFalseAndInsertDate(Date insertDate);
    @Query("from appointment a where a.isTaken = false " +
            " And a.appointmentCode = :appointmentCode")
    Boolean deleteByAppointmentCode(String appointmentCode);

    Optional<Appointment> findAppointmentByAppointmentCode(String appointmentCode);
}
