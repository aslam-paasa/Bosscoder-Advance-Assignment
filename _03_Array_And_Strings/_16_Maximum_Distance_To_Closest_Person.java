package _03_Array_And_Strings;

public class _16_Maximum_Distance_To_Closest_Person {
    public static void main(String[] args) {
        /**
         * Approach: Two-Pointer Technique
         * Input: seats = [1, 0, 0, 0, 1, 0, 1]
         *                 0  1  2  3  4  5  6
         * => Har '1' pe banda baitha hai aur '0' pe khali hai to hm
         *    '0' pe apna banda baitha skte hai.
         * => Humein apna banda aisa baithana hai ki distance between the
         *    closest person is max.
         * => Means If Alex sits in the second open seat (seat[2]), then
         *    the closest person has distance 2.
         *               2      2
         *            <-----><----->
         * => seats = [1, 0, A, 0, 1, 0, 1]
         * => If Alex sits in any other open seat, the closest person has
         *    distance 1.
         * => Thus, the maximum distance to the closest person is 2.
         * 
         * Approach:
         *  [0 , 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0]
         *   0   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18
         *  pi   i
         * => Start m prevIdx ko -1 set kr lenge aur jb mera idx m '1' aaega to
         *    prevIdx to Idx count krnge, dono ki idx ko subtract kr denge
         *    prevIdx - Idx => 2 (count: -1, 0, 1)
         * => Ab prevIdx ko set kr diya '1' pe aur next '1' ka wait krne lage,
         *    jaise hi humein nexr '1' mila, dono idx ko subtract kr denge, jisse
         *    humein pta lg jaega ki bich m kitna '0' aae:
         *  [0 , 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0]
         *   0   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18
         *       pi             i
         *  => idx - prevIdx = 6 - 1 => 5
         *  => 5/2 = 2 (pich m 2 k distance m '1' rkh denge)
         * 
         * => Similarly,
         *                      <--------------A-------------->
         *  [0 , 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0]
         *   0   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19
         *                      pi                            i
         *  => idx - prevIdx = 16 - 6 => 10
         *  => 10/2 = 5 (pich m 2 k distance m '1' rkh denge)
         * 
         * Note: Agar humein last m milta hai to "arr.length-1 - prevIdx kr denge".
         * Ya fir start m milta hai to dono case m "res/2" krne ki jarurat nhi
         * hai. Dono m yhi result hoga. Bass bich wale gap k andr jo v gap
         * hai uska divided by 2 se ans aaega.
         * 
         *      3           9/2 = 4                11/2 = 5                   4
         *  <---------> <------------> <------------------------------> <---------->
         *  [0, 0, 0,  1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0]
         *   0   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23
         * 
         * TC: O(n)
         * SC: O(1)
         * */ 

        int[] seats = {1, 0, 0, 0};

        int prevPersonIndex = -1; // Index of the last seen person
        int maxDistance = 0; // Maximum distance to the closest person

        for(int i = 0; i < seats.length; ++i) {
            /**
             * Jb Jb seats[i] == 1 hoga, tb tb kaam hoga: 
             * => Found a person sitting
            */
            if(seats[i] == 1) {
                int currentDistance = 0;
                
                if (prevPersonIndex < 0) {
                    /**
                     * First person encountered, distance is the index itself:
                    */
                    currentDistance = i;
                } else {
                    /**
                     * Distance between two people, take half the distance:
                    */
                    currentDistance = (i - prevPersonIndex) / 2;
                }
                /**
                 * Update maxDistance with the greater of the two distances:
                */
                maxDistance = Math.max(maxDistance, currentDistance);

                /**
                 * Update the index of the last seen person:
                */
                prevPersonIndex = i;
            }
        }
        /**
         * Edge case: Check distance from the last person to the end of the row
        */
        int lastDistance = seats.length - 1 - prevPersonIndex;
        maxDistance = Math.max(maxDistance, lastDistance);
        
        // return maxDistance;
        System.out.println(maxDistance);
    }
}
