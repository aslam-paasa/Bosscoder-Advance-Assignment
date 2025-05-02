package _03_Array_And_Strings;

import java.util.Arrays;

public class _31_Minimum_Number_Of_Arrows_To_Burst_Balloons {
    /**
     * 452. Minimum Number of Arrows to Burst Balloons
     * Input : points = [[10,16],[2,8],[1,6],[7,12]]
     * Output: 2
     * Explanation: The balloons can be burst by 2 arrows:
     *  - Shoot an arrow at x=6, bursting the balloons [2, 8] and [1, 6].
     *  - Shoot an arrow at x=11, bursting the balloons [10, 16] and [7, 12].
     * 
     * Input : points = [[1,2],[3,4],[5,6],[7,8]]
     * Output: 4
     * Explanation: One arrow needs to be shot for each balloon for a total 
     *              of 4 arrows.
     * 
     * Note: Humein minimum kitni arrows lagegi ki saare ballons burst ho jae.
     *       Similar to Merge Intervals
    */

    /**
     * Steps:
     * 1. Sort the array based on the end point of the balloons.
     * 2. Agar agle ka start point pehle wale k end se jyda hota to humein
     *    kuch ni krna
     *         2          8
     *         +----------+
     *    +----------+
     *    1          6
     *  
     *   But agar mai 2-6 tk kahi v arrow maaru to dono k balloon burst kr
     *   skta hu. Basically humein new tb lgegi jb start hi end se bda ho
     * 
     *                7             12
     *                +-------------+
     *        2          8
     *        +-----+----+
     *   1          6
     *   +----------+
     * 
     *   Now, next ka start point pehle wale k end se jyda ho to humein
     *   ek new arrow lagega qki 7 jo hai wo 6 k beyond start hota hai.
     *                       10            16
     *                       +-------------+
     *                7             12
     *                +-------------+
     *        2          8
     *        +-----+----+
     *   1          6
     *   +----------+
     * 
     *   Now next wale mai new arrow nhi lagega kyuki 10 jo hai wo 12 se pehle
     *   start hota hai.
    */

    public static int findMinArrowShots(int[][] points) {

        /**
         * 1. Sort the array based on the end point of the balloons.
         *    - If the start point is same then sort based on the end point.
         *    - If the start point is different then sort based on the start point.
         *    - If the start point and end point both are same then sort based on the index.
        */
        Arrays.sort(points, (a, b) -> {
            if(a[0] > b[0]) {
                return 1;
            } else if(a[0] == b[0]) {
                return -1;
            } else {
                return -1;
            }
        });

        /**
         * 2. Iterate through the array and count the number of arrows needed.
         *    - If the start point is greater than the end point of the previous balloon
         *      then we need a new arrow.
         *    - If the start point is less than or equal to the end point of the previous balloon
         *      then we don't need a new arrow.
        */
        int count = 0;
        int end = Integer.MAX_VALUE;
        for(int[] p : points) {
            if(p[0] > end) {
                count++;
                end = p[1];
            } else {
                end = Math.min(end, p[1]);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));
    }
}
