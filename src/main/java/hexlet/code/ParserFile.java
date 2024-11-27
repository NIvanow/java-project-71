package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeMap;

public class ParserFile {
    public static TreeMap<String, Object> parser(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        ObjectMapper mapper = new ObjectMapper();
        TreeMap<String, Object> date = mapper.readValue(
                path.toFile(), new TypeReference<TreeMap<String, Object>>() {});
        return date;
    }
    public static TreeMap<String,DifferValue> fileComparison(String filepath1, String filepath2) throws Exception {
        var resultComparsion = new TreeMap<String, DifferValue>();
        var date1 = parser(filepath1);
        var date2 = parser(filepath2);
        var dataKeys1 = date1.keySet();
        var dataKeys2 = date2.keySet();
        var allKeys = new ArrayList<String>();
        var oldValue = new Object();
        var newValue = new Object();
        allKeys.addAll(dataKeys1);
        allKeys.addAll(dataKeys2);

        for (var key : allKeys) {
            var valueFile1 = date1.get(key);
            var valueFile2 = date2.get(key);

            if(!(dataKeys2.contains(key))) {
                oldValue = valueFile1;
                resultComparsion.put(key, new DifferValue("removed", oldValue, newValue));
            }
            if(!(dataKeys1.contains(key))) {
                newValue = valueFile2;
                resultComparsion.put(key, new DifferValue("added",oldValue, newValue));
            }
            if(dataKeys1.contains(key) && dataKeys2.contains(key)) {
                if(valueFile1.equals(valueFile2)) {
                    oldValue = valueFile1;
                    newValue = valueFile2;
                resultComparsion.put(key, new DifferValue("unchanged",oldValue, newValue));
                } else {
                    oldValue = valueFile1;
                    newValue = valueFile2;
                    resultComparsion.put(key, new DifferValue("changed", oldValue, newValue));
                }
            }
        }
        return resultComparsion;
    }

}

