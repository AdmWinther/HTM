package MyHTM.htmMaker.Service.Identity;

import MyHTM.htmMaker.Model.Identity.Users;
import MyHTM.htmMaker.Service.DataBaseOperationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import MyHTM.htmMaker.Repository.Identity.UserRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    private final UserRepository userRepository;

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

    public DataBaseOperationResult save(Users user) {
        //Check if the user already exists by searching for the user email
        Optional<Users> existingUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (existingUser.isPresent()) {
             return new DataBaseOperationResult(false, "The email address is already assinged to another user.");
        } else {
            //todo: check if the user OrganizationId exists
            userRepository.save(user);
            return new DataBaseOperationResult(true, "User saved successfully");
        }
    }

    public Users findUserByEmailAddress(String emailAddress) {
        Optional<Users> existingUser = userRepository.findByEmailAddress(emailAddress);
        return existingUser.orElse(null);
    }

    public DataBaseOperationResult updateUserOrganizationID(String userId, String organizationId) {
        Optional<Users> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            Users user = existingUser.get();
            user.setOrganizationId(organizationId);
            userRepository.save(user);
            return new DataBaseOperationResult(true, "User organization ID updated successfully");
        } else {
            return new DataBaseOperationResult(false, "User not found");
        }
    }
}
