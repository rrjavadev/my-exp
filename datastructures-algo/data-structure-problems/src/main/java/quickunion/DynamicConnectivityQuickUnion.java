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

    private int findRoot(int id){
        //If id and valueOf(id) are identical, then that's the root
        /***
         * index :0 1 2 3 4 5 6 7 8 9
         * id val:1 1 1 8 3 0 5 1 8 8
         *
         * here 1 and 8 are roots because index and id are identical.
         * See figure QuickUnion.png
         */

        while (id != valueOf(id)){
            id = valueOf(id);
        }
        return id;
    }

    private int valueOf(int idVal) {
        return this.id[idVal];
    }

    public boolean connected(int id1, int id2) {
        return findRoot(id1) == findRoot(id2);
    }

    public int[] union(int id1, int id2) {

        int rootOfId1 = findRoot(id1);
        int rootOfId2 = findRoot(id2);

        id[rootOfId1] = rootOfId2;

        return id;
    }
}
