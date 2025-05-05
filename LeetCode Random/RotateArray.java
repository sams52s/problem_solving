public class RotateArray {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        int k2 = 3;
        rotate2ndSolution(nums2, k2);
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }
    /** 
     * this takes 0ms Runtime and 57.76MB Memory
     * **/
    private static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than n
        reverse(nums, 0, n - 1); // Reverse the entire array
        reverse(nums, 0, k - 1); // Reverse the first k elements
        reverse(nums, k, n - 1); // Reverse the remaining elements
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /** 
     * this takes 2ms Runtime and 57.13MB Memory
     * **/
    private static void rotate2ndSolution(int[] nums, int k){
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than n
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, n); // Copy the result back to nums
        // Note: This solution uses O(n) extra space for the result array
        // and O(n) time complexity for the copy operation.
        // The first solution is more space-efficient with O(1) extra space.
        // The second solution is more straightforward but less space-efficient.
        // Both solutions have O(n) time complexity.
        // The first solution is more space-efficient with O(1) extra space.
    }
}
