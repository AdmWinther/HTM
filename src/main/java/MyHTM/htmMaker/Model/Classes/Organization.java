package MyHTM.htmMaker.Model.Classes;

public class Organization extends Activeable {
    private int id;
    private String name;
    private ProjectAndEmployeeAccessLevelManager projectEmployeeAccessLevelManager;

    private void assignArguments(String name, User superUser) {
        try{
            isValidNewCompanyName(name);
            this.name = name;
            this.activate();
            this.projectEmployeeAccessLevelManager = new ProjectAndEmployeeAccessLevelManager();
            this.projectEmployeeAccessLevelManager.setSuperUser(superUser);
            this.projectEmployeeAccessLevelManager.addEmployee(superUser);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Organization(String name, User superUser) {
        try {
            if(superUser == null) throw new IllegalArgumentException("User cannot be null");
            assignArguments(name, superUser);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Organization(String name, String superUserName, String superUserLastName, String superUserEmail) {
        try {
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

    public User getSuperUser() {
        return this.projectEmployeeAccessLevelManager.getSuperUser();
    }

    public void changeSuperUser(User newSuperUser) {
        this.projectEmployeeAccessLevelManager.setSuperUser(newSuperUser);
    }
}
