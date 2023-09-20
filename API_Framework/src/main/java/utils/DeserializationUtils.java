package utils;

import com.google.gson.*;
import java.lang.reflect.Type;

public class DeserializationUtils {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Deserialize a JSON string to an object of the specified class and pretty print it.
     *
     * @param json  The JSON string to be deserialized.
     * @param clazz The class of the object to be created.
     * @return A pretty printed JSON string representing the object, or null if deserialization fails.
     */
    public static <T> T deserializeFromJson(String json, Class<T> clazz) {
        try {
            return gson.fromJson(json, clazz);
        } catch (JsonSyntaxException e) {
            // Handle any exceptions that occur during deserialization
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Parse a JSON string and return it as a JsonObject.
     *
     * @param json The JSON string to be parsed.
     * @return A JsonObject representing the JSON data, or null if parsing fails.
     */
    public static JsonObject parseJsonToJsonObj(String json) {
        try {
            return JsonParser.parseString(json).getAsJsonObject();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Deserialize a JSON string to an object of the specified type and return it as the desired type.
     *
     * @param json       The JSON string to be deserialized.
     * @param returnType The desired return type.
     * @param <T>        The desired return type.
     * @return An object of the specified type converted to the desired return type, or null if deserialization fails.
     */
    public static <T> T deserializeFromJson(String json, Type returnType) {
        try {
            return gson.fromJson(json, returnType);
        } catch (JsonSyntaxException e) {
            // Handle any exceptions that occur during deserialization
            e.printStackTrace();
            return null;
        }
    }
}






