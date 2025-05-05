public class  MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0; // Pointer for the last non-zero element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i]; // Move non-zero element to the front
            }
        }
        // Fill the remaining positions with zeros
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    /**
     * This solution has O(n) time complexity and O(1) space complexity.
     * It uses a two-pointer approach to move non-zero elements to the front
     * and fill the rest of the array with zeros.
     */
}
