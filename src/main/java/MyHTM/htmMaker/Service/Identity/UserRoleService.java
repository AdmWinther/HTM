package MyHTM.htmMaker.Service.Identity;

import MyHTM.htmMaker.Model.Identity.UserRole;
import MyHTM.htmMaker.Model.Util.Role;
import MyHTM.htmMaker.Repository.Identity.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRoleService {

    UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository){
        this.userRoleRepository = userRoleRepository;
    }

    public String testUserRoleService(){
        return "this is the test from UserRoleService!";
    }

    public List<UserRole> getAll(){
        return userRoleRepository.findAll();
    }

    public UserRole save() {
        UserRole userRole = new UserRole("test2", Role.ADMIN);
        return this.userRoleRepository.save(userRole);
    }
}
