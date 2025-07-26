package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 */
public class ThreeSum {


    public static List<List<Integer>> threeSum(int[] sorted) {
        List<List<Integer>> result = new ArrayList<>();
        int length = sorted.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > 0 ; j--) {
                int sum = sorted[i] + sorted[j] + sorted[j - 1];
                if (sum == 0) {
                    result.add(Stream.of(sorted[i], sorted[j], sorted[j - 1]).sorted().toList());
                }
            }
        }

        return result.stream().distinct().toList();
    }

    public static List<List<Integer>> threeSum1(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int[] sorted = Arrays.stream(nums).distinct().sorted().toArray();
        int length = sorted.length;

        int left = 0;
        int right = length - 1;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1]) continue; // Skip duplicates

            left = i + 1;
            right = length - 1;

            while (left < right) {
                int sum = sorted[i] + sorted[left] + sorted[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(List.of(sorted[i], sorted[left], sorted[right]));
//                    while (left < right && sorted[left] == sorted[left + 1]) left++; // Skip duplicates
//                    while (left < right && sorted[right] == sorted[right - 1]) right--; // Skip duplicates
                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
