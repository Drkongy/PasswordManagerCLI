package tech.kongolian.PasswordManagerCLI;

import tech.kongolian.PasswordManagerCLI.Format.ColourFormat;
import tech.kongolian.PasswordManagerCLI.lowDB.low;


import java.util.Scanner;


/**
 * @author Kongolian
 * @version 1.0
 * @since 2020-04-01
 */


// todo add encryption to the database
// todo add a way to manage passwords
// todo add a way to delete passwords
// todo add some sort of encryption to the passwords


public class Main {

    public static String Password;
    public static String usage;
    public static ColourFormat cf = new ColourFormat();

    /**
     * the linkedmap that contains all the passwords and usages
     */
    protected static low pm = new low();


    public static void main(String[] args) {


        //print a cool logo that says password manager


        System.out.println(cf.ANSI_GREEN(cf.ANSI_GREEN("  ____       _      ____    ____   __        __   ___    ____    ____  \n" +
                " |  _ \\     / \\    / ___|  / ___|  \\ \\      / /  / _ \\  |  _ \\  |  _ \\ \n" +
                " | |_) |   / _ \\   \\___ \\  \\___ \\   \\ \\ /\\ / /  | | | | | |_) | | | | |\n" +
                " |  __/   / ___ \\   ___) |  ___) |   \\ V  V /   | |_| | |  _ <  | |_| |\n" +
                " |_|     /_/   \\_\\ |____/  |____/     \\_/\\_/     \\___/  |_| \\_\\ |____/ \n" +
                "                                                                       "
        )));


        System.out.println(cf.ANSI_YELLOW("                                                  Generator / Manager "));
        System.out.println(cf.ANSI_YELLOW("                                                  Made by: Zeeshan\n\n\n"));


        System.out.println(cf.ANSI_BLUE("Usage: java -jar PasswordGenerator.jar\n"));
        System.out.println(cf.ANSI_BLUE("Welcome To the Password Generator / Manager! \nPlease choose an option!"));

        pm.initializeMap();


        choiceOptions();


    }

    /**
     * This method is used to print the options for the user to choose from
     */
    public static void choiceOptions() {
        System.out.println(cf.ANSI_PURPLE("Options:  "));
        System.out.println(cf.ANSI_PURPLE("1. Generate a new password"));
        System.out.println(cf.ANSI_PURPLE("2. Manage your passwords"));
        System.out.println(cf.ANSI_BRIGHT_RED("3. Exit"));
        Scanner scanner = new Scanner(System.in);
        // try catch for invalid input
        try {
            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    System.out.println(cf.ANSI_CYAN("Selected to Generate a new password!"));
                    Choice1_GeneratePassword();
                    return;
                case 2:
                    System.out.println(cf.ANSI_CYAN("Selected to manage passwords"));
                    Choice2_ManagePassword();
                    return;
                case 3:
                    System.out.println(cf.ANSI_BRIGHT_RED("Exiting"));
                    System.exit(0);
                    return;
                default:
                    System.out.println(cf.ANSI_BRIGHT_RED("Invalid choice! (Make sure you're using the correct number)  "));
                    choiceOptions();
            }
        } catch (Exception e) {
            System.out.println(cf.ANSI_BRIGHT_RED("Invalid choice! (Make sure you're using numbers) "));
            choiceOptions(); // loops through the method again if an invalid input is entered
        }
    }

    /**
     * This method is used to generate a new password
     */
    public static void Choice1_GeneratePassword() {
        cleanConsole();

        // general details
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println(cf.ANSI_CYAN("What platform is the password going to be used for?") + cf.ANSI_PURPLE(" facebook, netflix, instagram? "));
            usage = scanner.nextLine();
            usage = usage.toLowerCase();
            if (usage.equals("") || usage == null) {
                System.out.println(cf.ANSI_BRIGHT_RED("Please enter a valid platform"));
            }

        } while (usage == null || usage.equals(""));


        /*
         * This is the usage validation, it makes sure that the usage is not already in the hashmap, if it is, it will ask the user to enter a new usage.
         */
        keyValidation();


        // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


        // password generation details
        System.out.println(cf.ANSI_CYAN("How many characters do you want your password to be? "));
        int passwordLength = scanner.nextInt();

        //make sure the password length is at least 3 characters long and ask again if it is not
        while (passwordLength < 3 || passwordLength > 50) {
            System.out.println(cf.ANSI_RED("Your password must be between 3 - 50 characters long. Please enter a new password length."));
            passwordLength = scanner.nextInt();
        }

        //ask user for password type
        System.out.println(cf.ANSI_CYAN("What type of password do you want to generate?\n" +
                "1. Lowercase\n" +
                "2. Uppercase\n" +
                "3. Numeric\n" +
                "4. Lowercase and Uppercase\n" +
                "5. Lowercase, Uppercase, and Numeric\n" +
                "6. Lowercase, Uppercase, Numeric, and Special Characters"));
        //get user input
        int passwordType = scanner.nextInt();
        //make sure the password type is valid and ask again if it is not
        while (passwordType < 1 || passwordType > 6) {
            System.out.println(cf.ANSI_BRIGHT_RED("You must enter a valid password type. Please enter a new password type."));
            passwordType = scanner.nextInt();
        }

        //generate passwords
        PasswordGenerator passwordGenerator = new PasswordGenerator(passwordLength, passwordType);

        //print out the password
        Password = passwordGenerator.GeneratePassword();
        System.out.println(cf.ANSI_GREEN("Your password is: ") + Password);


        //--------------------------------------------------------------------------------------------------


        // ask if the user if they like the password, if they do, save it to the file, if not reroll it
        System.out.println(cf.ANSI_CYAN("Do you want to reroll the password? (y/n)"));
        while (true) {
            String likePassword = scanner.nextLine();
            likePassword = likePassword.toLowerCase();

            if (likePassword.equals("n")) {
                SavePasswords sp = new SavePasswords(Password, usage);
                sp.savePassword();

                System.out.println(cf.ANSI_GREEN("Your password has been saved! "));
                break;


            } else if (likePassword.equals("y")) {
                Password = passwordGenerator.GeneratePassword();
                System.out.println(cf.ANSI_GREEN("Your new password is: ") + Password);
                System.out.println(cf.ANSI_CYAN("Do you want to reroll the password? (y/n)"));
                if (likePassword.equals("n")) {
                    SavePasswords sp = new SavePasswords(Password, usage);
                    sp.savePassword();
                    System.out.println(cf.ANSI_GREEN("Your password has been saved! "));
                    break;
                }


            } else {

                if (likePassword != null && likePassword.length() > 0) {
                    System.out.println(cf.ANSI_RED("Invalid choice! (Make sure you're using y or n)"));
                }
            }
        }
    }

    /**
     * This method is used to ask the user if they want to manage there passwords
     */

    public static void Choice2_ManagePassword() {
        System.out.println(cf.ANSI_CYAN("Work In Progress!"));

    }

    /**
     * This methods clears the console.
     */
    public static void cleanConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


    /**
     * This method is used to check if the key already exists in the hashmap
     */
    public static void keyValidation() {
        // check the hashmap if that specific key already exists
        Scanner scanner = new Scanner(System.in);
        String overwrite;
        if (pm.containsKey(usage)) {
            System.out.println(cf.ANSI_BRIGHT_RED("This platform already exists in the database! "));

            do {
                System.out.println(cf.ANSI_BRIGHT_RED("Would you like to overwrite it? (y/n)"));
                overwrite = scanner.nextLine();
                overwrite = overwrite.toLowerCase();
                if (overwrite.equals("y")) {
                    System.out.println(cf.ANSI_CYAN("Overwriting the password for " + usage + "!"));
                    pm.remove(usage);

                } else if (overwrite.equals("n")) {
                    do {
                        usage = "";
                        System.out.println(cf.ANSI_CYAN("Please enter valid Platform?") + cf.ANSI_PURPLE(" facebook, netflix, instagram? "));
                        usage = scanner.nextLine();
                        usage = usage.toLowerCase();
                        keyValidation();

                    } while (usage == null || usage.equals(""));
                } else {
                    System.out.println(cf.ANSI_BRIGHT_RED("Please enter a valid option"));

                }
            } while (overwrite.equals(null) || overwrite.equals(""));

        }
    }


}

