package MyHTM.htmMaker.Control;

public class UserRequest {
    private String name;
    private String lastName;
    private String email;
    private String organizationId;

    public UserRequest(String name, String lastName, String email, String organizationId) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganizationId() {
        return organizationId;
    }
}
