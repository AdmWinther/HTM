package MyHTM.htmMaker.Steps;

import MyHTM.htmMaker.Model.Identity.MyUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class s_002_User {
    private MyUser user;

    @When("attempt to make a new user while any of name {string} lastName {string} emailAddress {string} password {string} and userRole {string} are invalid must throw an error error {string}")
    public void attemptToMakeANewUserWithInvalidCredentialsMustThrowAnErrorError
            (
                    String name,
                    String lastName,
                    String emailAddress,
                    String password,
                    String userRole,
                    String errorMessage) {
        try {
            MyUser user = new MyUser(name, lastName, emailAddress, password, userRole);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), errorMessage);
        }
    }

    @Given("attempt to make a new user with name {string} lastName {string} and emailAddress {string} password {string} and userRole {string}")
    public void attemptToMakeANewUserWithNameLastNameAndEmailAddressPasswordAndUserRole(String name, String lastName, String emailAddress, String password, String userRole) {
        try {
            this.user = new MyUser(name, lastName, emailAddress, password, userRole);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @When("the user is created")
    public void theUserIsCreated() {
        assert this.user != null;
    }

    @Then("the user name is {string}")
    public void theUserNameIs(String name) {
        assertEquals(this.user.getName(), name);
    }

    @And("the user has an ID")
    public void theUserHasAnID() {
        assert this.user.getId() != null;
        assertFalse(this.user.getId().isEmpty());
    }
}
