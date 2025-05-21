/**
 * First Unique Character in a String (LeetCode 387)
 * 
 * Problem:
 * Given a string s, find the first non-repeating character and return its index.
 * If it does not exist, return -1.
 * 
 * Example:
 * Input: s = "leetcode"
 * Output: 0 (because 'l' is the first non-repeating character)
 */
import java.util.HashMap;
import java.util.HashSet;
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s)); // Output: 0
    }

    /**
     * Approach 1: Array Counter
     * Algorithm:
     * 1. Create frequency array for 26 lowercase letters
     * 2. Count character frequencies in first pass
     * 3. Find first character with count 1 in second pass
     * 
     * Time: O(n), Space: O(1)
     */
    public static int firstUniqChar(String s) {
        int[] count = new int[26]; // Assuming only lowercase letters a-z
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 2: HashMap Counter
     * Algorithm:
     * 1. Use HashMap to store character frequencies
     * 2. Count frequencies in first pass
     * 3. Find first character with count 1 in second pass
     * 
     * Advantage: Works with any character set (not just a-z)
     * Time: O(n), Space: O(k) where k is unique chars
     */
    public static int firstUniqChar2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 3: HashSet for Unique Characters
     * Algorithm:
     * 1. Use HashSet to track unique characters
     * 2. If character can't be added (already exists), remove it
     * 3. First character remaining in set is answer
     * 
     * Time: O(n), Space: O(k) where k is unique chars
     */
    public static int firstUniqChar3(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 4: String Built-in Methods
     * Algorithm:
     * 1. For each character, compare its first and last index
     * 2. If equal, it appears only once
     * 3. Return first such character's index
     * 
     * Advantages:
     * - Most concise solution
     * - No extra data structures
     * - Easy to understand
     * 
     * Disadvantages:
     * - indexOf() and lastIndexOf() each scan the string
     * - Time complexity is O(n^2) in worst case
     * 
     * Time: O(n^2), Space: O(1)
     */
    public static int firstUniqChar4(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
