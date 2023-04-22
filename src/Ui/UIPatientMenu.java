package Ui;

import java.util.Scanner;

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
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Not a correct answer");
            }

        } while (response != 0);
    }

        private static void showBookAppointmentMenu(){
            int response = 0;
            do {
                System.out.println("\n" +
                        "::Book an Appointment::" +
                        "\nSelect a Date");
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

                    UIMenu.patientLogged.add(date, time);
                    checkDoctorsAvailableAppointments(UIMenu.patientLogged);


                } else if (response==0) {
                    showDoctorMenu();
                }
            } while (response != 0);
        }
}