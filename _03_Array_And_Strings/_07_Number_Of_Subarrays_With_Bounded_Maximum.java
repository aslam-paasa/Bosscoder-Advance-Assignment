package _03_Array_And_Strings;

public class _07_Number_Of_Subarrays_With_Bounded_Maximum {
    public static void main(String[] args) {
        /**
         * Q. [7, 3, 5, 2, 3, 1, 4, 2, 8, 9] and max should be between [2 to 5]?
         * => arr   = [7, 3, 5, 2, 3, 1, 4, 2, 8, 9]
         * => max   =  7  3  5  5  5  5
         * => len   =  0  1  2  3  4  5
         * => result = 0  1  3  6  10 15
         * 
         * Total Subarray:
         * => Count:1 => [3], 
         * => Count:2 => [3,5], [5]
         * => Count:3 => [3,5,2], [5,2], [2]
         * => Count:4 => [3,5,2,3] [5,2,3] [2,3] [3]
         * => Count:5 => [3,5,2,3,1] [5,3,2,3,1] [3,2,3,1] [2,3,1] [3,1] [1]
         * 
         * => Shuru m hi 2 index rkhnge: start & end. Means sequence yhi se
         *    shuru ho rha hai aur yhi pe khtm ho rha hai
         * */ 

        /**
         * Initialize the input array, left, and right values.
         */
        int[] nums = {2, 1, 4, 3};
        int left = 2;
        int right = 3;

        /**
         * Initialize the result variable to store the count of subarrays.
         */
        int res = 0;

        /**
         * Initialize two pointers, s and e, to -1.
         */
        int s = -1;
        int e = -1;

        /**
         * Iterate through the array using a for loop.
         */
        for(int i = 0; i < nums.length; i++) {
            /**
             * Check if the current element is within the range [left, right].
             */
            if(nums[i] >= left && nums[i] <= right) {
                /**
                 * Update the end pointer e to the current index:
                 * => Agar current element valid maximum hai (i.e., [left, right] ke range mein hai), 
                 *    toh yeh element current valid subarray ke end ko mark karta hai.
                 * => Kaise Help Karega: e ko i pe set karke, aap end of the valid subarray mark kar 
                 *    rahe hain, taaki aap count kar sakein ki kitne valid subarrays yahan tak khatam
                 *    hote hain.
                 * => It means when i = 0,
                 *                  nums[0] = 2
                 *                  start = idx-0, end=idx-0
                 */
                e = i;
            } else if(nums[i] > right) {
                /**
                 * Update both pointers s and e to the current index.
                 */
                e = s = i;
            } else {
                /**
                 * Do nothing if the current element is less than left.
                 */
            }
            /**
             * Count the number of subarrays by adding the length of the current
             * subarray (e - s + 1) to the result.
             */
            res += (e - s + 1);
        }
        /**
         * Print the final result.
         */
        System.out.println(res);
        
    }
}



/**
 * 
 * Number of Subarrays with Bounded Maximum:
 * 1. Subarray:
 * => A subarray is a continuous part of an array. 
 * => For example, if you have the array [2, 1, 4, 3], some of 
 *    the subarrays are [2], [1, 4], and [4, 3].
 * 
 * 2. Bounded Maximum:
 * => The "maximum" is the largest number in the subarray. 
 * => "Bounded" means that this maximum number must be within a 
 *    specific range of numbers.
 * => You have two numbers, left and right. 
 *    You need to check if the biggest number in the subarray is at
 *    least left but no more than right.
 * 
 * 3. Putting It All Together:
 * => "Number of Subarrays with Bounded Maximum" means:
 *    (1) Find All Subarrays: 
 *     => Look at every possible continuous segment of the array. 
 *     => For example, in [2, 1, 4, 3], you need to consider all segments like 
 *        [2], [2, 1], [2, 1, 4], [1, 4], and so on.
 *    (2) Check the Maximum: 
 *     => For each of these subarrays, find the largest number in that segment.
 *    (3) Check the Bounds: 
 *     => Make sure this maximum number is between left and right inclusive.
 *     => For instance, if left = 2 and right = 3, you only care about subarrays
 *        where the largest number is between 2 and 3, including both 2 and 3.
 *    (4) Count the Valid Subarrays: 
 *     => Count how many subarrays meet this requirement.
 *
 * Dry Run:
 * Initial State:
 *    => nums = [2, 1, 4, 3]
 *    => left = 2, right = 3
 *    => res(count) = 0
 *    => s = -1, e = -1
 * 
 * Iteration-1: i = 0
 * => nums[0] = 2 which is in the range [2,3].
 * => Update e to 0(current Index): 
 *    e = 0;
 *    s = -1;
 * => Count subarrays:
 *    res += (e - s + 1) = (0 - (-1) + 1) = 2
 * => res = 2
 * 
 * Iteration-2: i = 1
 * => nums[1] = 1 which is less than left.
 * => Do nothing to 's' and 'e'
 * => Count subarrays: res += (e - s + 1) = (0 - (-1) + 1) = 2
 * => res = 4
 * 
 * Iteration-3: i = 2
 * => nums[2] = 4 which is greater than right.
 * => Update 's' and 'e' to 2.
 *    e = 2, s = 2
 * => Count subarrays: res += (e - s + 1) = (2 - 2 + 1) = 1.
 * => res = 5
 * 
 * Iteration-4: i = 3
 * => nums[3] = 3 which is in the range [2, 3].
 * => Update 'e' to 3.
 *    e = 3, s = 2
 * => Count subarrays: res += (e - s + 1) = (3 - 2 + 1) = 2.
 * => res = 7.
 * 
 * Explanation of the res Calculation:
 * => Whenever a valid maximum element within [left, right] is found, the
 *    number of valid subarrays ending at this index is calculated as the
 *    distance between e and s, plus one.
 * => Whenever a maximum element greater than right is encountered, s and
 *    e are reset to the current index, breaking the previous valid subarray
 *    segments and starting new ones.
 *  
 * Final Output:
 * => The final result is 7, which is printed at the end of the program.
 * 
 * Summary of Subarrays:
 * => Subarrays considered: [2], [2, 1], [3], [3, 2, 1, 4, 2, 8, 9]
 * => Subarrays satisfying the condition are:
 *    [2], [2, 1], [3], [3, 2], [2], [1, 4, 2, 8, 9]...
 * 
 * This approach ensures that we correctly count the number of subarrays
 * meeting the maximum element condition in an efficient manner
*/