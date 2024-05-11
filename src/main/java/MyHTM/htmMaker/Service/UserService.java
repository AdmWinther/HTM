package MyHTM.htmMaker.Service;

import MyHTM.htmMaker.Model.Identity.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    public User generateRandomUser() {
        return new User("Christian"+Math.round( Math.random()*10e2), "Perez", "ChrisPrz"+Math.round(Math.random()*10e2)+"@gmail.com");
    }
}
