public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    /**
     *  Explanation: 
     *  This problem requires finding the product of all elements in the array except the current element.
     *  
     *  First Solution (productExceptSelf):
     *  1. We use two passes through the array to avoid using division:
     *     - First pass: Calculate prefix products (product of all elements to the left)
     *     - Second pass: Calculate suffix products (product of all elements to the right) 
     *        and multiply with prefix products
     *  
     *  2. For example, with [1,2,3,4]:
     *     - After prefix calculation: [1,1,2,6] 
     *       (result[0]=1, result[1]=1*1=1, result[2]=1*2=2, result[3]=2*3=6)
     *     - After suffix calculation: [24,12,8,6]
     *       (result[3]=6*1=6, result[2]=2*4=8, result[1]=1*12=12, result[0]=1*24=24)
     *
     *  Second Solution (productExceptSelf2ndSolution):
     *  1. Similar overall approach with two passes but with different implementation:
     *     - Explicitly set result[0]=1 since there are no elements to the left of the first element
     *     - For the prefix calculation, start from index 1 and use the previous result value
     *     
     *  2. For example, with [1,2,3,4]:
     *     - Initialize: result[0]=1
     *     - Prefix calculation:
     *       * result[1]=result[0]*nums[0]=1*1=1
     *       * result[2]=result[1]*nums[1]=1*2=2
     *       * result[3]=result[2]*nums[2]=2*3=6
     *     - After prefix calculation: [1,1,2,6]
     *     - Suffix calculation works the same as first solution: [24,12,8,6]
     *  
     *  Both solutions achieve the same result with the same time and space complexity.
     *  Time Complexity: O(n) - we traverse the array twice
     *  Space Complexity: O(1) - excluding the output array, we only use constant extra space
     * **/
    
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Calculate the prefix products
        int prefixProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        // Calculate the suffix products and multiply with prefix products
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }

    public static int[] productExceptSelf2ndSolution(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // Calculate the prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) { 
            result[i] = result[i - 1] * nums[i - 1]; 
        }
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }
}
