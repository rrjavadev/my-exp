package top8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMedianFromDataStreamTest {

    @Test
    void findMedianWhenMaxAndMinHeapsHaveSameLength() {
        // Given a data stream, find the median of the numbers in the stream.
        FindMedianFromDataStream unit = new FindMedianFromDataStream();

        // Add numbers to the data stream and find the median.
        // Example: unit.addNum(1);
        // Example: unit.addNum(2);
        // Example: double median = unit.findMedian();
        // For instance, if the data stream is [1, 2, 3], the median should be 2.0.
        // Add numbers to the data stream.
        unit.add(1);
        unit.add(2);
        unit.add(5);
        unit.add(3);

        // When
        float median = unit.findMedian();

        // Then
        assertEquals(2.5, median);
    }

    @Test
    void findMedianWhenMaxAndMinHeapsHaveDifferentLength() {
        // Given a data stream, find the median of the numbers in the stream.
        FindMedianFromDataStream unit = new FindMedianFromDataStream();

        // Add numbers to the data stream and find the median.
        // Example: unit.addNum(1);
        // Example: unit.addNum(2);
        // Example: double median = unit.findMedian();
        // For instance, if the data stream is [1, 2, 3], the median should be 2.0.
        // Add numbers to the data stream.
        unit.add(1);
        unit.add(2);
        unit.add(5);

        // When
        float median = unit.findMedian();

        // Then
        assertEquals(2.0, median);
    }
}