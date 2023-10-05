package models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DynamicJSONModel {
//    private final Map<String, Object> model;
private  Map<String, Object> model;

    public DynamicJSONModel()
    {
        model = new HashMap<>();
    }
    public DynamicJSONModel(Map<String, Object> model) {
        this.model = model;
    }
    public DynamicJSONModel addField(String key, Object value)
    {
        model.put(key,value);
        return this;
    }

    public boolean containsKey(String key) {
//        return model.containsKey(key);
        return model != null && model.containsKey(key);
    }

    public Object get(String key) {
//        return model.get(key);
        return model != null ? model.get(key) : null;
    }

}
