package MyHTM.htmMaker.Repository.Identity;

import MyHTM.htmMaker.Model.Identity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<Users, String>{
    //Method to find user by email.
    Optional<Users> findByEmailAddress(String emailAddress);

}
