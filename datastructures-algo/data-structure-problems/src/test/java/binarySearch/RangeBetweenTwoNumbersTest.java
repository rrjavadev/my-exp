package binarySearch;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


class RangeBetweenTwoNumbersTest {

   @org.junit.jupiter.api.Test
    void testRangeBetweenTwoNumbersEmpty() {
        // When
        for(int i : new RangeBetweenTwoNumbers(0, 5)){
            System.out.println(i);
        }

       List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven");

       Map<Integer, String> collect = strings.stream()
               .collect(Collectors.toMap(s -> s.length(), k -> k, (s, k) -> s + "," + k));
         System.out.println(collect);
   }
}