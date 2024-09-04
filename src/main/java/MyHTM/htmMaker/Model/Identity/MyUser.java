package MyHTM.htmMaker.Model.Identity;
//
import MyHTM.htmMaker.Model.Util.Activeable;
import MyHTM.htmMaker.Model.Util.Email;
import MyHTM.htmMaker.Model.Util.Role;
import MyHTM.htmMaker.Utils.AppConfig;
import jakarta.persistence.*;

//
@Entity
@Table
public class MyUser extends Activeable {

    @Id
    private String id;

    private String name;
    private String lastName;
    private String emailAddress;
    private String password;
    private String role;

    public MyUser(String name, String lastName, String email, String password, String role) {

        try {
            isValidNewUser(name, lastName, email, role);
            this.id = ID.generateID();
            this.name = name;
            this.lastName = lastName;
            this.emailAddress = email;
            isValidPassword(password);
            this.password = password;
            this.role = role;
            this.activate();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

//    private void isUserRoleValid(String userRole) {
//        if(userRole == null || userRole.isEmpty()) {
//            throw new IllegalArgumentException("User role is required");
//        }
//        //todo: fetch all the possible roles from the database
//        if(!userRole.equals("Admin") && !userRole.equals("User")){
//            throw new IllegalArgumentException("User role is not valid");
//        }
//    }

    private void isValidPassword(String password) {
        if(password == null || password.isEmpty()) {
            throw new IllegalArgumentException("User password is required");
        }
    }


    protected MyUser() {
    }

    public static void isValidNewUser(String name, String lastName, String emailAddress, String userRole) throws IllegalArgumentException{
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

        if (userRole == null || userRole.isEmpty()) {
            throw new IllegalArgumentException("User role is required");
        } else {
            AppConfig appConfig = new AppConfig();
            if(!appConfig.getRoles().contains(userRole)) {
                throw new IllegalArgumentException("User role is not valid");
            }
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

    public void setID() {
        this.id = ID.generateID();
    }
}