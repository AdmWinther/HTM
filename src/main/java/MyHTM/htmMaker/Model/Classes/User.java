package MyHTM.htmMaker.Model.Classes;

public class User extends Activeable{
    private int id;
    private final String name;
    private final String lastName;
    private final Email email;
    private String password;
    private Organization organization;

    public User(String name, String lastName, String emailAddress) {
        try {
            isValidNewUser(name, lastName, emailAddress);
            this.name = name;
            this.lastName = lastName;
            this.email = new Email(emailAddress);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void isValidNewUser(String name, String lastName, String emailaddress) throws IllegalArgumentException{
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name is required");
        }

        if(lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("User lastname is required");
        }

        if(emailaddress == null || emailaddress.isEmpty()) {
            throw new IllegalArgumentException("User email address is required");
        }

        if(!Email.isEmail(emailaddress)) {
            throw new IllegalArgumentException("User email address is not correct");
        }
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }
}