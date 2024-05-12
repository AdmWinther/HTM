package MyHTM.htmMaker.Repository.Identity;

import MyHTM.htmMaker.Model.Identity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<AppUser, String>{
}
