package MyHTM.htmMaker.Model.Util;

public class OrganizationRequest {
    private final String organizationName;
    private final String superuserName;
    private final String superuserLastname;
    private final String superuserEmailAddress;
    private final String superuserPassword;


    public OrganizationRequest(String organizationName, String superuserName, String superuserLastname, String superuserEmailAddress, String superuserPassword) {
        this.organizationName = organizationName;
        this.superuserName = superuserName;
        this.superuserLastname = superuserLastname;
        this.superuserEmailAddress = superuserEmailAddress;
        this.superuserPassword = superuserPassword;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getSuperuserName() {
        return superuserName;
    }

    public String getSuperuserLastname() {
        return superuserLastname;
    }

    public String getSuperuserEmailAddress() {
        return superuserEmailAddress;
    }

    public String getSuperuserPassword() {
        return superuserPassword;
    }
}
