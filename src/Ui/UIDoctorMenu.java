package Ui;

import Model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu(){
        int response = 0;
        do {
            System.out.println("\n\n" +
                    "\nWelcome Doctor " + UIMenu.doctorLogged.getName() +
                    "\n1. Add Available Appointment" +
                    "\n2. My Schedule Appointments" +
                    "\n0. Logout");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Not a correct answer");
            }

        } while (response!=0);
    }

    private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do {
            System.out.println("\n" +
                    "::Add Available Appointment::" +
                    "\nSelect a Month");
            for (int i = 0; i < 12; i++) {
                int j = i + 1;
                System.out.println(j +". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){
            // 1, 2 o 3
                int monthSelected = response;
                System.out.println(monthSelected + ". " + UIMenu.MONTHS[monthSelected-1]);
                System.out.println("Enter available date: [dd/mm/yyyy]");
                String date = sc.nextLine();

                //Agregamos una confirmación

                System.out.println("Your date is " + date + "." +
                        "\n1 Correct" +
                        "\n2 Change date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue; // else?

                // Pedimos la hora
                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the available time for date " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is " + time + "." +
                            "\n1. Correct" +
                            "\n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());
                } while(responseTime==2);

                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorsAvailableAppointments(UIMenu.doctorLogged);


            } else if (response==0) {
                showDoctorMenu();
            }
        } while (response != 0);
    }

    public static void checkDoctorsAvailableAppointments (Doctor doctor) {
        if (doctor.getAvailableAppointments().size()>0
                && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
