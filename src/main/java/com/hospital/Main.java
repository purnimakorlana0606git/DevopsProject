
package com.hospital;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HospitalService service = new HospitalService();

        while (true) {

            System.out.println("\n================================");
            System.out.println(" HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Add Doctor");
            System.out.println("5. View Doctors");
            System.out.println("6. Book Appointment");
            System.out.println("7. View Appointments");
            System.out.println("8. Generate Bill");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter patient name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter age: ");
                        int age = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter gender: ");
                        String gender = scanner.nextLine();

                        System.out.print("Enter disease: ");
                        String disease = scanner.nextLine();

                        Patient patient = service.addPatient(
                                name, age, gender, disease);

                        System.out.println("Patient added successfully!");
                        System.out.println(patient);
                        break;

                    case 2:
                        service.getAllPatients()
                                .forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter patient ID: ");
                        int searchId = Integer.parseInt(scanner.nextLine());

                        Patient found = service.searchPatient(searchId);

                        System.out.println(found != null
                                ? found : "Patient not found");
                        break;

                    case 4:
                        System.out.print("Enter doctor name: ");
                        String doctorName = scanner.nextLine();

                        System.out.print("Enter specialization: ");
                        String specialization = scanner.nextLine();

                        Doctor doctor = service.addDoctor(
                                doctorName, specialization);

                        System.out.println("Doctor added successfully!");
                        System.out.println(doctor);
                        break;

                    case 5:
                        service.getAllDoctors()
                                .forEach(System.out::println);
                        break;

                    case 6:
                        System.out.print("Enter patient ID: ");
                        int pId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter doctor ID: ");
                        int dId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter appointment date: ");
                        String date = scanner.nextLine();

                        Appointment appointment =
                                service.bookAppointment(pId, dId, date);

                        System.out.println("Appointment booked!");
                        System.out.println(appointment);
                        break;

                    case 7:
                        service.getAllAppointments()
                                .forEach(System.out::println);
                        break;

                    case 8:
                        System.out.print("Consultation fee: ");
                        int consultation = Integer.parseInt(scanner.nextLine());

                        System.out.print("Medicine fee: ");
                        int medicine = Integer.parseInt(scanner.nextLine());

                        System.out.print("Room fee: ");
                        int room = Integer.parseInt(scanner.nextLine());

                        double total = service.generateBill(
                                consultation, medicine, room);

                        System.out.println("Total bill: Rs. " + total);
                        break;

                    case 9:
                        System.out.println("Thank you!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
