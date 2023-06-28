package com.stackroute.telemedicineconsultation.consultation.service;

import com.stackroute.telemedicineconsultation.consultation.exception.ConsultationSlotNotAvailableException;
import com.stackroute.telemedicineconsultation.consultation.model.Consultation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultationService {
    //create scheduleMedicalConsultation method which takes consultation object as input and returns the same object
    Consultation scheduleMedicalConsultation(Consultation consultation) throws ConsultationSlotNotAvailableException;

    //create getMedicalConsultation method which takes consultationId as input and returns the consultation object
    Consultation getMedicalConsultation(int consultationId);

    //create getAllMedicalConsultations method which returns list of consultation objects
    List<Consultation> getAllMedicalConsultations();

    //create updateMedicalConsultation method which takes consultation object as input and returns the same object
    Consultation updateMedicalConsultation(Consultation consultation, int consultationId);

    //create deleteMedicalConsultation method which takes consultationId as input and returns String as "Consultation Deleted Successfully!"
    String deleteMedicalConsultation(int consultationId);

}
