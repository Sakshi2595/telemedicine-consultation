package com.stackroute.telemedicineconsultation.consultation.repository;

import com.stackroute.telemedicineconsultation.consultation.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepo extends JpaRepository<Consultation, Integer> {
    //create findByDoctorId method for finding consultation by doctorId
    public Consultation findByDoctorId(int doctorId);

    //create findByScheduledDateTime method for finding consultation by scheduledDateTime
    public Consultation findByScheduledDateTime(String scheduledDateTime);


}
