package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.Users;
import MyHTM.htmMaker.Service.Identity.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello world from UserController!";
    }

    @GetMapping("/generateRandomUser")
    public Users generateRandomUser() {
//        return new AppUser("Christian"+Math.round( Math.random()*10e2), "Perez", "ChrisPrz"+Math.round(Math.random()*10e2)+"@gmail.com", "dfafd");
        return userService.generateRandomUser();
    }

    @GetMapping("/getAll")
    public List<Users> getAll() {
        return userService.getAll();
    }

    @PostMapping("/newUser")
    public void newUser(@RequestBody UserRequest userRequest) {
        //the username and last name is sent via request body
        Users user = new Users(
                userRequest.getName(),
                userRequest.getLastName(),
                userRequest.getEmail(),
                userRequest.getOrganizationId());

        System.out.println("User is received"+ userRequest.getName());
        userService.save(user);
    }
}
