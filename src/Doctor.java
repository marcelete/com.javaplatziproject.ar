import java.net.StandardSocketOptions;

public class Doctor {

    static int id; //Autoincrimentado
    String name;
    String speciality;

    //Comportamientos

    Doctor (){
        id++;
        System.out.println("Construyendo el objeto Doctor");
    }; //Metodo constructor por defecto

    Doctor(int id, String name, String speciality){
        id++;
        System.out.println("Construyendo el objeto Doctor con el ID " + id + ". Llamado " + name + ". Especialista en " + speciality);
    }; //Metodo constructor sobrecargado pasando valores

    public void showName () {
        System.out.println("El nombre del doctor es " + name);
    }
}
