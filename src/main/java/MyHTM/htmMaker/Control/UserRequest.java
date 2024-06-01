package MyHTM.htmMaker.Control;

public class UserRequest {
    private final String name;
    private final String lastName;
    private final String email;
    private final String password;
    private final String organizationId;

    public UserRequest(String name, String lastName, String email, String password, String organizationId) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public String getOrganizationId() {
        return organizationId;
    }
}
