package Medium;

public class ProductsofArrayExceptSelf {
    // Problem Statement
    // Given an integer array nums, return an array output where output[i] is the
    // product of all the elements of nums except nums[i].
    // Each product is guaranteed to fit in a 32-bit integer.

    // Example 1:
    // Input: nums = [1,2,4,6]
    // Output: [48,24,12,8]

    // Constraints:
    // 2 <= nums.length <= 1000
    // -20 <= nums[i] <= 20

    public static void main(String[] args) {
        int[] result = productExceptSelfOptimizedSpace(new int[] { 1, 2, 4, 6 }); // [48, 24, 12, 8]
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // Approach is to use a brute force approach where we iterate through the array
    // and for each element we multiply all the other elements
    // :: time complexity O(n^2) space complexity O(n)
    public static int[] productExceptSelfBruteForce(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int counter = 0;
            int multipliedValue = 1;
            while (counter < nums.length) {
                if (counter != i) {
                    multipliedValue = multipliedValue * nums[counter];
                }
                counter++;
            }
            result[i] = multipliedValue;
        }
        return result;
    }

    // Approach is to create two arrays left and right where left[i] is the product
    // of all the elements to the left of i and right[i] is the product of all the
    // elements to the right of i
    // then we can multiply left[i] and right[i] to get the product of all the
    // elements except nums[i] at index i
    // :: time complexity O(n) space complexity O(n)
    public static int[] productExceptSelfOptimized(int[] nums) {

        int[] result = new int[nums.length];

        int[] left = new int[nums.length];
        left[0] = 1;

        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            left[i + 1] = left[i] * nums[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            right[i - 1] = right[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    // Approach is to optimize the space complexity by using the result array to
    // store the left products and then using a variable to store the right product
    // :: time complexity O(n) space complexity O(1)
    public static int[] productExceptSelfOptimizedSpace(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            result[i + 1] = result[i] * nums[i];
        }

        int rightMultiplier = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * rightMultiplier;
            rightMultiplier = rightMultiplier * nums[i];
        }

        return result;

    }
}
