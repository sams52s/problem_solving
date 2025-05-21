import java.util.HashMap;
    import java.util.Arrays;
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int[] nums2 = {-1,-3, 20,20, 3, 9, 10,20, 23};
        int k2 = 20;
        int k = 2;
        System.out.println(subarraySum(nums, k)); // Output: 2
        System.out.println("NUM2    " + Arrays.toString(nums2)); // Debugging line to check the array
        System.out.println(subarraySum(nums2, k2)); // Output: 1
    }

    /**
     * Approach: HashMap for Prefix Sums
     * 
     * Algorithm:
     * 1. Use a HashMap to store prefix sums and their frequencies
     * 2. Initialize sum to 0 and count to 0
     * 3. Iterate through the array, updating sum and checking for (sum - k) in the map
     * 4. Update the map with the current sum
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    /**
     * Detailed explanation of count += map.getOrDefault(sum - k, 0):
     * 
     * Let's trace with example: nums = [1,2,3,4,3], k = 7
     * 
     * 1. Map stores running sum frequencies: map<sum, frequency>
     * 2. For any index i, if (currentSum - k) exists in map, we found a subarray with sum k
     * 
     * Step by step trace:
     * Initial state: map = {0:1}
     * 
     * i=0: num=1
     * - sum = 1
     * - check map.get(1-7) = map.get(-6) = 0
     * - map = {0:1, 1:1}
     * 
     * i=1: num=2
     * - sum = 3
     * - check map.get(3-7) = map.get(-4) = 0
     * - map = {0:1, 1:1, 3:1}
     * 
     * i=2: num=3
     * - sum = 6
     * - check map.get(6-7) = map.get(-1) = 0
     * - map = {0:1, 1:1, 3:1, 6:1}
     * 
     * i=3: num=4
     * - sum = 10
     * - check map.get(10-7) = map.get(3) = 1  // Found! count++
     * - map = {0:1, 1:1, 3:1, 6:1, 10:1}
     * 
     * i=4: num=3
     * - sum = 13
     * - check map.get(13-7) = map.get(6) = 1  // Found! count++
     * - map = {0:1, 1:1, 3:1, 6:1, 10:1, 13:1}
     * 
     * Final count = 2 (subarrays: [3,4] and [4,3])
     * 
     * Time: O(n), Space: O(n)
     */
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Handle case where subarray starts from index 0
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            System.out.println("num = " + num); // Debugging line to check the current number
            System.out.println("sum before = " + sum); // Debugging line to check the sum before adding the current number
            System.out.println("count before = " + count); // Debugging line to check the count before updating
            // Update the sum with the current number
            sum += num;
            count += map.getOrDefault(sum - k, 0); // Check if (sum - k) exists in the map
            System.out.println("sum after = " + sum); // Debugging line to check the sum after adding the current number
            System.out.println("count after = " + count); // Debugging line to check the count after updating
            
            /** 
             *  If (sum - k) exists in the map, it means there is a subarray that sums to k
             *  Update the map with the current sum
             *  Increment the count of the current sum in the map
             *  This allows us to find subarrays that sum to k
             *  in future iterations
             *  For example, if sum = 5 and k = 3, we check if (5 - 3) = 2 exists in the map
             *  If it does, it means there is a subarray that sums to k
             *  We also need to increment the count of the current sum in the map
             */
            
            map.put(sum, map.getOrDefault(sum, 0) + 1); 
            System.out.println("map = " + map); // Debugging line to check the map after updating
        }

        return count;
    }
    /**
     * Approach: Brute Force (for comparison)
     * 
     * Algorithm:
     * 1. Use two nested loops to check all subarrays
     * 2. Count the number of subarrays that sum to k
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
}
}