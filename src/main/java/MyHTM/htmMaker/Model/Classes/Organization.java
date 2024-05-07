package MyHTM.htmMaker.Model.Classes;

import java.util.ArrayList;

public class Organization extends Activeable {
    private final String id;
    private String name;
    private ArrayList<String> superUsersIds;

    private void assignArguments(String name, User superUser) {
        try{
            isValidNewCompanyName(name);
            this.name = name;
            this.activate();
            this.superUsersIds = new ArrayList<String>();
            this.superUsersIds.add(superUser.getId());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Organization(String name, User superUser) {
        try {
            ID id = new ID();
            this.id = id.getId();
            if(superUser == null) throw new IllegalArgumentException("User cannot be null");
            assignArguments(name, superUser);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Organization(String name, String superUserName, String superUserLastName, String superUserEmail) {
        try {
            ID id = new ID();
            this.id = id.getId();
            User superUser = new User(superUserName, superUserLastName, superUserEmail);
            this.assignArguments(name, superUser);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void isValidNewCompanyName(String name) {
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

    public ArrayList<String> getSuperUsersIds() {
        return superUsersIds;
    }

    public void addSuperUser(User superUser) {
        this.superUsersIds.add(superUser.getId());
    }

    public void removeSuperUser(User superUser) {
        if(superUser == null) throw new IllegalArgumentException("User cannot be null");
        if(!this.superUsersIds.contains(superUser.getId())) throw new IllegalArgumentException("User not in organization");
        this.superUsersIds.remove(superUser.getId());
    }

    public void setName(String newName) {
        this.isValidNewCompanyName(newName);
        this.name = newName;
    }

    public String getId() {
        return id;
    }

    public boolean isSuperUser(User user) {
        return this.superUsersIds.contains(user.getId());
    }
}
