package MyHTM.htmMaker.Model.Util.Util;

import java.security.SecureRandom;
import java.util.Base64;

public class ID {
    private static int idCounter = 1000;
    private final String id;

    public ID() {
        //generate the hashcode of idCounter+1
        int idNumber = idCounter++;
        this.id = hash(idNumber);
    }

    public String getId() {
        return id;
    }
    public String hash(int id) {
        byte[] salt = new byte[64];
        for(byte s : salt) {
            s += (byte) id;
        }
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
//        byte[] hash = new byte[salt.length];
//        System.arraycopy(salt, 0, hash, 0, salt.length);
        Base64.Encoder enc = Base64.getUrlEncoder().withoutPadding();
        return id + '$' + enc.encodeToString(salt);
    }
}
