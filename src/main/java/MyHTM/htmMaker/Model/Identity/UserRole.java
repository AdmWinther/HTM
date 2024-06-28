package MyHTM.htmMaker.Model.Identity;

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
    private String roleId;

    public UserRole(String UserId, String RoleId) {
        this.id = ID.generateID();
        this.userId = UserId;
        this.roleId = RoleId;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
