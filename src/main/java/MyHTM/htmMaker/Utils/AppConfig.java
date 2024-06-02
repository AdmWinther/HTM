package MyHTM.htmMaker.Utils;

import MyHTM.htmMaker.Model.Util.Version;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String version;
    private String name;

    // getters and setters

    public Version getVersion() {
        return new Version(this.version);
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
