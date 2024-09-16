package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.Organization;
import MyHTM.htmMaker.Model.Identity.MyUser;
import MyHTM.htmMaker.Model.Util.OrganizationAPIPostRequest;
import MyHTM.htmMaker.Service.DataBaseOperationResult;
import MyHTM.htmMaker.Service.Identity.OrganizationService;
import MyHTM.htmMaker.Service.Identity.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    private final OrganizationService organizationService;
    private final MyUserService myUserService;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public OrganizationController(
            OrganizationService organizationService,
            MyUserService myUserService,
            PasswordEncoder passwordEncoder)
    {
        this.organizationService = organizationService;
        this.myUserService = myUserService;
        this.passwordEncoder = passwordEncoder;
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

    @PostMapping("/new")
    public DataBaseOperationResult newOrganization(@RequestBody OrganizationAPIPostRequest organizationRequest) {

        System.out.println("new Organization started!");
        System.out.println("Organization Name: " + organizationRequest.getOrganizationName());

        MyUser user = new MyUser(
            organizationRequest.getSuperuserName(),
            organizationRequest.getSuperuserLastname(),
            organizationRequest.getSuperuserEmailAddress(),
            passwordEncoder.encode(organizationRequest.getSuperuserPassword()),
            "User");

        Organization organization = new Organization(organizationRequest.getOrganizationName());

        DataBaseOperationResult dataBaseOperationResult = this.organizationService.RecordNewOrganization(user, organization);
        return dataBaseOperationResult;
    }
}
