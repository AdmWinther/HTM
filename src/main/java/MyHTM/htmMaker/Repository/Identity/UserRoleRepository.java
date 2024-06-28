package MyHTM.htmMaker.Repository.Identity;

import MyHTM.htmMaker.Model.Identity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
