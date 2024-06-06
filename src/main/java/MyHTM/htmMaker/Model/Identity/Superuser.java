package MyHTM.htmMaker.Model.Identity;

import jakarta.persistence.*;

@Entity
@Table
public class Superuser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organizationId", nullable = false) // Foreign key to Organization
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false) // Foreign key to User
    private MyUser user;

    // Constructors, getters and setters

    protected Superuser() {
    }

    public Superuser(Organization organization, MyUser user) {
        this.organization = organization;
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }
}
