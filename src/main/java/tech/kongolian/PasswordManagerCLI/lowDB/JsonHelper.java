package tech.kongolian.PasswordManagerCLI.lowDB;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * JsonHelper
 *
 * @author Kongolian
 * @version 1.0
 * @see JsonHelper
 * @see Gson
 * @since 2020-01-01
 */


public class JsonHelper {

    /**
     * @param json
     * @param type
     * @return
     */
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private static final Type MAP_Type = new TypeToken<Map<String, String>>() {
    }.getType();

    /**
     * converting from json to map
     *
     * @param json
     * @return
     */
    public Map<String, String> jsonToMap(String json) {
        Map<String, String> ret = new HashMap<>();
        if (json == null || json.isEmpty())
            return ret;
        return gson.fromJson(json, MAP_Type);
    }

    /**
     * converting from map to json
     *
     * @param map
     * @return
     */
    public String mapToJson(Map<String, String> map) {
        if (map == null)
            map = new HashMap<String, String>();
        return gson.toJson(map);
    }
}
