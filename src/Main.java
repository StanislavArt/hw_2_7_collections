import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 1, 2, 10, 216, 8, 3, 4, 4, 5, 5, 6, 7)); // task 1, task 2
        List<String> words = new ArrayList<>(List.of("слива", "груша", "слива", "яблоня", "орех",
                "дерево", "фрезер", "слива", "груша", "код", "отладка", "код", "слива", "код", "фрезер")); // task 3, task 4

        // task 1
        System.out.println("Нечетные числа:");
        printOddNumbers(numbers);

        // task 2
        System.out.println("\n\nЧетные числа в порядке возростания:");
        printEvenNumbersSorted(numbers);

        // task 3
        System.out.println("\n\nУникальные слова:");
        printUniqueWords(words);

        // task 4
        System.out.println("\nПовторяющиеся слова с количеством повторов:");
        printDuplicatedWords(words);
    }

    // task 1
    public static void printOddNumbers(List<Integer> numbers) {
        boolean isRequiredComma = false;
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                if (isRequiredComma) System.out.print(", "); else isRequiredComma = true;
                System.out.print(number);
            }
        }
    }

    // task 2
    public static void printEvenNumbersSorted(List<Integer> numbers) {
        List<Integer> array = new ArrayList<>(numbers); // введен новый массив, чтобы не изменять первоначальный
        array.sort(Comparator.naturalOrder());
        boolean isRequiredComma = false;
        for (Integer number : array) {
            if (number % 2 == 0) {
                if (isRequiredComma) System.out.print(", "); else isRequiredComma = true;
                System.out.print(number);
            }
        }
    }

    // task 3
    public static void printUniqueWords(List<String> words) {
        Set<String> uniqueWords = new HashSet<>();
        Set<String> duplicatedWords = new HashSet<>();

        for (String word : words) {
            if (duplicatedWords.contains(word)) {
                continue;
            }
            if (words.indexOf(word) != words.lastIndexOf(word)) {
                duplicatedWords.add(word);
            } else {
                uniqueWords.add(word);
            }
        }
        System.out.println(uniqueWords);
    }

    // task 4
    public static void printDuplicatedWords(List<String> words) {
        Map<String, Integer> wordsMap = new HashMap<>();

        // заполняем контейнер всеми словами с количеством повторов
        for (String word : words) {
            int numberOfRepetitions = wordsMap.getOrDefault(word, 0);
            wordsMap.put(word, numberOfRepetitions + 1);
        }

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue() == 1) {
                continue;
            }
            System.out.printf("Слово \"%s\" встречается %d раз(а)\n", entry.getKey(), entry.getValue());
        }
    }
}
