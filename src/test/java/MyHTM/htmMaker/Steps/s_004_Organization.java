package MyHTM.htmMaker.Steps;

import MyHTM.htmMaker.Model.Identity.Organization;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class s_004_Organization{
    private Organization organization;
//    private User user;
//    private User secondUser;

    @When("attempt to make a new organization with invalid name {string} firstName {string} lastName {string} and emailAddress {string} must throw an {string}")
    public void attemptToMakeANewUserWithNameLastNameAndEmailAddressMustThrowAnErrorError
            (
                    String name,
                    String firstName,
                    String lastName,
                    String emailAddress,
                    String errorMessage) {
        try {
            Organization organization = new Organization(name, firstName, lastName, emailAddress);
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
            this.organization = new Organization(name, firstName, lastName, emailAddress);
            assertEquals(organization.getName(), name);
//            assertTrue(organization.isSuperUser(user));
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @When("attempt to make a new organization with correct name <name> but a null User must throw an error")
    public void attemptToMakeANewOrganizationWithCorrectNameNameButANullUserMustThrowAnError() {
        try{
            this.organization = new Organization("MyCompany", null, null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "User cannot be null");
        }
    }

//    @Then("the organization must have the correct name {string} firstName {string} lastName {string} and emailAddress {string}")
//    public void theOrganizationMustHaveTheCorrectNameNameFirstNameFirstNameLastNameLastNameAndEmailAddressEmailAddress(
//            String name,
//            String firstName,
//            String lastName,
//            String emailAddress) {
//        assertEquals(organization.getName(), name);
//        assertTrue(organization.isSuperUser(this.user));
//    }
//
//    @And("the organization must have an id")
//    public void theOrganizationMustHaveAnId() {
//        assert this.organization.getId() != null;
//        assertFalse(this.organization.getId().isEmpty());
//    }
//
//    @Given("a new organization with correct name {string} firstName {string} lastName {string} and emailAddress {string}")
//    public void aNewOrganizationWithCorrectNameNameFirstNameFirstNameLastNameLastNameAndEmailAddressEmailAddress(
//        String name,
//        String firstName,
//        String lastName,
//        String emailAddress) {
//            try {
//                this.organization = new Organization(name, firstName, lastName, emailAddress);
//                assertEquals(organization.getName(), name);
//                assertTrue(organization.isSuperUser(user));
//            } catch (IllegalArgumentException e) {
//                fail();
//            }
//    }
//
//    @When("adding a few SuperUsers with correct firstName {string} lastName {string} and emailAddress {string}")
//    public void addingAFewSuperUsersWithCorrectFirstNameSecondFirstNameLastNameSecondlastNameAndEmailAddressSecondEmailAddress(
//            String firstName,
//            String lastName,
//            String emailAddress) {
//        try {
////            this.secondUser = new User(firstName, lastName, emailAddress);
//            this.organization.addSuperUser(firstName, lastName, emailAddress);
//            assertTrue(this.organization.isSuperUser(secondUser));
//        } catch (IllegalArgumentException e) {
//            fail();
//        }
//    }
//
//    @Then("the organization must have two SuperUsers")
//    public void theOrganizationMustHaveTwoSuperUsers() {
//        assertEquals(this.organization.getSuperUsersIds().size(), 2);
//    }
//
//    @And("the superUsers ID must be equal to the user ID of User and secondUser.")
//    public void theSuperUsersIDMustBeEqualToTheUserIDOfUserAndSecondUser() {
//        assertEquals(this.organization.getSuperUsersIds().get(0), this.user.getId());
//        assertEquals(this.organization.getSuperUsersIds().get(1), this.secondUser.getId());
//    }
}
