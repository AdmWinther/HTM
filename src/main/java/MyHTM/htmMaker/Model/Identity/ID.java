package MyHTM.htmMaker.Model.Identity;

import java.util.UUID;

public class ID {
    private final String value;

    private ID(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static ID generateIDObject() {
        String newValue = UUID.randomUUID().toString();
        return new ID(newValue);
    }

    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}