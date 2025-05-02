package _03_Array_And_Strings;

import java.util.Arrays;

public class _34_Maximum_Product_For_Three_Numbers {
    /**
     * 628. Maximum Product of Three Numbers
     * Input: nums = [1,2,3,4]
     * Output: 24
     * 
     * 
    */

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    public static int maximumProduct_Optimized(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int n : nums) {
            if(n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if(n > max2) {
                max3 = max2;
                max2 = n;
            } else if(n > max3) {
                max3 = n;
            } 

            if(n < min1) {
                min2 = min1;
                min1 = n;
            } else if(n < min2) {
                min2 = n;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(maximumProduct(nums));
        System.out.println(maximumProduct_Optimized(nums));
    }
}
