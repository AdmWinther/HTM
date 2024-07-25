package MyHTM.htmMaker.Repository;

import MyHTM.htmMaker.Model.Identity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoleRepository extends JpaRepository<Role, String> {
}
