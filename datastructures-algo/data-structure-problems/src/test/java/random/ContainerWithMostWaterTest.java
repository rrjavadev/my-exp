package random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    void maxArea() {
        //Given
        int[] height = {1,8,6,2,5,4,8,3,7};

        //When
        int result = ContainerWithMostWater.maxArea(height);

        //Then
        assertEquals(49, result); // The maximum area is 49
    }
}