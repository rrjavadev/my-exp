package twosum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumProblemTest {

    @Test
    public void shouldReturnIndicesOfTwoSumBruteForce() {
        // Given
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1}; // Indices of the numbers that add up to the target

        // When
        int[] result = TwoSumProblem.twoSumBruteForce(nums, target);

        // Then
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnIndicesOfTwoSumOptimised() {
        // Given
        Integer[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1}; // Indices of the numbers that add up to the target

        // When
        int[] result = TwoSumProblem.twoSumOptimised(nums, target);

        // Then
        assertArrayEquals(expected, result);
    }

}