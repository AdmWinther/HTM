package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.User;
import MyHTM.htmMaker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/generateRandomUser")
    public User getUser() {
        return userService.generateRandomUser();
    }
}
