package _03_Array_And_Strings;

import java.util.Arrays;

public class _20_Minimum_Number_Of_Platforms_required_for_railwaybus {
    public static void main(String[] args) {
        /**
         * Problem:
         * Given arrival and departure times of trains, find the minimum number of platforms required so that no train waits.
         * 
         * Example:
         * - arr[] = {0900, 0940, 0950, 1100, 1500, 1800}  // Arrival times
         * - dep[] = {0910, 1200, 1120, 1130, 1900, 2000}  // Departure times
         * - Output: 3
         * 
         * Explanation: Minimum 3 platforms are required to safely arrive and
         *              depart all trains.
         *                             t2
         *                       t2    t3     t4                          t6 
         *     t1[a] t1[d] t2    t3    t4     t2     t2            t5     t5     t6
         * => [9:00, 9:10, 9:40, 9:50, 11:00, 11:20, 11:30, 12:00, 15:00, 18:00, 19:00, 20:00]
         *                             |
         *                             V
         * => Ek time pe maximum number of trains-3 thi. Max number of trains at
         *    any time is equal to the minimum number of platforms we required.
         * 
         * TC: O(n log n)
         * Note: Question format is very popular.
         * 
         * Approach:
         * => arr[] ko sort kr liye fir dep[] ko v sort kr liya.
         * => arr[0] & dep[0] m chota element kn sa hai? arr[0].
         *    To arr[0] badh k arr[1] ho jaega aur humaara count=1 ho
         *    jaega.
         * => Ab arr[1] & dep[0] m dep[0] chota hai to count=0 ho jaega
         *    aur dep[1] m chla jaega.
         * => Ab arr[1] & dep[1] m arr[1] chota hai to count=1 ho jaega
         *    aur arr[2] m chla jaega.
         * => arr[2] & dep[1] m arr[2] choti hai to count=2 ho jaega
         *    aur arr[3] m chla jaega.
         * => arr[3] & dep[1] m arr[3] chota hai count=3 ho jaega aur
         *    arr[4] m chla jaega. Humara max trains 3 arrive ho chuke h.
         * => arr[4] & dep[1] m dep[1] chota hai to count=2 ho jaega aur
         *    dep[2] m chla jaega.
         * => arr[4] & dep[2] m dep[2] chota hai to count=1 ho jaega aur
         *    dep[3] m chla jaega.
         * => arr[4] & dep[3] m dep[3] chota hai to count=0 ho jaega aur
         *    dep[4] m chla jaega
         * => arr[4] & dep[4] m arr[4] chota hai to count=1 ho jaega aur
         *    arr[5] m chla jaega
         * => arr[5] & dep[5] m arr[5] chota hai to count=2 ho jaega aur
         *    aur dep[4] m count=1 aur dep[5] m count=0 ho jaega.
         *
         * Approach:
         * - Sort both arrival and departure arrays.
         * - Use two pointers to traverse the sorted arrays.
         * - Increase count when an arrival is before or at the same time as a departure.
         * - Decrease count when a departure happens before the next arrival.
         * - Track the maximum number of platforms needed.
         * 
         * Complexity: O(n log n) due to sorting.
         * 
         * Dry Run:
         * Initial arrays:
         * arr = {900, 940, 950, 1100, 1500, 1800}
         * dep = {910, 1120, 1130, 1200, 1900, 2000}
         * 
         * Initial state:
         * count = 0, max = 0, i = 0, j = 0
         * 
         * Iteration 1:
         * arr[i] = 900 <= dep[j] = 910 : count = 1, max = 1, i = 1
         * 
         * Iteration 2:
         * arr[i] = 940 > dep[j] = 910 : count = 0, j = 1
         * 
         * Iteration 3:
         * arr[i] = 940 <= dep[j] = 1120 : count = 1, max = 1, i = 2
         * 
         * Iteration 4:
         * arr[i] = 950 <= dep[j] = 1120 : count = 2, max = 2, i = 3
         * 
         * Iteration 5:
         * arr[i] = 1100 <= dep[j] = 1120 : count = 3, max = 3, i = 4
         * 
         * Iteration 6:
         * arr[i] = 1500 > dep[j] = 1120 : count = 2, j = 2
         * 
         * Iteration 7:
         * arr[i] = 1500 > dep[j] = 1130 : count = 1, j = 3
         * 
         * Iteration 8:
         * arr[i] = 1500 > dep[j] = 1200 : count = 0, j = 4
         * 
         * Iteration 9:
         * arr[i] = 1500 <= dep[j] = 1900 : count = 1, max = 3, i = 5
         * 
         * Iteration 10:
         * arr[i] = 1800 <= dep[j] = 1900 : count = 2, max = 3, i = 6
         * 
         * Result: max = 3
         */

        int[] arr = {900, 940, 950, 1100, 1500, 1800}; // Arrival times
        int[] dep = {910, 1120, 1130, 1200, 1900, 2000}; // Departure times

        Arrays.sort(arr); // Sort arrival times
        Arrays.sort(dep); // Sort departure times

        int count = 0; // Current number of platforms needed
        int max = 0;   // Maximum platforms needed

        int i = 0; // Pointer for arrival times
        int j = 0; // Pointer for departure times

        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                count++; // New train arriving before previous one departs
                i++;
            } else {
                count--; // Train departed
                j++;
            }
            max = Integer.max(count, max); // Update max platforms needed
        }

        // Output the result
        System.out.println(max);
        // return max;
    }
}
