package _03_Array_And_Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class _27_MergeIntervals {
    /**
     * Merge Intervals:
     * 
     * Problem: 56. Merge Intervals
     * Given an array of intervals where intervals[i] = [starti, endi], merge
     * all overlapping intervals, and return an array of the non-overlapping
     * intervals that cover all the intervals in the input.
     * 
     * Example:
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * 
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    */


    /**
     * Step-by-Step in-depth explanation:
     * 1. Sort the intervals based on the start time.
     *    - This is done to ensure that we can easily check if two intervals overlap.
     * 2. Create a list to store the merged intervals.
     *    - This is done to store the merged intervals.
     *    - We will use a list to store the merged intervals.
     *    - Example of merged intervals:
     *      - [[1,3],[2,6],[8,10],[15,18]]
     *      - [[1,6],[8,10],[15,18]]
     * 3. Traverse through the intervals and merge them if they overlap.
     *    - This is done to merge the intervals if they overlap.
     *    - If the current interval overlaps with the previous one, we merge them.
     *    - Otherwise, we add the current interval to the list.
     * 4. Return the merged intervals.
     *    - This is done to return the merged intervals.
    */

    /**
     * Approach-1: Brute Force
     * 1. Sort the intervals based on the start time.
     * 2. Traverse through the intervals and merge them if they overlap.
     * 3. Return the merged intervals.
     * 
     * TC: O(nlogn)
     * SC: O(n)
    */
    public static int[][] merge(int[][] intervals) {
        /**
         * 1. Sort the intervals based on the start time.
        */
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        /**
         * 2. Create a list to store the merged intervals.
        */
        List<int[]> merged = new ArrayList<>();

        int[] currentInterval = intervals[0];
        
        /**
         * 3. Traverse through the intervals and merge them if they overlap.
        */
        for(int i = 1; i < intervals.length; i++) {
            /**
             * 3.1. If the current interval's start time is less than or equal to the 
             *      previous interval's end time, then merge the intervals.
            */
            if(intervals[i][0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } 
            
            /**
             * 3.2. If the current interval's start time is greater than the 
             *      previous interval's end time, then add the current interval 
             *      to the list and update the current interval.
            */
            else {
                merged.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        /**
         * 4. Add the last interval to the list.
        */
        merged.add(currentInterval);

        /**
         * 5. Return the merged intervals.
        */
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * Approach-2: Using Stack
     * 1. Sort the intervals based on the start time.
     * 2. Create a stack to store the merged intervals. (Traverse)
     *    | [2, 6] | => Can be merge, bcoz 2 ka starting point 1 se bada hai.
     *    | [1, 3] |
     *    +--------+
     * 
     *           2         6
     *           +---------+
     *       +--------+
     *       1        3
     * 
     *    => After merge: [1, 6]
     * 
     * Note: Agar new point i.e. stack k top wale start point agar apne niche
     *       wale point k end point se bada nhi hai toh dono ko merge kro.
     * 
     *    | [8, 10] | => Can't be merge, bcoz 8 ka starting point 6 se chota hai.
     *    | [1, 6]  |
     *    +---------+
     * 
     *           8         10
     *           +---------+
     *       +--------+
     *       1        6
     * 
     *    | [15, 18] | => Can't be merge, bcoz 15 ka starting point 10 se bada hai.
     *    | [8, 10]  |
     *    +----------+
     * 
     *           15        18
     *           +---------+
     * 
     * 4. Return the merged intervals.
     * 
     * TC: O(nlogn)
     * SC: O(n)
    */
    public static int[][] mergeII(int[][] intervals) {
        /**
         * 1. Sort the intervals based on the start time.
        */
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        /**
         * 2. Create a stack to store the merged intervals.
        */
        Stack<int[]> stack = new Stack<>();

        /**
         * 3. Traverse through the intervals and merge them if they overlap.
        */
        for(int[] interval : intervals) {
            /**
             * 3.1. If the stack is empty or the top of the stack's end time 
             *      is less than the current interval's start time, then 
             *      push the current interval onto the stack.
            */
            if(stack.isEmpty() || stack.peek()[1] < interval[0]) {
                stack.push(interval);
            } else {
                /**
                 * 3.2. If the top of the stack's end time is greater than or 
                 *      equal to the current interval's start time, then 
                 *      merge the intervals.
                */
                stack.peek()[1] = Math.max(stack.peek()[1], interval[1]);
            }
        }
        
        /**
         * 4. Create a result array to store the merged intervals.
        */
        int[][] result = new int[stack.size()][2];
        
        /**
         * 5. Return the merged intervals.
        */
        for(int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
    
    /**
     * Approach-3: Using Priority Queue
     * 1. Sort the intervals based on the start time.
     * 2. Traverse through the intervals and merge them if they overlap.
     * 3. Return the merged intervals.
     * 
    */
    public static int[][] mergeIII(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int[] interval : intervals) {
            if(pq.isEmpty() || pq.peek()[1] < interval[0]) {
                pq.offer(interval);
            } else {
                pq.peek()[1] = Math.max(pq.peek()[1], interval[1]);
            } 
        }

        int[][] result = new int[pq.size()][2];
        for(int i = pq.size() - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
        System.out.println(Arrays.deepToString(mergeII(intervals)));
        System.out.println(Arrays.deepToString(mergeIII(intervals)));
    }
}
