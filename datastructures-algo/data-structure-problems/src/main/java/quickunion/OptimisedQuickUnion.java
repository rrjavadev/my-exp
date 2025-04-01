package quickunion;

import java.util.stream.IntStream;

/**
 * QuickUnion uses a tree structure.
 */
public class OptimisedQuickUnion {
    int[] id;
    int[] sz;

    public OptimisedQuickUnion(int n) {
        id = new int[n];
        IntStream.range(0, n)
                .forEach(i -> id[i] = i);
        sz = new int[id.length];
    }

    public int[] getIds() {
        return id;
    }

    private int root(int index) {

        while (index != this.id[index]) {
            index = this.id[index];
        }
        return index;
    }

    public boolean connected(int id1, int id2) {
        return root(id1) == root(id2);
    }

    public int[] union(int id1, int id2) {

        int rootOfId1 = root(id1);
        int rootOfId2 = root(id2);
        id[rootOfId1] = rootOfId2;

        if(sz[])


        return id;
    }
}
