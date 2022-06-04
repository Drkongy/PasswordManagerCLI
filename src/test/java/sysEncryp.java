import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;



public class sysEncryp {
    public static void main(String[] args) {
        System.out.println("Encrypting...");
        System.out.println(encrypt("Hello World!"));
        System.out.println("Decrypting...");
        String encrypted = encrypt("Hello World!");
        System.out.println(decrypt(encrypted));

    }




    // make simple encryption
    public static String encrypt(String s) {
        try {
            // get a key generator
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            // generate a key
            SecretKey key = keyGen.generateKey();
            // get a cipher
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            // get the parameters
            GCMParameterSpec params = new GCMParameterSpec(128, key.getEncoded());
            // init the cipher
            cipher.init(Cipher.ENCRYPT_MODE, key, params);
            // encrypt the string
            byte[] encrypted = cipher.doFinal(s.getBytes());
            // encode the encrypted string
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    // decrypt the string
    public static String decrypt(String s) {
        try {
            // get a key generator
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            // generate a key
            SecretKey key = keyGen.generateKey();
            // get a cipher
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            // get the parameters
            GCMParameterSpec params = new GCMParameterSpec(128, key.getEncoded());
            // init the cipher
            cipher.init(Cipher.DECRYPT_MODE, key, params);
            // decode the encrypted string
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(s));
            // return the decrypted string
            return new String(decrypted);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
