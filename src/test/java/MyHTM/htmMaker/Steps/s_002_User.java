//package MyHTM.htmMaker.Steps;
//
//import MyHTM.htmMaker.Model.Identity.User;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class s_002_User {
//    private User user;
//    @When("attempt to make a new user with empty name must throw an error {string}")
//    public void attemptToMakeANewUserWithEmptyNameMustThrowAnError(String arg0) {
//        try {
//            User user = new User("", "Doe", "john@doe.com");
//            fail();
//        } catch (IllegalArgumentException e) {
//            assertEquals(e.getMessage(), arg0);
//        }
//    }
//
//    @When("attempt to make a new user with empty lastname must throw an error {string}")
//    public void attemptToMakeANewUserWithEmptyLastnameMustThrowAnError(String arg0) {
//        try {
//            User user = new User("John", "", "john@doe.com");
//        } catch (IllegalArgumentException e) {
//            assert e.getMessage().equals(arg0);
//        }
//    }
//
//    @When("attempt to make a new user with empty email must throw an error {string}")
//    public void attemptToMakeANewUserWithEmptyEmailMustThrowAnError(String arg0) {
//        try {
//            User user = new User("John", "Doe", "");
//        } catch (IllegalArgumentException e) {
//            assert e.getMessage().equals(arg0);
//        }
//    }
//
//    @When("attempt to make a new user with invalid email must throw an error {string}")
//    public void attemptToMakeANewUserWithInvalidEmailMustThrowAnError(String arg0) {
//        try {
//            User user = new User("John", "Doe", "john@d.com");
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            System.out.println(arg0);
//            assert e.getMessage().equals(arg0);
//        }
//    }
//
//    @When("attempt to make a new user with name {string} lastName {string} and emailAddress {string} must throw an error error {string}")
//    public void attemptToMakeANewUserWithNameLastNameAndEmailAddressMustThrowAnErrorError
//            (
//                    String name,
//                    String lastName,
//                    String emailAddress,
//                    String errorMessage) {
//        try {
//            User user = new User(name, lastName, emailAddress);
//            fail();
//        } catch (IllegalArgumentException e) {
//            assertEquals(e.getMessage(), errorMessage);
//        }
//    }
//
//    @When("attempt to make a new user with name {string} lastName {string} and emailAddress {string}")
//    public void attemptToMakeANewUserWithNameLastNameAndEmailAddressMustBeSuccessful(String name, String lastName, String emailAddress) {
//        try {
//            this.user = new User(name, lastName, emailAddress);
//        } catch (IllegalArgumentException e) {
//            fail();
//        }
//    }
//
//    @When("the user is created")
//    public void theUserIsCreated() {
//        assert this.user != null;
//    }
//
//    @Then("the user name is {string}")
//    public void theUserNameIs(String userName) {
//        assertEquals(this.user.getName(), userName);
//    }
//
//    @And("the user has an ID")
//    public void theUserHasAnID() {
//        assert this.user.getId() != null;
//        assertFalse(this.user.getId().isEmpty());
//    }
//}
