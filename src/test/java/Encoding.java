import java.util.Base64;

public class Encoding {

    public static void main(String[] args) {
        String test = "Hello World!";


        System.out.println(encode(test));
        System.out.println(decode(encode(test)));

    }


    public static String encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static String decode(String str) {
        return new String(Base64.getDecoder().decode(str));
    }


}
