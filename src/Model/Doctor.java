package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    //Atributos propios
    String speciality;

    //Constructor
    public Doctor(String name, String email) {
        super(name, email);
        this.speciality = speciality;
    }

    @Override
    public void showDataUser() {
        System.out.println(
                "Hospital's Employee: Red Cross\n" +
                "Department: Oncology"
        );
    }

    //Comportamientos
    //Getters & Setters
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //Instanciar la lista de availableAppointment

    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

       //agendar una nueva cita
    public void addAvailableAppointment(String date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }

        // ver citas agendadas / view AvailableAppointments
    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Speciality: " + speciality + "\n" +
                "Available Appointmnt: " + getAvailableAppointments();
    }
    //Crear una clase anidada de objetos "availableAppointment
    public static class AvailableAppointment{
        //Variables (darle sus caracteristicas)
        private int id;
        private Date date;
        private String time;
        private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        //Hacer su contructor
        public AvailableAppointment(String date, String time){
            try {
                this.date = simpleDateFormat.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }
        //Establecer getters y setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public String getDate(String date) {
            return simpleDateFormat.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {this.time = time;}

        @Override
        public String toString() {
            return  "\nDate: " + date + " Time: " + time;
        }
    }
}



