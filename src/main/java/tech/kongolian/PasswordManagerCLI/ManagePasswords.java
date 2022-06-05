package tech.kongolian.PasswordManagerCLI;
import tech.kongolian.PasswordManagerCLI.lowDB.low;
import tech.kongolian.PasswordManagerCLI.Format.ColourFormat;
import tech.kongolian.PasswordManagerCLI.Encryption.Encoder;

// import scanner
import java.util.Scanner;
public class ManagePasswords {


    public ManagePasswords() {

    }

    public static ColourFormat cf = new ColourFormat();
    public static Encoder encoder = new Encoder();


    public void passManager(){
        low.initializeMap();
        System.out.println(cf.ANSI_CYAN("Welcome to the Password Manager"));
        System.out.println(cf.ANSI_CYAN("Please select an option:"));
        System.out.println(cf.ANSI_CYAN("1. Find a password"));
        System.out.println(cf.ANSI_CYAN("2. Remove a password"));
        System.out.println(cf.ANSI_CYAN("3. Change a password"));
        System.out.println(cf.ANSI_CYAN("4. View all passwords"));
        System.out.println(cf.ANSI_CYAN("5. Exit"));
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();


        switch(choice){
            case 1:
                findPassword();
                break;
            case 2:
                removePassword();
                break;
            case 3:
                changePassword();
                break;
            case 4:
                viewPasswords();
                break;
            case 5:
                System.out.println(cf.ANSI_RED("Exiting..."));
                System.exit(0);
                break;
            default:
                System.out.println(cf.ANSI_RED("Please enter a valid option"));
                break;

        }

    }

    public static void findPassword(){
        System.out.println(cf.ANSI_CYAN("Please enter the name of the platform for the password you want to find:"));
        System.out.println(cf.ANSI_CYAN("List of platforms:"));
        for(String key : low.passMap.keySet()){
            System.out.println(cf.ANSI_BOLD(key));
        }
        Scanner scan = new Scanner(System.in);
        String find = scan.nextLine();
        find.toLowerCase();
        if(low.passMap.containsKey(find)){
            String pass = encoder.decode(low.passMap.get(find));
            System.out.println(cf.ANSI_GREEN("The password for " + find + " is: " + pass));
            System.out.println(cf.ANSI_BOLD("Press enter to continue..."));
            scan.nextLine();
        }
        else{
            System.out.println(cf.ANSI_RED("The password for '" + find + "' does not exist"));
            findPassword();

        }



    }


    public static void removePassword(){
        System.out.println(cf.ANSI_CYAN("Please enter the name of the password you want to remove:"));
        System.out.println(cf.ANSI_CYAN("List of platforms:"));
        for(String key : low.passMap.keySet()){
            System.out.println(cf.ANSI_BOLD(key));
        }
        Scanner scan = new Scanner(System.in);
        String remove = scan.nextLine();
        remove.toLowerCase();

        if(low.passMap.containsKey(remove)){
            low.passMap.remove(remove);
            System.out.println(cf.ANSI_GREEN("The password for " + remove + " has been removed"));
            low.saveToFile();
            System.out.println(cf.ANSI_BOLD("Press enter to continue..."));
            scan.nextLine();
        }
           else{
            System.out.println(cf.ANSI_RED("The password for '" + remove + "' does not exist"));
            removePassword();
        }
    }

    public static void changePassword(){
        System.out.println(cf.ANSI_CYAN("Please enter the name of the platform you want to change the password for:"));
        System.out.println(cf.ANSI_CYAN("List of platforms:"));
        for(String key : low.passMap.keySet()){
            System.out.println(cf.ANSI_BOLD(key));
        }
        Scanner scan = new Scanner(System.in);
        String change = scan.nextLine();
        change.toLowerCase();
        if(low.passMap.containsKey(change)){
            System.out.println(cf.ANSI_CYAN("Please enter the new password for " + change + ":"));
            Scanner scan2 = new Scanner(System.in);
            String newPass = scan2.nextLine();
            low.passMap.put(change, encoder.encode(newPass));
            System.out.println(cf.ANSI_GREEN("The password for " + change + " has been changed"));
            low.saveToFile();
            System.out.println(cf.ANSI_BOLD("Press enter to continue..."));
            scan.nextLine();

        }
        else{
            System.out.println(cf.ANSI_RED("The password for '" + change + "' does not exist"));
            changePassword();
        }
    }

    public static void viewPasswords(){
        Scanner scan = new Scanner(System.in);
        System.out.println(cf.ANSI_CYAN("The passwords are:"));
        for(String key : low.passMap.keySet()){
            String pass =  encoder.decode(low.passMap.get(key));
            System.out.println(cf.ANSI_BOLD(key + ": " + pass));
        }
        System.out.println(cf.ANSI_BOLD("Press enter to continue..."));
        scan.nextLine();
    }

}


