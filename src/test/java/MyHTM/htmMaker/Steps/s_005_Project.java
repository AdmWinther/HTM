package MyHTM.htmMaker.Steps;

import MyHTM.htmMaker.Model.Classes.Project;
import MyHTM.htmMaker.Model.Classes.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class s_005_Project {
    private Project project;
    private User user;
    private User secondUser;
    @When("attempt to make a new Project with an empty name must throw an error")
    public void attemptToMakeANewProjectWithoutNameMustThrowAnError() {
        try {
             Project project = new Project("", new User("John", "Doe", "john@doe.com"));
             fail();
        } catch (IllegalArgumentException e) {
             assertEquals(e.getMessage(), "Project name is invalid");
        }
    }

    @When("attempt to make a new Project with a null name must throw an error")
    public void attemptToMakeANewProjectWithANullNameMustThrowAnError() {
        try {
            Project project = new Project(null, new User("John", "Doe", "john@doe.com"));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Project name is invalid");
        }
    }

    @When("attempt to make a new Project with a valid name and projectManager must return a new Project object")
    public void attemptToMakeANewProjectWithAValidNameAndProjectManagerMustReturnANewProjectObject() {
        try {
            Project project = new Project("MyProject", new User("John", "Doe", "John@doe.com"));
            assertEquals(project.getName(), "MyProject");
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Given("a Project with a ProjectManager is made")
    public void aProjectWithAProjectManagerIsMade() {
        this.project = new Project("MyProject", new User("John", "Doe", "john@doe.com"));
    }

    @Given("a new project named {string} with a projectManager firstName {string} lastName {string} and emailAddress {string} is made")
    public void aNewProjectNamedProjectNameWithAProjectManagerFirstNameFirstNameLastNameLastNameAndEmailAddressEmailAddressIsMade(
            String projectName, String firstName, String lastName, String emailAddress) {
        this.user = new User(firstName, lastName, emailAddress);
        this.project = new Project(projectName, user);
    }

    @When("adding a new projectManager with correct firstName {string} lastName {string} and emailAddress {string}")
    public void addingANewProjectManagerWithCorrectFirstNameSecondFirstNameLastNameSecondlastNameAndEmailAddressSecondEmailAddress(
            String secondFirstName, String secondLastName, String secondEmailAddress) {
        this.secondUser = new User(secondFirstName, secondLastName, secondEmailAddress);
        this.project.addProjectManager(this.secondUser);
    }

    @Then("the project must have two projectManagers")
    public void theProjectMustHaveTwoProjectManagers() {
        assertEquals(this.project.getProjectManagersIds().size(), 2);
    }

    @And("the projectManagers ID must be equal to the user ID of User and secondUser.")
    public void theProjectManagersIDMustBeEqualToTheUserIDOfUserAndSecondUser() {
        assertEquals(this.project.getProjectManagersIds().get(0), this.user.getId());
        assertEquals(this.project.getProjectManagersIds().get(1), this.secondUser.getId());
    }
}
