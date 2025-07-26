package top8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Given an array of words and an integer k, return the k most frequent words.
 * The answer should be sorted by frequency in descending order. Sort the words by their lexicographical order if
 * they have the same frequency.
 */
public class TopKFrequentWords {

    public List<String> getTopKFrequentWordsUsingMinHeapOrDynamicArray(List<String> strings, int k) {

        Map<String, Integer> wordCountMap = strings.stream()
                .collect(groupingBy(s -> s, Collectors.summingInt(count -> 1)));

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(TopKFrequentWords::compareEntriesForMinHeap);
        for (Map.Entry<String, Integer> wordMapEntry : wordCountMap.entrySet()) {
            minHeap.offer(wordMapEntry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.stream()
                .map(e -> e.getKey())
                .toList();
    }

    private static int compareEntriesForMinHeap(Map.Entry<String, Integer> s1, Map.Entry<String, Integer> s2) {

        int comparisonResult = s1.getValue().compareTo(s2.getValue());
        if (comparisonResult == 0) {
            return s1.getKey().compareTo(s2.getKey());
        } else {
            return comparisonResult;
        }
    }

    private static int compareEntriesForMaxHeap(Map.Entry<String, Integer> s1, Map.Entry<String, Integer> s2) {

        int comparisonResult = s2.getValue() - s1.getValue();
        if (comparisonResult == 0) {
            return s1.getKey().compareTo(s2.getKey());
        } else {
            return comparisonResult;
        }
    }

    public List<String> getTopKFrequentWordsUsingMaxHeap(List<String> strings, int k) {

        //First store the key value pair of count
        Map<String, Integer> wordCountMap = strings.stream()
                .collect(groupingBy(s1 -> s1, Collectors.summingInt(count -> 1)));

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(TopKFrequentWords::compareEntriesForMaxHeap);

        maxHeap.addAll(wordCountMap.entrySet());

//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
//            result.add(maxHeap.poll().getKey());
//        }

//        return result;
        //or

        return IntStream.range(0, k)
                .mapToObj(i -> Objects.requireNonNull(maxHeap.poll()).getKey())
                .toList();
    }
}
