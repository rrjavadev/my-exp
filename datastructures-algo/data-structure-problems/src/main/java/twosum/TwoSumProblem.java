package twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return the indices of the two numbers such that they add up to the target.
 *
 * You may assume:
 *
 * Each input has exactly one solution.
 *
 * You cannot use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Exampele:
 *
  *
  * Input: nums = [2, 7, 11, 15], target = 9
  * Output: [0, 1]
  * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSumProblem {


    public static int[] twoSumBruteForce(int[] nums, int target) {
        for(int i=0; i< nums.length ; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumOptimised(Integer[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++) {
            Integer diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i); // Store the index of the current number

        }
        return null;
    }
}
