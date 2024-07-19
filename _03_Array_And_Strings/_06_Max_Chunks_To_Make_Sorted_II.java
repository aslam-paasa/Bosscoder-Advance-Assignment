package _03_Array_And_Strings;

public class _06_Max_Chunks_To_Make_Sorted_II {
    public static void main(String[] args) {
        /**
         * Max Chunks II: Approach:
         * 1. Identify Chunks Using Maximum and Minimum:
         *    (a) We need to find positions in the array where we can 
         *        make a "cut" or chunk such that if we sort these chunks
         *        individually, the whole array will be sorted.
         *    (b) To do this, we need to keep track of the maximum value 
         *        from the left up to each point and the minimum value from
         *        the right up to each point.
         * 2. Create Arrays for Max and Min:
         *    (a) Create an array maxLeft where each element at index i is the
         *        maximum value from the start of the array up to i.
         *    (b) Create an array minRight where each element at index i is the
         *        minimum value from i to the end of the array.
         * 3. Count Chunks:
         *    (a) Iterate through the array and compare the values of 
         *        maxLeft[i] and minRight[i + 1]. 
         *        If maxLeft[i] <= minRight[i + 1], it means we can make
         *        a chunk here.
         * 
         * Dry Run:
         * Let's take the example array: [2, 1, 3, 4, 4].
         * 1. Initialize Arrays:
         *    => maxLeft will store the maximum values from the left.
         *    => minRight will store the minimum values from the right.
         * 2. Fill maxLeft:
         *    => For index 0, maxLeft[0] = arr[0] = 2
         *    => For index 1, maxLeft[1] = max(arr[1], maxLeft[0]) = max(1, 2) = 2
         *    => For index 2, maxLeft[2] = max(arr[2], maxLeft[1]) = max(3, 2) = 3
         *    => For index 3, maxLeft[3] = max(arr[3], maxLeft[2]) = max(4, 3) = 4
         *    => For index 4, maxLeft[4] = max(arr[4], maxLeft[3]) = max(4, 4) = 4
         *    => So, maxLeft becomes: [2, 2, 3, 4, 4].
         * 3. Fill minRight:
         *    => For index 4, minRight[4] = arr[4] = 4
         *    => For index 3, minRight[3] = min(arr[3], minRight[4]) = min(4, 4) = 4
         *    => For index 2, minRight[2] = min(arr[2], minRight[3]) = min(3, 4) = 3
         *    => For index 1, minRight[1] = min(arr[1], minRight[2]) = min(1, 3) = 1
         *    => For index 0, minRight[0] = min(arr[0], minRight[1]) = min(2, 1) = 1
         *    => So, minRight becomes: [1, 1, 3, 4, 4].
         * 4. Count Chunks:
         *  (a) Initialize chunks to 0.
         *  (b) Iterate through the array and compare maxLeft[i] with minRight[i + 1]:
         *    => For i = 0: maxLeft[0] (2) <= minRight[1] (1) is false, no chunk here.
         *    => For i = 1: maxLeft[1] (2) <= minRight[2] (3) is true, increment chunks to 1.
         *    => For i = 2: maxLeft[2] (3) <= minRight[3] (4) is true, increment chunks to 2.
         *    => For i = 3: maxLeft[3] (4) <= minRight[4] (4) is true, increment chunks to 3.
         *    => Since we need to add 1 to the final result (as the last part of the array is
         *       always a chunk), the total number of chunks is 3 + 1 = 4.
         * 
         * TC: O(n)
         * SC: O(n)
         *  
         * */ 

        int[] arr = {2, 1, 3, 4, 4};

        /**
         * Calculate the minimum value from the right side for each index.
         */
        int[] minfr = new int[arr.length];
        minfr[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            minfr[i] = Math.min(arr[i], minfr[i + 1]);
        }

        /**
         * Calculate the maximum value from the left side and compare with the minimum value from the right side.
         */
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            max = Math.max(max, arr[i]);
            if (max <= minfr[i + 1]) {
                count++;
            }
        }

        System.out.println("Maximum number of chunks: " + (count + 1));
    }
}


/**
 * Dry Run: For the array [2, 1, 3, 4, 4]:
 * 1. minfr array is calculated as [1, 1, 3, 4, 4].
 * 2. max starts from Integer.MIN_VALUE and gets updated as we iterate:
 *    (a) At i = 0, max becomes 2 (no chunk here).
 *    (b) At i = 1, max remains 2 and since 2 <= 3, we can form a chunk (chunk count: 1).
 *    (c) At i = 2, max becomes 3 and since 3 <= 4, we can form another chunk (chunk count: 2).
 *    (d) At i = 3, max becomes 4 and since 4 <= 4, we can form another chunk (chunk count: 3).
 * => Finally, add 1 to the chunk count, resulting in 4 chunks for the array [2, 1, 3, 4, 4].
 * 
 * 
 * Purpose Behind Solving This Problem:
 * => Imagine you have a messy box of Lego pieces, and you want to organize 
 *    them in a way that, if you sort small groups of pieces, the whole box 
 *    will eventually be sorted without needing to sort the entire box all 
 *    at once. This problem is like finding the best way to break down a 
 *    big task into smaller, manageable chunks.
 * 
 * What We Can Learn:
 * 1. Breaking Down Problems:
 * => It teaches us how to break down a big problem (like sorting a whole 
 *    array) into smaller problems (sorting chunks of the array).
 * 
 * 2. Efficiency:
 * => We learn how to do things more efficiently. Instead of sorting the
 *    entire array multiple times, we figure out the smallest number of
 *    steps needed to get the job done.
 * 
 * 3. Strategic Thinking:
 * => It helps us develop strategic thinking. We need to find the right 
 *    spots to "cut" the array into chunks that make sorting easier.
 * 
 * 
 * Daily Life Implementation:
 * 1. Cleaning Your Room:
 * => Instead of trying to clean the entire messy room at once, you divide
 *    it into chunks. You clean one corner at a time (like your desk, 
 *    then your bed, then the closet). This way, it's easier and less 
 *    overwhelming, and by the time you finish each part, the whole room
 *    is clean.
 * 
 * 2. Studying for Exams:
 * => Instead of trying to study an entire textbook in one go, you break 
 *    it into chapters or sections. You focus on one chapter at a time, 
 *    making it easier to understand and remember the material.
 * 
 * 3. Cooking a Big Meal:
 * => When cooking a big meal with multiple dishes, you don't make everything
 *    at once. You break it down into tasks: chopping vegetables first, 
 *    then cooking the main dish, and finally preparing the dessert. 
 *    This way, everything gets done efficiently and on time.

*/