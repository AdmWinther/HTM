package MyHTM.htmMaker.Model.Identity;

import MyHTM.htmMaker.Model.Util.Util.Activeable;
import MyHTM.htmMaker.Model.Util.Util.ID;
import jakarta.persistence.Entity;

import java.util.Objects;

public class User extends Activeable {
    private final String id;
    private final String name;
    private final String lastName;
    private final Email email;
    private String password;
    private Organization organization;

    public User(String name, String lastName, String emailAddress) {
        try {
            ID id = new ID();
            this.id = id.getId();
            isValidNewUser(name, lastName, emailAddress);
            this.name = name;
            this.lastName = lastName;
            this.email = new Email(emailAddress);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void isValidNewUser(String name, String lastName, String emailaddress) throws IllegalArgumentException{
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name is required");
        }

        if(lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("User lastname is required");
        }

        if(emailaddress == null || emailaddress.isEmpty()) {
            throw new IllegalArgumentException("User email address is required");
        }

        if(!Email.isEmail(emailaddress)) {
            throw new IllegalArgumentException("User email address is not correct");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getAddress();
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public boolean equals(User user) {
        if(Objects.equals(this.name, user.getName())){
            if(Objects.equals(this.lastName, user.getLastName())){
                if(Objects.equals(this.getEmail(), user.getEmail())){
                    return this.id == user.getId();
                }
            }
        }
        return false;
    }
}