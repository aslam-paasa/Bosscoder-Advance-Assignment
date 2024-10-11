package _03_Array_And_Strings;

import java.util.PriorityQueue;

public class _21_Car_Pooling {
    class Pair implements Comparable<Pair> {
        int time;
        int delta;

        Pair(int time, int delta) {
            this.time = time;
            this.delta = delta;
        }

        public int compareTo(Pair o) {
            return this.time - o.time;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] map = new int[1001];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int[] trip : trips) {
            pq.add(new Pair(trip[1], +trip[0]));
            pq.add(new Pair(trip[2], -trip[0]));
        }

        int pic = 0;
        while(pq.size() > 0) {
            Pair rem = pq.remove();
            pic += rem.delta;

            if(pic > capacity) {
                return false;
            } else if(pic < 0) {
                pic = 0;
            }
        }
        return true;
    }

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
         * */ 

        _21_Car_Pooling carPool = new _21_Car_Pooling();

        // Example 1: trips = [[2, 1, 5], [3, 3, 7]], capacity = 4
        int[][] trips1 = {{2, 1, 5}, {3, 3, 7}};
        int capacity1 = 4;

        boolean result1 = carPool.carPooling(trips1, capacity1);
        System.out.println("Example 1: " + result1); // Expected output: False

        // Example 2: trips = [[2, 1, 5], [3, 5, 7]], capacity = 3
        int[][] trips2 = {{2, 1, 5}, {3, 5, 7}};
        int capacity2 = 3;

        boolean result2 = carPool.carPooling(trips2, capacity2);
        System.out.println("Example 2: " + result2); // Expected output: True

    }
}
