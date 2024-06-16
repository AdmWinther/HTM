package MyHTM.htmMaker.Model.Identity;
//
import MyHTM.htmMaker.Model.Util.Activeable;
import MyHTM.htmMaker.Model.Util.Email;
import jakarta.persistence.*;

import java.util.UUID;
//
@Entity
@Table
public class MyUser extends Activeable {

    @Id
    private String id;

    private String name;
    private String lastName;
    private String username;
    private String emailAddress;
    private String password;
    private String role;

    public MyUser(String name, String lastName,String username, String email, String password, String userRole) {

        try {
            isValidNewUser(name, lastName, email);
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.lastName = lastName;
            this.username = username;
            this.emailAddress = email;
            this.password = password;
            this.role = userRole;
            this.activate();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }


    protected MyUser() {
    }

    public static void isValidNewUser(String name, String lastName, String emailAddress) throws IllegalArgumentException{
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name is required");
        }

        if(lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("User lastname is required");
        }

        if(emailAddress == null || emailAddress.isEmpty()) {
            throw new IllegalArgumentException("User email address is required");
        }

        if(!Email.isEmail(emailAddress)) {
            throw new IllegalArgumentException("User email address is not correct");
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}