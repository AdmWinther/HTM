package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.MyUser;
import MyHTM.htmMaker.Service.Identity.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/root")
public class RootController {

    MyUserService myUserService;

    @Autowired
    public RootController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    //create a post endpoint that receives username and password form the post request
    @GetMapping("/test")
    public String checkLogin() {
        return "Hello world from RootController!";
    }

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
