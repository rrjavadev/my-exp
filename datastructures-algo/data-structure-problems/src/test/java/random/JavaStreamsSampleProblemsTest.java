package random;

import org.assertj.core.api.Assertions;
import org.assertj.core.internal.Integers;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class JavaStreamsSampleProblemsTest {

    @Test
    void shouldFindDuplicateInLinkedList() {
        // Given
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(11);
        linkedList.add(2);

        // When
        List<Integer> duplicate = JavaStreamsSampleProblems.findDuplicate(linkedList);

        // Then
        assertThat(duplicate).isEqualTo(List.of(1, 2));
    }

    @Test
    void shouldGroupStringsByLength() {
        // Given
        List<String> strings = List.of("apple", "banana", "kiwi", "pear", "peach");

        // When
        var grouped = JavaStreamsSampleProblems.groupStringsByLength(strings);

        // Then
        assertThat(grouped).containsEntry(5, List.of("apple", "peach"))
                                      .containsEntry(6, List.of("banana"))
                                      .containsEntry(4, List.of("kiwi", "pear"));
    }

    @Test
    void shouldFindTheFirstNonRepeatedCharacter() {
        // Given
        String input = "swiss";

        // When
        Optional<Character> result = JavaStreamsSampleProblems.firstNonRepeatedCharacter(input);

        // Then
        assertThat(result.get()).isEqualTo('w');
    }

    @Test
    void shouldFindTheSumOfEvenNumbers(){
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // When
        int sum = JavaStreamsSampleProblems.sumOfEvenNumbers(numbers);

        // Then
        assertThat(sum).isEqualTo(12); // 2 + 4 + 6 = 12
    }

    @Test
    void shouldSortAndRemoveDuplicates() {
        // Given
        List<Integer> numbers = List.of(5, 3, 8, 1, 2, 3, 5);

        // When
        List<Integer> sortedUniqueNumbers = JavaStreamsSampleProblems.sortAndRemoveDuplicates(numbers);

        // Then
        assertThat(sortedUniqueNumbers).isEqualTo(List.of(1, 2, 3, 5, 8));
    }

    @Test
    void shouldCouldTheOccurrencesOfEachWord() {
        // Given
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        // When
        var wordCount = JavaStreamsSampleProblems.countOccurrencesOfEachWord(words);

        // Then
        assertThat(wordCount).containsEntry("apple", 3L)
                             .containsEntry("banana", 2L)
                             .containsEntry("orange", 1L);
    }

    /**
     * Given a List<String>, use streams to find the longest string.
     */
    @Test
    void shouldFindTheLongestWord() {
        // Given
        List<String> words = List.of("apple", "banana", "kiwi", "strawberry");

        // When
        String longestWord = JavaStreamsSampleProblems.findLongestWord(words);

        // Then
        assertThat(longestWord).isEqualTo("strawberry");
    }

    @Test
    void shouldConvertListOfStringsToUpperCase() {
        // Given
        List<String> strings = List.of("apple", "banana", "kiwi");

        // When
        List<String> upperCaseStrings = JavaStreamsSampleProblems.convertToUpperCase(strings);

        // Then
        assertThat(upperCaseStrings).isEqualTo(List.of("APPLE", "BANANA", "KIWI"));
    }

    /**
     * Partition Numbers into Even and Odd
     */
    @Test
    void shouldPartitionNumbersIntoEvenAndOdd() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // When
        Map<String, List<Integer>> partitioned = JavaStreamsSampleProblems.partitionNumbers(numbers);

        // Then
        assertThat(partitioned.get("Even")).isEqualTo(List.of(2, 4, 6));
        assertThat(partitioned.get("Odd")).isEqualTo(List.of(1, 3, 5));
    }

    void shouldReverseString() {
        // Given
        String input = "hello";

        // When
        String reversed = JavaStreamsSampleProblems.reverseString(input);

        // Then
        assertThat(reversed).isEqualTo("olleh");
    }
}