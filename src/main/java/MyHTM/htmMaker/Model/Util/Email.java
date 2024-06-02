package MyHTM.htmMaker.Model.Util;

//import MyHTM.htmMaker.Model.Util.Util.ID;

//
//@Entity
//@Table
public class Email {
//    @Id
//    private final String id;
//
//    private final String address;
//
//    //Constructor
//    public Email(String email) {
//        if(isEmail(email)) {
//            this.id = new ID().getId();
//            this.address = email;
//        } else {
//            throw new IllegalArgumentException("Invalid email address");
//        }
//    }
//
//    public Email() {
//        this.id = new ID().getId();
//        this.address = "";
//    }
//
//    //todo; This method must changed to private but we cannot do it now because the method is used in User class.
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
//
//    public String getAddress() {
//        return address;
//    }
}
