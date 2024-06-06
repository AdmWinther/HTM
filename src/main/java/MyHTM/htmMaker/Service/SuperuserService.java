package MyHTM.htmMaker.Service;

import MyHTM.htmMaker.Model.Identity.Organization;
import MyHTM.htmMaker.Model.Identity.Superuser;
import MyHTM.htmMaker.Model.Identity.MyUser;
import MyHTM.htmMaker.Repository.SuperuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuperuserService{
    private final SuperuserRepository superuserRepository;

    @Autowired
    public SuperuserService(SuperuserRepository superuserRepository) {
        this.superuserRepository = superuserRepository;
    }

    public List<Superuser> getAll() {
        return superuserRepository.findAll();
    }

    public void save(Organization organization, MyUser superuser) {
        this.superuserRepository.save(new Superuser(organization, superuser));
    }
}
