package MyHTM.htmMaker.Steps;

import MyHTM.htmMaker.HtmMakerAppApplication;
import MyHTM.htmMaker.Utils.AppConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class s_006_userController {
    private AppConfig appConfig;

    private ResponseEntity<String> response;
    private TestRestTemplate restTemplate;

    @Given("the server is running the app")
    public void theServerIsRunningTheApp() {
        HtmMakerAppApplication.main(new String[]{});
        System.out.println("Server is running");
    }

    @Then("the client receives a response with a random user")
    public void theClientReceivesAResponseWithARandomUser() {
        assertEquals(response.getBody(), "anything");
    }

    @When("the client calls the url {string}")
    public void theClientCallsTheUrl(String url) {
        System.out.println(STR."Client calls \{url}");
        response = this.restTemplate.getForEntity("http://localhost:8080/user/generateRandomUser", String.class);
        System.out.println(STR."Response: \{response.getBody()}");
    }
}
