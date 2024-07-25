package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.MyUser;
import MyHTM.htmMaker.Model.Util.UserAPIPostRequest;
import MyHTM.htmMaker.Service.DataBaseOperationResult;
import MyHTM.htmMaker.Service.Identity.MyUserService;
import MyHTM.htmMaker.Utils.Single;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
public class MyUserController {
//    @Autowired
    private MyUserService myUserService;
//    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MyUserController(MyUserService myUserService, PasswordEncoder passwordEncoder) {
        this.myUserService = myUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/test")
    public String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        } else {
                return "Hello to unauthenticated user from UserController!";
        }
    }

    @GetMapping("/generateRandomUser")
    public MyUser generateRandomUser() {
//        return new AppUser("Christian"+Math.round( Math.random()*10e2), "Perez", "ChrisPrz"+Math.round(Math.random()*10e2)+"@gmail.com", "dfafd");
        return myUserService.generateRandomUser();
    }

    @GetMapping("/resetUserTable")
    public String resetUserTable() {
        try {
            myUserService.eraseUserTable();
            myUserService.generateAdmin();
            myUserService.generateUser();
            return "User Table erase successfully!";
        } catch (Exception e) {
            return "User Table erase failed!"+e.getMessage();
        }
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAll")
    public List<MyUser> getAll() {
        System.out.println("Get all users");
        List<MyUser> myUsers = myUserService.getAll();
//        for (MyUser myUser : myUsers) {
//            System.out.println(myUser.getName()+" "+myUser.getLastName());
//        }
        return myUsers;
    }

    //allow cross-origin requests
    @CrossOrigin("http://localhost:5173/")
    @PostMapping(value = "/newUser", produces = "application/json", consumes = "application/json")
    public DataBaseOperationResult newUser(@RequestBody MyUser myUser) {
        System.out.println("the endpoint is reached.");
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        myUser.setID();
        System.out.println(myUser.getId());
        System.out.println(myUser.getName());
        System.out.println(myUser.getLastName());
        System.out.println(myUser.getEmailAddress());
        System.out.println(myUser.getPassword());
        System.out.println(myUser.getRole());
        return myUserService.save(myUser);
    }

//    @CrossOrigin("http://localhost:5173")
//    @GetMapping(value = "/newUser")
//    public String newUserGet() {
//        return "We Got a new user request!";
//    }

    @CrossOrigin(origins = "http://localhost:5173/")
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

    @GetMapping("/userType")
    public Single userType() {
        System.out.println("User Type is reached.");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            MyUser myUser = myUserService.findUserByUsername(userDetails.getUsername()).get();
            String type = myUser.getRole();
            return new Single(type);
        } else {
            return new Single("Unauthenticated");
        }
    }
}
