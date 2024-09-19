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
                "ChrisPrz"+Math.round(Math.random()*10e2)+"@gmail.com",
                "$2a$12$epLoy.JlekCaSGhQLa3bVucC41s7273OqSxWzGRJO4STVwJC.AkTq",
                "User");
        myUserRepository.save(myUser);
        return myUser;
    }

    public List<MyUser> getAll() {
        return myUserRepository.findAll();
    }

    public DataBaseOperationResult
    save(MyUser user) {
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
            throw new IllegalArgumentException("The email address is already assigned to another user.");
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
        //the email address of the user is used as the username
        return myUserRepository.findByEmailAddress(username);
    }

    public MyUser generateUser() {
        Optional<MyUser> user = myUserRepository.findByEmailAddress("user@user.com");
        if(user.isPresent()) {
            throw new IllegalArgumentException("The user already exists");
        } else {
            MyUser myUser = new MyUser(
                    "User",
                    "user",
                    "user@user.com",
                    "$2a$12$epLoy.JlekCaSGhQLa3bVucC41s7273OqSxWzGRJO4STVwJC.AkTq",
                    "USER");
            return myUserRepository.save(myUser);
        }
    }

    public MyUser generateAdmin() {
        Optional<MyUser> user = myUserRepository.findByEmailAddress("admin@admin.com");
        if(user.isPresent()) {
            throw new IllegalArgumentException("The user already exists");
        } else {
            MyUser myUser = new MyUser(
                    "AdminName",
                    "adminLastName",
                    "admin@admin.com",
                    "$2a$12$epLoy.JlekCaSGhQLa3bVucC41s7273OqSxWzGRJO4STVwJC.AkTq",
                    "ADMIN");
            return myUserRepository.save(myUser);
        }
    }

    public void eraseUserTable() {
        try {
            myUserRepository.deleteAll();
        } catch (Exception e) {
            throw new RuntimeException("User table erase failed! "+e.getMessage());
        }
    }
}
