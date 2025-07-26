package top8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentWordsTest {

    @Test
    void getTopKFrequentWordsUsingMinHeapOrDynamicArraySortedLexicographicallyUsingMinHeap() {

        // Given an array of words and an integer k, return the k most frequent words.
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        List<String> strings = List.of("love", "i", "i", "love", "leetcode", "i", "love", "coding");

        //When
        List<String> result = topKFrequentWords.getTopKFrequentWordsUsingMinHeapOrDynamicArray(strings, 2);

        //Then
        assertEquals(List.of("i", "love"), result);
    }

    @Test
    void getTopKFrequentWordsUsingMinHeapOrDynamicArraySortedLexicographicallyUsingMaxHeap() {

        // Given an array of words and an integer k, return the k most frequent words.
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        List<String> strings = List.of("love", "i", "i", "love", "leetcode", "i", "love", "coding");

        //When
        List<String> result = topKFrequentWords.getTopKFrequentWordsUsingMaxHeap(strings, 2);

        //Then
        assertEquals(List.of("i", "love"), result);
    }
}