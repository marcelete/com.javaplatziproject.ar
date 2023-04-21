package Ui;

import Model.Doctor;
import Model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

import static Ui.UIDoctorMenu.showDoctorMenu;

public class UIMenu {

    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Select your choice");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());


            switch (response){
                case 1:
                    //System.out.println("Doctor");
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    response = 0;
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 4; i++) {
                        System.out.println(i +". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }

    private static void authUser(int userType){
        // userType = 1 Doctor
        // userType = 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Juan Perez", "juanp@mail.com"));
        doctors.add(new Doctor("Diego Diez", "diegod@mail.com"));
        doctors.add(new Doctor("Maria Ramirez", "mariar@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add (new Patient("Paco Ramos", "pacor@mail.com"));
        patients.add (new Patient("Juan Frutos", "juanf@mail.com"));
        patients.add (new Patient("Paco Ramos", "pacor@mail.com"));

        boolean correctEmail = false;
        do {
            System.out.println("Insert your email: [a@mail.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType==1) {
                for (Doctor d : doctors) {
                    if (d.getEmail().equals(email)) {
                        correctEmail = true;
                        doctorLogged = d;
                        showDoctorMenu();
                    }
                }
            }
            if (userType==2) {
                for (Patient p: patients) {
                    if (p.getEmail().equals(email)){
                        correctEmail = true;
                        patientLogged = p;
                        showPatientMenu();
                    }

                }
            }

        } while (!correctEmail);
    }
}