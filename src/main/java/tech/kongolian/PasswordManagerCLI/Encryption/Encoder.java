package tech.kongolian.PasswordManagerCLI.Encryption;

import java.util.Base64;

public class Encoder {

    /**
     * Encodes a string to Base64
     */

    public static String encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    /**
     * Decodes a Base64 string
     */

    public static String decode(String str) {
        return new String(Base64.getDecoder().decode(str));
    }

}
