package Ui;

import Model.Doctor;

import java.util.Date;


public class Main {
    public static void main(String[] args) {

//      showMenu();
//
//      Model.Doctor doctor = new Model.Doctor("Marcelo", "Traumatologia");

//        Model.Patient patient = new Model.Patient("Adrian", "adriangomez@email.com");
//
//        System.out.println(patient);

        Doctor doctor = new Doctor ("marcelo", "marcebellizia@gmail.com");

        doctor.addAvailableAppointment(new Date(), "9 am");
        doctor.addAvailableAppointment(new Date(), "12 pm");
        doctor.addAvailableAppointment(new Date(), "15 pm");

        System.out.println(doctor);

        //Model.Doctor.AvailableAppointment availableAppointment = new Model.Doctor.AvailableAppointment(int 2000, int 12, int 10; String "20:00");


    }
}