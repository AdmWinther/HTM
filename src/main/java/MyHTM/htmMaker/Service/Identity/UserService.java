package MyHTM.htmMaker.Service.Identity;

import MyHTM.htmMaker.Model.Identity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import MyHTM.htmMaker.Repository.Identity.UserRepository;

import java.util.List;

@Component
public class UserService {

    static UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Users generateRandomUser() {
        Users users = new Users("Christian"+Math.round( Math.random()*10e2), "Perez", "ChrisPrz"+Math.round(Math.random()*10e2)+"@gmail.com");
        userRepository.save(users);
        return users;
    }

    public List<Users> getAll() {
        return userRepository.findAll();
    }

    public void save(Users user) {
        userRepository.save(user);
    }
}
