package quickunion;

import java.util.stream.IntStream;

public class DynamicConnectivityQuickUnion {
    int[] id;

    public DynamicConnectivityQuickUnion(int n) {
        id = new int[n];
        IntStream.range(0, n)
                .forEach(i -> id[i] = i);
    }

    public int[] getIds() {
        return id;
    }
}
