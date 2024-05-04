package MyHTM.htmMaker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.System.getProperty;

@SpringBootApplication
public class HtmMakerAppApplication {

	@RestController
	public class VersionController {
		private final AppConfig appConfig;
        public VersionController(AppConfig appConfig) {
            this.appConfig = appConfig;
        }

        @GetMapping("/version")
		public String getVersion() {
			System.out.println("Version 1.02");

			return this.appConfig.getVersion();
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(HtmMakerAppApplication.class, args);
	}

}
