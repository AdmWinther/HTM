package MyHTM.htmMaker.Service.Identity;

import MyHTM.htmMaker.Model.Identity.MyUser;
import MyHTM.htmMaker.Model.Util.Email;
import MyHTM.htmMaker.Service.DataBaseOperationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import MyHTM.htmMaker.Repository.Identity.MyUserRepository;

import java.util.List;
import java.util.Optional;

@Component
public class MyUserService {

    private final MyUserRepository myUserRepository;

    @Autowired
    public MyUserService(MyUserRepository myUserRepository){
        this.myUserRepository = myUserRepository;
    }

    public MyUser generateRandomUser() {
        MyUser myUser = new MyUser("Christian"+Math.round( Math.random()*10e2),
                "Perez",
                "test"+Math.round( Math.random()*10e2),
                "ChrisPrz"+Math.round(Math.random()*10e2)+"@gmail.com",
                "$2a$12$UCQGsmuHpa3rfgCGPV0nkO9Hc75go8RHuZNpU4/sNutFKhvTJ0n22",
                "Admin");
        myUserRepository.save(myUser);
        return myUser;
    }

    public List<MyUser> getAll() {
        return myUserRepository.findAll();
    }

    public DataBaseOperationResult save(MyUser user) {
        //Check if the user already exists by searching for the user email
        Optional<MyUser> existingUser = myUserRepository.findByEmailAddress(user.getEmailAddress());
        if (existingUser.isPresent()) {
             return new DataBaseOperationResult(false, "The email address is already assinged to another user.");
        } else {
            //todo: check if the user OrganizationId exists
            myUserRepository.save(user);
            return new DataBaseOperationResult(true, "User saved successfully");
        }
    }

    public MyUser saveAndReturn(MyUser user) {
        //Check if the user already exists by searching for the user email
        Optional<MyUser> existingUser = myUserRepository.findByEmailAddress(user.getEmailAddress());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("The email address is already assinged to another user.");
        } else {
            //todo: check if the user OrganizationId exists
            return myUserRepository.save(user);
        }
    }

    public Optional<MyUser> findUserByEmailAddress(String emailAddress) {
        return myUserRepository.findByEmailAddress(emailAddress);
    }

    public boolean isEmailAddressValid(String emailAddress) {
        Optional<MyUser> existingUser = myUserRepository.findByEmailAddress(emailAddress);
        if(existingUser.isPresent() || !Email.isEmail(emailAddress)){
            return false;
        } else {
            return true;
        }
    }

    public Optional<MyUser> findUserByUsername(String username) {
        return myUserRepository.findByUsername(username);
    }
}
