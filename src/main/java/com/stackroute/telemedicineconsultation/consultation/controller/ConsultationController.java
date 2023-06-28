package com.stackroute.telemedicineconsultation.consultation.controller;

import com.stackroute.telemedicineconsultation.consultation.exception.ConsultationSlotNotAvailableException;
import com.stackroute.telemedicineconsultation.consultation.model.Consultation;
import com.stackroute.telemedicineconsultation.consultation.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/consultation")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    //create post mapping for scheduleMedicalConsultation method with url /api/v1/consultation which take parameter as Consultation object and return the response as ResponseEntity
    @PostMapping
    public ResponseEntity<?> scheduleMedicalConsultation(@RequestBody Consultation consultation) throws ConsultationSlotNotAvailableException {
        //call scheduleMedicalConsultation method from service and return the response as ResponseEntity
        Consultation consultation1 = consultationService.scheduleMedicalConsultation(consultation);
        return ResponseEntity.ok(consultation1);
    }
    //create get mapping for getMedicalConsultation method with url /api/v1/consultation/{consultationId} and return the response as ResponseEntity
    @GetMapping("/{consultationId}")
    public ResponseEntity<?> getMedicalConsultation(@PathVariable int consultationId){
        return new ResponseEntity<>(consultationService.getMedicalConsultation(consultationId), HttpStatus.OK);
    }
    //create get mapping for getAllMedicalConsultations method with url /api/v1/consultation/all
    @GetMapping("/all")
    public ResponseEntity<?> getMedicalConsultation(){
        return new ResponseEntity<>(consultationService.getAllMedicalConsultations(), HttpStatus.OK);
    }

    //create put mapping for updateMedicalConsultation method with url /api/v1/consultation/{consultationId}
    @PutMapping("/{consultationId}")
    public ResponseEntity<?> updateMedicalConsultation(@PathVariable int consultationId, @RequestBody Consultation consultation){
        return new ResponseEntity<>(consultationService.updateMedicalConsultation(consultation, consultationId), HttpStatus.OK);
    }

    //create delete mapping for deleteMedicalConsultation method with url /api/v1/consultation/{consultationId}
    @DeleteMapping("/{consultationId}")
    public ResponseEntity<?> deleteMedicalConsultation(@PathVariable int consultationId){
        return new ResponseEntity<>(consultationService.deleteMedicalConsultation(consultationId), HttpStatus.OK);
    }

}
