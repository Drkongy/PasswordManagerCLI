import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        decryptTest();


    }


    protected static String KEY = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!?£$%^&*()_+-=[]{}|;'#:@~,./<> ";



    public static void encryptionTest(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a message: ");
        String message = input.nextLine();
        String encrypted = encrypt(message, KEY);
        System.out.println("Encrypted message: " + encrypted);
        String decrypted = decrypt(encrypted, KEY);
        System.out.println("Decrypted message: " + decrypted);
        System.out.println("Key: " + KEY);
    }


    public static void decryptTest(){
        String message = "Hello World!";
        String encrypted = encrypt(message, KEY);
        String decrypted = decrypt(")\u0007\n" +
                "F0\u0007\u001B\u0006\u000FM", KEY);
//        String decrypted = decrypt(encrypted, KEY);
        System.out.println("Encrypted message: \n" + encrypted);
        System.out.println("Decrypted message: " + decrypted);
        System.out.println("Key: " + KEY);

    }



















    // use the key to encrypt data
    public static String encrypt(String data, String key) {
        String encrypted = "";
        for (int i = 0; i < data.length(); i++) {
            encrypted += (char)(data.charAt(i) ^ key.charAt(i));
        }
        return encrypted;
    }

    // use the key to decrypt data
    public static String decrypt(String data, String key) {
        String decrypted = "";
        for (int i = 0; i < data.length(); i++) {
            decrypted += (char)(data.charAt(i) ^ key.charAt(i));
        }
        return decrypted;
    }













}


