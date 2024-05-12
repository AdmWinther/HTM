package MyHTM.htmMaker.Repository.Identity;

import MyHTM.htmMaker.Model.Identity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrganizationRepository extends JpaRepository<Organization, String> {
}
