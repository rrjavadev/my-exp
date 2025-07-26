package random;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int maxCapacity = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            int tempCapacity = Math.min(height[left], height[right]) * (right - left);
            System.out.println("Left: " + left + ", Right: " + right + ", Height Left: " + height[left] + ", Height Right: " + height[right] + ", Temp Capacity: " + tempCapacity);
            if (tempCapacity > maxCapacity) {
                maxCapacity = tempCapacity;
            }

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxCapacity;
    }
}
