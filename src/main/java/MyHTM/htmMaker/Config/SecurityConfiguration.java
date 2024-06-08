package MyHTM.htmMaker.Config;

import MyHTM.htmMaker.Service.Identity.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private MyUserDetailService userDetailService;

    @Autowired
    public SecurityConfiguration(MyUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        try {
            return httpSecurity.authorizeHttpRequests(registry->{
                //The endpoint /api/user/test is open to all users
                registry.requestMatchers("/api/user/test").permitAll();
                registry.requestMatchers("api/user/getUserByEmail").permitAll();

                //the endpoint for making a new user is open to all
                registry.requestMatchers("/api/user/newUser").permitAll();
                registry.requestMatchers("/version").permitAll();


                //The endpoint /api/organization/newOrganization is open to ADMIN users
                registry.requestMatchers("/api/organization/newOrganization").permitAll();


                //The endpoint /api/organization/test is open to all users
                registry.requestMatchers("/api/organization/test").permitAll();

                //The endpoint /api/*/getAll is open to normal users
                registry.requestMatchers("/api/organization/getAll").hasRole("User");
                registry.requestMatchers("/api/user/getAll").hasRole("User");

                //The endpoint /api/organization/generateRandomOrganization is open to all users
                registry.requestMatchers("/api/organization/generateRandomOrganization").hasRole("Admin");
                //The endpoint /api/user/generateRandomUser is open to Admin
                registry.requestMatchers("/api/user/generateRandomUser").hasRole("Admin");

                //The endpoint /api/superuser/newUser is open to superusers
                registry.requestMatchers("/api/superuser/test").hasRole("Superuser");
                //the endpoint /api/superuser/getAll is open to superusers

                //If any other request needs authentication
                registry.anyRequest().authenticated();
            }).formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                    .build();
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
