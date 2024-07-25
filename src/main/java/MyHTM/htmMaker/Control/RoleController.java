package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/initialize")
    public String initializeRoleTable() {
        try{
            this.roleService.initializeRoleTable();
            return "Role Table initialized successfully!";
        } catch (Exception e){
            return "Role Table initialization failed!";
        }
    }
}
