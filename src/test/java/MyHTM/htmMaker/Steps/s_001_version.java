package MyHTM.htmMaker.Steps;

import MyHTM.htmMaker.HtmMakerAppApplication;
import MyHTM.htmMaker.Model.Util.Version;
import MyHTM.htmMaker.Utils.AppConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class s_001_version {
    private AppConfig appConfig;
    private TestRestTemplate restTemplate;
    private ResponseEntity<Version> response;
    private String fetchVersion;
    private String versionFromAppConfig;

    public s_001_version(AppConfig appConfig) {
        this.appConfig = appConfig;
        versionFromAppConfig = appConfig.getVersion().version();
    }

    @Given("the server is running")
    public void theServerIsRunning() {
        System.out.println("Server is running");
    }

    @When("the client calls {string}")
    public void theClientCalls(String arg0) {
        System.out.println("Client calls"+arg0+".");
        restTemplate = new TestRestTemplate();
        response = this.restTemplate.getForEntity("http://localhost:8080/version", Version.class);
        System.out.println("Response: "+response.getBody().version());
        fetchVersion = response.getBody().version();
    }

    @Then("the client receives server version")
    public void theClientReceivesServerVersion() {
        System.out.println("Client receives server version");
        assertEquals(fetchVersion, versionFromAppConfig);
        assertEquals(response.getBody().hashCode(), appConfig.getVersion().hashCode());
        System.out.println("END, even the hashcode is same.");
    }

    @And("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int arg0) {
        System.out.println("Client receives status code of"+arg0+".");
        assertEquals(arg0, response.getStatusCode().value());
        System.out.println("END, status code is same.");
    }
}
