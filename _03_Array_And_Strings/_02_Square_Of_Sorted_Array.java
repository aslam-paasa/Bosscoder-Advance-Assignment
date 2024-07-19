package _03_Array_And_Strings;

import java.util.Arrays;

public class _02_Square_Of_Sorted_Array {
    public static void main(String[] args) {
        /**
         * => Return an array of the squares of each number sorted in
         *    non-decreasing order.
         * => Input: nums = [-4, -1, 0, 3, 10]
         * => Output: [0, 1, 9, 16, 100]
         * => Explanation: After squaring, the array becomes 
         *    [16, 1, 0, 9, 100]. After sorting, it becomes [0, 1, 9, 16, 100].
         * 
         * [-4, -1, 0, 3, 10]
         * => The largest square will be either from -4 or 10.
         * => Compare the squares of -4 and 10.
         * => Between -4 and 10, 10's square is larger i.e. 100, so place 100 at the last:
         *    [_, _, _, _, 100]
         * => Now compare -4 and 3. -4's square is larger i.e. 16, so place it before 100:
         *    [_, _, _, 16, 100]
         * => Now compare -1 and 3. 3's square is larger i.e. 9, so place it before 16:
         *    [_, _, 9, 16, 100]
         * => Now compare -1 and 0. -1's square is larger i.e. 1, so place it before 9:
         *    [_, 1, 9, 16, 100]
         * => The last element is 0, so its square is 0, place it before 1:
         *    [0, 1, 9, 16, 100]
         */
        int[] nums = {-4, -1, 0, 3, 10};

        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int k = result.length - 1;

        while(k >= 0) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[k] = nums[left] * nums[left];
                left++;
            } else {
                result[k] = nums[right] * nums[right];
                right--;
            }
            /**
             * Decrement k to move to the next position in the result array
             * */ 
            k--;
        }

        /**
         * Convert Array into String and print:
        */
        System.out.println(Arrays.toString(result));
    }
}
