package MyHTM.htmMaker.Model.Identity;
//
import MyHTM.htmMaker.Model.Util.Util.Activeable;
import MyHTM.htmMaker.Model.Util.Util.Email;
import jakarta.persistence.*;

import java.util.UUID;
//
@Entity
@Table
public class Users extends Activeable {

    @Id
    private String id;

    private String name;
    private String lastName;
    private String emailAddress;
    private String password;
//  this attribute must be annotated as foreign key
    @JoinColumn(name = "organizationId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Organization_SuperUser"))
    private String organizationId;

    public Users(String name, String lastName, String email, String password, String OrganizationId) {

        try {
            isValidNewUser(name, lastName, email);
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.lastName = lastName;
            this.emailAddress = email;
            this.password = password;
            this.organizationId = OrganizationId;
            //todo: the user must be activated only after the email address is confirmed
            this.activate();
            //todo; register the user on the database
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Users(String name, String lastName, String email, String OrganizationId) {

        try {
            isValidNewUser(name, lastName, email);
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.lastName = lastName;
            this.emailAddress = email;
            this.password = "";
            this.organizationId = OrganizationId;
            //todo: the user must be activated only after the email address is confirmed
            this.activate();
            //todo; register the user on the database
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Users(String name, String lastName, String email) {

        try {
            isValidNewUser(name, lastName, email);
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.lastName = lastName;
            this.emailAddress = email;
            this.password = "";
            //todo: the user must be activated only after the email address is confirmed
            this.activate();
            //todo; register the user on the database
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    //
    protected Users() {
//        this.id = UUID.randomUUID().toString();
    }
//
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

    public String getOrganizationId() {
        return organizationId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrganizationId(String id) {
        this.organizationId = id;
    }
//    public boolean equals(User user) {
//        if(Objects.equals(this.name, user.getName())){
//            if(Objects.equals(this.lastName, user.getLastName())){
//                if(Objects.equals(this.emailAddress, user.emailAddress)){
//                    return Objects.equals(this.id, user.getId());
//                }
//            }
//        }
//        return false;
//    }

//
}