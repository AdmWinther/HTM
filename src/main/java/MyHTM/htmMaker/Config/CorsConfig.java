package MyHTM.htmMaker.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import MyHTM.htmMaker.Utils.AppConfig;

@Configuration
public class CorsConfig {

    private final AppConfig appConfig;

    public CorsConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfigurationSource source = corsConfigurationSource();
        return new CorsFilter(source);
    }

    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin(appConfig.getDomain());
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        configuration.addExposedHeader("Content-Length"); // Add headers you want to expose
        configuration.addExposedHeader("X-Xsrf-Token"); // Example of a custom header

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
