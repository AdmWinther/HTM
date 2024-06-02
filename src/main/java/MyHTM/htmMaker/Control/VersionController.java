package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Util.Version;
import MyHTM.htmMaker.Utils.AppConfig;
import org.springframework.web.bind.annotation.CrossOrigin;
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

        //allow cross-origin requests
        @CrossOrigin(origins = "http://localhost:5173")
        @GetMapping()
        public Version getVersion() {
            System.out.println(this.appConfig.getVersion());
            return this.appConfig.getVersion();
        }
}
