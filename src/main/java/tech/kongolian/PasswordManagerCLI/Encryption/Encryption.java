package tech.kongolian.PasswordManagerCLI.Encryption;

public class Encryption {


    /**
     * Encrypts a string with a given key and returns the encrypted string
     * since the key is automatically set for each string, it's hard to decypher the encrypted string with the key used cause there are multiple strings.
     */

    // Encrypts a string with a given key
    public static String encrypt(String text, String key) {
        String encrypted = "";
        for (int i = 0; i < text.length(); i++) {
            encrypted += (char) (text.charAt(i) ^ key.charAt(i % key.length()));
        }
        return encrypted;
    }

    // Decrypts a string with a given key
    public static String decrypt(String text, String key) {
        return encrypt(text, key);
    }

}
