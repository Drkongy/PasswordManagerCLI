package tech.kongolian.PasswordManagerCLI;

public class PasswordGenerator {

    public int length;
    public int type;


    public PasswordGenerator(int length, int type) {
        this.length = length;
        this.type = type;
    }


    public String GeneratePassword() {
        String password;
        switch (type) {
            case 1:
                password = GeneratePasswordForLowercase();
                break;
            case 2:
                password = GeneratePasswordForUppercase();
                break;
            case 3:
                password = GeneratePasswordForNumbers();
                break;
            case 4:
                password = GeneratePasswordForLetters();
                break;
            case 5:
                password = GeneratePasswordForLettersAndNumbers();
                break;
            case 6:
                password = GeneratePasswordForLettersNumbersAndSymbols();
                break;
            default:
                password = GeneratePasswordForLowercase();
                break;

        }
        return password;
    }

    public String GeneratePasswordForLowercase() {
        String password = "";
        for (int i = 0; i < length; i++) {
            password += (char) (Math.random() * 26 + 97);
        }
        return password;
    }

    public String GeneratePasswordForUppercase() {
        String password = "";
        for (int i = 0; i < length; i++) {
            password += (char) (Math.random() * 26 + 65);
        }
        return password;
    }

    public String GeneratePasswordForNumbers() {
        String password = "";
        for (int i = 0; i < length; i++) {
            password += (char) (Math.random() * 10 + 48);
        }
        return password;
    }

    public String GeneratePasswordForLetters() {
        String password = "";

        for (int i = 0; i < length / 2; i++) {
            password += (char) (Math.random() * 26 + 97);
            password += (char) (Math.random() * 26 + 65);
        }

        //make sure the length of password is equal to the length of password for type
        if (length % 2 == 0) {
            return password;
        } else {
            password += (char) (Math.random() * 26 + 97);
        }

        return password;
    }

    public String GeneratePasswordForLettersAndNumbers() {
        String password = "";
        for (int i = 0; i < length / 3; i++) {
            password += (char) (Math.random() * 26 + 97);
            password += (char) (Math.random() * 26 + 65);
            password += (char) (Math.random() * 10 + 48);
        }
        //make sure the length of password is equal to the length of password for type
        if (length % 3 == 0) {
            return password;

        } else if (length % 3 == 1) {
            password += (char) (Math.random() * 26 + 97);
            return password;
        } else {
            password += (char) (Math.random() * 26 + 97);
            password += (char) (Math.random() * 10 + 48);
            return password;
        }
    }


    public String GeneratePasswordForLettersNumbersAndSymbols() {
        String password = "";
        for (int i = 0; i < length / 4; i++) {
            password += (char) (Math.random() * 26 + 97);
            password += (char) (Math.random() * 26 + 65);
            password += (char) (Math.random() * 10 + 48);
            password += (char) (Math.random() * 10 + 33);
        }
        //make sure the length of password is equal to the length of password for type
        if (length % 4 == 0) {
            return password;

        } else if (length % 4 == 1) {
            password += (char) (Math.random() * 26 + 97);
            return password;

        } else if (length % 4 == 2) {
            password += (char) (Math.random() * 26 + 97);
            password += (char) (Math.random() * 10 + 48);
            return password;

        } else if (length % 4 == 3) {
            password += (char) (Math.random() * 26 + 97);
            password += (char) (Math.random() * 10 + 48);
            password += (char) (Math.random() * 10 + 33);
            return password;
        } else {
            password += (char) (Math.random() * 26 + 97);
            password += (char) (Math.random() * 26 + 65);
            password += (char) (Math.random() * 10 + 48);
            password += (char) (Math.random() * 10 + 33);
            return password;

        }


    }


}
