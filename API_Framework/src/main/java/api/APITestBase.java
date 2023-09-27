package api;

import com.google.gson.reflect.TypeToken;
import utils.APIUtils;
import utils.DeserializationUtils;

import java.lang.reflect.Type;
import java.util.Map;

public class APITestBase {
    // Common utility method for deserialization
    protected static Map<String, Object> deserializeJsonResponse(String jsonResponse) {
        Type mapType = new TypeToken<Map<String, Object>>() {}.getType();
        return DeserializationUtils.deserializeFromJson(jsonResponse, mapType);
    }

}
