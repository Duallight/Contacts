package contacts;

import java.util.Scanner;

public class Organization extends Contact{
    private String name;
    private String address;
    public Organization(String name, String address, String phone) {
        super(phone);
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        if (name.isEmpty()) {
            name = "[no data]";
        }
        if (address.isEmpty()) {
            address = "[no data]";
        }

        System.out.println("Organization name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Number: " + getPhoneNumber());
        System.out.println("Time created: " + getTimeCreated());
        System.out.println("Time last edit: " + getLastEdit());
    }
    @Override
    public void printName() {
        System.out.println(name);
    }
    @Override
    public void edit() {
        System.out.println("Select a field (name, address, number)");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        if ("name".equalsIgnoreCase(choice)) {
            System.out.println("Enter name: ");
            this.name = scan.nextLine();
            System.out.println("Record updated.");
            setLastEdit();
        } else if ("address".equalsIgnoreCase(choice)) {
            System.out.println("Enter address: ");
            this.address = scan.nextLine();
            System.out.println("Record updated.");
            setLastEdit();
        } else if ("number".equalsIgnoreCase(choice)) {
            System.out.println("Enter number");
            setPhoneNumber(scan.nextLine());
            System.out.println("Record updated.");
            setLastEdit();
        } else {
            System.out.println("Not a valid option.");
        }
    }

}
