package javaProblemsSolution.october;

import java.util.Stack;

public class MaxWidthRamp {

        public int maxWidthRamp(int[] nums) {
            Stack<Integer> stack = new Stack<>();

            // Build a stack of indices in a decreasing order of nums[i]
            for (int i = 0; i < nums.length; i++) {
                if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                    stack.push(i);
                }
            }

            int maxWidth = 0;

            // Traverse nums from the end and try to find the maximum width ramp
            for (int j = nums.length - 1; j >= 0; j--) {
                // While the stack has elements and we find a valid ramp
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                    maxWidth = Math.max(maxWidth, j - stack.pop());
                }
            }

            return maxWidth;
        }

}
