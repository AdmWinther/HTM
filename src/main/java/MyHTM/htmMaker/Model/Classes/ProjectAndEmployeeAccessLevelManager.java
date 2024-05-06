package MyHTM.htmMaker.Model.Classes;

import java.util.ArrayList;

public class ProjectAndEmployeeAccessLevelManager {
    private ArrayList<Project> projects;
    private User superUser;
    private ArrayList<User> employees;
    private ArrayList<UserProjectAccess> userProjectAccesses;

    public ProjectAndEmployeeAccessLevelManager(User superUser) {
        projects = new ArrayList<>();
        employees = new ArrayList<>();
        this.superUser = superUser;
        employees.add(superUser);
        userProjectAccesses = new ArrayList<>();
    }
    public void addEmployee(User user) {
        // add an employee to the organization employees list
        if(user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        for(User oneUser : employees) {
            if(oneUser.equals(user)){
                throw new IllegalArgumentException("User already in organization");
            }
        }
        employees.add(user);
    }

    public void setSuperUser(User superUser) {
        // Make sure the super user is not null or empty
        if(superUser == null) {
            throw new IllegalArgumentException("Super user cannot be null");
        }
        this.superUser = superUser;
        this.addEmployee(superUser);
        //todo; Make sure superuser is not already in the organization employees list
        //todo; in the UserProjectAccess, add the super user to the list of users and give him/her the highest access level.
    }

    public User getSuperUser() {
        return superUser;
    }

    public void giveAccessToProject(Project project, AccessLevel accessLevel) {
        // add a user with AccessLevel to a project to the organization projects list
    }

    public void removeAccessToProject(User user, Project project) {
        // take access from a user
    }

    public void giveAccessToAll(User user, AccessLevel accessLevel) {
        // remove an employee from the organization employees list
    }

    public void removeAllAccess(User user) {
        // remove an employee from the organization employees list
    }

    public void setAccessToProject(User user, Project project, AccessLevel accessLevel) {
        // change the access level of a user to a project
    }
}
