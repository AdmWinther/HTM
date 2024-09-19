package MyHTM.htmMaker.Model.Util;

public class UserAPIPostRequest {
    private final String name;
    private final String lastname;
    private final String emailAddress;
    private final String password;
    private final String role;

    public UserAPIPostRequest(String name, String lastName, String emailAddress, String password, String organizationId, String role) {
        this.name = name;
        this.lastname = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
