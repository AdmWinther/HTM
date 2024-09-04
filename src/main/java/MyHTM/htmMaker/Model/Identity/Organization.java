package MyHTM.htmMaker.Model.Identity;

import MyHTM.htmMaker.Model.Util.Activeable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table
public class Organization extends Activeable {

    @Id
    private String id;
    private String name;
    private String superUserId;
    //todo; in the future, we will have a list of super users

    public Organization(String name, String superUserName, String superUserLastName, String superUserEmail, String userRole) {
        try {
            isValidNewCompanyName(name);
            MyUser.isValidNewUser(superUserName, superUserLastName, superUserEmail, userRole);
            this.id = ID.generateID();
            this.name = name;
            this.activate();
            MyUser superUsers = new MyUser(superUserName, superUserLastName, superUserEmail, this.id, "User");
            this.superUserId= superUsers.getId();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    protected Organization() {
    }

    public Organization(String name) {
        try {
            this.id = UUID.randomUUID().toString();
            this.name = name;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }


    public Organization(String name, String superUserId) {
        try {
            if(superUserId == null) throw new IllegalArgumentException("SuperUserId cannot be null");
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.superUserId = superUserId;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void isValidNewCompanyName(String name) {
        if(name == null) {
            throw new IllegalArgumentException("Organization name cannot be null");
        }
        if(name.length() < 3) {
            throw new IllegalArgumentException("Organization name too short, the minimum length is 3 characters.");
        }
    }

    public String getName() {
        return name;
    }

    public void setSuperUserId(String superUserId) {
        this.superUserId = superUserId;
    }

    public void setName(String newName) {
        isValidNewCompanyName(newName);
        this.name = newName;
    }

    public String getId() {
        return id;
    }
}
