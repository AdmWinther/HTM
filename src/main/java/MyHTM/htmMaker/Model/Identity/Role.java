package MyHTM.htmMaker.Model.Identity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table
public class Role {
    @Id
    private String id;
    private String name;

    public Role(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    protected Role() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
