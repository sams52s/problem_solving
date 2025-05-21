import java.util.ArrayList;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_anArray {
    public static void main(String[] args) {
            Find_All_Numbers_Disappeared_in_anArray solution = new Find_All_Numbers_Disappeared_in_anArray();
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            int[] nums2 = {1, 1};
            int[] nums3 = {1, 2, 3, 4, 5, 6};
            System.out.println(solution.findDisappearedNumbers(nums)); // Output: [5, 6]
            System.out.println(solution.findDisappearedNumbers(nums2)); // Output: [2]
            System.out.println(solution.findDisappearedNumbers(nums3)); // Output: []

    }
    /**
     * Finds all numbers from 1 to n that are missing from the array
     * where n is the length of the input array.
     * 
     * Algorithm:
     * 1. Create a boolean array 'seen' of size n+1 to mark present numbers
     * 2. Iterate through input array and mark numbers as seen
     * 3. Check which numbers from 1 to n are not marked as seen
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param nums Input array containing numbers from 1 to n
     * @return List of missing numbers
     */
    private List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] seen = new boolean[nums.length + 1];  // +1 because numbers are 1-based
        for (int num : nums) {
            System.out.println("num = " + num); // Debugging line to check the current number
            // Mark the number as seen
            // The number is in the range 1 to n, so we can use it as an index
            // seen[num] = true;  // Mark numbers that exist in the input array
            seen[num] = true;  // Mark numbers that exist in the input array
        }
        for (int i = 1; i < seen.length; i++) {
            System.out.println("seen[" + i + "] = " + seen[i]); // Debugging line to check the seen array
            // Check if the number i was not seen in the input array
            // If not seen, add it to the result list
            // This is the main logic of the algorithm
            if (!seen[i]) {    // If number i was not seen in the input array
                result.add(i); // Add it to the result list
            }
        }
        return result;
    }
}
