package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.MyUser;
import MyHTM.htmMaker.Model.Util.Version;
import MyHTM.htmMaker.Service.Identity.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


@RestController
@RequestMapping(path = "/root")
public class RootController {

    MyUserService myUserService;

    @Autowired
    public RootController(MyUserService myUserService, PasswordEncoder passwordEncoder) {
        this.myUserService = myUserService;
    }

    //create a post endpoint that receives username and password form the post request
//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/test")
    public Version testRoot(@RequestHeader HttpHeaders headers) {
        System.out.println("root/test is called by a get request.");
        return new Version("9.9.9");
    }

    //SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    //SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    //SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    //SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    //create a post endpoint that receives username and password form the post request
//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/csrf")
    public String sendCSRF(@RequestHeader HttpHeaders headers) {
        System.out.println("root/csrf is called by a get request.");
        //generate a CSRF token
//        CookieCsrfTokenRepository cookie = new CookieCsrfTokenRepository();
        CookieCsrfTokenRepository myCookie = CookieCsrfTokenRepository.withHttpOnlyFalse();
        //system out the generated token
        System.out.println(myCookie.generateToken(null).getToken());
        return myCookie.generateToken(null).toString();
    }
    //SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    //SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    //SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    //SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    //SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    //SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS


    @PostMapping("/logger")
    public String login() {
//        System.out.println("Username: " + username);
//        System.out.println("Password: " + password);
        return "shakira";
    }

    //create a get endpoint that receives username and password form the post request
    @GetMapping("/userDetailServiceTest")
    public UserDetails userDetailServiceTest()
    {
        return loadUserByUsername("user");
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> myUser = myUserService.findUserByUsername(username);
        if(myUser.isPresent()) {
            MyUser userObject = myUser.get();
            UserDetails userDetails = User.builder()
                    .username(userObject.getEmailAddress())
                    .password(userObject.getPassword())
                    .roles(userObject.getRole())
                    .build();
            return userDetails;
        } else {
            throw new UsernameNotFoundException("User"+username+" not found");
        }
    }
}
