package MyHTM.htmMaker.Repository;

import MyHTM.htmMaker.Model.Identity.Superuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperuserRepository extends JpaRepository<Superuser, String> {

}
