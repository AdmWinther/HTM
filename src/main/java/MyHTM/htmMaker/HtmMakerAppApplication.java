package MyHTM.htmMaker;

import MyHTM.htmMaker.Utils.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static java.lang.System.getProperty;

@SpringBootApplication
public class HtmMakerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtmMakerAppApplication.class, args);
	}


}
