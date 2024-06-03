package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.Organization;
import MyHTM.htmMaker.Model.Identity.Users;
import MyHTM.htmMaker.Model.Util.OrganizationRequest;
import MyHTM.htmMaker.Service.DataBaseOperationResult;
import MyHTM.htmMaker.Service.Identity.OrganizationService;
import MyHTM.htmMaker.Service.Identity.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    private final OrganizationService organizationService;
    private final UserService userService;


    @Autowired
    public OrganizationController(
            OrganizationService organizationService,
            UserService userService)
    {
        this.organizationService = organizationService;
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello World from OrganizationController!";
    }

    @GetMapping("/generateRandomOrganization")
    public Organization generateRandomOrganization() {
        Organization organization = organizationService.generateRandomOrganization();
        organizationService.saveTemporary(organization);
        return organization;
    }

    @GetMapping("/getAll")
    public List<Organization> getAll() {
        return organizationService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/newOrganization")
    public DataBaseOperationResult newOrganization(@RequestBody OrganizationRequest organizationRequest) {

        System.out.println("new Organization started!");
        System.out.println("Organization Name: " + organizationRequest.getOrganizationName());

        Users user = new Users(
            organizationRequest.getSuperuserName(),
            organizationRequest.getSuperuserLastname(),
            organizationRequest.getSuperuserEmailAddress(),
            organizationRequest.getSuperuserPassword());


        DataBaseOperationResult MakingNewUserResult = userService.save(user);
        if(!MakingNewUserResult.isOperationDone()) {
            return MakingNewUserResult;
        } else {
            Users registeredUser = userService.findUserByEmailAddress(user.getEmailAddress());
            Organization organization = new Organization(
                organizationRequest.getOrganizationName(),
                    registeredUser.getId());
            organizationService.saveNewOrganization(organization);
            Organization registeredOrganization = organizationService.getOrganizationBySuperUserId(registeredUser.getId());

            DataBaseOperationResult dataBaseOperationResult;
            dataBaseOperationResult = userService.updateUserOrganizationID(registeredUser.getId(), registeredOrganization.getId());
        }
        return new DataBaseOperationResult(true, "Organization saved successfully");
    }
}
