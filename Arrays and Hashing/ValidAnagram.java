import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    // Problem Statement
    // Given two strings s and t,return true if the two strings are anagrams of each
    // other, otherwise return false.
    // An anagram is astring that contains the exact same characters as another
    // string, but the order of the characters can be different.

    // Example 1:
    // Input: s = "racecar", t = "carrace"
    // Output: true

    // Constraints:
    // 1 <= s.length, t.length <= 5 * 10^4
    // s and t consist of lowercase English letters.

    public static void main(String[] args) {
        System.out.println(isAnagram("racecar", "carrace")); // true
        System.out.println(isAnagram("hello", "bello")); // false
        System.out.println(isAnagram("listen", "silent")); // true
        System.out.println(isAnagram("python", "java")); // false

        System.out.println(isAnagramWithArray("racecar", "carrace")); // true
        System.out.println(isAnagramWithArray("hello", "bello")); // false
        System.out.println(isAnagramWithArray("listen", "silent")); // true
        System.out.println(isAnagramWithArray("python", "java")); // false
    }

    // My solution 1 : Using hash map to count the frequency of characters in both
    // strings ::
    // time complexity O(n)
    // space complexity O(k)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charCountMap.put(s.charAt(i), charCountMap.getOrDefault(s.charAt(i), 0) + 1);
            charCountMap.put(t.charAt(i), charCountMap.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Integer count : charCountMap.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    // Solution using array to count the frequency of characters in both strings ::
    // time complexity O(n)
    // space complexity O(1)
    public static boolean isAnagramWithArray(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;

    }

}