package MyHTM.htmMaker.Service;

import MyHTM.htmMaker.Model.Identity.Role;
import MyHTM.htmMaker.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void initializeRoleTable() {
        try {
            this.eraseRoleTable();
            this.addAllRoles();
        } catch (Exception e) {
            throw new RuntimeException("Error in initializing roles: " + e.getMessage());
        }
    }

    private void addAllRoles() {
        List<Role> allRoles = this.roleRepository.findAll();
        if(allRoles.isEmpty()) {
            List<Role> result = new ArrayList<Role>();
            try{
                this.roleRepository.save(new Role("Admin"));
                this.roleRepository.save(new Role("Manager"));
                this.roleRepository.save(new Role("Project Manager"));
                this.roleRepository.save(new Role("Project Specialist"));
                this.roleRepository.save(new Role("Specialist"));
                this.roleRepository.save(new Role("Project Reviewer"));
                this.roleRepository.save(new Role("Reviewer"));
                this.roleRepository.save(new Role("Project Reader"));
                this.roleRepository.save(new Role("Reader"));
                this.roleRepository.save(new Role("Project Approver"));
                this.roleRepository.save(new Role("Approver"));
            } catch (Exception e) {
                throw new RuntimeException("Error in adding roles: " + e.getMessage());
            }
        }
    }

    private void eraseRoleTable() {
        try {
            this.roleRepository.deleteAll();
        } catch (Exception e) {
            throw new RuntimeException("Error in erasing roles: " + e.getMessage());
        }
    }
}
