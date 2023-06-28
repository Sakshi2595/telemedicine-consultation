package com.stackroute.telemedicineconsultation.consultation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Prescription {
    //declare variables for prescription details of the patient as  {
    //      "medication": "Ibuprofen",
    //      "dosage": "400mg",
    //      "frequency": "Once every 6 hours",
    //      "startDate": "2023-06-25",
    //      "endDate": "2023-06-28"
    //    }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int prescriptionId;
    private String medication;
    private String dosage;
    private String frequency;
    private String startDate;
    private String endDate;

    public Prescription() {
    }

    public Prescription(int prescriptionId, String medication, String dosage, String frequency, String startDate, String endDate) {
        this.prescriptionId = prescriptionId;
        this.medication = medication;
        this.dosage = dosage;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
    }

//    public int getPrescriptionId() {
//        return prescriptionId;
//    }
//
//    public void setPrescriptionId(int prescriptionId) {
//        this.prescriptionId = prescriptionId;
//    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "medication='" + medication + '\'' +
                ", dosage='" + dosage + '\'' +
                ", frequency='" + frequency + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }


}
