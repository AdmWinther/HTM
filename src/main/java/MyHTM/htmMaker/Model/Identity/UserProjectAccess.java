package MyHTM.htmMaker.Model.Identity;

public class UserProjectAccess {
    String userId;
    String projectId;
    AccessLevel accessLevel;

    public UserProjectAccess(String userId, String projectId, AccessLevel accessLevel){
        this.userId = userId;
        this.projectId = projectId;
        this.accessLevel = accessLevel;
    }

    public String getUserId(){
        return userId;
    }

    public String getProjectId(){
        return projectId;
    }

    public AccessLevel getAccessLevel(){
        return accessLevel;
    }

    public void setAccessLevel( AccessLevel accessLevel){
        this.accessLevel = accessLevel;
    }

    public void removeAccess(){
        accessLevel = AccessLevel.None;
    }

    public void setEditAccess(){
        accessLevel = AccessLevel.Editor;
    }

    public void setViewAccess(){
        accessLevel = AccessLevel.Viewer;
    }
}

