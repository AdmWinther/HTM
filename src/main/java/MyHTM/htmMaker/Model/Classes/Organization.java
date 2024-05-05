package MyHTM.htmMaker.Model.Classes;

public class Organization extends Activeable {
    private int id;
    private String name;
    private User superUser;

    private void assignArguments(String name, User superUser) {
        this.name = name;
        this.superUser = superUser;
        this.activate();
    }

    public Organization(String name, User superUser) {
        try {
            isValidNewCompany(name);
            assignArguments(name, superUser);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Organization(String name, String superUserName, String superUserLastName, String superUserEmail) {
        try {
            User.isValidNewUser(superUserName, superUserLastName, superUserEmail);
            User superUser = new User(superUserName, superUserLastName, superUserEmail);
            this.assignArguments(name, superUser);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void isValidNewCompany(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
    }

    public String getName() {
        return name;
    }

    public User getSuperUser() {
        return superUser;
    }
}
