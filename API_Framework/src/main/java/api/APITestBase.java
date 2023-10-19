package api;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import models.DynamicJSONModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.APIUtils;
import utils.DeserializationUtils;

import java.lang.reflect.Type;
import java.util.Map;

public class APITestBase {
    // Common utility method for deserialization
    protected static final Logger logger= LogManager.getLogger("APIFile");
    protected static Map<String, Object> deserializeJsonResponse(String jsonResponse) {
        Type mapType = new TypeToken<Map<String, Object>>() {}.getType();
        return DeserializationUtils.deserializeFromJson(jsonResponse, mapType);
    }




}
