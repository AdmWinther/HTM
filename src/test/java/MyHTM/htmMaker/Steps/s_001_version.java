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
    }

    @When("the client calls {string}")
    public void theClientCalls(String arg0) {
        response = restTemplate.getForEntity("/http://localhost:8080/version", String.class);
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int arg0) {
        assertEquals(response.getBody(), appConfig.getVersion());
    }

    @And("the client receives server version {double}")
    public void theClientReceivesServerVersion(int arg0, int arg1) {
        assertEquals(arg1, response.getStatusCode().value());
    }

    @Then("the client receives server version {string}")
    public void theClientReceivesServerVersion(String arg0) {
        assertEquals(appConfig.getVersion(), response.getStatusCode().value());
    }
}
