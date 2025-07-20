package binarySearch;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeBetweenTwoNumbers implements Iterable<Integer> {
    private int start;
    private int end;

    public RangeBetweenTwoNumbers(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Start must be less than or equal to end.");
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index = start;

            @Override
            public Object next() {

                if (index < end) {
                    return index++;
                }

                throw new NoSuchElementException("No more elements in the range.");
            }

            @Override
            public boolean hasNext() {
                return index < end;
            }
        };
    }
}
