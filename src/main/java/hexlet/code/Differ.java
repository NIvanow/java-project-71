package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        var resultMap = ParserFile.fileComparison(filepath1, filepath2);
        var result = new LinkedHashMap<String, Object>();
        var keysResultMap = new ArrayList<String>();
        keysResultMap.addAll(resultMap.keySet());
        for (var key : keysResultMap) {
            var value = resultMap.get(key);
            var newValue = value.getNewValue();
            var oldValue = value.getOldValue();
            switch (value.getState()) {
                case "added":
                    result.put("+ " + key, newValue);
                    break;
                case "removed":
                    result.put("- " + key, oldValue);
                    break;
                case "unchanged":
                    result.put("  " + key, oldValue);
                    break;
                case "changed":
                    result.put("- " + key, oldValue);
                    result.put("+ " + key, newValue);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + value.getState());

            }
        }
        var resultString = new StringBuilder("{\n");
        for (var item : result.entrySet()) {
            resultString.append(item +"\n");
        }
        resultString.append("}");
        System.out.println(resultString);
        return resultString.toString();
    }
}
