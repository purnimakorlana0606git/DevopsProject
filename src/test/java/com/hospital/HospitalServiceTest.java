package com.hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalServiceTest {

    private HospitalService service;

    @BeforeEach
    void setUp() {
        service = new HospitalService();
    }

    @Test
    void testAddPatient() {

        Patient patient = service.addPatient(
                "Rahul", 25, "Male", "Fever");

        assertNotNull(patient);
        assertEquals("Rahul", patient.getName());
        assertEquals(25, patient.getAge());
    }

    @Test
    void testSearchPatient() {

        Patient patient = service.addPatient(
                "Priya", 28, "Female", "Cold");

        Patient result = service.searchPatient(patient.getId());

        assertNotNull(result);
        assertEquals("Priya", result.getName());
    }

    @Test
    void testAddDoctor() {

        Doctor doctor = service.addDoctor(
                "Dr. Kumar", "Cardiology");

        assertEquals("Dr. Kumar", doctor.getName());
        assertEquals("Cardiology", doctor.getSpecialization());
    }

    @Test
    void testBookAppointment() {

        Patient patient = service.addPatient(
                "Rahul", 25, "Male", "Fever");

        Doctor doctor = service.addDoctor(
                "Dr. Kumar", "General Medicine");

        Appointment appointment = service.bookAppointment(
                patient.getId(), doctor.getId(), "2026-11-12");

        assertNotNull(appointment);
        assertEquals("Rahul", appointment.getPatient().getName());
    }

    @Test
    void testGenerateBill() {

        double bill = service.generateBill(500, 300, 1000);

        assertEquals(1800.0, bill);
    }

    @Test
    void testInvalidPatient() {

        assertThrows(IllegalArgumentException.class, () ->
                service.addPatient("", 25, "Male", "Fever"));
    }
}
