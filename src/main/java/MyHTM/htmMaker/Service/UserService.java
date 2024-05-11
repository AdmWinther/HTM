package MyHTM.htmMaker.Service;

import MyHTM.htmMaker.Model.Identity.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    public User generateRandomUser() {
        return new User("Christian", "Perez", "ChrisPrz@gmail.com");
    }
}
