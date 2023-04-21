package Model;


public class Patient extends User{
    //Atributos
    private String birthday;
    private double weight;
    private double height;
    private String blood;


    public Patient (String name, String email) {
        super(name, email);
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
        this.blood = blood;
    }





    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWeight() {
        return weight + " Kgs.";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height + " meters";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() + "Birthday: " + getBirthday() +
                "\nWeight: " + getWeight() +
                "\nHeight: " + getHeight() +
                "\nBlood: " + getBlood();
    }

    @Override
    public void showDataUser() {
        System.out.println("Patient" +
                "\nComplete History");
    }
}
