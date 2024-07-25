package _03_Array_And_Strings;

public class _18_Find_Missing_Positive {
    public static void main(String[] args) {
        /**
         * Smallest missing positive number:
         * Unsorted integer array nums, return the smallest missing positive integer.
         * TC: O(n)
         * SC: O(1)
         * 
         * Input: nums = [1, 2, 0]
         * Output: 3 is missing
         * 
         * Input: nums = [3, 4, -1, 1]
         * Output: 2
         * 
         * Input: nums = [7, 8, 9, 11, 12]
         * Output: 1 => 10 missing hai, '1' hi nhi hai to sbse chota
         *         missing positive number iss array m missing h wo
         *         btana hai.
         * 
         * Note: Agar extra space le skte to qstn bahut easy hota:
         * arr = [                                                    ]
         *        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
         * => Size-16 ka array hai, to agar isme 01-16 tk saare number hote
         *    to hum 17 ko return krte.
         * => Let's say isme 7 missing hai, to hm new boolean array bna lete
         *    same size ka, aur sb jagha by default false pda hai.
         * => Jb mera koi number 1to16 k bich m aata to uss element k
         *    corresponding index m jaa k true daal deta. Aur jo element
         *    1to16 range m bahar h uske liye kuch nhi krna.
         * => So, agar element-1 hai to idx-0 ko true kr denge aur element-16
         *    hai to idx-15 ko true kr denge. Agar -6 aaya to element skip kr
         *    do.
         * => Jaha false reh gya means wo number nhi aaya, aur jaha sbse pehle
         *    false index reh gya to usse return kr denge[idx+1].
         * 
         * Approach: Inplace array m krna hai (SC: O(1))
         * => Jo v negative hai means 1to16 k range k bahar hai means:
         *    (a) Negative
         *    (b) 0
         *    (b) Number greater than 16( > length)
         * => [4, -5, 12, 2, -6, 6, 43, 11, 0, 10, 1, 9, 3, 47, 5, 8]
         *     0   1   2  3   4  5   6   7  8   9  10 11 12 13  14 15
         * => Agar idx-1 pe -5(negative) hai to usko replace kr denge
         *    element 17 se.
         * => Fir -6 ko 17 se replace kr do
         *        43 ko 17 se replace kr do
         *         0 ko 17 se replace kr do
         *        47 ko 17 se replace kr do
         * => Means jo v elements 1to16 k range m nhi hai uske jagha
         *    humne length+1 daal diya hai.
         * => [4, 17, 12, 2, 17, 6, 17, 11, 17, 10, 1, 9, 3, 17, 5, 8]
         *     0   1   2  3   4  5   6   7  8   9  10 11 12  13  14 15
         * => Ab iske andr saare positive numbers hai, iske andr dobara
         *    loop lagaunga aur unhein negative bnata jaunga:
         *    (a) element-4 => idx-3 becomes nagative => -2
         *    (b) element-17 => out of range => skip
         *    (c) element-12 => idx-11 negative => -9
         *    (d) element-2 => idx-1 negative => -17
         *    ....
         *    ....
         *    ....
         * 
         * => [-4, -17, -12, -2, -17, -6, 17, -11, -17, -10, -1,  -9,  3,  17, 5, 8]
         *      0    1    2   3    4   5   6    7   8     9   10   11  12  13  14 15
         *                                 |
         *                                 V
         * => Jo pehle positive bachega wo humaara answer hoga.
         * */ 

        int[] nums = {7, 8, 9, 10, 11, 13};
        int n = nums.length;

        /**
         * Jo element 1 to 16 m nhi aate:
         * (a) negative
         * (b) zero
         * (c) greater than 16
         * unn sbpe n+1 daal denge i.e. 17.
         * */ 
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        /**
         * Ab value ki absolute value dekhnge, agar wo 'n' se km hai to mai
         * value-1 pe jaaunga aur number ko negative kr dunga. Aur agar
         * wo pehle se negative hai to kuch nhi krna, wrna negative kr denge.
        */
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);

            if(val <= n) {
                int idx = val - 1;

                if(nums[idx] > 0) {
                    nums[idx] = -1 * nums[idx];
                }
            }
        }

        /**
         * Jo pehla index milega jiske value positive hai to wo index+1
         * return kr denge.
        */
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                System.out.println(i + 1);
                break;
                // return i + 1;
            } else {
                /**
                 * But agar 1-16 tk saare element present hai to n+1 i.e. 17
                 * return kr denge.
                */
                // return n + 1;
                System.out.println(n+1);
                break;
            }
        }
    }
}
