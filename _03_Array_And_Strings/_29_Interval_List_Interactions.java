package _03_Array_And_Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class _29_Interval_List_Interactions {
    /**
     * Problem: 986. Interval List Intersections [Intersection of Two Lists]
     * 
     * Q. You are given two lists of closed intervals, firstList and secondList,
     *    where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
     *    Each list of intervals is pairwise disjoint and in sorted order.
     *    Return the intersection of these two interval lists.
     * 
     * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], 
     *        secondList = [[1,5],[8,12],[15,24],[25,26]]
     * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     * 
     * 
     * Input: firstList = [[1,3]], secondList = [[4,8]]
     * Output: []
    */

    /**
     * Approach:
     * 1. Two Pointer use karnge (i & j)
     *    - i : firstList ka pointer
     *    - j : secondList ka pointer
     * 2. Check kro ki intersection hai ya nahi
     *    - Agar firstList[i] aur secondList[j] ka overlap ho rha hai, toh
     *      intersection calculate karna hai:
     *    - Example: [0, 2] & [1, 5] 
     *      a. Start = max(0, 1) = 1
     *      b. End = min(2, 5) = 2
     *      c. Intersection = [1, 2] => Add result list me
     * 3. Pointer move kro jiska end pehle aata hai:
     *    - Agar end1 < end2, toh i++ (firstList ko pointer badhao)
     *    - Agar end2 < end1, toh j++ (secondList ko pointer badhao)
     *    - Agar end1 == end2, toh dono ko badhao (i++ & j++)
     * 4. Jab tak ek list complete na ho jaye, loop chalao
     *    - Jb 'i == firstList.length' ya 'j == secondList.length', tb stop.
     * 5. Final result return karo jo intersections store kiye hai.
    */

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> list = new ArrayList<>();

        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);

            if(low <= high) {
                list.add(new int[]{low, high});
            }

            if(firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] result = intervalIntersection(firstList, secondList);
        System.out.println(Arrays.deepToString(result));
    }
}
