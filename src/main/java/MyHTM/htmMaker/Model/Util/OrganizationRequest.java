package MyHTM.htmMaker.Model.Util;

public class OrganizationRequest {
    private final String organization_name;
    private final String superuser_name;
    private final String superuser_lastname;
    private final String superuser_email;
    private final String superuser_password;


    public OrganizationRequest(String organization_name, String superuser_name, String superuser_lastname, String superuser_email, String superuser_password) {
        System.out.println("hello"+superuser_email);
        this.organization_name = organization_name;
        this.superuser_name = superuser_name;
        this.superuser_lastname = superuser_lastname;
        this.superuser_email = superuser_email;
        this.superuser_password = superuser_password;
    }

    public String getOrganizationName() {
        return organization_name;
    }

    public String getSuperuserName() {
        return superuser_name;
    }

    public String getSuperuserLastname() {
        return superuser_lastname;
    }

    public String getSuperuserEmailAddress() {
        return superuser_email;
    }

    public String getSuperuserPassword() {
        return superuser_password;
    }
}
