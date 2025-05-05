import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1})); // true
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4})); // false
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1, 2, 3})); // true
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> contain = new HashSet<>();
        for (int num : nums) {
           if(!contain.add(num)) { // Try to add the number to the set
                // If the number is already in the set, it means we have a duplicate
                // So we return true
                return true; 
            }
        }
        return false;
    }
}
