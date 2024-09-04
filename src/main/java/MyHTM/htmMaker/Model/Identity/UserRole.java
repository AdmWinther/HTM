package MyHTM.htmMaker.Model.Identity;

import MyHTM.htmMaker.Model.Util.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.repository.cdi.Eager;

import java.util.UUID;

@Entity
@Table
public class UserRole {
    @Id
    private String id;
    private String userId;
    private String projectId;
    private Role role;

    public UserRole(String UserId, Role role) {
        this.id = ID.generateID();
        this.userId = UserId;
        this.role = role;
    }

    protected UserRole() {
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return role;
    }

    public void setRoleId(Role newRole) {
        this.role = newRole;
    }
}
