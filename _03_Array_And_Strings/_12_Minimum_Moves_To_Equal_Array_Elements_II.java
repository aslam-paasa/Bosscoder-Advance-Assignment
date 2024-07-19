package _03_Array_And_Strings;

import java.util.Arrays;

public class _12_Minimum_Moves_To_Equal_Array_Elements_II {
    public static void main(String[] args) {
        /**
         * Q. Minimum Moves to Equal Array Elements:
         * => Return the minimum number of moves required to make
         *    all array elements equal.
         * => Answer should fit in a 32-bit integer.
         * 
         * Input: nums = [1, 2, 3]
         * Output: 2
         * Explanation: Only two moves are needed (remember each move
         *              increments or decrements one element):
         *              [1, 2, 3] => [2, 2, 3] => [2, 2, 2]
         * 
         * Note: Hum koi ek number lenge, for example: n = 2.
         * => Ab humein array ki saari elements ko 2 k equal krna hai.
         * => Iss case m humein 1 ko ek baad bdhana pdega, 3 ko ek baar
         *    ghatana pdega.
         * => Humein btana hai ki total kitne operations krne pdnge?
         * Note: Array Sorted nhi milega, humein khud se sort krna pdega.
         * 
         * TC: O(n log n)
         * 
         * 
         * Step-1: Sort the array:
         * => [8, 2, 9, 3, 7, 5, 6]
         * => [2, 3, 5, 6, 7, 8, 9]
         * 
         * Step-2: Median(bich wala element) k equal krna hai: (Partitioning)
         * Q. 2 ko 6 k paas le jaane k liye kitne operations krne pdnge?
         * => 6-2 operations
         * 
         * Q. 9 ko 6 k paas le jaane k liye kitne operations krne pdnge?
         * => 9-6 operations
         * 1. 6-2 => 4
         * 2. 6-3 => 3
         * 3. 6-5 => 1
         * 4. 7-6 => 1
         * 5. 8-6 => 2
         * 6. 9-6 => 3 => Total = 14
         * 
         * => Ye sb aapas m kt jaate hai aur last m bachega:
         *    (a) 9-2 = 7
         *    (b) 8-3 = 5
         *    (c) 7-5 = 2
         *    =============
         *      Total = 14 Operations
         * 
         * Q. Median k equal q krna tha?
         * => Kisi v 'y' number ko 'x' number k equal krne k liye humein
         *    'x - y' krna pdega.
         * => Median isliye nikaalte hai ki bade number k saamne rkhnge
         *    to operations km honge, but jyda saamne rkhnge to chote
         *    numbers k operations badh jaenge. Isliye hum 'x' ko median
         *    maan lete hai jisse baaki sbke operations minimum ho jaate hai.
        */

        int[] nums = {1, 2, 3};

        Arrays.sort(nums);

        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        int minMoves = 0;

        while(leftIdx < rightIdx) {
            minMoves += nums[rightIdx] - nums[leftIdx];
            leftIdx++;
            rightIdx--;
        }

        System.out.println(minMoves);       
    }
}
