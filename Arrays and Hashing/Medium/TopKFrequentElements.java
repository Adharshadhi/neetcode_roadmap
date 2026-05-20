package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    // Problem Statement
    // Given an integer array nums and an integer k, return the k most frequent
    // elements within the array.
    // The test cases are generated such that the answer is always unique.
    // You may return the output in any order.

    // Example 1:
    // Input: nums = [1,2,2,3,3,3], k = 2
    // Output: [2,3]

    // Constraints:
    // 1 <= nums.length <= 10^4.
    // -1000 <= nums[i] <= 1000
    // 1 <= k <= number of distinct elements in nums.

    public static void main(String[] args) {
        int[] result = topKFrequent(new int[] { 1, 2, 2, 3, 3, 3 }, 2); // [3, 2]
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // Using hashmap and sorting :: time complexity O(n log n) where n is the number
    // of distinct elements in the array :: space complexity O(n)
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int element = frequencyMap.getOrDefault(nums[i], 0) + 1;
            frequencyMap.put(nums[i], element);
        }

        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(frequencyMap.entrySet());
        freqList.sort((a, b) -> b.getValue() - a.getValue());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = freqList.get(i).getKey();
        }

        return result;
    }
}