package MyHTM.htmMaker.Steps;

import MyHTM.htmMaker.Model.Classes.Organization;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class s_004_Organization {
    @When("attempt to make a new organization with name {string} first name {string} lastName {string} and emailAddress {string} must throw an error error {error}")
    public void attemptToMakeANewOrganizationWithNameNameFirstNameSuperUserFirstNameLastNameLastNameAndEmailAddressEmailAddressMustThrowAnErrorErrorError(
            String name,
            String superUserFirstName,
            String lastName,
            String emailAddress,
            String error
    ) {
        try {
            Organization organization = new Organization(
                    name,
                    superUserFirstName,
                    lastName,
                    emailAddress);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), error);
        }
    }

    @When("new organization with name {string} first name {string} lastName {string} and emailAddress {string} throws error {string}")
    public void newOrganizationWithNameNameFirstNameSuperUserFirstNameLastNameLastNameAndEmailAddressEmailAddressThrowsErrorError() {
    }
}
