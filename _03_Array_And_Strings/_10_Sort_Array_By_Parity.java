package _03_Array_And_Strings;

import java.util.Arrays;

public class _10_Sort_Array_By_Parity {
    public static void main(String[] args) {
        /**
         * => Move all the even integers at the beginning of the array
         *    followed by all the odd integers.
         * 
         * => Input: nums = [3, 1, 2, 4]
         * => Output: [2, 4, 3, 1]
         * => Explanation: The outputs [4, 3, 2, 1], and [2, 4, 1, 3]
         *                 and [4, 2, 1, 3] would also be accepted.
         * 
         * => Input: nums = [0]
         * => Output: [0]
         * 
         * => No extra space, do in single traversal: 
         * 1. Two Pointer + Swapping Approach
         * 
         * 
         * 
        */

        int[] nums = {3, 1, 2, 4};

        int i = 0;
        int j = 0;

        while(i < nums.length) {
            if(nums[i] % 2 == 1) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
