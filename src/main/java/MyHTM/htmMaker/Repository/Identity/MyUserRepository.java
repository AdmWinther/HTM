package MyHTM.htmMaker.Repository.Identity;

import MyHTM.htmMaker.Model.Identity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface MyUserRepository extends JpaRepository<MyUser, String>{
    //Method to find user by email.
    Optional<MyUser> findByEmailAddress(String emailAddress);

}
