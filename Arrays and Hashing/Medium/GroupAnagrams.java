package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    // Problem Statement
    // Given an array of strings strs, group all anagrams together into sublists.
    // You may return the output in any order.
    // An anagram is a string that contains the exact same characters as another
    // string, but the order of the characters can be different.

    // Example 1:
    // Input: strs = ["act","pots","tops","cat","stop","hat"]
    // Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

    // Constraints:
    // 1 <= strs.length <= 1000.
    // 0 <= strs[i].length <= 100
    // strs[i] is made up of lowercase English letters.

    public static void main(String[] args) {
        List<List<String>> result = groupAnagrams(new String[] { "act", "pots", "tops", "cat", "stop", "hat" });
        for (List<String> group : result) {
            System.out.print("[");
            for (String word : group) {
                System.out.print(word + " ");
            }
            System.out.println("]");
        }

        List<List<String>> resultTwo = groupAnagramsOptimized(
                new String[] { "act", "pots", "tops", "cat", "stop", "hat" });
        for (List<String> group : resultTwo) {
            System.out.print("[");
            for (String word : group) {
                System.out.print(word + " ");
            }
            System.out.println("]");
        }
    }

    // Using hashmap and frequency array :: time complexity O(n * k) where n is the
    // number of strings and k is the average length of the string :: space
    // complexity O(n * k)
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> outputResult = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            int[] freqArray = new int[26];
            for (int i = 0; i < str.length(); i++) {
                freqArray[str.charAt(i) - 'a']++;
            }
            String uniqueStr = Arrays.toString(freqArray);
            List<String> currentList = anagramMap.getOrDefault(uniqueStr, new ArrayList<>());
            currentList.add(str);
            anagramMap.put(uniqueStr, currentList);
        }

        return new ArrayList<>(anagramMap.values());

    }

    // using sorting :: time complexity O(n * k log k) where n is the number of
    // strings and k is the average length of the string :: space complexity O(n *
    // k)
    public static List<List<String>> groupAnagramsOptimized(String[] strs) {
        List<List<String>> outputResult = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedVal = new String(chars);

            List<String> currentList = null;

            if (anagramMap.containsKey(sortedVal)) {
                currentList = anagramMap.get(sortedVal);
            } else {
                currentList = new ArrayList<>();
            }
            currentList.add(strs[i]);
            anagramMap.put(sortedVal, currentList);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
