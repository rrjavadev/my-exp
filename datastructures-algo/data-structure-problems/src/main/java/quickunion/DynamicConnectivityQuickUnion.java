package quickunion;

import java.util.stream.IntStream;

/**
 * QuickUnion uses a tree structure.
 */
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

    private int root(int index){

        while (index != this.id[index]){
            index = this.id[index];
        }
        return index;
    }

    public boolean connected(int id1, int id2) {
        return root(id1) == root(id2);
    }
}
