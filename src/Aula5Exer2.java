import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aula5Exer2 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("maça");
        strings.add("banana");
        strings.add("maça");
        strings.add("laranja");
        strings.add("banana");
        strings.add("banana");
        strings.add("maça");

        Map<String, Integer> occurrences = countOccurrences(strings);
        System.out.println("Quantidade de ocorrências:");
        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, Integer> countOccurrences(List<String> strings) {
        Map<String, Integer> occurrences = new HashMap<>();

        for (String str : strings) {
            if (occurrences.containsKey(str)) {
                occurrences.put(str, occurrences.get(str) + 1);
            } else {
                occurrences.put(str, 1);
            }
        }

        return occurrences;
    }
}
