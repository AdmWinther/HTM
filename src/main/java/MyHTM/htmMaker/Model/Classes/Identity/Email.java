package MyHTM.htmMaker.Model.Classes.Identity;

import MyHTM.htmMaker.Model.Classes.ID;

public class Email {
    private final String id;
    private String emailID;
    private String domain;
    private String extension;
    private String address;
    public Email(String email) {
        if(isEmail(email)) {
            int atIndex = email.indexOf('@');
            int dotIndex = email.lastIndexOf('.');
            this.emailID = email.substring(0, atIndex);
            this.domain = email.substring(atIndex + 1, dotIndex);
            this.extension = email.substring(dotIndex + 1);
            this.address = STR."\{this.emailID}@\{this.domain}.\{this.extension}";
            ID id = new ID();
            this.id = id.getId();
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

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

    public String getEmailID() {
        return emailID;
    }

    public String getDomain() {
        return domain;
    }

    public String getExtension() {
        return extension;
    }

    public String getEmail() {
        return emailID + "@" + domain + "." + extension;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
