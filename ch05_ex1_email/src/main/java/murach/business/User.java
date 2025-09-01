package murach.business;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String heardFrom;
    private String wantsUpdates;
    private String contactVia;

    public User() {
        email = "";
        firstName = "";
        lastName = "";
        dateOfBirth = "";
        heardFrom = "";
        wantsUpdates = "";
        contactVia = "";
    }

    public User(String email, String firstName, String lastName, String dateOfBirth, String heardFrom,
                String wantsUpdates, String contactVia) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.heardFrom = heardFrom;
        this.wantsUpdates = wantsUpdates;
        this.contactVia = contactVia;
    }

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getdateOfBirth() { return dateOfBirth; }
    public void setdateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getHeardFrom() { return heardFrom; }
    public void setHeardFrom(String heardFrom) { this.heardFrom = heardFrom; }

    public String getWantsUpdates() { return wantsUpdates; }
    public void setWantsUpdates(String wantsUpdates) { this.wantsUpdates = wantsUpdates; }

    public String getContactVia() { return contactVia; }
    public void setContactVia(String contactVia) { this.contactVia = contactVia; }
}