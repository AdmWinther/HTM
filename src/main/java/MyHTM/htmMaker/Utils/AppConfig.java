package MyHTM.htmMaker.Utils;

import MyHTM.htmMaker.Model.Util.Version;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    private static AppConfig instance;

    @Value("${app.version}")
    private String version;

    @Value("${app.verbose}")
    private boolean verbose;

    @Value("${app.name}")
    private String name;

    @Value("${app.domain}")
    private String domain;

    @Value("#{'${app.roles}'.split(',')}")
    private List<String> roles;

    @PostConstruct
    private void initialize() {
        instance = this;
    }

    public static AppConfig getInstance() {
        return instance;
    }

    // getters and setters

    public Version getVersion() {

        //get version from the application.properties file

        return new Version(this.version);
    }

    public boolean isVerbose() {
        return this.verbose;
    }

    public String getName() {
        return this.name.toString();
    }

    public String getDomain() {
        return (this.domain);
    }

    public List<String> getRoles() {
        System.out.println("Roles: "+roles);
        return roles;
    }
}
