package com.stackroute.telemedicineconsultation.consultation;

import com.stackroute.telemedicineconsultation.consultation.controller.ConsultationController;
import com.stackroute.telemedicineconsultation.consultation.exception.ConsultationSlotNotAvailableException;
import com.stackroute.telemedicineconsultation.consultation.model.Consultation;
import com.stackroute.telemedicineconsultation.consultation.service.ConsultationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest
public class ConsultationControllerTest {

    @MockBean
    private ConsultationService consultationService;

    @Autowired
    private ConsultationController consultationController;

    @Autowired
    private MockMvc mockMvc;

    //add test case for controller getAllConsultations() of ConsultationController class
    // @Test
    // void testScheduleMedicalConsultation_ValidInput_ConsultationScheduledSuccessfully() throws ConsultationSlotNotAvailableException {
    //     // Arrange
    //     Consultation consultation = new Consultation();
    //     // Set the consultation properties

    //     Consultation scheduledConsultation = new Consultation();
    //     // Set the scheduled consultation properties

    //     when(consultationService.scheduleMedicalConsultation(consultation)).thenReturn(scheduledConsultation);

    //     // Act
    //     ResponseEntity<?> response = consultationController.scheduleMedicalConsultation(consultation);

    //     // Assert
    //     assertEquals(HttpStatus.OK, response.getStatusCode());
    //     assertEquals(scheduledConsultation, response.getBody());
    //     verify(consultationService, times(1)).scheduleMedicalConsultation(consultation);
    // }
  
    
    //add test case for controller getConsultationById() of ConsultationController class
    

    //add test case for controller scheduleConsultation() of ConsultationController class

    //add test case for controller updateConsultation() of ConsultationController class

    //add test case for controller deleteConsultation() of ConsultationController class

}
