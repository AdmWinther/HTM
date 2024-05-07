package MyHTM.htmMaker.Model.Classes;

public class UserProjectAccess {
    String userId;
    String projectId;
    AccessLevel accessLevel;

    public String getUserId(){
        return userId;
    }

    public String getProjectId(){
        return projectId;
    }

    public AccessLevel getAccessLevel(){
        return accessLevel;
    }
}

