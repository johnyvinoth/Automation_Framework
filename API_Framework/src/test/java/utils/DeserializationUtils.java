package utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class DeserializationUtils {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Deserialize a JSON string to an object of the specified class and pretty print it.
     *
     * @param json   The JSON string to be deserialized.
     * @param clazz  The class of the object to be created.
     * @return A pretty printed JSON string representing the object, or null if deserialization fails.
     */
    public static <T> String deserializeFromJson(String json, Class<T> clazz) {
        try {
            T deserializedObject = gson.fromJson(json, clazz);
            if (deserializedObject != null) {
                return gson.toJson(deserializedObject);
            } else {
                return null;
            }
        } catch (JsonSyntaxException e) {
            // Handle any exceptions that occur during deserialization
            e.printStackTrace();
            return null;
        }
    }
}







