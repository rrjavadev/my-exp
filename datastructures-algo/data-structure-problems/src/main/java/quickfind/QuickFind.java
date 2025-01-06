package quickfind;

import java.util.stream.IntStream;

public class QuickFind {

    int[] id;

    public QuickFind(int n) {
        id = new int[n];
       IntStream.range(0, n)
                .forEach(i -> id[i] = i);
    }

    public int[] getIds() {
        return id;
    }

    public boolean connected(int index1, int index2) {
        return id[index1] == id[index2];
    }
}
