package fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciJavaStreamTest {

    @Test
    void shouldReturnFibonacciNumber() {
        // Given
        int n = 10;
        int expected = 55; // The 10th Fibonacci number is 55

        // When
        List<Integer> result = FibonacciJavaStream.fibonacci(n);

        // Then
        assertEquals(expected, result);
    }

    @Test
    void fibonacciWhileLoop(){

        // Given
        int n = 10;

        // When
        int[] result = FibonacciJavaStream.fibRecursion( n);

        // Then
        assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, result);
    }

}