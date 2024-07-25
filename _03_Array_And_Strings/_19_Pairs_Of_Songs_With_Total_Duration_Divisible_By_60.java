package _03_Array_And_Strings;

public class _19_Pairs_Of_Songs_With_Total_Duration_Divisible_By_60 {
    public static void main(String[] args) {
        /**
         * Pairs Sum divisible by K: (FrequencyMap Concept)
         * 
         * Problem:
         * We have an array of song durations, and we want to find the number of pairs of songs 
         * where the total duration of the pair is divisible by 60.
         * 
         * Example:
         * Input: time = [30, 20, 150, 100, 40]
         * Output: 3
         * Explanation: The three pairs are:
         * 1. (time[0] = 30, time[2] = 150) => 30 + 150 = 180 (divisible by 60)
         * 2. (time[1] = 20, time[3] = 100) => 20 + 100 = 120 (divisible by 60)
         * 3. (time[1] = 20, time[4] = 40) => 20 + 40 = 60 (divisible by 60)
         * 
         * TC: O(n)
         * 
         * 
         * Approach:
         * - Use a frequency map (array) to count remainders of song durations when divided by 60.
         * - For each song duration, calculate the remainder when divided by 60.
         * - Use the frequency map to count how many previous durations can pair with the current duration
         *   to form a sum divisible by 60.
         * - Special cases:
         *   1. Remainder 0: Pair with other remainders 0.
         *   2. Remainder 30: Pair with other remainders 30 (because 30 + 30 = 60).
         *   3. Other remainders: Pair with complementary remainder to reach 60.
         * => Formula: (time[i] + time[j]) % 60 == 0
         * 
         * Approach: HashMap
         * => Pairs Sum divisible by K = 5
         * => arr = [2, 7, 16, 5, 8, 19, 4, 11, 20, 15]
         * => Ek hashmap bnanenge, uske andr bnaega ki:
         *    (a) 0 remainder aane wale kitne hai
         *    (b) 1 remainder aane wale kitne hai
         *    (c) 2 remainder aane wale kitne hai
         *    (d) 3 remainder aane wale kitne hai
         *    (e) 4 remainder aane wale kitne hai
         * => k=5 hai to remainder 0 to 4 tk hi aa skte hai. Aur inke andr
         *    count store krnge:
         *    [0] => [5, 20, 15] => 3
         *    [1] => [16, 11]    => 2
         *    [2] => [2, 7]      => 2
         *    [3] => [8]         => 1
         *    [4] => [19, 4]     => 2
         * => Ab jinke remainder '1' aae aur jinke '4' aae unke bich m pair kr
         *    skte hai. Aur total: 2 * 2 => 4 pairs possible hai.
         *    (1) 16 + 19 => 35
         *    (2) 16 + 4  => 20
         *    (3) 11 + 19 => 30
         *    (4) 11 + 4  => 15
         * => Remainder '2' & '3' mil k v pair bn skte hai. Aur inke total
         *    3 pairs banenge.
         *    (1) 2 + 8  => 10
         *    (2) 7 + 8  => 15
         * => Remainder '0' k liye [n(n-1)/2] formula lga lenge:
         *    => 3(3-1)/2
         *    => 6/2
         *    => 3
         * */ 

        int[] time = {30, 20, 150, 100, 40};

        // Frequency map to count remainders
        int[] remainderCount = new int[60];

        int pairCount = 0;

        for (int t : time) {
            int remainder = t % 60;

            if (remainder == 0) {
                 // If remainder is 0, pair with other songs that have remainder 0
                pairCount += remainderCount[0];
            } else {
                 // Pair with songs that have remainder (60 - remainder)
                pairCount += remainderCount[60 - remainder];
            }

             // Increment the count for this remainder
            remainderCount[remainder]++;
        }

        // Output the number of valid pairs
        System.out.println(pairCount);
        // return pairCount;
    }
}


/**
 * Dry Run for time = [30, 20, 150, 100, 40]
 * 
 * Initial Setup:
 * - remainderCounts = [0, 0, 0, ..., 0] (size 60)
 * - pairCount = 0
 * 
 * Iteration 1:
 * - Song duration = 30
 * - Remainder = 30 % 60 = 30
 * - Look for remainder 30 in remainderCounts (0 pairs found)
 * - Update remainderCounts[30] to 1
 * - pairCount = 0
 * 
 * Iteration 2:
 * - Song duration = 20
 * - Remainder = 20 % 60 = 20
 * - Look for remainder 40 in remainderCounts (0 pairs found)
 * - Update remainderCounts[20] to 1
 * - pairCount = 0
 * 
 * Iteration 3:
 * - Song duration = 150
 * - Remainder = 150 % 60 = 30
 * - Look for remainder 30 in remainderCounts (1 pair found with the first song)
 * - Update remainderCounts[30] to 2
 * - pairCount = 1
 * 
 * Iteration 4:
 * - Song duration = 100
 * - Remainder = 100 % 60 = 40
 * - Look for remainder 20 in remainderCounts (1 pair found with the second song)
 * - Update remainderCounts[40] to 1
 * - pairCount = 2
 * 
 * Iteration 5:
 * - Song duration = 40
 * - Remainder = 40 % 60 = 40
 * - Look for remainder 20 in remainderCounts (1 pair found with the second song)
 * - Update remainderCounts[40] to 2
 * - pairCount = 3
 * 
 * Final Result:
 * - pairCount = 3
*/