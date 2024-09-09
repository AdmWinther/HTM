package MyHTM.htmMaker.Service.Identity;

import MyHTM.htmMaker.Model.Identity.MyUser;
import MyHTM.htmMaker.Model.Identity.Organization;
import MyHTM.htmMaker.Service.DataBaseOperationResult;
//import MyHTM.htmMaker.Service.SuperuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import MyHTM.htmMaker.Repository.Identity.OrganizationRepository;

import java.util.List;

@Component
public class OrganizationService {

    private final MyUserService myUserService;
//    private final SuperuserService superuserService;
    OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, MyUserService myUserService) {
        this.organizationRepository = organizationRepository;
        this.myUserService = myUserService;
//        this.superuserService = superuserService;
    }

    public Organization generateRandomOrganization() {
        MyUser myUser = myUserService.generateRandomUser();
        Organization organization = new Organization("My Organization", myUser.getId());
        myUserService.save(myUser);
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

    public DataBaseOperationResult RecordNewOrganization(MyUser user, Organization organization) {
        //check if there is a user with the same email address in the database.
        boolean isEmailAddressValid = myUserService.isEmailAddressValid(user.getEmailAddress());
        if(!isEmailAddressValid) {
            throw new RuntimeException("Either a user is already registered with this email address or the email address in not in the right format.");
        } else {
            MyUser registeredUser = myUserService.saveAndReturn(user);
            organization.setSuperUserId(registeredUser.getId());
            Organization registeredOrganization = organizationRepository.save(organization);
            myUserService.save(registeredUser);
            return new DataBaseOperationResult(true, "Organization saved successfully");
        }
    }
}
