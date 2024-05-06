package MyHTM.htmMaker.Model.Classes;

import java.util.ArrayList;

public class ProjectAndEmployeeAccessLevelManager {
    private ArrayList<Project> projects;
    private User superUser;
    private ArrayList<Pair<User, EmployeeStatus>> employees;

    public ProjectAndEmployeeAccessLevelManager() {
        projects = new ArrayList<>();
        employees = new ArrayList<>();
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
}
