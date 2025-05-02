package _03_Array_And_Strings;

import java.util.Arrays;
import java.util.Stack;

public class _33_Sliding_Window_Maximum {
    /**
     * 239. Sliding Window Maximum => Refer Scalar Module
     * Input : nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation: 
     * - Window position                Max
     *   ---------------               -----
     *   [1  3  -1] -3  5  3  6  7       3
     *   1  [3  -1 -3]  5  3  6  7       3
     *   1  3  [-1 -3  5] 3  6  7        5
     *   1  3  -1 [-3  5  3] 6  7        5
     *   1  3  -1 -3 [5  3  6] 7         6
     *   1  3  -1 -3  5 [3  6  7]        7
    */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        /**
         * 1. Create a result array to store the maximum values.
        */
        int[] result = new int[nums.length - k + 1];

        /**
         * 2. Iterate through the array and find the maximum value in the 
         *    current window.
        */
        int idx = 0;
        for(int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[idx++] = max;
        }

        /**
         * 3. Return the result array.
        */
        return result;
    }

    /**
     * Approach-2: Stack
    */
    public static int[] maxSlidingWindow_Stack(int[] nums, int k) {

        int[] nextGreaterElement = new int[nums.length];

        /**
         * 2. Create a stack to store the indices of the elements.
        */
        Stack<Integer> stack = new Stack<>();
        stack.push(nums.length - 1);
        nextGreaterElement[nums.length - 1] = nums.length;

        for(int i = nums.length - 2; i >= 0; i--) {
            int val = nums[i];
            while(stack.size() > 0 && val >= nums[stack.peek()]) {
                stack.pop();
            }
            
            if(stack.size() == 0) {
                nextGreaterElement[i] = nums.length;
            } else {
                nextGreaterElement[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] result = new int[nums.length - k + 1];
        int j = 0;
        for(int i = 0; i < result.length; i++) {
            
            if(j < i) {
                j = i;
            }

            while(nextGreaterElement[j] <= i + k - 1) {
                j = nextGreaterElement[j];
            }
            result[i] = nums[j];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));

        result = maxSlidingWindow_Stack(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
