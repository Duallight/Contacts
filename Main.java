package contacts;
import java.io.*;
import java.util.Scanner;
public class Main {
    static Contact contact;
    static contactList phoneBook = new contactList();
    public static void main(String[] args) {
        try {
            File file = new File("Contacts.txt");
            if (!file.createNewFile()) {
                //deserialize
                try {
                    FileInputStream fis = new FileInputStream("Contacts.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    phoneBook = (contactList) ois.readObject();
                    ois.close();
                    fis.close();
                } catch (IOException ieo) {
                    System.out.println("Error Loading List");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("[Menu] Enter action (add, list, search, count, exit): ");
        String choice = scan.next();
        while (true) {
            if ("add".equalsIgnoreCase(choice)) { // done
                add();
            } else if ("list".equalsIgnoreCase(choice)) {
                phoneBook.printBook();
                System.out.println("[list] Enter action ([number], back): ");
                String listChoice = scan.next();
                while (!"back".equalsIgnoreCase(listChoice) || listChoice.isEmpty()) {
                    if (isInt(listChoice)) {
                        if (Integer.parseInt(listChoice) > 0 && Integer.parseInt(listChoice) <= phoneBook.getCount()) {
                            record(Integer.parseInt(listChoice));
                            break;
                        } else {
                            System.out.println("Not a valid choice");
                            listChoice = scan.next();
                            System.out.println(listChoice);
                        }
                    }
                }
            } else if ("search".equalsIgnoreCase(choice)) {
                System.out.println("Enter search query: ");
                phoneBook.search(scan.next());
            } else if ("count".equalsIgnoreCase(choice)) { //done
                phoneBook.count();
            } else if ("exit".equalsIgnoreCase(choice)) {
                saveFile();
                break;
            } else {
                System.out.println("Not a valid option.");
            }
                System.out.println("\n[Menu] Enter action (add, list, search, count, exit): ");
                choice = scan.next();
        }

    }
    static private void add() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the type (person, organization): ");
        String type = scan.nextLine();
        if ("person".equalsIgnoreCase(type)) {
            System.out.println("Enter the name: ");
            String firstName = scan.nextLine();
            System.out.println("Enter the surname: ");
            String lastName = scan.nextLine();
            System.out.println("Enter the birth date: ");
            String birthdate = scan.nextLine();
            System.out.println("Enter the gender(M, F): ");
            String gender = scan.nextLine();
            System.out.println("Enter the phone number: ");
            String phone = scan.nextLine();
            contact = new Person(firstName,lastName, birthdate, gender, phone);
            phoneBook.add(contact);
        } else if ("organization".equalsIgnoreCase(type)) {
            System.out.println("Enter the organization name: ");
            String orgName = scan.nextLine();
            System.out.println("Enter the address: ");
            String address = scan.nextLine();
            System.out.println("Enter the phone number: ");
            String phone = scan.nextLine();
            contact = new Organization(orgName, address, phone);
            phoneBook.add(contact);
        } else {
            System.out.println("not a valid option");
        }

    }
    static private void remove() {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to remove!");
        } else {
            Scanner scan = new Scanner(System.in);
            phoneBook.printBook();
            System.out.print("Select a record: ");
            phoneBook.remove(scan.nextInt());
        }
    }
    static private void edit(int index) {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to edit");
        } else {
            phoneBook.editContact(--index);
        }

    }
    private static void saveFile() {
        try {
            FileOutputStream fout = new FileOutputStream("Contacts.txt");
            ObjectOutputStream s = new ObjectOutputStream(fout);
            s.writeObject(phoneBook);
        } catch (Exception e) {
            System.out.println("Error: Could not save file");
        }
    }
    private static void record(int index) {
        index--;
        phoneBook.printContact(++index);
        System.out.println("printed contact");
        System.out.println("\n[record] Enter action (edit, delete, menu): ");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        while (!"menu".equalsIgnoreCase(choice)) {
            if ("edit".equalsIgnoreCase(choice)) {
                edit(index);
            }else if ("delete".equalsIgnoreCase(choice)) {
                phoneBook.remove(index++);
            } else if ("menu".equalsIgnoreCase(choice)) {
                break;
            } else if ("exit".equalsIgnoreCase(choice)) {
                break;
            } else {
                System.out.println("Not a valid option.");
            }
            System.out.println("\n[record] Enter action (edit, delete, menu): ");
            choice = scan.nextLine();

        }
    }
    private static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}

