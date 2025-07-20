package fibonacci;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciJavaStream {

    public static  List<Integer> fibonacci(int n) {
//        return Stream.iterate(0, x -> x + 1)
        return Stream.iterate(new int[]{0, 1},
                        pair -> new int[]{pair[1], pair[0] + pair[1]})
                .peek(e -> System.out.println("Current Fibonacci pair: " + e[0] + ", " + e[1]))
                .limit(n)
                .map(pair -> pair[0])
                .collect(Collectors.toList());

    }

    public static int[] fibRecursion(int n){

        int curr = 0;
        int next = 1;
        int[] arr = new int[n];
        arr[0] = curr;
        arr[1] = next;
        int i = 2; // Start from the third element

        while(n > i){
            arr[i] = curr + next;
            curr = next;
            next =  arr[i];
            i++;
        }
        return arr;
    }
}
