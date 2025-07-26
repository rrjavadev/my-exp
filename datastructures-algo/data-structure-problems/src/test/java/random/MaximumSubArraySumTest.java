package random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubArraySumTest {

    @Test
    void shouldReturnMaximumSubArraySum() {

        // Given
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expectedMaxSum = 6; // The maximum subarray is [4, -1, 2, 1] which sums to 6

        // When
        int resultMaxSum = MaximumSubArraySum.maxSubArray(nums);

        // Then
        assertEquals(expectedMaxSum, resultMaxSum);
    }

}