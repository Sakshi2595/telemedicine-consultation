package com.stackroute.telemedicineconsultation.consultation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String scheduledDateTime;
    private int duration;
    private String status;
    private String diagnosis;
    private Prescription[] prescription;

    public Consultation() {
    }

    public Consultation(int id, int patientId, int doctorId, String scheduledDateTime, int duration, String status, String diagnosis, Prescription[] prescription) {
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

    public String getScheduledDateTime() {
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

    public Prescription[] getPrescriptions() {
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

    public void setScheduledDateTime(String scheduledDateTime) {
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

    public void setPrescriptions(Prescription[] prescription) {
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
                ", prescription=" + prescription +
                '}';
    }

}
