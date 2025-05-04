
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
    public int lengthOfLongestSubstring(String s) {

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
