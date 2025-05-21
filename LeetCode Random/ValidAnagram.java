import java.util.*;

/**
 * Valid Anagram (LeetCode 242)
 * 
 * Problem:
 * Given two strings s and t, determine if t is an anagram of s.
 * An anagram is a word formed by rearranging the letters of another word.
 * 
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Constraints:
 * - 1 <= s.length, t.length <= 5 * 10^4
 * - s and t consist of lowercase English letters
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t)); // Output: true
    }

    /**
     * Approach 1: Single Pass with Counter Array (Debug version)
     * 
     * Algorithm:
     * 1. Check if lengths are equal (if not, return false)
     * 2. Use int array of size 26 as counter for lowercase letters
     * 3. Iterate through both strings simultaneously
     * 4. Increment count for chars in s, decrement for chars in t
     * 5. Check if all counts are zero
     * 
     * Time Complexity: O(n) where n is length of strings
     * Space Complexity: O(1) as array size is fixed at 26
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26]; // Assuming only lowercase letters a-z
        for (int i = 0; i < s.length(); i++) {
            System.out.println("s.charAt(i) = " + s.charAt(i)); // Debugging line to check the current character
            System.out.println("t.charAt(i) = " + t.charAt(i)); // Debugging line to check the current character
            System.out.println("count[s.charAt(i) - 'a'] = " + count[s.charAt(i) - 'a']); // Debugging line to check the count array
            System.out.println("count[t.charAt(i) - 'a'] = " + count[t.charAt(i) - 'a']); // Debugging line to check the count array
            // Increment the count for s and decrement for t
            count[s.charAt(i) - 'a']++; // Increment count for s
            count[t.charAt(i) - 'a']--; // Decrement count for t
            System.out.println("count after update = " + Arrays.toString(count)); // Debugging line to check the count array
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean isAnagram2(String s, String t) {
    
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
}
