package _03_Array_And_Strings;

public class _03_Next_Greater_Element_iii {
    public static void main(String[] args) {

        /**
         * Smallest Greater Integer(Ceil):
         * 
         * Approach:
         * 1. Given a number 683486532,
         *    rearrange its digits to form the smallest possible number
         *    that is greater than the given number.
         * 2. The goal is to find the smallest number that is bigger 
         *    than 683486532 using its digits => 683523468.
         * Note: The returned integer should fit in 32-bit integer, if
         *       there is a valid answer but it does not fit in 32-bit
         *       integer, return -1.
         * 
         * Dry Run:
         * => Let's take the number 683486532 as an example.
         *
         * Step 1: Find the first dip
         * => Jbtk value badhti rahegi tbtk chlte rhnge, but jaha gir
         *    jaegi waha ruk jaenge:
         *           <--------+
         *    6 8 3 4 8 6 5 3 2
         * 
         * Step 2: Find the smallest digit greater than 4 on the right side
         * Step 3: Swap the digits
         * => Ab dobara shuru krnge aur value badhti jaegi, 4 se jaha value
         *    badi hogi waha ruk jaenge aur uss value ko 4 se swap kr denge:
         *          <-----> 
         *    6 8 3 5 8 6 4 3 2
         * 
         * Step 4: Reverse the digits from the first dip to the end
         * => Ab iski iss number ko short kr k chota bna denge(reverse):
         *           <---------->
         *    6 8 3 5 2 3 4 6 8
         * => And that's the next greater element!
         * 
         * Note: Ye number bade wale m sbse chota number hai
         * 
         */

        int n = 683486532;

        /**
         * 1. Convert the integer to a character array to easily manipulate its digits.
         */
        char[] arr = (n + "").toCharArray();
        
        /**
         * 2. Find the first digit that is smaller than the next digit (first dip).
         *    This is the digit that needs to be replaced to get the next greater element.
         *    We start from the end of the array and move backwards.
         */
        int i = arr.length - 1; 
        while(i > 0) {
            /**
             * 2.1 If the current digit is smaller than the next digit, we break the loop.
             *     If not, we keep moving backwards.
             */
            if(arr[i - 1] >= arr[i]) {
                i--;
            } else{
                break;
            }
        }
        
        /**
         * 3. If we reach the beginning of the array without finding a first dip,
         *    it means the number is already the largest possible.
         */
        if(i == 0) {
            // return -1;
            System.out.println(-1);
        }

        /**
         * 4. Store the index of the first dip.
         */
        int idx1 = i - 1;


        /**
         * 5. Find the smallest digit on the right side of the first dip that is greater than the digit 
         *    at the first dip. This is the digit that will replace the digit at the first dip.
         */
        int j = arr.length - 1;
        while(j > idx1) {
            /**
             * 5.1 If we find a digit that is greater than the digit at the first dip, we break the loop.
             */
            if(arr[j] > arr[idx1]) {
                break;
            }
            j--;
        }

        /**
         * 6. Swap the digits at the first dip and the found digit.
         */
        swap(arr, idx1, j);
        

        /**
         * 7. Reverse the digits from the first dip to the end to get the smallest possible number.
         */
        int left = i;
        int right = arr.length - 1;
        while(left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }

        /**
         * 8. Convert the character array back to an integer and check if it fits in 32-bit integer.
         */
        String res = new String(arr);
        long val = Long.parseLong(res);
        System.out.println(val > Integer.MAX_VALUE ? -1 : (int) val);

    }

    // Helper function to swap two characters in the array.
    public static void swap(char[] arr, int i, int j) {
        char chTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = chTemp;
    }
}


/**
 * Q. Why Start from the Second-to-Last Digit?
 * When we search for the "first dip" in the number (the point where the digits stop 
 * increasing and start decreasing), we start from the second-to-last digit to ensure
 * we always have a digit to compare it with on its right. This prevents errors that
 * occur when we try to compare a digit with a non-existent digit.
 * 
 * Dry Run Example:
 * => Let's use the number 683486532 and go through the steps:
 * 1. Initial Setup:
 *    => We convert the number to an array of characters: 
 *       ['6', '8', '3', '4', '8', '6', '5', '3', '2'].
 *    => We start from the second-to-last digit: 
 *       arr.length - 2 which is 7 (index of the digit 3).
 * 
 * 2. Finding the First Dip:
 *    => Compare 3 (at index 7) with 2 (at index 8). Since 3 > 2, move left.
 *    => Compare 5 (at index 6) with 3 (at index 7). Since 5 > 3, move left.
 *    => Compare 6 (at index 5) with 5 (at index 6). Since 6 > 5, move left.
 *    => Compare 8 (at index 4) with 6 (at index 5). Since 8 > 6, move left.
 *    => Compare 4 (at index 3) with 8 (at index 4). Since 4 < 8, we found 
 *       the first dip at index 3.
 * 
 * Note: Comparing left with right:
 *       (a) left: arr.length-1
 *       (b) right: arr.length-2
 * */ 