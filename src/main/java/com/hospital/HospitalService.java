
package com.hospital;

import java.util.ArrayList;
import java.util.List;

public class HospitalService {

    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();

    private int patientId = 1;
    private int doctorId = 1;
    private int appointmentId = 1;

    // Add patient
    public Patient addPatient(String name, int age,
                              String gender, String disease) {

        if (name == null || name.isBlank()
                || age <= 0 || gender == null || gender.isBlank()
                || disease == null || disease.isBlank()) {
            throw new IllegalArgumentException("Invalid patient details");
        }

        Patient patient = new Patient(
                patientId++, name, age, gender, disease);

        patients.add(patient);
        return patient;
    }

    // View all patients
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

    // Search patient
    public Patient searchPatient(int id) {
        return patients.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Add doctor
    public Doctor addDoctor(String name, String specialization) {

        if (name == null || name.isBlank()
                || specialization == null
                || specialization.isBlank()) {
            throw new IllegalArgumentException("Invalid doctor details");
        }

        Doctor doctor = new Doctor(
                doctorId++, name, specialization);

        doctors.add(doctor);
        return doctor;
    }

    // View doctors
    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors);
    }

    // Book appointment
    public Appointment bookAppointment(
            int patientId, int doctorId, String date) {

        Patient patient = searchPatient(patientId);

        Doctor doctor = doctors.stream()
                .filter(d -> d.getId() == doctorId)
                .findFirst()
                .orElse(null);

        if (patient == null || doctor == null
                || date == null || date.isBlank()) {
            throw new IllegalArgumentException(
                    "Invalid patient, doctor or date");
        }

        Appointment appointment = new Appointment(
                appointmentId++, patient, doctor, date);

        appointments.add(appointment);
        return appointment;
    }

    // View appointments
    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }

    // Generate bill
    public double generateBill(int consultationFee,
                               int medicineFee,
                               int roomFee) {

        if (consultationFee < 0 || medicineFee < 0 || roomFee < 0) {
            throw new IllegalArgumentException("Fees cannot be negative");
        }

        return consultationFee + medicineFee + roomFee;
    }
}
