package Model;

import java.util.Scanner;

public abstract class User {

    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private Scanner phoneNumberScanner = new Scanner (System.in);

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


     public void setPhoneNumber(String phoneNumber) {
        System.out.println("Enter your phone number");
        phoneNumber = phoneNumberScanner.nextLine();
        if (phoneNumber.length()!= 8){
            do {
                System.out.println("The phone number length must be 8 digits." +
                        "\nEnter your phone number");
                        phoneNumber = phoneNumberScanner.nextLine();
            }
            while (phoneNumber.length()!=8);
        } else {
            System.out.println("Phone number is correct");
            this.phoneNumber=phoneNumber;
        }
    }

    public Scanner getPhoneNumberScanner() {
        return phoneNumberScanner;
    }

    public void setPhoneNumberScanner(Scanner phoneNumberScanner) {
        this.phoneNumberScanner = phoneNumberScanner;
    }

    @Override
    public String toString() {
        return "User: " + getName() + " \nEmail: " + getEmail() + " \nAdress: " + getAddress() +
               " \nPhone number: " + getPhoneNumber() + "\n";
    }

    public abstract void showDataUser();
}
