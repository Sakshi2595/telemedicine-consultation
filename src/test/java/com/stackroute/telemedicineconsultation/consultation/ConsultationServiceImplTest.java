package com.stackroute.telemedicineconsultation.consultation;

import com.stackroute.telemedicineconsultation.consultation.exception.ConsultationSlotNotAvailableException;
import com.stackroute.telemedicineconsultation.consultation.model.Consultation;
import com.stackroute.telemedicineconsultation.consultation.repository.ConsultationRepo;
import com.stackroute.telemedicineconsultation.consultation.service.ConsultationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class ConsultationServiceImplTest {

    @Autowired
    private ConsultationService consultationService;

    @MockBean
    private ConsultationRepo consultationRepo;

    //add test case for scheduleConsultation() method of ConsultationServiceImpl class
    @Test
    public void testScheduleConsultation() throws ConsultationSlotNotAvailableException {
        // Prepare test data
        Consultation consultation = new Consultation();
        consultation.setId(1);
        consultation.setPatientId(1);
        consultation.setDoctorId(12);
        consultation.setScheduledDateTime("2021-06-21 10:00:00");
        consultation.setStatus("Scheduled");

        // Configure mock repository
        doReturn(consultation).when(consultationRepo).save(consultation);

        // Call the service method
        Consultation result = consultationService.scheduleMedicalConsultation(consultation);

        // Verify the repository method is called
        verify(consultationRepo).save(consultation);

        // Assert the result
        assertEquals(1, result.getId());
        assertEquals(1, result.getPatientId());
        assertEquals(12, result.getDoctorId());
        assertEquals("2021-06-21 10:00:00", result.getScheduledDateTime());
        assertEquals("Scheduled", result.getStatus());

    }

    //add test case for getMedicalConsultation() method of ConsultationServiceImpl class
    @Test
    public void testGetMedicalConsultation() {
        // Prepare test data
        Consultation consultation = new Consultation();
        consultation.setId(1);
        consultation.setPatientId(1);
        consultation.setDoctorId(12);
        consultation.setScheduledDateTime("2021-06-21 10:00:00");
        consultation.setStatus("Scheduled");

        // Configure mock repository
        doReturn(Optional.of(consultation)).when(consultationRepo).findById(1);

        // Call the service method
        Optional<Consultation> result = Optional.ofNullable(consultationService.getMedicalConsultation(1));

        // Verify the repository method is called
        verify(consultationRepo).findById(1);

        // Assert the result
        assertEquals(1, result.get().getId());
        assertEquals(1, result.get().getPatientId());
        assertEquals(12, result.get().getDoctorId());
        assertEquals("2021-06-21 10:00:00", result.get().getScheduledDateTime());
        assertEquals("Scheduled", result.get().getStatus());
    }

    //add test case for getAllMedicalConsultations() method of ConsultationServiceImpl class
    @Test
    public void testGetAllMedicalConsultations() throws ConsultationSlotNotAvailableException {
        // Prepare test data
        Consultation consultation = new Consultation();
        consultation.setId(1);
        consultation.setPatientId(1);
        consultation.setDoctorId(12);
        consultation.setScheduledDateTime("2021-06-21 10:00:00");
        consultation.setStatus("Scheduled");

        // Configure mock repository
        doReturn(consultation).when(consultationRepo).save(consultation);

        // Call the service method
        Consultation result = consultationService.scheduleMedicalConsultation(consultation);

        // Verify the repository method is called
        verify(consultationRepo).save(consultation);

        // Assert the result
        assertEquals(1, result.getId());
        assertEquals(1, result.getPatientId());
        assertEquals(12, result.getDoctorId());
        assertEquals("2021-06-21 10:00:00", result.getScheduledDateTime());
        assertEquals("Scheduled", result.getStatus());
    }

    //add test case for updateMedicalConsultation() method of ConsultationServiceImpl class
    @Test
    public void testUpdateMedicalConsultation() {
        // Prepare test data
        Consultation consultation = new Consultation();
        consultation.setId(1);
        consultation.setPatientId(1);
        consultation.setDoctorId(12);
        consultation.setScheduledDateTime("2021-06-21 10:00:00");
        consultation.setStatus("Scheduled");

        // Configure mock repository
        doReturn(Optional.of(consultation)).when(consultationRepo).findById(1);

        // Call the service method
        Optional<Consultation> result = Optional.ofNullable(consultationService.getMedicalConsultation(1));

        // Verify the repository method is called
        verify(consultationRepo).findById(1);

        // Assert the result
        assertEquals(1, result.get().getId());
        assertEquals(1, result.get().getPatientId());
        assertEquals(12, result.get().getDoctorId());
        assertEquals("2021-06-21 10:00:00", result.get().getScheduledDateTime());
        assertEquals("Scheduled", result.get().getStatus());
    }

    //add test case for deleteMedicalConsultation() method of ConsultationServiceImpl class
    @Test
    public void testDeleteMedicalConsultation() {
        // Prepare test data
        Consultation consultation = new Consultation();
        consultation.setId(1);
        consultation.setPatientId(1);
        consultation.setDoctorId(12);
        consultation.setScheduledDateTime("2021-06-21 10:00:00");
        consultation.setStatus("Scheduled");

        // Configure mock repository
        doReturn(Optional.of(consultation)).when(consultationRepo).findById(1);

        // Call the service method
        Optional<Consultation> result = Optional.ofNullable(consultationService.getMedicalConsultation(1));

        // Verify the repository method is called
        verify(consultationRepo).findById(1);

        // Assert the result
        assertEquals(1, result.get().getId());
        assertEquals(1, result.get().getPatientId());
        assertEquals(12, result.get().getDoctorId());
        assertEquals("2021-06-21 10:00:00", result.get().getScheduledDateTime());
        assertEquals("Scheduled", result.get().getStatus());
    }

    @Test
    void testDeleteMedicalConsultation_ValidConsultationId_ConsultationDeletedSuccessfully() {
        // Arrange
        int consultationId = 1;

        // Act
        String result = consultationService.deleteMedicalConsultation(consultationId);

        // Assert
        assertEquals("Consultation Deleted Successfully!", result);
        verify(consultationRepo, times(1)).deleteById(consultationId);
    }


}
