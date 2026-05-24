package Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // Problem Statement
    // Given an array of integers nums, return the length of the longest consecutive
    // sequence of elements that can be formed.
    // A consecutive sequence is a sequence of elements in which each element is
    // exactly 1 greater than the previous element. The elements do not have to be
    // consecutive in the original array.
    // You must write an algorithm that runs in O(n) time.

    // Example
    // Input: nums = [2,20,4,10,3,4,5]
    // Output: 4
    // Explanation: The longest consecutive sequence is [2, 3, 4, 5].

    // Constraints:
    // 0 <= nums.length <= 1000
    // -10^9 <= nums[i] <= 10^9

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 20, 4, 10, 3, 4, 5 };
        System.out.println(longestConsecutive(nums)); // 4

        int[] nums2 = new int[] { 2, 20, 4, 10, 3, 4, 5 };
        System.out.println(longestConsecutiveHashSet(nums2)); // 4
    }

    // Approach is to sort the array and then iterate through it and keep track of
    // the current streak and the best streak
    // if the current number is the same as the next number we skip it since it does
    // not contribute to the streak
    // if the current number is one less than the next number we increment the
    // streak time complexity O(n log n) space complexity O(1)
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int streak = nums.length == 0 ? 0 : 1;
        int bestStreak = streak;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            } else if ((nums[i + 1] - nums[i]) == 1) {
                streak++;
            } else {
                streak = 1;
            }
            if (streak > bestStreak) {
                bestStreak = streak;
            }
        }
        return bestStreak;
    }

    // Approach is to use a hash set to keep track of the numbers in the array and
    // then iterate through the set and for each number we check if it is the start
    // of a streak by checking if the previous number is not in the set if it is not
    // then we increment the streak until we find a number that is not in the set
    // time complexity O(n) space complexity O(n)
    public static int longestConsecutiveHashSet(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (Integer num : nums) {
            numSet.add(num);
        }
        int maxStreak = 0;
        for (Integer num : numSet) {
            // if the previous number is not in the set then we have found the start of a
            // streak
            if (!numSet.contains(num - 1)) {
                int streak = 1;
                int counter = num;
                while (numSet.contains(counter + 1)) {
                    streak++;
                    counter++;
                }
                maxStreak = Math.max(streak, maxStreak);
            }
        }
        return maxStreak;
    }
}
