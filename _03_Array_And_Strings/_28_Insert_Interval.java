package _03_Array_And_Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _28_Insert_Interval {
    /**
     * Insert Interval:
     * 
     * Problem: 57. Insert Interval
     * Insert newInterval into intervals such that intervals is still sorted
     * in ascending order by start and intervals still does not have any
     * overlapping intervals(merge overlapping intervals if necessary). 
     * 
     * Input : intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     * Explanation: Since intervals [1,3] and [2,5] are overlapping, we merge 
     *              them into [1,5].
     * 
     * Input : intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * Output: [[1,2],[3,10],[12,16]]
     * Explanation: Since intervals [3,5] and [6,7] are overlapping, we merge 
     *              them into [3,7].
     * 
    */



    /**
     * Steps:
     * 1. Create a new list to store the merged intervals.
     * 2. Add all intervals that appear before 'newInterval' (No Overlap)
     *    - If the 'end' of the current interval is smaller than the 'start'
     *      of 'newInterval', add it directly to the list.
     *    - Ex: [1, 2] & [4, 8] => Since, '2 < 4', add [1, 2] to the list.
     * 
     * 3. Merge Overlapping intervals with 'newInterval':
     *    - If the 'start' of current interval is 'less than or equal to'
     *      the 'end' of 'newInterval', update the 'newInterval' by adjusting
     *      its 'start' and 'end' values. 
     *    - Example:
     *      - [3, 5]  & [4, 8] => Since, 5 >= 4, merge to [3, 8].
     *      - [6, 7]  & [3, 8] => Since, 7 >= 3, merge to [3, 8].
     *      - [8, 10] & [3, 8] => Since, 10 >= 3, merge to [3, 10].
     *      - After merging, add the updated 'newInterval' to the list.
     * 4. Add the remaining intervals that appear after 'newInterval'(No overlap):
     *    - If the 'start' of the current interval is 'greater' than the 'end'
     *      of 'newInterval', add both 'newInterval' and the remaining intervals
     *      to the list.
     *    - Ex: [12, 16] & [3, 10] => Since, 12 > 10 and [3, 10] is already
     *      in the list, add [12, 16] to the list.
     * 5. Convert the list to array and return the final merged intervals.
    */
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        /**
         * 1. Create a list to store the final merged intervals
        */
        ArrayList<int[]> result = new ArrayList<>();

        /**
         * 2. Add all intervals that come before newInterval (No Overlap)
        */
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        /**
         * 3. Merge overlapping intervals
         *    - Start with new Interval
         *    - Check if it overlaps with the next interval
         *    - If it does, merge them
         *    - If it doesn't, add it to the result list
        */
        int[] interval = newInterval;
        while(i < intervals.length && intervals[i][0] <= interval[1]) {
            interval[0] = Math.min(interval[0], intervals[i][0]);
            interval[1] = Math.max(interval[1], intervals[i][1]);
            i++;
        }

        /**
         * 4. Add the merged interval to the result list
        */
        result.add(interval);

        /**
         * 5. Add all the intervals that come after the new interval
        */
        while(i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        /**
         * 6. Convert the result list to an array
        */
        return result.toArray(new int[result.size()][]);
    }



    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] result = insert(intervals, newInterval);
        System.out.println("Approach-1: " + Arrays.deepToString(result));

        
    }
}
