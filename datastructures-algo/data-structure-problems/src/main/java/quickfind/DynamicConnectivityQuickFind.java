package quickfind;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DynamicConnectivityQuickFind {

    int[] id;

    public DynamicConnectivityQuickFind(int n) {
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

    public int[] union(int index1, int index2) {
       for(int i = 0; i < id.length; i ++){
            if(id[i] == id[index1]){
                id[i] = id[index2];
            }
       }
       return id;
    }
}
