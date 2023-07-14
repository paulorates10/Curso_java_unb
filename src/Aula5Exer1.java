import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Aula5Exer1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(1);
        numbers.add(5);
        numbers.add(3);

        List<Integer> duplicates = findDuplicates(numbers);
        System.out.println("Números duplicados: " + duplicates);
    }

    public static List<Integer> findDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                duplicates.add(number);
            }
        }

        return new ArrayList<>(duplicates);
    }
}
