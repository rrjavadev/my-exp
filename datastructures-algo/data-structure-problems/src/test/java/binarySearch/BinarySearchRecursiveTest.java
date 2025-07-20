package binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchRecursiveTest {

    @Test
    void testBinarySearchRecursive() {

        // Given
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int target = 15;
        int expectedIndex = 14; // Index of the target in the array

        // When
        int resultIndex = BinarySearchRecursive.binarySearch(arr, target);

        // Then
        assertEquals(expectedIndex, resultIndex);
    }
}