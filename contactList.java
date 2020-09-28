package contacts;

import java.util.ArrayList;
import java.util.List;

public class contactList {
    private final List<Contact> CONTACT_LIST = new ArrayList<>();

    public contactList () { }

    public void add(Contact contact) {
        CONTACT_LIST.add(contact);
        if (CONTACT_LIST.size() == 1) {
            System.out.println("A Phone Book with a single record created!");
        } else {
            System.out.println("Record added to Phone Book");
        }
    }
    public void printBook() {
        int i = 1;
        for(Contact c : CONTACT_LIST) {
            System.out.print(i +". ");
            c.printName();
            i++;
        }
    }
    public int getCount() {
        return CONTACT_LIST.size();
    }
    public boolean isEmpty() {
        return CONTACT_LIST.isEmpty();
    }
    public void remove(int choice) {
        CONTACT_LIST.remove(choice - 1);
        System.out.println("Record removed");
    }
    public void count() {
        System.out.println("The Phone Book has " + CONTACT_LIST.size() + " records.");
    }
    public void printContact(int index) {
        index--;
        CONTACT_LIST.get(index).print();
    }
    public void editContact(int index) {
        CONTACT_LIST.get(index).edit();
    }
    public void search(String searchTerm) {
        searchTerm = searchTerm.toLowerCase();
        int i = 1;
        String contactValues;
        for (Contact c : CONTACT_LIST) {
            contactValues = c.getName() + c.getPhoneNumber();
            if (contactValues.toLowerCase().contains(searchTerm)) {
                System.out.println(i + ". " + c.getName());
            }
            i++;
        }
    }
}
