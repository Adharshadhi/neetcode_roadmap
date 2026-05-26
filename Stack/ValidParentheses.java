package Stack;

import java.util.Stack;

public class ValidParentheses {
    // Problem Statement
    // You are given a string s consisting of the following characters: '(', ')',
    // '{', '}', '[' and ']'.
    // The input string s is valid if and only if:
    // Every open bracket is closed by the same type of close bracket.
    // Open brackets are closed in the correct order.
    // Every close bracket has a corresponding open bracket of the same type.
    // Return true if s is a valid string, and false otherwise.

    // Example 1:
    // Input: s = "[]"
    // Output: true
    // Example 2:
    // Input: s = "([{}])"
    // Output: true

    // Constraints:
    // 1 <= s.length <= 1000

    public static void main(String[] args) {
        String[] tests = { "()", "()[]{}", "(]", "([)]", "{[]}", "" };
        for (String t : tests) {
            System.out.printf("%s -> %b\n", t, isValid(t));
        }
    }

    // Approach is to use a stack to keep track of the opening brackets and for each
    // closing bracket we check if the last inserted opening bracket is the
    // corresponding one if it is not we return false
    // time complexity O(n) space complexity O(n) since in the worst case we can
    // have all opening brackets in the stack

    // In a valid parenthesis expression, every opening bracket must have a
    // corresponding closing bracket. The stack is used to process the valid string,
    // and it should be empty after the entire process. This ensures that there is a
    // valid substring between each opening and closing bracket.
    public static boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '{' || currentChar == '[' || currentChar == '(') {
                charStack.push(currentChar);
            } else {
                if (charStack.isEmpty()) {
                    return false;
                }
                char lastInsertedCharacter = charStack.pop();
                if (lastInsertedCharacter != mappedChar(currentChar)) {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }

    // utility function to map the closing brackets to their corresponding opening
    // brackets
    private static char mappedChar(char character) {
        return switch (character) {
            case '}' -> '{';
            case ')' -> '(';
            default -> '[';
        };
    }
}
