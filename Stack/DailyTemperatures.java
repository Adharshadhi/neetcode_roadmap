package Stack;

import java.util.Stack;

public class DailyTemperatures {

    // Problem Statement
    // You are given an array of integers temperatures where temperatures[i]
    // represents the daily temperatures on the ith day.
    // Return an array result where result[i] is the number of days after the ith
    // day before a warmer temperature appears on a future day. If there is no day
    // in the future where a warmer temperature will appear for the ith day, set
    // result[i] to 0 instead.

    // Example 1:
    // Input: temperatures = [30,38,30,36,35,40,28]
    // Output: [1,4,1,2,1,0,0]

    // Constraints:
    // 1 <= temperatures.length <= 1000.
    // 1 <= temperatures[i] <= 100

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] temperatures = { 30, 38, 30, 36, 35, 40, 28 };
        int[] result = solution.dailyTemperaturesOptimized(temperatures);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println("***********");
        int[] temperaturesTwo = { 30, 38, 30, 36, 35, 40, 28 };
        int[] resultTwo = solution.dailyTemperaturesBruteForce(temperaturesTwo);
        for (int i : resultTwo) {
            System.out.print(i + " ");
        }
    }

    // Approach is to use a brute force approach where we iterate through the
    // temperatures array and for each temperature we iterate through the rest of
    // the array to find the next warmer temperature, we calculate the number of
    // days until a warmer temperature appears by subtracting the current index from
    // the index of the warmer temperature, if we find a warmer temperature we break
    // out of the inner loop, if we do not find a warmer temperature we set the
    // result for that index to 0, at the end we should have the result array filled
    // with the number of days until a warmer temperature appears for each day
    // Time complexity is O(n^2) where n is the number of temperatures in the input
    // array, since we need to iterate through all the temperatures once and for
    // each temperature we need to iterate through the rest of the array to find the
    // next warmer temperature, which is also O(n) time complexity
    // Space complexity is O(n) since we need to create a result array of the same
    // length as the input array to store the number of days until a warmer
    // temperature appears for each day, which is O(n) space complexity
    public int[] dailyTemperaturesBruteForce(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }

    // Approach is to use a stack to keep track of the indices of the temperatures,
    // we iterate through the temperatures array and for each temperature we check
    // if it is greater than the temperature at the index at the top of the stack,
    // if it is we pop the index from the stack and calculate the number of days
    // until a warmer temperature appears by subtracting the popped index from the
    // current index, we repeat this process until we find a temperature that is not
    // greater than the temperature at the index at the top of the stack or until
    // the stack is empty, then we push the current index onto the stack, at the end
    // we should have all the indices of the temperatures in the stack and we can
    // return the result array
    // Time complexity is O(n) where n is the number of temperatures in the input
    // array, since we need to iterate through all the temperatures once, and in the
    // worst case we will pop all the indices from the stack once, which is also
    // O(n) time complexity
    // Space complexity is O(n) in the worst case when all the temperatures are in
    // increasing order, we will have n indices in the stack at the end of the
    // iteration, which is O(n) space complexity
    public int[] dailyTemperaturesOptimized(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> temperatureStack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            while (!temperatureStack.isEmpty() && currentTemp > temperatures[temperatureStack.peek()]) {
                int poppedIndex = temperatureStack.pop();
                result[poppedIndex] = i - poppedIndex;
            }
            temperatureStack.push(i);
        }

        return result;
    }
}
