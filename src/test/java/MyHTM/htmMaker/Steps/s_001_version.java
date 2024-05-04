package MyHTM.htmMaker.Steps;

import MyHTM.htmMaker.AppConfig;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class s_001_version {
    private AppConfig appConfig;
    private TestRestTemplate restTemplate;
    private ResponseEntity<String> response;

    public s_001_version(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Given("the server is running")
    public void theServerIsRunning() {
        // Assuming the server is auto-started by @SpringBootTest
        System.out.println("Server is running");
    }

    @When("the client calls {string}")
    public void theClientCalls(String arg0) {
        System.out.println("Client calls " + arg0);
        //send the get request to localhost:8080/version
        restTemplate = new TestRestTemplate();
        response = this.restTemplate.getForEntity("http://localhost:8080/version", String.class);
        System.out.println("Response: " + response.getBody());
    }

    @Then("the client receives server version {string}")
    public void theClientReceivesServerVersion(String arg0) {
        System.out.println("Client receives server version " + arg0);
        assertEquals(response.getBody(), appConfig.getVersion());
    }

    @And("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int arg0) {
        System.out.println("Client receives status code of " + arg0);
        assertEquals(arg0, response.getStatusCode().value());
    }
}
