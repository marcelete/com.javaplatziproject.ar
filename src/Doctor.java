import java.net.StandardSocketOptions;

public class Doctor extends User{
    //Atributos
    String speciality;


    //Constructor
    public Doctor(String name, String email, String speciality) {
        super(name, email);
        this.speciality = speciality;
    }

    //Comportamientos
        public void showName () {
        System.out.println("El nombre del doctor es " + super.getName());
    }
}
