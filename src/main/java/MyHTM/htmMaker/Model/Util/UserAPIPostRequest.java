package MyHTM.htmMaker.Model.Util;

public class UserAPIPostRequest {
    private final String name;
    private final String lastname;
    private final String email;
    private final String password;

    public UserAPIPostRequest(String name, String lastName, String email, String password, String organizationId) {
        this.name = name;
        this.lastname = lastName;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
