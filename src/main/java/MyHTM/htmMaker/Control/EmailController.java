package MyHTM.htmMaker.Control;

import MyHTM.htmMaker.Model.Identity.Email;
import MyHTM.htmMaker.Model.Util.Util.ID;
import MyHTM.htmMaker.Service.EmailService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/email")
public class EmailController {
    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/generateRandomEmail")
    public Email getEmail() {
        return emailService.generateRandomEmail();
    }

    @GetMapping("/getAllEmails")
    public List<Email> getallEmail() {
        return emailService.getAllEmails();
    }

}
