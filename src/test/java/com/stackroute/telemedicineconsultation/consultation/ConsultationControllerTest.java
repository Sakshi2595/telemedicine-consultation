// // package com.stackroute.telemedicineconsultation.consultation;

// // import com.stackroute.telemedicineconsultation.consultation.controller.ConsultationController;
// // import com.stackroute.telemedicineconsultation.consultation.exception.ConsultationSlotNotAvailableException;
// // import com.stackroute.telemedicineconsultation.consultation.model.Consultation;
// // import com.stackroute.telemedicineconsultation.consultation.service.ConsultationService;
// // import org.junit.jupiter.api.Test;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// // import org.springframework.boot.test.mock.mockito.MockBean;
// // import org.springframework.http.HttpStatus;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.test.web.servlet.MockMvc;

// // import java.time.LocalDateTime;
// // import java.util.ArrayList;
// // import java.util.List;

// // import static org.junit.Assert.assertEquals;
// // import static org.junit.jupiter.api.Assertions.assertThrows;
// // import static org.mockito.Mockito.doReturn;
// // import static org.mockito.Mockito.times;
// // import static org.mockito.Mockito.verify;
// // import static org.mockito.Mockito.when;

// // @WebMvcTest
// // public class ConsultationControllerTest {

// //     @MockBean
// //     private ConsultationService consultationService;

// //     @Autowired
// //     private ConsultationController consultationController;

// //     @Autowired
// //     private MockMvc mockMvc;

// //     //add test case for controller getAllConsultations() of ConsultationController class
    
// //     //add test case for controller getConsultationById() of ConsultationController class
    

// //     //add test case for controller scheduleConsultation() of ConsultationController class
   

// //     //add test case for controller updateConsultation() of ConsultationController class

// //     //add test case for controller deleteConsultation() of ConsultationController class

// // }
// package com.stackroute.telemedicineconsultation.consultation;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.stackroute.telemedicineconsultation.consultation.controller.ConsultationController;
// import com.stackroute.telemedicineconsultation.consultation.exception.ConsultationSlotNotAvailableException;
// import com.stackroute.telemedicineconsultation.consultation.model.Consultation;
// import com.stackroute.telemedicineconsultation.consultation.service.ConsultationService;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import java.util.ArrayList;
// import java.util.List;

// import static org.mockito.ArgumentMatchers.*;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @SpringJUnitConfig
// @WebMvcTest(ConsultationController.class)
// @SpringBootTest
// @ComponentScan("com.stackroute.telemedicineconsultation.consultation.service")
// public class ConsultationControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @Mock
//     private ConsultationService consultationService;

//     @InjectMocks
//     private ConsultationController consultationController;

//     private Consultation consultation;

//     @BeforeEach
//     public void setUp() throws ConsultationSlotNotAvailableException {
//         consultation = new Consultation();
//         // Set up the consultation object with test data
//         // ...

//         // Initialize mock behavior
//         when(consultationService.scheduleMedicalConsultation(any(Consultation.class))).thenReturn(consultation);
//         when(consultationService.getMedicalConsultation(anyInt())).thenReturn(consultation);
//         when(consultationService.getAllMedicalConsultations()).thenReturn(new ArrayList<>());
//         when(consultationService.updateMedicalConsultation(any(Consultation.class), anyInt())).thenReturn(consultation);
//         when(consultationService.deleteMedicalConsultation(anyInt())).thenReturn("Consultation deleted");
//     }

//     @Test
//     public void scheduleMedicalConsultation_Success() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/consultation")
//                 .content(asJsonString(consultation))
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .accept(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
//     }

//     @Test
//     public void getMedicalConsultation_Success() throws Exception {
//         int consultationId = 1;
//         mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/consultation/{consultationId}", consultationId)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .accept(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(consultationId));
//     }

//     @Test
//     public void getAllMedicalConsultations_Success() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/consultation/all")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .accept(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(0));
//     }

//     @Test
//     public void updateMedicalConsultation_Success() throws Exception {
//         int consultationId = 1;
//         mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/consultation/{consultationId}", consultationId)
//                 .content(asJsonString(consultation))
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .accept(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(consultationId));
//     }

//     @Test
//     public void deleteMedicalConsultation_Success() throws Exception {
//         int consultationId = 1;
//         mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/consultation/{consultationId}", consultationId)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .accept(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(consultationId));
//     }

//     private static String asJsonString(final Object obj) {
//         try {
//             return new ObjectMapper().writeValueAsString(obj);
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//     }
// }

