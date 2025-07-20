package binarySearch;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @org.junit.jupiter.api.Test
    void testBinarySearch() {

        //Given
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int expectedIndex = 4; // Index of the target in the array

        //When
        int resultIndex = BinarySearch.binarySearch(arr, target);

        //Then
        assertEquals(expectedIndex, resultIndex);
    }

    @org.junit.jupiter.api.Test
    void testBinarySearchNotFound() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 6;

        int resultIndex = BinarySearch.binarySearch(arr, target);
        assertEquals(-1, resultIndex); // Target not found
    }

}