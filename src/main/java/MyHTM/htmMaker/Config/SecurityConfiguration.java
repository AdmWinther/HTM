package MyHTM.htmMaker.Config;

//import MyHTM.htmMaker.AuthenticationSuccessHandler;
import MyHTM.htmMaker.Service.Identity.MyUserDetailService;
import MyHTM.htmMaker.Utils.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private MyUserDetailService userDetailService;

    @Autowired
    public SecurityConfiguration(MyUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AppConfig appConfig) {
        try {
            httpSecurity.authorizeHttpRequests(registry->{
                //allow all get requests to the endpoint /version
                registry.requestMatchers("/version").permitAll();
                //allow all post requests to the endpoint /version
                registry.requestMatchers(HttpMethod.POST, "/version").permitAll();

                registry.requestMatchers(HttpMethod.POST, "/Login").permitAll();

                //The endpoint /api/user/test is open to all users
                registry.requestMatchers("/api/user/test").permitAll();
                registry.requestMatchers("api/user/getUserByEmail").permitAll();
                registry.requestMatchers("api/user/getUserByUsername").permitAll();

                //the endpoint for making a new user is open to all
                registry.requestMatchers(HttpMethod.POST,"/api/user/newUser").permitAll();
//                registry.requestMatchers("/version").permitAll();


                //The endpoint  /api/organization/newOrganization is open to ADMIN users
                registry.requestMatchers("/api/organization/newOrganization").permitAll();


                //The endpoint /api/organization/test is open to all users
                registry.requestMatchers("/api/organization/test").permitAll();
                //The endpoint /api/*/getAll is open to normal users
                registry.requestMatchers("/api/organization/getAll").hasRole("User");
                //The endpoint /api/organization/generateRandomOrganization is open to all users
                registry.requestMatchers("/api/organization/generateRandomOrganization").hasRole("Admin");

                registry.requestMatchers("/api/user/getAll").hasRole("User");
                registry.requestMatchers("/api/user/generateRandomUser").permitAll();
                registry.requestMatchers("/api/user/generateUser").permitAll();
                registry.requestMatchers("/api/user/generateAdmin").permitAll();

                registry.requestMatchers("/api/role/test").permitAll();

                //The endpoint /api/superuser/newUser is open to superusers
                registry.requestMatchers("/api/superuser/test").hasRole("User");
                //the endpoint /api/superuser/getAll is open to superusers
                registry.requestMatchers(HttpMethod.POST, "/root/logger").permitAll();
                registry.requestMatchers("/root/userDetailServiceTest").permitAll();

                //If any other request needs authentication
//                registry.anyRequest().authenticated();
                registry.anyRequest().permitAll();
            }).csrf(csrf->{
                 csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
            }).addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class)
            .formLogin(httpSecurityFormLoginConfigurer -> {
                httpSecurityFormLoginConfigurer
                    .successHandler((request, response, authentication) -> {
                        response.setStatus(200);
                        response.setHeader("Location", "dashboard");
                    })
                    .failureHandler(((request, response, exception) ->
                            response.setStatus(401))
                    )
                    .permitAll();
            }).logout(httpSecurityLogoutConfigurer -> {
                System.out.println("Logout is called.");
                httpSecurityLogoutConfigurer
                    .logoutSuccessHandler((request, response, authentication) -> {
                        response.setStatus(200);
                        response.setHeader("Location", "logout");
                    }).permitAll();
            }).httpBasic(Customizer.withDefaults());

            httpSecurity.cors(Customizer.withDefaults());

            return httpSecurity.build();
        } catch (Exception e) {
            throw new RuntimeException("Error in security configuration. Build failed."+e.getMessage()) ;
        }
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return  provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
