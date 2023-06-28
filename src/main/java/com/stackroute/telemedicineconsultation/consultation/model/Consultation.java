package com.stackroute.telemedicineconsultation.consultation.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Consultation {
    //declare the variables for consultation model class as {
    //  "id": 2,
    //  "patientId": 123,
    //  "doctorId": 456,
    //  "scheduledDateTime": "2023-06-27T14:00:00Z",
    //  "duration": 45,
    //  "status": "Scheduled",
    //  "diagnosis": null,
    //  "prescriptions": []
    //}
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int patientId;
    private int doctorId;
    private LocalDateTime scheduledDateTime;
    private int duration;
    private String status;
    private String diagnosis;

    // Add a OneToOne mapping to the Prescription entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    public Consultation() {
    }

    public Consultation(int id, int patientId, int doctorId, LocalDateTime scheduledDateTime, int duration, String status, String diagnosis, Prescription prescription) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.scheduledDateTime = scheduledDateTime;
        this.duration = duration;
        this.status = status;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public LocalDateTime getScheduledDateTime() {
        return scheduledDateTime;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setScheduledDateTime(LocalDateTime scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }


    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", scheduledDateTime='" + scheduledDateTime + '\'' +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescriptions=" + prescription +
                '}';
    }

}
