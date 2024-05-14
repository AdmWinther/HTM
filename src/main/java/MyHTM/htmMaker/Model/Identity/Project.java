package MyHTM.htmMaker.Model.Identity;

import MyHTM.htmMaker.Model.Util.Util.Activeable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table
public class Project extends Activeable {

    @Id
    private String id;
    private String name;
    //todo: in the future, each project can have multiple project managers
    private String projectManagersId;

    public Project(String name, String projectManagerID) {
        try {
            this.id = UUID.randomUUID().toString();
            assignArguments(name, projectManagerID);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    protected Project() {

    }

    private void assignArguments(String name, String projectManagerId) {
        try{
            isValidNewProjectName(name);
            this.name = name;
            this.projectManagersId = projectManagerId;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void isValidNewProjectName(String name) {
        // throw an error if the project name is null or is shorter than 3 characters
        if(name == null || name.length() < 3) {
            throw new IllegalArgumentException("Project name is invalid");
        }
    }

    public void addProjectManager(Users user) {
        // add a SuperUser to the project
        if(user == null) throw new IllegalArgumentException("User cannot be null");
        if(projectManagersId.equals(user.getId())) throw new IllegalArgumentException("User is already a project manager");
        projectManagersId = user.getId();
    }

//    public void removeProjectManager(AppUser user) {
//        if(user == null) throw new IllegalArgumentException("User cannot be null");
//        if(!projectManagersId.equals(user.getId())) throw new IllegalArgumentException("User is not a project manager");
//        //check if the user is the only project manager
//        // remove a user from the project
//        projectManagersIds.remove(user.getId());
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.length() < 3) throw new IllegalArgumentException("Project name is invalid");
        this.name = name;
    }

    public String getProjectManagersId() {
        return projectManagersId;
    }

    public String getId() {
        return id;
    }
}