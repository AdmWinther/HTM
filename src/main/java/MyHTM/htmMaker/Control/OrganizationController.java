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


    @Autowired
    public OrganizationController(
            OrganizationService organizationService,
            UserService userService)
    {
        this.organizationService = organizationService;
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

    @PostMapping("/newOrganization")
    public DataBaseOperationResult newOrganization(@RequestBody OrganizationRequest organizationRequest) {
        Organization organization = new Organization(
            organizationRequest.getOrganizationName(),
            organizationRequest.getSuperuserName());
        Users user = new Users(
            organizationRequest.getSuperuserName(),
            organizationRequest.getSuperuserLastname(),
            organizationRequest.getSuperuserEmailAddress(),
            organizationRequest.getSuperuserPassword());


        return organizationService.saveNewOrganization(organization);
    }
}
