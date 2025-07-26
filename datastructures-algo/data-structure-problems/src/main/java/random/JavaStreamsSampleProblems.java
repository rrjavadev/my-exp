package random;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsSampleProblems {

    public static List<Integer> findDuplicate(List<Integer> linkedList) {

        return linkedList.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    /**
     * Given a List<String>, group the strings by their length using Java Streams.
     *
     * @param strings
     * @return
     */
    public static Map<Integer, List<String>> groupStringsByLength(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.mapping(s -> s, Collectors.toList())));
    }


    /**
     * Given a string, find the first non-repeated character.
     */
    public static Optional<Character> firstNonRepeatedCharacter(String input) {
        System.out.println("Input string: " + input.toCharArray());

        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .peek(e -> System.out.println("First non-repeated character: " + e))
                .findFirst()
                .map(e -> e.getKey());
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {

        return numbers.stream()
                .filter(e -> e % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static List<Integer> sortAndRemoveDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted()
                .toList();
    }

    public static Map<String, Long> countOccurrencesOfEachWord(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    public static String findLongestWord(List<String> words) {

        return words.stream()
                .reduce("", (s1, s2) -> s1.length() > s2.length() ? s1 : s2);
    }

    public static List<String> convertToUpperCase(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static Map<String, List<Integer>> partitionNumbers(List<Integer> numbers) {
//        return numbers.stream()
//                .collect(Collectors.partitioningBy(num -> num % 2 == 0, Collectors.toList()))
//                .entrySet()
//                .stream()
//                .collect(Collectors.toMap(e -> e.getKey() ? "Even" : "Odd", Map.Entry::getValue));

        return numbers.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.partitioningBy(num -> num % 2 == 0, Collectors.toList()),
                        e -> Map.of("Even", e.get(true),
                                "Odd", e.get(false))));
    }

    public static String reverseString(String input) {

        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder sb = new StringBuilder(input).reverse();
        return sb.toString();

//        StringBuilder sb = new StringBuilder();
//        for(int i =input.length() -1; i >=0; i--){
//            sb.append(input.charAt(i));
//        }

//        return Arrays.stream(input.split(""))
//                .reduce("", (s1, s2) -> s1 + s2);

//        return input.chars()
//                .mapToObj(c -> (char) c)
//                .reduce("", (c1, c2) -> c2 + c1, String::concat);

    }
}
