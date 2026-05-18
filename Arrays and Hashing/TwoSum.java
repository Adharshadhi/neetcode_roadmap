import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // Problem Statement
    // Given an array of integers nums and an integer target, return the indices i
    // and j such that nums[i] + nums[j] == target and i != j.
    // You may assume that every input has exactly one pair of indices i and j that
    // satisfy the condition.
    // Return the answer with the smaller index first.

    // Example 1:
    // Input:
    // nums = [3,4,5,6], target = 7
    // Output: [0,1]

    // Constraints:
    // 2 <= nums.length <= 1000
    // -10,000,000 <= nums[i] <= 10,000,000
    // -10,000,000 <= target <= 10,000,000
    // Only one valid answer exists.

    public static void main(String[] args) {
        int[] result = twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // [0, 1]

        result = twoSum(new int[] { 3, 2, 4 }, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // [1, 2]

        result = twoSum(new int[] { 3, 3 }, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // [0, 1]

        result = twoSumOptimized(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // [0, 1]

        result = twoSumOptimized(new int[] { 3, 2, 4 }, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // [1, 2]

        result = twoSumOptimized(new int[] { 3, 3 }, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // [0, 1]

    }

    // brute force solution :: time complexity O(n^2) :: space complexity O(1)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }

    // optimized solution :: time complexity O(n) :: space complexity O(n)
    public static int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int difference = 0;
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                return new int[] { indexMap.get(nums[i]), i };
            } else {
                difference = target - nums[i];
                indexMap.put(difference, i);
            }
        }
        return new int[0];
    }

}
