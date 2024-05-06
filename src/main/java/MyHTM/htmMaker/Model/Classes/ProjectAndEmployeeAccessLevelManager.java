package MyHTM.htmMaker.Model.Classes;

import java.util.ArrayList;

public class ProjectAndEmployeeAccessLevelManager {
    private ArrayList<Project> projects;
    private User superUser;
    private ArrayList<Pair<User, EmployeeStatus>> employees;

    public ProjectAndEmployeeAccessLevelManager(User superUser) {
        projects = new ArrayList<>();
        employees = new ArrayList<>();
        this.superUser = superUser;
        employees.add(new Pair<>(superUser, EmployeeStatus.Active));
    }
    public void addEmployee(User user) {
        // add an employee to the organization employees list
        Pair<User, EmployeeStatus> employee = new Pair<>(user, EmployeeStatus.Active);
        for(Pair<User, EmployeeStatus> pair: employees) {
            if(pair.first().equals(user)){
                if(pair.second().equals(EmployeeStatus.Inactive)){
                    throw new IllegalArgumentException("User already in organization but inactive");
                } else {
                    throw new IllegalArgumentException("User already in organization and active");
                }
            }
        }
        employees.add(employee);
    }

    public void setSuperUser(User superUser) {
        //todo: Make sure the super user is not already in the employees list
        //todo: Make sure the super user is not null or empty
        this.superUser = superUser;
        this.addEmployee(superUser);
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
