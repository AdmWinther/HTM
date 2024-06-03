package MyHTM.htmMaker.Service.Identity;

import MyHTM.htmMaker.Model.Identity.Users;
import MyHTM.htmMaker.Model.Identity.Organization;
import MyHTM.htmMaker.Model.Util.OrganizationRequest;
import MyHTM.htmMaker.Service.DataBaseOperationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import MyHTM.htmMaker.Repository.Identity.OrganizationRepository;

import java.util.List;

@Component
public class OrganizationService {

    private final UserService userService;
    OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, UserService userService) {
        this.organizationRepository = organizationRepository;
        this.userService = userService;
    }

    public Organization generateRandomOrganization() {
        Users users = userService.generateRandomUser();
        Organization organization = new Organization("My Organization", users.getId());
        users.setOrganizationId(organization.getId());
        userService.save(users);
        return organization;
    }

    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    //todo: this method must be deleted.
    public void saveTemporary(Organization organization) {
        //todo: Check if the organization already exists
        //todo: Check if the organization name is unique
        //todo: check if the super user does not exist in another organization
        organizationRepository.save(organization);
    }

    public DataBaseOperationResult saveNewOrganization(Organization organization) {
        //todo: Check if the organization already exists
        //todo: Check if the organization name is unique
        //todo: check if the super user does not exist in another organization
        organizationRepository.save(organization);
        return new DataBaseOperationResult(true, "Organization saved successfully");
    }


    public Organization getOrganizationBySuperUserId(String id) {
        return organizationRepository.findBySuperUserId(id).orElse(null);
    }
}
