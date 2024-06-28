package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.UserRole;
import MyHTM.htmMaker.Service.Identity.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/userRole")
public class UserRoleController {

    UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService){
        this.userRoleService = userRoleService;
    }

    @GetMapping("/test")
    public String test(){
        return "this is the test from UserRoleController!";
    }

    @GetMapping("/testUserRoleService")
    public String testUserRoleService(){
        return this.userRoleService.testUserRoleService();
    }

    @GetMapping("/getAll")
    public List<UserRole> getAll(){
        return this.userRoleService.getAll();
    }

    @GetMapping("/save")
    public UserRole save(){
        return this.userRoleService.save();
    }
}
