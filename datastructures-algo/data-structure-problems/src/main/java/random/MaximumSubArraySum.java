package random;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArraySum {

    private static int currentSum = 0;
    private static int maxSum = 0;

    public static int maxSubArray(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            currentSum = Math.max(nums[i] + currentSum, nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
