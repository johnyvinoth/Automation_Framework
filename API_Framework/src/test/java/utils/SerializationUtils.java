package utils;
import com.google.gson.Gson;
public class SerializationUtils {
    private static final Gson gson=new Gson();
    /**
     * Serialize an object to a JSON string.
     *
     * @param object The object to be serialized.
     * @return A JSON string representing the serialized object.
     */

    public static String serializeToJson(Object object)
    {
        return gson.toJson(object);
    }

}
