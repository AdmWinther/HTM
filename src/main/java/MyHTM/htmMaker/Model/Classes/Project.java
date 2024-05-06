package MyHTM.htmMaker.Model.Classes;

import java.util.HashSet;
import java.util.Set;

public class Project extends Activeable{
    private final String id;
    private String name;
    private User projectManager;
//    private Set<Pair<User, AccessLevel>> projectTeam;

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
            this.projectManager = projectManager;
            //todo fix it.
//            this.projectTeam = new HashSet<>();
            this.addUser(projectManager, AccessLevel.Editor);
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

    public void addUser(User user, AccessLevel role) {
        // add a user to the project
        Pair<User, AccessLevel> teamMember = new Pair<>(user, role);
        //Todo fix it.
//        if(projectTeam.contains(teamMember)) throw new IllegalArgumentException("User already in project");
//        projectTeam.add(teamMember);
    }

    public void removeUser(User user) {
        if(user == null) throw new IllegalArgumentException("User cannot be null");
        // remove a user from the project
        if(user.equals(projectManager)) throw new IllegalArgumentException("Cannot remove project manager from the project team. Please assign a new project manager first.");
        //Todo fix it.
//        for(Pair<User, AccessLevel> teamMember : projectTeam) {
//            if(teamMember.getFirst().equals(user)) {
//                projectTeam.remove(teamMember);
//                return;
//            }
//        }
        throw new IllegalArgumentException("User not in project");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.length() < 3) throw new IllegalArgumentException("Project name is invalid");
        this.name = name;
    }

    public User getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(User newProjectManager) {
        if(newProjectManager == null) throw new IllegalArgumentException("Project manager is required");
        //the old project manager is still in the project team and have Editor AccessLevel.
        projectManager = newProjectManager;
        //Todo fix it.
//        projectTeam.add(new Pair<>(newProjectManager, AccessLevel.Editor));
    }

    public String getId() {
        return id;
    }
}