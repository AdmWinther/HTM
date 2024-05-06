package MyHTM.htmMaker.Steps;

import MyHTM.htmMaker.Model.Classes.Organization;
import MyHTM.htmMaker.Model.Classes.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class s_004_Organization {
    @When("attempt to make a new organization with invalid name {string} firstName {string} lastName {string} and emailAddress {string} must throw an {string}")
    public void attemptToMakeANewUserWithNameLastNameAndEmailAddressMustThrowAnErrorError
            (
                    String name,
                    String firstName,
                    String lastName,
                    String emailAddress,
                    String errorMessage) {
        try {
            User user = new User(firstName, lastName, emailAddress);
            Organization organization = new Organization(name, user);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), errorMessage);
        }
    }

    @When("attempt to make a new organization with correct name {string} firstName {string} lastName {string} and emailAddress {string} must succeed")
    public void attemptToMakeANewOrganizationWithCorrectNameNameFirstNameFirstNameLastNameLastNameAndEmailAddressEmailAddressMustSucceed(
            String name,
            String firstName,
            String lastName,
            String emailAddress) {
        try {
            User user = new User(firstName, lastName, emailAddress);
            Organization organization = new Organization(name, user);
            assertEquals(organization.getName(), name);
            assertEquals(organization.getSuperUser(), user);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @When("attempt to make a new organization with correct name <name> but a null User must throw an error")
    public void attemptToMakeANewOrganizationWithCorrectNameNameButANullUserMustThrowAnError() {
        try{
            Organization organization = new Organization("MyCompany", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "User cannot be null");
        }
    }
}
