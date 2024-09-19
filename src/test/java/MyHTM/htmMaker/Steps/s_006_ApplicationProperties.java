package MyHTM.htmMaker.Steps;

import MyHTM.htmMaker.HtmMakerAppApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import MyHTM.htmMaker.Utils.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class s_006_ApplicationProperties {
//    private final AppConfig appConfig;
    private List<String> rolesFromAppConfig;
    private String theAppDomain;
    private boolean isVerbose;


//    public s_006_ApplicationProperties(AppConfig appConfig) {
//        this.appConfig = appConfig;
//    }

    @Given("the server is running App_Prop")
    public void theServerIsRunningAppProp() {
        //start the spring boot server

//        HtmMakerAppApplication.main(new String[]{});
    }

    @When("the client calls app_config_getRoles")
    public void run_app_config_getRoles() {
        System.out.println("Client calls app_config_getRoles.");
        AppConfig appConfig = new AppConfig();
        this.rolesFromAppConfig = appConfig.getRoles();
        System.out.println(rolesFromAppConfig);
    }

    @Then("the client receives app.roles")
    public void theClientReceivesAppRoles() {
        System.out.println("roles are read.");
        assertEquals(Arrays.asList("ADMIN", "USER"), rolesFromAppConfig);
    }

    @When("the client calls app_domain")
    public void theClientCallsApp_domain() {
        AppConfig appConfig = new AppConfig();
        this.theAppDomain = appConfig.getDomain();
        System.out.println(this.theAppDomain);
    }

    @Then("the app_domain is equal to {string}")
    public void theApp_domainIsEqualTo(String arg0) {
        assertEquals("http://localhost:3000", theAppDomain);
    }

    @When("the client calls app_roles")
    public void theClientCallsApp_roles() {
        AppConfig appConfig = new AppConfig();

        this.rolesFromAppConfig = appConfig.getRoles();
        System.out.println(this.rolesFromAppConfig);
    }

    @Then("the app_domain is equal to ADMIN_USER")
    public void theApp_domainIsEqualToADMIN_USER() {
        assertEquals(Arrays.asList("ADMIN", "USER"), rolesFromAppConfig);
    }

    @When("the client calls app_verbose")
    public void theClientCallsApp_verbose() {
        AppConfig appConfig = new AppConfig();
        this.isVerbose = appConfig.isVerbose();
    }

    @Then("the app_verbose is equal to True")
    public void theApp_verboseIsEqualToTrue() {
        assertTrue(isVerbose);
    }
}
