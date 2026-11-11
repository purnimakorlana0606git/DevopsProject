
package com.hospital;

public class Appointment {

    private int id;
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(int id, Patient patient,
                       Doctor doctor, String date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id
                + ", Patient: " + patient.getName()
                + ", Doctor: " + doctor.getName()
                + ", Date: " + date;
    }
}
