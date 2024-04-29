package MyHTM.htmMaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HtmMakerAppApplication {

	@RestController
	public class VersionController {
		@GetMapping("/version")
		public String getVersion() {
			return "1.0";
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(HtmMakerAppApplication.class, args);
	}

}
