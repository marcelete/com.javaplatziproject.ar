package Ui;

import Model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static Ui.UIDoctorMenu.*;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n" +
                    "\nWelcome Patient " + UIMenu.patientLogged.getName() +
                    "\n1. Book an Appointment" +
                    "\n2. My Appointments" +
                    "\n0. Logout");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointmnts();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Not a correct answer");
            }

        } while (response != 0);
    }

    private static void showBookAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("\n" +
                    "::Book an Appointment::" +
                    "\nSelect a Date");
            //Ahora necesitamos traer todas las fechas que los doctores ya hallan agendado como disponibles
            // mediante un TreeMap
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            //Recorre cada Array de doctores con citas disponiles y los almacena en un nuevo array
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                    = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                //CAPTURA EL INDICE DE LA FECHA Y EL OBJETO DOCTOR
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < doctorAppointments.size(); j++) {
                    k++;
                    System.out.println(j + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j),UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);

                }

            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();

            }

            System.out.println(doctorSelected.getName()
                    + "\n. Date " + doctorSelected.getAvailableAppointments().get(indexDate).getDate()
                    + "\n. Time " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment:" +
                    "\n1. Yes" +
                    "\n2. Change data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UIMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                        );

            }
            showPatientMenu();

        } while (response != 0);

    }
    private static void showPatientMyAppointmnts(){
        int response = 0;

        do {
            System.out.println("My Appointments");

            if (UIMenu.patientLogged.getAppointmentDoctors().size()==0){
                System.out.println("You don't have appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i +1;
                System.out.println(j + ". " +
                "\nDate" + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                "\nTime" + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime()+
                "\nDoctor"+ UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
            }

            System.out.println("0. To exit");

        } while (response !=0);


    }
}

                /*
                for (int i = 0; i < 3; i++) {
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

                    UIMenu.patientLogged.add(date, time);
                    checkDoctorsAvailableAppointments(UIMenu.patientLogged);


                } else if (response==0) {
                    showDoctorMenu();
                }
            } while (response != 0);
        }
}*/