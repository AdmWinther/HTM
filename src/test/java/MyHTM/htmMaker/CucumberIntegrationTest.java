package MyHTM.htmMaker;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/resources/feature",
        plugin = {"pretty", "html:target//cucumber"},
        glue = "com.#####.########.cucumberspringboot.cucumberglue"
)
public class CucumberIntegrationTest {}