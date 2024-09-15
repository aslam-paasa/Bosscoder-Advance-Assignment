package _03_Array_And_Strings;

public class _23_Parition_Array_Into_Disjoint_Intervals {
    /**
     * Humein aisi line khichni hai ki leftside ka koi v bnda right side
     * k kisi v bande se bda naa ho.
     * Ex:
     * (a) Input: [5, 0, 3, 8, 6]
     * (b) Output: 3
     * (c) Explanation: left: [5, 0, 3], right: [8, 6]
     * 
     * Note: 
     * (i) Left k sbse bda element, right k sbse chote element se chota hoga.
     * (ii) Left side se max nikaalte rhnge, right side se min nikaalte rhnge.
     *      
     *      arr  = 5  6  7  3  4 | 8  9  14  12  11  10 
     *      max  = 5  6  7  7  7 | 8  9  14  14  14  14 (left-to-right)
     *      min  = 3  3  3  3  4 | 8  9  10  10  10  10 (right-to-left)
     *      (left side max)    |   |  (right side min)
     *                         V   V
     *              left max = 7 < right min = 8
     * */ 

    public static void main(String[] args) {
        int[] nums = { 5, 0, 3, 8, 6 };
        System.out.println(partitionDisjoint(nums));
        System.out.println(paritionDisjointOptimized(nums));
    }

    public static int partitionDisjoint(int[] nums) {
        /**
         * TC: O(N)
         * SC: O(N)
        */
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        // Left Side Max
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(nums[i], left[i - 1]);
            }
        }

        // Right Side Min
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1) {
                right[i] = nums[i];
            } else {
                right[i] = Math.min(nums[i], right[i + 1]);
            }
        }


        int ans = -1;
        for(int i = 0; i < nums.length; i++) {
            if(left[i] <= right[i+1]) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }

    public static int paritionDisjointOptimized(int[] nums) {
        /**
         * TC: O(N)
         * SC: O(1)
        */
        // maxTillParition
        // maxTillScan
        /**
         * Test Case
         * 5  6  8  3  14  12  7  15
         * 
         * Step-1: Starting m idx-0 pe parition krnge:
         * 5 | 6  8  3  14  12  7  15
         * (i) maxTillParition: Parition tk ka mera max '5' hai.
         * (ii) maxTillScan: Aur jitne num tk humne scan kiya hai uska
         *      max v 5 hai.
         * 
         * Step-2: 6 is max than 5
         * (a) maxTillParition: No change
         * (b) maxTillScan: No change
         * 
         * Step-3: 8 is max than 5
         * (a) maxTillParition: No change
         * (b) maxTillScan: No change
         * 
         * Step-4: 3 is min than 5
         * (a) Update Parition Line:
         *     5  6  8  3 | 14  12  7  15
         * (a) maxTillParition: 8, means jitna area humne scan kiya uska
         *     max aa jaega.
         * (b) maxTillScan: No change
         * 
         * Step-5: 14 is max than 8
         * (a) maxTillParition: No change
         * (b) maxTillScan: No change
         * 
         * Step-6: 12 is max than 8
         * (a) maxTillParition: No change
         * (b) maxTillScan: No change
         * 
         * Step-7: 7 is min than 8
         * (a) Update Parition Line:
         *     5  6  8  3 14  12  7 | 15
         * (a) maxTillParition: 14, means jitna area humne scan kiya uska
         *     max aa jaega.
         * (b) maxTillScan: No change
         * 
         * Step-8: 15 is max than 14
         * (a) maxTillParition: No change
         * (b) maxTillScan: No change
         * 
         * => So, 7 k left tk k jitne v element hai wo 15 se bda nhi hnge.
        */

        int partitionIdx = 0;
        int maxTillPartition = nums[0];
        int maxTillScan = nums[0];

        for(int i = 1; i < nums.length; i++) {
            maxTillScan = Math.max(nums[i], maxTillScan);

            if(nums[i] < maxTillPartition) {
                partitionIdx = i;
                maxTillPartition = maxTillScan;
            }
        }
        return partitionIdx + 1;
    }

}
