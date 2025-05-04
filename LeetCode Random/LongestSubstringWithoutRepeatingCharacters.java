
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("")); // 0
        System.out.println(lengthOfLongestSubstring("a")); // 1
        System.out.println(lengthOfLongestSubstring("au")); // 2
    }
    public static int lengthOfLongestSubstring(String s) {

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
}
