package tech.kongolian.PasswordManagerCLI;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tech.kongolian.PasswordManagerCLI.Format.ColourFormat;
import tech.kongolian.PasswordManagerCLI.lowDB.low;

import java.io.FileWriter;
import java.io.IOException;


public class SavePasswords {

    private final String password;
    private final String usages;


    /**
     * Gson object Initialization
     */

    private final Gson gson = new GsonBuilder().create();
    /**
     * Formatter initialization
     */

    private final ColourFormat cf = new ColourFormat();
    /**
     * Map object Initialization
     */
    protected low pm = new low();


    /**
     * Constructor for SavePasswords
     */


    public SavePasswords(String password, String usages) {
        this.password = password;
        this.usages = usages;
    }

    /**
     * Save the data to the file and convert it to a json
     */

    public void savePassword() {
        //append the new password to the map
        pm.initializeMap();
        pm.passMap.put(usages, password);

        // convert the data to json
        String dataJson = gson.toJson(pm.passMap);


        // write the data to the file
        try {
            /*
             * path to resources folder
             */
            String path = "src/main/resources/";
            FileWriter file = new FileWriter(path + "passwords.json");
            file.write(dataJson);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
