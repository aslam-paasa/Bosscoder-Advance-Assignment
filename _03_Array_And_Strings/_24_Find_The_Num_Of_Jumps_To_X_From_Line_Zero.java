package _03_Array_And_Strings;

public class _24_Find_The_Num_Of_Jumps_To_X_From_Line_Zero {
    /**
     * Topic: Binary Search (Mathematical problem involving jumps and parity)
     * 
     * Problem: 754. Reach a Number
     * Given an integer X, find the minimum number of steps required to 
     * reach X on a number line starting from 0.
     * 
     * Explanation:
     * 1. You start at position 0 and can move either left or right.
     * 2. In the first step, you move 1 unit (left or right). 
     *    In the second step, you can move 2 units, in the third, 3 units,
     *    and so on.
     * 3. The goal is to find the minimum number of steps to exactly reach
     *    position X.
     * Ex:     +----+----+----+----+----+----+----+----+----+
     *        -1    0    1    2    3    4    5    6    7    8
     * 1-step  <----+
     * 2-step    +--------->
     * 3-step              +-------------->
     * 4-step                             +-------------------> (destination)
     * 
     *         => ith move = i-size 
     *         => 4-move   = 4-step
     * 
     * Ex:     +----+----+----+----+----+----+----+----+----+----+----+----+
     *        -3   -2   -1    0    1    2    3    4    5    6    7    8    9
     * 1-step            <----+
     * 2-step  <---------+
     * 3-step  +-------------->
     * 4-step                 +------------------->
     * 5-step                                     +------------------------>
     * 
     *         => ith move = i-size 
     *         => 5-move   = 5-step  
     * 
     * Observation: 2^n steps
     * 1. Agr sirf 1 step allow hota to hm sirf 2 destination m jaa skte the: 
     *    => -1 or 1
     * 2. Agr sirf 2 step allow hota to hm sirf 4 destination m jaa skte the:
     *    => -1 -2 => -3
     *    => -1 +2 =>  1
     *    => +1 -2 => -1
     *    => +1 +2 =>  3
     *    Agar humne n-step chla hai to hm -(n(n+1)/2) to +(n(n+1)/2) tk 
     *    visit kr skte hai, but:
     *    (a) Agar n-odd m hai to sirf odd num visit krnge
     *    (b) Agar n-even m hai to sirf even num visit krnge 
     * 3. Agr sirf 3 step allow hota to hm sirf 8 destination m jaa skte the:
     *    => -1 -2 -3 = -6
     *    => -1 -2 +3 =  0
     *    => -1 +2 -3 = -2
     *    => -1 +2 +3 =  4
     *    => +1 -2 -3 = -4
     *    => +1 -2 +3 =  2
     *    => +1 +2 -3 =  0
     *    => +1 +2 +3 =  6
     * => Agar humein 16th destination m jaana hota to:
     *    1 => 1(1+1)/2 => 1
     *    2 => 2(2+1)/2 => 3
     *    3 => 3(3+1)/2 => 6
     *    4 => 4(4+1)/2 => 10
     *    5 => 5(5+1)/2 => 15
     *    6 => 6(6+1)/2 => 21 
     * => 6-step chlnge to -21 to 21 tk saare odd num visit kra skta hai.
     *    But 16 even num hai tohm next num try knrge:
     *    7 => 7(7+1/2) => 28 (-28 to 28) => 7steps m hm reach kr jaenge.
     * 
     * TC: O(root N)
    */ 

    public int reachNumber(int target) {
        /**
         * Absolute value of the target because direction doesn't matter
         * (symmetry in number line)
         * */ 
        target = Math.abs(target);
        int x = 0;

        while(true) {
            int range =  x*(x+1)/2;
            if(range >= target && range % 2 == target % 2) {
                break;
            } else {
                x++;
            }
        }
        return x;
    }

    /**
     * Approach-2: Binary Search
     * => O(log N)
    */
    public int reachNumberBinary(int target) {
        target = Math.abs(target);
        int low = 1;
        int high = target * 2;

        int x = -1;
        while(low < high) {
            int mid = (low + high) / 2;
            int range = mid * (mid + 1) / 2;

            if(target <= range && range % 2 == target % 2) {
                high = mid - 1;
                x = mid;
            } else {
                low = mid + 1;
            }
        }
        return x;
    }
}
