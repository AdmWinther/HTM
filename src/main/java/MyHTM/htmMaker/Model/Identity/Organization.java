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
    private String CVRnumber;
    private String superUserId;
    //todo; in the future, we will have a list of super users

    public Organization(String name, String superUserName, String superUserLastName,String superUserUsername, String superUserEmail) {
        try {
            isValidNewCompanyName(name);
            MyUser.isValidNewUser(superUserName, superUserLastName, superUserEmail);
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.CVRnumber = "12345678";
            this.activate();
            MyUser superUsers = new MyUser(superUserName, superUserLastName, superUserEmail, this.id, "SuperUser");
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

//    public ArrayList<String> getSuperUsersIds() {
//        return superUsersIds;
//    }

//    public void addSuperUser(String firstName, String lastName, String email) {
//        User user = new User(firstName, lastName, email, this.id);
//        this.superUsersIds.add(user.getId());
//    }

//    public void addOrdinaryUser(String firstName, String lastName, String email) {
//        User user = new User(firstName, lastName, email, this.id);
//    }
    //todo; make a method for remving an ordinary user

//    public void removeSuperUser(User superUser) {
//        if(superUser == null) throw new IllegalArgumentException("User cannot be null");
//        if(!this.superUsersIds.contains(superUser.getId())) throw new IllegalArgumentException("User not in organization");
//        this.superUsersIds.remove(superUser.getId());
//    }

    public void setName(String newName) {
        isValidNewCompanyName(newName);
        this.name = newName;
    }

    public String getId() {
        return id;
    }

    public String getSuperUserId() {
        return superUserId;
    }

//    public boolean isSuperUser(User user) {
//        return this.superUsersIds.contains(user.getId());
//    }

//    public void addNewUser(String name, String lastName, String email) {
//        User newUser = new User(name, lastName, email, this.id);
//    }
}
