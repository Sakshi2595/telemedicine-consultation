package com.stackroute.telemedicineconsultation.consultation;

import com.stackroute.telemedicineconsultation.consultation.repository.ConsultationRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.stackroute.telemedicineconsultation.consultation.model.Consultation;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@DataJpaTest
public class ConsultationRepoTest {

    @Autowired
    private ConsultationRepo consultationRepo;

    @Autowired
    private TestEntityManager entityManager;

    //add test case for public Consultation findByDoctorId(int doctorId); method of ConsultationRepo interface
    @Test
    public void testFindByDoctorId() {
        // Create test consultations
        Consultation consultation1 = new Consultation();
        consultation1.setDoctorId(1);
        entityManager.persist(consultation1);

        Consultation consultation2 = new Consultation();
        consultation2.setDoctorId(2);
        entityManager.persist(consultation2);

        // Perform the search
        Consultation foundConsultation = consultationRepo.findByDoctorId(1);

        // Assertion
        assertNotNull(foundConsultation);
        assertEquals(1, foundConsultation.getDoctorId());
    }

    //add test case for public Consultation findByScheduledDateTime(String scheduledDateTime); method of ConsultationRepo interface
    // @Test
    // public void testFindByScheduledDateTime() {
    //     // Create test consultations
    //     Consultation consultation1 = new Consultation();
    //     //consultation1.setScheduledDateTime(LocalDateTime.parse("2021-08-01 10:00:00"));
    //     entityManager.persist(consultation1);

    //     Consultation consultation2 = new Consultation();
    //     //consultation2.setScheduledDateTime(LocalDateTime.parse("2021-08-02 10:00:00"));
    //     entityManager.persist(consultation2);

    //     // Perform the search
    //     //Consultation foundConsultation = consultationRepo.findByScheduledDateTime(LocalDateTime.parse("2021-08-01 10:00:00"));

    //     // Assertion
    //     //assertNotNull(foundConsultation);
    //     //assertEquals("2021-08-01 10:00:00", foundConsultation.getScheduledDateTime());
    // }
}
