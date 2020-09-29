package contacts;

import java.util.Scanner;

public class Person extends Contact implements java.io.Serializable  {
    private String firstName;
    private String lastName;
    private String birthDay;
    private String gender;
    public Person(String first, String last, String birthDay, String gender, String phone) {
        super(phone);
        this.firstName = first;
        this.lastName = last;
        this.birthDay = birthDay;
        this.gender = gender;
    }
    public String getName() {
        return firstName + " " + lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getBirthDay() { return birthDay;}
    public String getGender() { return gender;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setBirthDay(String birthday) { this.birthDay = birthday; }
    public void setGender(String gender) { this.gender = gender; }

    @Override
    public void print() {
        if (firstName.isEmpty()) {
            firstName = "[no data]";
        }
        if (lastName.isEmpty()) {
            lastName = "[no data]";
        }
        if (birthDay.isEmpty()) {
            birthDay = "[no data]";
        }
        if (gender.isEmpty()) {
            gender = "[no data]";
        }
        System.out.println("Name: " + firstName);
        System.out.println("Surname: " + lastName);
        System.out.println("Birth date: " + birthDay);
        System.out.println("Gender: " + gender);
        System.out.println("Number: " + getPhoneNumber());
        System.out.println("Time created: " + getTimeCreated());
        System.out.println("Time last edit: " + getLastEdit());
    }
    @Override
    public void printName() {
        System.out.println(firstName + " " + lastName);
    }
    @Override
    public void edit() {
        System.out.println("Select a field ( name, surname, birth, gender, number): ");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        if ("name".equalsIgnoreCase(choice)) {
            System.out.println("Enter new name: ");
            this.firstName = scan.nextLine();
            System.out.println("Record updated.");
            setLastEdit();
        } else if ("surname".equalsIgnoreCase(choice)) {
            System.out.println("Enter new surname: ");
            this.lastName = scan.nextLine();
            System.out.println("Record updated.");
            setLastEdit();
        } else if ("birth".equalsIgnoreCase(choice)) {
            System.out.println("Enter new birthday: ");
            this.birthDay = scan.nextLine();
            System.out.println("Record updated.");
            setLastEdit();
        } else if ("gender".equalsIgnoreCase(choice)) {
            System.out.println("Enter new gender: ");
            this.gender = scan.nextLine();
            System.out.println("Record updated.");
            setLastEdit();
        } else if ("number".equalsIgnoreCase(choice)) {
            System.out.println("Enter new phone number: ");
            setPhoneNumber(scan.nextLine());
            System.out.println("Record updated.");
            setLastEdit();
        } else {
            System.out.println("Not a valid option.");
        }
    }


}
