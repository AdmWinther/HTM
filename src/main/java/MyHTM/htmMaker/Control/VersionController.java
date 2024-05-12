package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Utils.AppConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/version")
public class VersionController {

    private final AppConfig appConfig;
    public VersionController(AppConfig appConfig) {
            this.appConfig = appConfig;
        }

    @GetMapping()
    public String getVersion() {
        System.out.println("Version 1.0x");

        return this.appConfig.getVersion();
    }
}
