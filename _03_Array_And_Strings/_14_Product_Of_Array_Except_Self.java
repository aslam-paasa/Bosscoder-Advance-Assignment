package _03_Array_And_Strings;

import java.util.Arrays;

public class _14_Product_Of_Array_Except_Self {
    public static void main(String[] args) {
        /**
         * Product of Array Except Self:
         * => Return an array 'answer' such that 'answer[i]' is equal
         *    to the product of all the elements of 'nums' except nums[i].
         * => TC: O(n) without using division operator.
         * 
         * Input: nums = [1,2,3,4]
         * Output: [24,12,8,6]
         * => 1. nums[0] = 2*3*4 = 24
         * => 2. nums[1] = 1*3*4 = 12
         * => 3. nums[2] = 1*2*4 = 8
         * => 4. nums[3] = 1*2*3 = 6
         * 
         * Original Array:
         * => arr = [a, b, c, d, e, f]
         * 
         * Approach-1:
         * => Ek bna lo left[] array, or ek right[] array.
         * => Left means nums[i] pehle walo ka product.
         * => Right means nums[i] k baad walo ka product.
         * => Fir hum apna ek output bna skte hai.
         * 
         * => arr   = [a,     b,     c,     d,      e,        f        ]
         * => left  = [1,     a,     ab,    abc,    abcd,     abcde    ]
         * => right = [bcdef, cdef,  def,   ef,     f,        1        ]
         * => O/p   = [bcdef, acdef, abdef, abcef,  abcdf,    abcde    ]
         * 
         * Approach-2:
         * => idx   =  0      1      2      3       4         5
         * => arr   = [a,     b,     c,     d,      e,        f        ]
         * => left  = [1,     a,     ab,    abc,    abcd,     abcde    ]
         * => right =
         * 
         * Note: 
         * => nums[5] ka product bss sahi hai.
         * => Ek new variable bnao, usme initial m value '1' rkho.
         * => Jb m 'e' element par aaunga right var ka product hoga '1 * f'.
         *    To left m 'abcd' jo pda tha usko right var se multiply kr k
         *    change kr do : 'abcdf'
         * => Wapas aate hue ab 'element-d' pe aaya to right var update kr k
         *    'e*f' kr do aur isko left m pade element se multiply kr do - 'abcef'.
         * => Similarly, 'abdef', 'acdef' & 'bcdef'.
         * */ 

        int[] nums = {1, 2, 3, 4};
        int[] left = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0) {
                left[i] = 1;
            } else {
                left[i] = left[i-1] * nums[i - 1];
            }
        }

        int right = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            right = right * nums[i+1];
            left[i] = left[i] * right;
        }
        // return left;
        System.out.println(Arrays.toString(left));
    }
}
