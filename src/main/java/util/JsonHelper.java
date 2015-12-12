package util;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

import java.util.List;

/**
 * Helper to parse json(as String) and return value or List of values
 */
public class JsonHelper {

    public static String getString(String json, String jsonPath){
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        String value = JsonPath.read(document, jsonPath);
        return value;
    }

    public static List<String> getList(String json, String jsonPath){
        Configuration conf = Configuration.defaultConfiguration();
        Configuration confList = conf.addOptions(Option.ALWAYS_RETURN_LIST);
        List<String> values = JsonPath.using(confList).parse(json).read(jsonPath);
        return values;
    }
}
