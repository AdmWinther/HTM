package MyHTM.htmMaker.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import MyHTM.htmMaker.Model.Identity.Email;

import static org.junit.Assert.*;

public class s_003_Email {
    private boolean isEmail;
    private Email email;

    @When("{string} is passed to Email.isEmail")
    public void isPassedToEmailIsEmail(String arg0) {
        isEmail = Email.isEmail(arg0);
    }

    @Then("the method Email.isEmail must return false")
    public void theMethodEmailIsEmailMustReturnFalse() {
        assertFalse(isEmail);
    }

    @Then("the method Email.isEmail must return true")
    public void theMethodEmailIsEmailMustReturnTrue() {
        assertTrue(isEmail);
    }

    @When("{string} is passed to Email constructor")
    public void isPassedToEmail(String arg0) {
        this.email = new Email(arg0);
    }

    @Then("the method Email must return a not null object Email")
    public void theMethodEmailMustReturnANotNullObjectEmail() {
        assertNotNull(this.email);
    }

    @Then("Trying to make a new Email with argument abc@d.com must throw an exception {string}")
    public void tryingToMakeANewEmailWithArgumentMustThrowAnException(String arg0) {
        try {
            this.email = new Email("abc@d.com");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), arg0);
        }
    }

    @And("the Email ID must not be null")
    public void theEmailIDMustNotBeNull() {
        assertNotNull(this.email.getId());
        assertNotEquals(this.email.getId(), "");
    }
}
