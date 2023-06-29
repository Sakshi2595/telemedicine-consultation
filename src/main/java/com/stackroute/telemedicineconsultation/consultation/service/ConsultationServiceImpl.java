package com.stackroute.telemedicineconsultation.consultation.service;

import com.stackroute.telemedicineconsultation.consultation.exception.ConsultationSlotNotAvailableException;
import com.stackroute.telemedicineconsultation.consultation.model.Consultation;
import com.stackroute.telemedicineconsultation.consultation.model.Prescription;
import com.stackroute.telemedicineconsultation.consultation.repository.ConsultationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ConsultationServiceImpl implements ConsultationService{

    @Autowired
    private ConsultationRepo consultationRepo;

    //create scheduleMedicalConsultation method which takes consultation object as input and returns the same object
    @Override
    public Consultation scheduleMedicalConsultation(Consultation consultation) throws ConsultationSlotNotAvailableException {
        consultation.setStatus("Scheduled");
        Prescription prescription = new Prescription();
        consultation.setPrescription(prescription);
        if(consultationRepo.findByDoctorId(consultation.getDoctorId()) != null &&
                consultationRepo.findByScheduledDateTime(consultation.getScheduledDateTime()) != null){
            throw new ConsultationSlotNotAvailableException("Consultation slot not available. Please choose another slot.");
        }
        Consultation cons = consultationRepo.save(consultation);
        return cons;
    }

    //create getMedicalConsultation method which takes consultationId as input and returns the consultation object
//    @Override
//    public Consultation getMedicalConsultation(int consultationId) {
//        logger.info("Getting consultation with id: " + consultationId);
//        Consultation cons = consultationRepo.findById(consultationId).get();
//        logger.info("Found consultation with id: " + consultationId);
//        return cons;
//    }
    @Override
    public Consultation getMedicalConsultation(int consultationId) {
        return consultationRepo.findById(consultationId)
                .orElseThrow(() -> new NoSuchElementException("No consultation found with ID: " + consultationId));
    }


    //create getAllMedicalConsultations method which returns list of consultation objects
    @Override
    public List<Consultation> getAllMedicalConsultations() {
      //  Consultation cons = consultationRepo.findAll().get(0);
        return consultationRepo.findAll();
    }

    //create updateMedicalConsultation method which takes consultation object as input and returns the same object
//    @Override
//    public Consultation updateMedicalConsultation(Consultation consultation, int consultationId) {
//        //implement the rest api method for updating consultation
//        Consultation cons = consultationRepo.findById(consultationId).get();
//        cons.setScheduledDateTime(consultation.getScheduledDateTime());
//        cons.setDoctorId(consultation.getDoctorId());
//        cons.setPatientId(consultation.getPatientId());
//        cons.setPrescriptions(consultation.getPrescriptions());
//        cons.setStatus(consultation.getStatus());
//        Consultation cons1 = consultationRepo.save(cons);
//        return cons1;
//    }
    @Override
    public Consultation updateMedicalConsultation(Consultation consultation, int consultationId) {
        Optional<Consultation> optionalConsultation = consultationRepo.findById(consultationId);
        if (optionalConsultation.isPresent()) {
            Consultation existingConsultation = optionalConsultation.get();
            existingConsultation.setScheduledDateTime(consultation.getScheduledDateTime());
            existingConsultation.setDoctorId(consultation.getDoctorId());
            existingConsultation.setPatientId(consultation.getPatientId());
            existingConsultation.setPrescription(consultation.getPrescription());
            existingConsultation.setStatus(consultation.getStatus());
            existingConsultation.setDiagnosis(consultation.getDiagnosis());
            Consultation updatedConsultation = consultationRepo.save(existingConsultation);
            return updatedConsultation;
        }
        return null; // Consultation with the given ID not found
    }


    //create deleteMedicalConsultation method which takes consultationId as input and returns String as "Consultation Deleted Successfully!"
    @Override
    public String deleteMedicalConsultation(int consultationId) {
        //implement the rest api method for deleting consultation
        consultationRepo.deleteById(consultationId);
        return "Consultation Deleted Successfully!";

    }

}
