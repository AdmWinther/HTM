package MyHTM.htmMaker.Model.Classes.Identity;

import MyHTM.htmMaker.Model.Classes.Activeable;
import MyHTM.htmMaker.Model.Classes.ID;

import java.util.ArrayList;

public class Project extends Activeable {
    private final String id;
    private String name;
    private ArrayList<String> projectManagersIds;

    public Project(String name, User projectManager) {
        ID id = new ID();
        this.id = id.getId();
        try {
            assignArguments(name, projectManager);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Project(String name, String projectManagerFirstName, String projectManagerLastName, String projectManagerEmail) {
        ID id = new ID();
        this.id = id.getId();
        try {
            User projectManager = new User(projectManagerFirstName, projectManagerLastName, projectManagerEmail);
            assignArguments(name, projectManager);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void assignArguments(String name, User projectManager) {
        try{
            isValidNewProjectName(name);
            this.name = name;
            this.projectManagersIds = new ArrayList<>();
            this.projectManagersIds.add(projectManager.getId());
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

    public void addProjectManager(User user) {
        // add a SuperUser to the project
        if(user == null) throw new IllegalArgumentException("User cannot be null");
        if(projectManagersIds.contains(user.getId())) throw new IllegalArgumentException("User is already a project manager");
        projectManagersIds.add(user.getId());
    }

    public void removeProjectManager(User user) {
        if(user == null) throw new IllegalArgumentException("User cannot be null");
        if(!projectManagersIds.contains(user.getId())) throw new IllegalArgumentException("User is not a project manager");
        //check if the user is the only project manager
        if(projectManagersIds.size() == 1) throw new IllegalArgumentException("Cannot remove the only project manager from the project");
        // remove a user from the project
        projectManagersIds.remove(user.getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.length() < 3) throw new IllegalArgumentException("Project name is invalid");
        this.name = name;
    }

    public ArrayList<String> getProjectManagersIds() {
        return projectManagersIds;
    }

    public String getId() {
        return id;
    }
}