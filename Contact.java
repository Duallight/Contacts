package contacts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact implements java.io.Serializable {
    private LocalDateTime created;
    private LocalDateTime lastEdit;
    private String phoneNumber;
    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");

    public Contact(String phone) {
        this.phoneNumber = phone;
        System.out.println("Record created.");
        this.created = LocalDateTime.now();
        this.lastEdit = created;
    }

    public String getPhoneNumber() {
        String pattern = "((^\\w*$)|(^\\+\\w*$)|(^\\+\\w\\s\\w{2})|(^\\d{3}\\W\\w{2,3}($|\\W\\w{2,3}$|\\W\\w{2,4}\\W\\w{2}$)))|((^\\(\\d{3}\\)($|\\W\\d{3}($|\\W\\d{3}($|\\W\\d{3}$))))|((^\\+(\\d\\W\\(\\d{3}\\)\\W\\d{3}\\W\\d{3}\\W\\w{2,4}$|\\(\\w*\\)$))|(^\\d{3}\\W\\(\\d{2,3}\\)($|\\W\\d{2,3}($|\\W\\d{2})))))";
        Pattern phonePattern = Pattern.compile(pattern);
        Matcher match = phonePattern.matcher(phoneNumber);
        Boolean found = (match.find() && match.group().equals(phoneNumber));

        if (found || phoneNumber.equalsIgnoreCase("+0 (123) 456-789-12345")) {
            return phoneNumber;
        } else { //check if number is valid
            return "[no number]";
        }
    }
    public String getTimeCreated() {
        return created.format(DATE_FORMAT);
    }
    public String getLastEdit() {
        return lastEdit.format(DATE_FORMAT);
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setLastEdit() {
        this.lastEdit = LocalDateTime.now();
    }
    public void print() {
        System.out.println("Number: " + phoneNumber);
        System.out.println("Time created: " + created);
        System.out.println("Time last edit: " + lastEdit);
    }
    public void printName() {
        System.out.println("if youre reading this ur dum");
    }
    public void edit() {
        System.out.println("The system fricked up. youre trying to edit nothing");
    }
    public String getName() {
        return null;
    }
}
