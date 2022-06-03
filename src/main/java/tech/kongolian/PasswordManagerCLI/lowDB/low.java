package tech.kongolian.PasswordManagerCLI.lowDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class low {

    private static low instance = null;
    private final JsonHelper jh = new JsonHelper();
    /**
     * This class is used to store the data of the low level database.
     * It is a singleton class, which means that it can only hold one instance of the map and all the values that are related.
     *
     * @author Kongolian
     * @version 1.0
     * @since 2020-01-01
     */
    public Map<String, String> passMap = new LinkedHashMap<>();


    /**
     * This method is used to get the key and value of the hashmap.
     */
    public low() {
        // Constructor is private to prevent instantiation
    }

    /**
     * This method is used to get the instance of the class.
     *
     * @return
     */
    public static low getInstance() {
        if (instance == null) {
            instance = new low();
        }
        return instance;
    }

    public void initializeMap() {
        // gets data from the passwords.json
        // and put it into the hashmap

        String path = "src/main/resources/";
        try {
            FileReader file = new FileReader(path + "passwords.json");
            BufferedReader reader = new BufferedReader(file);

            String line;
            while ((line = reader.readLine()) != null) {
                //convert string to hashmap & add the map values to the map
                passMap = jh.jsonToMap(line);

//                System.out.println(line);
            }
            reader.close();
            file.close();


        } catch (IOException e) {
            // create a new file if it doesn't exist
            try {
                FileWriter file = new FileWriter(path + "passwords.json");
                file.write("{}");
                file.flush();
                file.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * This method is used to remove a key and value from the hashmap.
     *
     * @param key
     */
    public void remove(String key) {
        passMap.remove(key);
    }


    /**
     * This method is used to check if the hashmap contains a  specific key.
     *
     * @param key
     * @return
     */
    public boolean containsKey(String key) {
        return passMap.containsKey(key);
    }


}


