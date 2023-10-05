package models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DynamicJSONModel {
    private final Map<String, Object> model;

    public DynamicJSONModel()
    {
        this.model=new HashMap<>();
    }
    public DynamicJSONModel addField(String key, Object value)
    {
        model.put(key,value);
        return this;
    }

    public boolean containsKey(String key) {
        return model.containsKey(key);
    }

    public Object get(String key) {
        return model.get(key);
    }
}
