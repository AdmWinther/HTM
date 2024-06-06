package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.Superuser;
import MyHTM.htmMaker.Service.SuperuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/superuser")
public class SuperuserController {
    private final SuperuserService superuserService;

    @Autowired
    public SuperuserController(SuperuserService superuserService) {
        this.superuserService = superuserService;
    }


    @GetMapping("/test")
    public String test() {
        return "Hello World from SuperuserController!";
    }

    @GetMapping("/getAll")
    public List<Superuser> getAll() {
        return superuserService.getAll();
    }
}
