public class ValidPalindrome {

    // Problem Statement
    // Given a string s, return true if it is a palindrome, otherwise return false.
    // A palindrome is a string that reads the same forward and backward. It is also
    // case-insensitive and ignores all non-alphanumeric characters.
    // Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers
    // (0-9).

    // Example 1:
    // Input: s = "Was it a car or a cat I saw?"
    // Output: true

    // Explanation: After considering only alphanumerical characters we have
    // "wasitacaroracatisaw", which is a palindrome.

    // Constraints:
    // 1 <= s.length <= 1000
    // s is made up of only printable ASCII characters.

    // Approach 1: Using StringBuilder
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // Build two strings, one from the start and one from the end, and compare them.
    public boolean isPalindromeWithStringBuilder(String s) {
        StringBuilder initialStr = new StringBuilder();
        StringBuilder finalStr = new StringBuilder();

        for (int i = s.length() - 1, j = 0; i >= 0 && j < s.length(); i--, j++) {
            if (isAlphaNumericCharacter(s.charAt(j))) {
                initialStr.append(Character.toLowerCase(s.charAt(j)));
            }
            if (isAlphaNumericCharacter(s.charAt(i))) {
                finalStr.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        return initialStr.toString().equals(finalStr.toString());
    }

    // Approach 2: Using Two Pointers
    // Time Complexity: O(n)
    // Space Complexity: O(1) (No extra space used)
    // Use two pointers, one starting from the beginning and the other from the end
    // of the string. Move the pointers towards each other while skipping
    // non-alphanumeric characters and comparing the characters at both pointers.
    public boolean isPalindromeTwoPointer(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // while is required instead of if as multiple non-alphanumeric characters can
            // be present in a
            // row
            while (left < right && !isAlphaNumericCharacter(s.charAt(left))) {
                left++;
            }
            while (left < right && !isAlphaNumericCharacter(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }

    private boolean isAlphaNumericCharacter(char character) {
        // Check if the character is alphanumeric (0-9, A-Z, a-z)
        return ((character >= '0' && character <= '9')
                || (character >= 'A' && character <= 'Z')
                || (character >= 'a' && character <= 'z'));
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        // Test cases
        System.out.println(solution.isPalindromeWithStringBuilder("A man, a plan, a canal: Panama")); // true
        System.out.println(solution.isPalindromeWithStringBuilder("race a car")); // false
        System.out.println(solution.isPalindromeWithStringBuilder(" ")); // true

        System.out.println("Using Two Pointer Approach:");

        System.out.println(solution.isPalindromeTwoPointer("A man, a plan, a canal: Panama")); // true
        System.out.println(solution.isPalindromeTwoPointer("race a car")); // false
        System.out.println(solution.isPalindromeTwoPointer(" ")); // true
    }
}
