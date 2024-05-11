package MyHTM.htmMaker.Repository;

import MyHTM.htmMaker.Model.Identity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmailRepository extends JpaRepository<Email, String> {

}
