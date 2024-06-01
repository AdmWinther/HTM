package MyHTM.htmMaker.Control;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

    //create a post endpoint that receives username and password form the post request
    @PostMapping("/")
    public String checkLogin() {
        return "Hello world from LoginController!";
    }
}
