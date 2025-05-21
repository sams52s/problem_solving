import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("")); // 0
        System.out.println(lengthOfLongestSubstring("a")); // 1
        System.out.println(lengthOfLongestSubstring("au")); // 2
    }

    /**
     * Finds the length of the longest substring without repeating characters.
     * This implementation shows two approaches: HashMap and HashSet.
     * 
     * HashMap Approach:
     * - Uses a sliding window technique with optimized jumping
     * - map stores character -> latest index mapping
     * - j keeps track of the leftmost valid position
     * - When we find a repeating character, we jump j to its last occurrence
     * 
     * Example with "abcabcbb":
     * i=0: a->0, j=-1, length=1
     * i=1: b->1, j=-1, length=2
     * i=2: c->2, j=-1, length=3
     * i=3: a exists, j=max(-1,0)=0, a->3, length=3
     * And so on...
     * 
     * HashSet Approach:
     * - Uses sliding window with character set
     * - left pointer moves one by one
     * - set maintains current window's unique characters
     * - When duplicate found, shrink window from left
     * 
     * Example with "abcabcbb":
     * i=0: set=[a], left=0, length=1
     * i=1: set=[a,b], left=0, length=2
     * i=2: set=[a,b,c], left=0, length=3
     * i=3: remove 'a', left=1, set=[b,c,a], length=3
     * And so on...
     * 
     * Time Complexity: O(n) where n is string length
     * Space Complexity: O(min(m,n)) where m is size of charset
     * 
     * @param s input string
     * @return length of longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring2(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int j = -1;

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            //If I solve this by HashMap
            if (map.containsKey(s.charAt(i))){
                j =  Math.max(j, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            length = Math.max(length, i - j);
            //If I solve this by HashSet
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            length = Math.max(length, i - left + 1);
        }
        return length;
    }
     public static int lengthOfLongestSubstring3(String s) {
        List<Character> list = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (list.contains(currentChar)) {
                System.out.println("Duplicate found: " + currentChar);
                // Remove characters from the start of the list until we remove the duplicate
                while (list.contains(currentChar)) {
                    System.out.println("Removing character: " + list.get(0));
                    list.remove(0);
                }
            }
            list.add(currentChar);
            maxLength = Math.max(maxLength, list.size());
            System.out.println("Current character: " + currentChar + ", Current list: " + list + ", Max length: " + maxLength);
        }
        return maxLength;
     }

    /**
     * Returns the length of the longest substring without repeating characters in the given string.
     *
     * <p>
     * This method uses the sliding window technique with a HashSet to efficiently track unique characters.
     * It maintains two pointers, {@code left} and {@code right}, which define the current window of unique characters.
     * As the {@code right} pointer moves through the string, characters are added to the set.
     * If a duplicate character is found, the {@code left} pointer is incremented and characters are removed from the set
     * until the duplicate is eliminated. The maximum window size encountered during this process is returned.
     * </p>
     *
     * @param s the input string to be examined
     * @return the length of the longest substring without repeating characters
     *
     * <p>
     * Example:
     * <pre>
     * lengthOfLongestSubstring("abcabcbb") returns 3, because "abc" is the longest substring without repeating characters.
     * </pre>
     * </p>
     */
     public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            while (set.contains(currentChar)) {
                System.out.println("Duplicate found: " + currentChar);
                System.out.println("Removing character: " + s.charAt(left));
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
     }
}
