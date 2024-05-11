package MyHTM.htmMaker.Model.Identity;

import MyHTM.htmMaker.Model.Util.Util.ID;
import jakarta.persistence.*;

import static java.lang.StringTemplate.STR;

@Entity
@Table
public class Email {
    @Id
    @SequenceGenerator(
            name = "email_sequence", sequenceName = "email_sequence", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "email_sequence")
    private final String id;
    private final String address;
    public Email(String email) {
        if(isEmail(email)) {
            this.id = new ID().getId();
            int atIndex = email.indexOf('@');
            int dotIndex = email.lastIndexOf('.');
            String emailID = email.substring(0, atIndex);
            String domain = email.substring(atIndex + 1, dotIndex);
            String extension = email.substring(dotIndex + 1);
            this.address = STR."\{emailID}@\{domain}.\{extension}";
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    public Email() {
        this.id = new ID().getId();
        this.address = "";
    }

    //todo; This method must changed to private but we cannot do it now because the method is used in User class.
    public static boolean isEmail(String email) {
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        // Check that "@" exists, is not the first character, and has at least 3 characters between it and the "."
        if (atIndex > 0 && dotIndex > (atIndex + 3)) {
            // Check that there's at least one character before the "@"
            // the minimum number of characters before DOT is 5, for example: a@abc.de therefore DOT is at least 4.
            if(dotIndex > 4) {
                return email.length() - dotIndex > 2;
            }
            // and at least two after the last "."
        }
        return false;
    }
    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
