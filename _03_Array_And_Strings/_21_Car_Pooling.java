package _03_Array_And_Strings;

import java.util.HashMap;

public class _21_Car_Pooling {
    public static void main(String[] args) {
        /**
         * Input: trips = [[2, 1, 5], [3, 3, 7]], capacity = 4
         * Output: False
         * 
         * Explanation:
         * [2] => No of Passenger  [3] => No of Passenger
         * [1] => Station-1        [3] => Station-3
         *           to                      to
         * [5] => Station-5        [7] => Station-7
         * => Capacity = 4 passengers
         * => Humein btana hai ki kya ye journey possible hai.
         * 
         * Passenger:  +2  +3  -2  -3
         * Trips:     [ 1,  3,  5,  7]
         * 
         * Note: Pichle question k arrival mai +1 hota tha aur departure
         *       m -1 hota tha. But iss baar arrival mai +2 hoga aur
         *       fir 3 wale arrival pe +3 hoga, then 5 pe -2 hoga and
         *       then 7 pe -3 hoga. Agar count 5 se jyda ya km hoga to false
         *       ho jaega.
         * 
         * => Ek hashmap pe ye saare time daal denge. Sbse min time le
         *    lenge, then sbse max time le lenge fir min time se max time
         *    ki aur badh jaenge.
         * 
         * 3:19:10 => 21 July
         * */ 

        // int[] trips = [[2, 1, 5], [3, 3, 7]];

        HashMap<Integer, Integer> map = new HashMap<>();
    }
}
