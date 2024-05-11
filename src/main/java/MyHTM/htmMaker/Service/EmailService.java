package MyHTM.htmMaker.Service;

import MyHTM.htmMaker.Model.Identity.Email;
import MyHTM.htmMaker.Model.Util.Util.ID;
import MyHTM.htmMaker.Repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailService {
    private EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Transactional
    public Email generateRandomEmail() {
        String emailText = "HenryFord"+ Math.round(Math.random()*10e2) + "@gmailService.com";
        Email email = new Email(emailText);
        emailRepository.save(email);
        return email;
    }

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }
}
