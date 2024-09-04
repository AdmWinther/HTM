package MyHTM.htmMaker.Utils;

import MyHTM.htmMaker.Model.Util.Version;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    @Value("${app.version}")
    private String version;

    @Value("${app.name}")
    private String name;

    @Value("${app.domain}")
    private String domain;

    @Value("${app.roles}")
    private List<String> roles;

    // getters and setters

    public Version getVersion() {

        //get version from the application.properties file

        return new Version(this.version);
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public List<String> getRoles() {
        return roles;
    }
}
