package MyHTM.htmMaker.Service.Identity;

import MyHTM.htmMaker.Model.Identity.AppUser;
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

    public AppUser generateRandomUser() {
        AppUser appUser = new AppUser("Christian"+Math.round( Math.random()*10e2), "Perez", "ChrisPrz"+Math.round(Math.random()*10e2)+"@gmail.com");
        userRepository.save(appUser);
        return appUser;
    }

    public List<AppUser> getAll() {
        return userRepository.findAll();
    }

    public void save(AppUser user) {
        userRepository.save(user);
    }
}
