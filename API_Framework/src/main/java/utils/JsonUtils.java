package utils;
import api.APITestBase;
import models.DynamicJSONModel;

import java.util.Map;

public class JsonUtils extends APITestBase {

    /**
     * Get a nested value from a JSON structure.
     *
     * @param jsonResponse   The JSON data in which to search for the nested value.
     * @param keys       An array of keys representing the path to the nested value.
     * @param <T>        The type of the nested value.
     * @return The nested value if found, or null if not found or if any intermediate key is missing.
     */
    public static <T> T getNestedValueFromJson(String jsonResponse, String... keys)
    {
        Map<String, Object> dataMap= deserializeJsonResponse(jsonResponse);
        Map<String, Object> currentMap=dataMap;
//        DynamicJSONModel dataMap=deserializeJsonResponse(jsonResponse);
//        DynamicJSONModel currentMap=dataMap;

        for(String key:keys)
        {
            if(currentMap.containsKey(key))
            {
                Object value=currentMap.get(key);
                if(value instanceof Map)
                {
                    currentMap=(Map<String, Object>) value;
//                    currentMap=(DynamicJSONModel) value;
                }
                else {
                    try
                    {

                    return (T) value;
                    }catch (ClassCastException e)
                    {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
                else
                {
                    return null; //Key not found
                }
        }
                return null; // Key hierarchy doesn't match the structure.

    }




}
