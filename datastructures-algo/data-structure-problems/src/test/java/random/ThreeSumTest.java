package random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @Test
    void testThreeSum() {

        // Given
        int[] nums = {-1, 0, 1, 2, -1, -4};

        // When
         List<List<Integer>> result = ThreeSum.threeSum(nums);

        // Then
        assertEquals(2, result.size()); // There should be two unique triplets

        assertThat(result)
                .anySatisfy(triplet -> assertThat(triplet).containsExactlyInAnyOrder(-1, 0, 1));
    }

    @Test
    void testThreeSumShouldReturnEmptyList() {

        // Given
        int[] nums = {3,-2,1,0};

        // When
         List<List<Integer>> result = ThreeSum.threeSum(nums);

        // Then
        assertEquals(0, result.size()); // There should be two unique triplets
    }

    @Test
    void testThreeSumShouldR() {

        // Given
        int[] nums = {-2,0,1,1,2};

        // When
         List<List<Integer>> result = ThreeSum.threeSum(nums);

        // Then
        assertEquals(2, result.size()); // There should be two unique triplets
    }
}