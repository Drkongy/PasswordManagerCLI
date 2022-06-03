import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a key: ");
        String key = input.nextLine();

        System.out.println("Enter a message: ");
        String message = input.nextLine();

        System.out.println("Encrypted message: " + encrypt(message, key));
        key = "test";
        System.out.println("Decrypted message: " + decrypt(encrypt(message, "waffle"), "waffle"));
    }









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
