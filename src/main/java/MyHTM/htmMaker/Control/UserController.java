package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.Users;
import MyHTM.htmMaker.Model.Util.UserRequest;
import MyHTM.htmMaker.Service.DataBaseOperationResult;
import MyHTM.htmMaker.Service.Identity.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAll")
    public List<Users> getAll() {
        System.out.println("Get all users");
        List<Users> users = userService.getAll();
        for (Users user : users) {
            System.out.println(user.getName());
        }
        return users;
    }

    //allow cross-origin requests
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping(value = "/newUser", produces = "application/json", consumes = "application/json")
    public DataBaseOperationResult newUser(@RequestBody UserRequest userRequest) {

        //the username and last name is sent via request body
        Users user = new Users(
                userRequest.getName(),
                userRequest.getLastname(),
                userRequest.getEmail(),
                userRequest.getPassword(),
                userRequest.getOrganizationId());

        return userService.save(user);
    }
}
