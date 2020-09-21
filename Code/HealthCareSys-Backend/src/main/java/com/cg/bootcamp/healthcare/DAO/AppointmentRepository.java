package com.cg.bootcamp.healthcare.DAO;

import com.cg.bootcamp.healthcare.Entity_Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AppointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}
