package Model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    //Atributos propios
    String speciality;

    //Constructor
    public Doctor(String name, String email) {
        super(name, email);
        System.out.println("El nombre del doctor es "+ name);
        this.speciality = speciality;
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

      /*  //agendar una nueva cita
    public void addAvailableAppointment(Date date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }

        // ver citas agendadas / view AvailableAppointments
    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Especialidad: " + speciality + "\n" +
                "Citas disponibles: " + getAvailableAppointments();
    }
*/
    //Crear una clase anidada de objetos "availableAppointment
    public static class AvailableAppointment{
        //Variables (darle sus caracteristicas)
        private int id;
        private Date date;
        private String time;

        //Hacer su contructor
        public AvailableAppointment(Date date, String time){
            this.date = date;
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

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {this.time = time;}

        @Override
        public String toString() {
            return  "\nDía: " + date + " Hora: " + time;
        }
    }
}



