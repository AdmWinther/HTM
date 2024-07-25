package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Util.Version;
import MyHTM.htmMaker.Utils.AppConfig;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/version")
public class VersionController {

    private final AppConfig appConfig;
    public VersionController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping()
    public Version getVersion() {
        System.out.println(this.appConfig.getVersion());
        System.out.println("Version GET is running.");
        return this.appConfig.getVersion();
    }

    @PostMapping()
    public Version postVersion() {
        System.out.println(this.appConfig.getVersion());
        System.out.println("Version Post is running.");
        return this.appConfig.getVersion();
    }
}
