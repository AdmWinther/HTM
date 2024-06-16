package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.MyUser;
import MyHTM.htmMaker.Model.Util.UserAPIPostRequest;
import MyHTM.htmMaker.Service.DataBaseOperationResult;
import MyHTM.htmMaker.Service.Identity.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
public class MyUserController {
    private final MyUserService myUserService;

    @Autowired
    public MyUserController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello world from UserController!";
    }

    @GetMapping("/generateRandomUser")
    public MyUser generateRandomUser() {
//        return new AppUser("Christian"+Math.round( Math.random()*10e2), "Perez", "ChrisPrz"+Math.round(Math.random()*10e2)+"@gmail.com", "dfafd");
        return myUserService.generateRandomUser();
    }

    @GetMapping("/generateUser")
    public MyUser generateUser() {
//        return new AppUser("Christian"+Math.round( Math.random()*10e2), "Perez", "ChrisPrz"+Math.round(Math.random()*10e2)+"@gmail.com", "dfafd");
        return myUserService.generateUser();
    }

    @GetMapping("/generateAdmin")
    public MyUser generateAdmin() {
//        return new AppUser("Christian"+Math.round( Math.random()*10e2), "Perez", "ChrisPrz"+Math.round(Math.random()*10e2)+"@gmail.com", "dfafd");
        return myUserService.generateAdmin();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAll")
    public List<MyUser> getAll() {
        System.out.println("Get all users");
        List<MyUser> myUsers = myUserService.getAll();
        for (MyUser myUser : myUsers) {
            System.out.println(myUser.getName()+" "+myUser.getLastName());
        }
        return myUsers;
    }

    //allow cross-origin requests
    @CrossOrigin("http://localhost:5173")
    @PostMapping(value = "/newUser", produces = "application/json", consumes = "application/json")
    public DataBaseOperationResult newUser(@RequestBody UserAPIPostRequest userRequest) {

        //the username and last name is sent via request body
        MyUser user = new MyUser(
                userRequest.getName(),
                userRequest.getLastname(),
                userRequest.getUsername(),
                userRequest.getEmail(),
                userRequest.getPassword(),
                "Admin");

        return myUserService.save(user);
    }

    @CrossOrigin("http://localhost:5173")
    @GetMapping(value = "/newUser")
    public String newUserGet() {
        return "We Got a new user request!";
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getUserByEmail")
    public Optional<MyUser> getUserByEmail(@RequestParam String email) {
        Optional<MyUser> myUser = myUserService.findUserByEmailAddress(email);
        if(myUser.isPresent()) {
            return myUser;
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getUserByUsername")
    public Optional<MyUser> getUserByUsername(@RequestParam String username) {
        Optional<MyUser> myUser = myUserService.findUserByUsername(username);
        if(myUser.isPresent()) {
            return myUser;
        } else {
            return null;
        }
    }
}
