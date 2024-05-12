package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.Organization;
import MyHTM.htmMaker.Service.Identity.OrganizationService;
import MyHTM.htmMaker.Service.Identity.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    OrganizationService organizationService;
    UserService userService;

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
        organizationService.save(organization);
        return organization;
    }

    @GetMapping("/getAll")
    public List<Organization> getAll() {
        return organizationService.getAll();
    }
}
