import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Dia11 {

    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = Map.of(
                "tres", 3,
                "um", 1,
                "quatro", 4,
                "cinco", 5,
                "dois", 2
        );

        Map<String, Integer> sortedMap = sortByValue(unsortedMap);

        System.out.println(sortedMap);
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsorteMap) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        unsorteMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> sortedMap.put( entry.getKey(), entry.getValue()));

        return Collections.unmodifiableMap(sortedMap);
    }
}
