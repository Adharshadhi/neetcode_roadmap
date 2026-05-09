import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {

    // Problem Statement
    // Given an integer array nums, return true if any value appears more than once
    // in the array,
    // otherwise return false.

    // Example 1:
    // Input: nums = [1, 2, 3, 3]
    // Output: true

    // Constraints:
    // 0 <= nums.length <= 10^5
    // -10^9 <= nums[i] <= 10^9

    public static void main(String[] args) {
        System.out.println(hasDuplicate(new int[] { 1, 2, 3, 3 })); // true
        System.out.println(hasDuplicate(new int[] { 1, 2, 3, 4 })); // false
        System.out.println(hasDuplicate(new int[] { 1 })); // false
        System.out.println(hasDuplicate(new int[] { 0, 0 })); // true

        System.out.println(hasDuplicateOptimized(new int[] { 1, 2, 3, 3 })); // true
        System.out.println(hasDuplicateOptimized(new int[] { 1, 2, 3, 4 })); // false
        System.out.println(hasDuplicateOptimized(new int[] { 1 })); // false
        System.out.println(hasDuplicateOptimized(new int[] { 0, 0 })); // true
    }

    // brute force solution :: time complexity O(n^2)
    public static boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Using hashset for optimizing the lookup :: time complexity O(n)
    public static boolean hasDuplicateOptimized(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i])) {
                return true;
            }
            numSet.add(nums[i]);
        }
        return numSet.size() != nums.length;
    }
}
