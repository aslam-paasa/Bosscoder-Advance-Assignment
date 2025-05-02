package _03_Array_And_Strings;

import java.util.Arrays;

public class _30_Sum_Of_Subsequence_Widths {
    /**
     * Problem: 891. Sum of Subsequence Widths
     * The width of a sequence is the difference between the max and min
     * element in the sequence.
     * 
     * Q. Given an array nums, return the sum of the widths of all the non-empty
     *    subsequences of nums. Since the answer may be too large, return it
     *    modulo 10^9 + 7.
     * => A Subsequence is a sequence that can be derived from another sequence
     *    by deleting some or no elements without changing the order of the
     *    remaining elements.
     * => For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
     * 
     * Input: nums = [2,1,3]
     * Output: 6
     * Explanation:
     * Formula of subsequence : 2^n => 2^3 = 8 subseq possible
     * The subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
     * a. Negative width = max - min
     * b. Positive width = min - max
     *    _  _  _  =>   0
     *    _  _  3  => - 3 + 3 => 0
     *    _  1  _  => - 1 + 1 => 0
     *    _  1  3  => - 1 + 3 => 2
     *    2  _  _  => - 2 + 2 => 0
     *    2  _  3  => - 2 + 3 => 1
     *    2  1  _  => - 1 + 2 => 1
     *    2  1  3  => - 1 + 3 => 2
     * 
     * The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
     * The sum of these widths : 0 + 0 + 0 + 2 + 1 + 1 + 2 = 6 
     * 

     * Input: nums = [2]
     * Output: 0
     * 
     * 
     */

    public static int sumOfSubsequenceWidths(int[] nums) {
        long MOD = 1000000007;
        Arrays.sort(nums);

        long sum = 0;
        long power = 1;
        for(int i = 0; i < nums.length; i++) {
            sum = (sum + (nums[i] * power - nums[nums.length - i - 1] * power)) % MOD;
            power = (power * 2) % MOD;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        System.out.println(sumOfSubsequenceWidths(nums));
    }
}
