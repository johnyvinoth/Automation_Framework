package api;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import models.DynamicJSONModel;
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

    protected static DynamicJSONModel deserializeJsonResponse_new(String jsonResponse) {
        try {
            Type mapType = new TypeToken<DynamicJSONModel>() {}.getType();
            return DeserializationUtils.deserializeFromJson(jsonResponse, mapType);
        } catch (JsonSyntaxException e) {
            e.printStackTrace(); // Log the error
            return null; // Return null or another appropriate value to handle the error
        }

//        try {
//            System.out.println("Input JSON: " + jsonResponse); // Print the JSON string before deserialization
//            DynamicJSONModel model = DeserializationUtils.deserializeFromJson(jsonResponse, DynamicJSONModel.class);
//            System.out.println("Deserialized Model: " + model); // Print the deserialized model
//            return model;
//        } catch (JsonSyntaxException e) {
//            // Handle any exceptions that occur during deserialization
//            e.printStackTrace();
//            return null;
//        }
    }


}
