package top8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue(Comparator.comparing(Integer::intValue));
    PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.comparing(Integer::intValue).reversed());

    public void add(int i) {
        maxHeap.offer(i);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public float findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0f;
        }
    }
}
