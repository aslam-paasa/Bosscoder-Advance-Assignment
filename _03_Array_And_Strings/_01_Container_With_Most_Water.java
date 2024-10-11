package _03_Array_And_Strings;

public class _01_Container_With_Most_Water {
    public static void main(String[] args) {
        /**
         * Two Pointer:
         * Input: height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
         * Output: 49
         * 
         * Explanation:
         * => We can select any two walls to form a container and calculate 
         *    the amount of water it can hold. The amount of water is 
         *    determined by the shorter wall and the distance between the 
         *    two walls.
         *           
         *           | 6L                     |
         *           +----+                   |         |
         *           |    |           4L   4L |         |
         *           |    |         |----+----+     3L  |
         *           |    | 2L   2L |    |    | 3L +----+
         *        1L |    +----+----+    |    +----|    |
         *      +----+    |    |    |    |    |    |    |
         *      |    |    |    |    |    |    |    |    |
         * +-------------------------------------------------+
         *      1    8    6    2    5    4    8    3    7
         * 
         * Note: The height of the container is limited by the shorter wall.
         * 
         * Brute Force Approach: O(n^2)
         * - Try all possible pairs of walls to find the maximum area.
         * - Example pairs: (1, 8), (1, 6), (1, 2), (1, 5), etc.
         * 
         * Can we do better in O(n)?
         * Optimized Approach: O(n) => Greedy Algorithm
         * - Use two pointers, one at the beginning (start) and one at 
         *   the end (end) of the array.
         *
         * 
         *           | 6L                     |
         *           +----+                   |         |
         *           |    |           4L   4L |         |
         *           |    |         |----+----+     3L  |
         *           |    | 2L   2L |    |    | 3L +----+
         *        1L |    +----+----+    |    +----|    |
         *      +----+    |    |    |    |    |    |    |
         *      |    |    |    |    |    |    |    |    |
         * +-------------------------------------------------+
         *      1    8    6    2    5    4    8    3    7
         *     start                                   end
         * 
         * 1) Check walls at positions 1 and 7:
         *    - Width = 8 (No of walls between 1-7)
         *    - Height = min(1, 7) = 1
         *    - Area = 1 * 8 = 8
         *    - Since the height of 1 is less than 7, move the start pointer to the right.
         * 
         * Note: Ek baar humne 1-7 check kr liye to uske baad humein 1-3, 1-8, 
         *       1-4 etc, check krne ki jarurat hi nhi hai qki ye sb kvi 1-7 se
         *       better area de hi nhi skte, to hm baaki sb ko discard kr skte
         *       hai.
         *
         * 2) Check walls at positions 8 and 7:
         *    - Width = 7
         *    - Height = min(8, 7) = 7
         *    - Area = 7 * 7 = 49
         * 
         * 4) Check walls at positions 8 and 3:
         *    - Width = 6
         *    - Height = min(8, 3) = 3
         *    - Area = 6 * 3 = 18
         * 
         * 4) Check walls at positions 8 and 8:
         *    - Width = 5
         *    - Height = min(8, 8) = 8
         *    - Area = 5 * 8 = 40
         * 
         * 5) Check walls at positions 6 and 8:
         *    - Width = 4
         *    - Height = min(6, 8) = 4
         *    - Area = 4 * 6 = 24
         *
         * 3) Continue this process until the start pointer crosses the end pointer.
         *    - The maximum area found will be the result.
         * */ 

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = 0;

        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            /**
             * int area = height.min(leftIdx, rightIdx) * width(rightIdx - leftIdx);
             * */ 
            int area = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, area);

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(result);
    }
}
