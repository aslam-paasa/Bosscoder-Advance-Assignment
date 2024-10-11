package _03_Array_And_Strings;

public class _25_Max_Sum_Of_Two_Non_Overlapping_Subarrays {
    /**
     * Q. Given an integer array nums and two integers firstLen and
     *    secondLen, return the maximum sum of elements in two
     *    non-overlapping subarrays with lengths firstLen and secondLen.
     * 
     *    The array with length firstLen could occur before or after the
     *    array with length secondLen, but they have to be non-overlapping.
     * 
     * Input: nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
     * Output: 29                                    |              |
     *                                               V              V
     *                                           [3, 8, 1]        [8, 9]
     * => Dono ka sum max hona chaiye aur dono subarray overlap ni krna
     *    chaiye.
    */

    /**
     * Approach-1: Sliding Window
     * (a) left  = 4
     * (b) right = 3
     * 
     * 1. left window:
     * arr   : a  b  c  d  e  f  g  h i  j
     * Prefix: --------->
     * => sum = abcd
     * 
     * Prefix:    --------->                remove-a, add-e
     * => Math.max(abcd, bcde)
     * 
     * Prefix:       --------->             remove-b, add-g
     * => Math.max((abcd, bcde), cdef)
     * 
     * Prefix:          --------->          remove-c, add-f
     * => Math.max(((abcd, bcde), cdef), defg)
     * 
     * Prefix:             --------->       remove-d, add-i
     * => Math.max((((abcd, bcde), cdef), defg,) efgh)
     * 
     * Prefix:                --------->    remove-e, add-j
     * => Math.max(((((abcd, bcde), cdef), defg,) efgh), fghi)
     * 
     * Prefix:                   ---------> remove-e, add-j
     * => Math.max((((((abcd, bcde), cdef), defg,) efgh), fghi), ghij)
     * 
     * Note: Har window ka max lete jaenge aur uska max store kr denge.
     * 
     * 2. Right Window:
     * arr   : a  b  c  d  e  f  g  h i  j
     *                              <-----    Math.max()
     *                           <-----       Math.max()
     *                         <-----         Math.max()
     *                      <-----            Math.max()
     *                   <-----               Math.max() 
     *               <-----                   Math.max()
     *            <-----                      Math.max()
     *         <-----                         Math.max()
     * 
     * Note: First code:
     *       => int max1 = getMax(nums, left, right)
     * 
     *       Second Code:
     *       => int max2 = getMax(nums, right, left)  
    */

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        // Placing `firstLen` subarray before the `secondLen` subarray
        int max1 = getMax(nums, firstLen, secondLen);
        
        // Pacing the `secondLen` subarray before the `firstLen` subarray
        int max2 = getMax(nums, secondLen, firstLen);

        //Return the maximum of both possible configurations
        return Math.max(max1, max2);
    }


    public int getMax(int[] nums, int firstLen, int secondLen) {
        /**
         * Step 1: Calculate the maximum sum of subarrays of length 
         * `firstLen` from the left side
        */
        int[] left = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(i == firstLen - 1) {
                left[i] = sum;
            } else if(i >= firstLen) {
                sum -= nums[i - firstLen];
                left[i] = Math.max(sum, left[i-1]);
            }
        }

        /**
         * Step 2: Calculate the maximum sum of subarrays of length 
         * `secondLen` from the right side
        */
        int[] right = new int[nums.length];
        sum = 0;
        for(int i = nums.length-1; i >= 0; i--) {
            sum += nums[i];
            if(i == nums.length - secondLen) {
                right[i] = sum;
            } else if(i < nums.length - secondLen) {
                sum -= nums[i + secondLen];
                right[i] = Math.max(sum, right[i + 1]);
            }
        }

        /**
         * Step 3: Find the maximum sum of two non-overlapping subarrays
         * => Traverse the array, ensuring that one subarray ends before
         *    the other starts.
        */
        int max = Integer.MIN_VALUE;
        for(int i = firstLen - 1; i < nums.length - secondLen; i++) {
            // Max sum of a valid combination
            max = Math.max(max, left[i] + right[i+1]);
        }
        return max;
    }


}
