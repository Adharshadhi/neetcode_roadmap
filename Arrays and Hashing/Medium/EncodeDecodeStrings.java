package Medium;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    // Problem Statement
    // Design an algorithm to encode a list of strings to a string. The encoded
    // string is then sent over the network and is decoded back to the original list
    // of strings.

    // Example 1:
    // Input: strs = ["Hello","World"]
    // Output: ["Hello","World"]

    // Constraints:
    // 0 <= strs.length < 100
    // 0 <= strs[i].length < 200
    // strs[i] contains any possible characters out of 256 valid ASCII characters.

    public static void main(String[] args) {
        List<String> result = decode(encode(new ArrayList<>() {
            {
                add("Hello");
                add("World");
            }
        })); // ["Hello", "World"]
        for (String str : result) {
            System.out.print(str + " ");
        }
    }

    // Approach is to encode the string by appending the length of the string
    // followed by a delimiter and then the string itself
    // :: time complexity O(n)
    // where n is the total number of characters in the list of strings
    // :: space complexity O(n)
    public static String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str.length()).append("@").append(str);
        }
        return result.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int currentPos = 0;
        while (currentPos < str.length()) {
            int tracker = currentPos;
            while (str.charAt(tracker) != '@') {
                tracker++;
            }
            int strLength = Integer.parseInt(str.substring(currentPos, tracker));
            tracker++;
            String element = str.substring(tracker, tracker + strLength);
            result.add(element);
            currentPos = tracker + strLength;
        }
        return result;
    }
}
