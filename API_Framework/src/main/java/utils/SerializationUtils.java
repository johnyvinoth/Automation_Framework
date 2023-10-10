package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class SerializationUtils {
//    private static final Gson gson = new Gson();
static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    /**
     * Serialize an object to a JSON string.
     *
     * @param object The object to be serialized.
     * @return A JSON string representing the serialized object.
     */

    public static String serializeToJson(Map<String, Object> model) {
        return gson.toJson(model);
    }

    public static Map<String, Object> readModelFromFile(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            Type mapType=new TypeToken<Map<String, Object>>() {}.getType();
            return gson.fromJson(reader,mapType);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
