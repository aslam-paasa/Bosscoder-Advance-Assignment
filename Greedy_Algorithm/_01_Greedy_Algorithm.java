package Greedy_Algorithm;

public class _01_Greedy_Algorithm {
    /**
     * Greedy Algorithm:
     * - It is not an algorithm, it is just a way of solving array or
     *   matrix problems.
     * - For example, I am at station-A, and from station-A there are
     *   two paths:
     *   a. Path Cost: 5rs
     *   b. Path Cost: 2rs
     *   Both of them are taking us to the same position at the end,
     *   what we will do? We will choose a path which is less costly,
     *   and this is called being Greedy.
     * - Is is a way to choose best/cheapest/easier path among given
     *   choices.
     * */    

    /**
     * Leetcode-135: Candies
     * - Given ratings(marks): [1, 2, 3, 4]
     *   Condition-1: Each student will get atleast one candy
     *   Condition-2: If higher rating than neighbours, that student will
     *                get more candy
     * 
     * - Create another array called 'chocolate', and here we will insert
     *   to that particular student, how many chocolate were given:
     *   a. Each student will get atleast one candy:
     *      - Initially every student will get atleast one candy.
     *      - Chocolate = [1, 1, 1, 1]
     *   b. If higher rating than neighbours, that student will one more
     *      candy:
     *      Case-1: Idx-1's rating is higher than its neighbours idx-0:
     *              - Chocolate = [1, 2, 1, 1]
     *      Case-2: Idx-2's rating is higher than its neighbours idx-1:
     *              - Chocolate = [1, 2, 3, 1]
     *      Case-3: Idx-3's rating is higher than its neighbours idx-2:
     *              - Chocolate = [1, 2, 3, 4]
     *   => Total chocolate distrbuted = sum of chocolate arr = 10
     *      This is a sorted array, so we just traversed from 
     *      left-to-right, and then from right-to-left.
     * 
     * What if rating is [1, 2, 1]?
     * => Rating    = [1, 2, 1]
     * 
     * Case-1: Traverse rating from left-to-right 
     *         Chocolate = [1, 1, 1]
     *                   = [1, 2, 1] [Left-to-right]
     *                   = [1, 2, 1] [Right-to-left]
     * 
     * Case-2: Traverse rating from right-to-left and verify max distribution
     *         Chocolate = [1, 2, 1]
     *          a. idx-last is having rating-1, so he has 1 chocolate
     *          b. idx-1 is having rating-2, so he has 2 chocolate
     *          c. idx-0 is having rating-1, so he has 1 chocolate
     *         So, no need to replace, and we need atleast 4-chocolate
     *         for the distribution to be completed.
     * 
     * What if the rating is [1, 3, 2, 4, 5]?
     * => Rating   : [1, 3, 2, 4, 5]
     * => Chocolate: [1, 2, 1, 2, 3] => Total: 9
     * 
     * What if the rating is [1, 2, 6, 5, 4, 3, 2]?
     * => Rating   : [1, 2, 6, 5, 4, 3, 2]
     * => Chocolate: [1, 2, 3, 1, 1, 1, 1]  left-to-right: 10
     *               ------------------->
     * => Chocolate: [1, 2, 5, 4, 3, 2, 1]  right-to-left: 18
     *               -----> <------------
     *  
     * PseudoCode:
     * int n = ratings.length;
     * int a[] = new int[n];
     * 
     * // Fill all array element with 1:
     * Arrays.fill(a, 1);
     * 
     * // ForwardPass [left-to-right]
     * for(int i = 1; i < n; i++) {
     *    if(ratings[i] > rating[i-1]) {
     *       a[i] = a[i-1] + 1;
     *    }
     * }
     * 
     * // BackwardPass [right-to-left]
     * for(int i = n-2; i >= 0; i--) {
     *    if(ratings[i] > ratings[i+1]) {
     *       a[i] = Math.max(a[i+1]+1, a[i]);
     *    }
     * }
     * 
     * // Sum of distribution of chocolates:
     * int sum = 0;
     * for(int i = 0; i < n; i++) {
     *    sum = sum + a[i];
     * }
     * return sum;
     * 
     * TC: O(N) + O(N) = O(N)
    */

    /**
     * Q. How will we identify?
     * => Whenever we are given a choice, and by just picking the 
     *    easier and less costly approach, we are getting the answer,
     *    and this is the indication that this is a greedy question.
    */

    /**
     * Leetcode-134: Gas Station
     * Q. Is there any trip possible that start from any gas station, and
     *    we can reach that gas station again?
     * => Yes!
     * 
     * Explanation:
     *            A  B  C  D  E
     * 1. Gas  = [1, 2, 3, 4, 5]
     * 2. Cost = [3, 4, 5, 1, 2]
     *    - Means how much amount of gas is available.
     *    - Means how many amount of gas will be needed to reach the
     *      next station.
     * 
     * a. Let's say I am at point-A, and at point-A, 1-unit is available
     *    and 3-unit is needed to reach another point which is point-B.
     * b. At point-B, 2-unit is available, and 4-unit is needed to reach
     *    another point which is point-C.
     * c. At point-C, 3-unit is available, and 5-unit is needed to reach
     *    another point which is point-D.
     * c. At point-D, 4-unit is available, and 1-unit is needed to reach
     *    another point which is point-E.
     * c. At point-E, 5-unit is available, and 2-unit is needed.
     * 
     * Suppose, Anil is at point-A and have to reach point-B, but 5-unit
     * of gas is available, and we need 8-unit to reach point-B. So, will
     * Anil reach? No!
     * 
     * But if Anil want to travel and fuel available is 6-units, and need
     * only 4-unit then Anil can travel, and 2-unit of extra gas is left. 
     * 
     * a. If we travel from point-D to point-E, we have 4 unit & 1 unit is
     *    needed. So, when we reach point-E, we have 3-unit left.
     * b. If we travel from point-E to point-A, we have 5unit + 3-unit i.e.
     *    8-unit & 2-unit is needed to reach point-A. So, when we reach
     *    point-A, we have 6-unit left.
     * c. If we travel from point-A to point-B, we have 6-unit + 1-unit
     *    i.e. 7-unit & 3-unit is needed to reach point-B. So, when we
     *    reach point-B, we have 4-unit left.
     * d. If we travel from point-B to point-C, we have 4-unit + 2-unit
     *    i.e. 6-unit & we needed 4-unit to reach point-C. So, when we
     *    reach point-C, we have 2-unit left.
     * e. If we travel from point-C to point-D, we have 2-unit + 3-unit
     *    i.e. 5-unit & we needed 5-unit to reach point-D.
     * So, our starting point will be point-D, and our answer will be
     * idx-3.
     * 
     * PseudoCode:
     * int n = gas.length; => total number of gas station
     * int total = 0;      => total amount of gas
     * int avail = 0;      => Available gas
     * int start = 0;      => Starting station-point
     * 
     * for(int i = 0; i < n; i++) {
     *    total = total + gas[i] - cost[i];
     *    avail = avail + gas[i] - cost[i];
     * 
     *    if(avail < 0) {
     *       avail = 0;
     *       start = i+1;
     *    }
     * }
     * 
     * if(total < 0) {
     *    return -1;
     * }
     * return start;
     * 
     * TC:
     * SC: 
    */

    /**
     * Leetcode-55:
     * 
     * 
     * Suppose, arr = [2, 1, 1]
     * Q. I will be starting from the 0th idx, can we reach the last idx?
     * => idx-0 = 2, which means either we can jump 1 to 2 place at a time.
     * => If we jump 2 places, then we can reach the last idx.
     *    a. If yes, return true
     *    b. Else, return false
     * 
     * Suppose, arr = [1, 1, 1, 1, 1]
     * => In this case, if we jump 1 place each time, we can reach the
     *    last place.
     * => So, return true.
     * 
     *        0  1  2  3  4
     * arr = [2, 3, 1, 1, 4]
     * These are the max number of jump that we can do from an index.
     * 1. idx-0 = 2, means we can do either 1 or 2 jump at one time.
     *               - jump-1: idx-0 to idx-1
     *               - jump-2: idx-0 to idx-2
     * 
     * Case-1: jump-1: idx-0 to idx-1
     * => From idx-1, we can jump upto 3 steps.
     * => If we jump 3 steps, we can reach the end.
     * => Return true.
     * 
     * Note: There can be multiple answer, but we have to check for the
     * way in which we can reach the end from the start, and return true.
     * 
     * 
     * Suppose, arr = [3, 2, 1, 0, 5]
     * => Return False
     * 
     * Q. If we start from Delhi, can we reach Bangalore?
     *           D  N  M  P  B
     * => arr = [2, 3, 1, 1, 4]
     *           0  1  2  3  4
     * => We will do it in a reverse manner. Suppose, currently I am at
     *    Pune, and from Pune we will check can we reach Bangalore?
     *    At max, we can reach = nums[i] + i (idx)
     *                         = 1 + 3
     *                         = 4 (idx)
     *    So, we can say there is a connection between Pune and Bangalore.
     *    It means from this point, Bangalore is reachable.
     * 
     * => Now, we will check backpoint Mumbai. We will check Mumbai to Pune,
     *    so at max, we reach  = nums[i] + i
     *                         = 1 + 2 
     *                         = 3 (idx)
     *    So, we can say there is a connection between Mumbai to Pune.
     * 
     * => Now, we will check backpoint Nagpur. We will check Nagpur to Mumbai,
     *    so at max, we reach  = nums[i] + i
     *                         = 3 + 1 
     *                         = 4 (idx)
     *    So, at max, from Nagpur, we can reach Bangalore(idx-4) directly.
     *    It means now the reachable point is Nagpur.
     * 
     * => Now, we will check backpoint Delhi. We will check Delhi to Nagpur,
     *    so at max, we reach  = nums[i] + i
     *                         = 0 + 2 
     *                         = 2 (idx)
     *    So, at max, we can idx-2 i.e. till Mumbai. But we are checking for
     *    route till Delhi, which is possible.
     * 
     * => Final Route: Delhi -> Nagpur -> Bangalore
     *    Return true
     * 
     * PseudoCode:
     * int index = nums.length - 1;
     * for(int i = nums.length-1; i >= 0; i--) {
     *    if(nums[i] + i >= index) {
     *       index = i;
     *    }
     * }
     * 
     * if(index == 0) {
     *    return true;
     * }
     * return false;
     * 
    */

    /**
     * Leetcode-221:
     * Let's say there are multiple square of 0 & 1 in this matrix, find
     * the largest square and its area.
     * 
     * Example-1:
     *    [1, 1]
     *    [1, 1] 2x2 = 4
     * 
     * Example-2:
     * Square of size-2
     * [1, 1, 0, 0, 0]
     * [1, 1, 0, 0, 0]
     * [0, 0, 1, 1, 1]
     * [0, 0, 1, 1, 1]
     * [0, 0, 1, 1, 1]
     *     Square of size-3
     * 
     * => Square of size-3 is greater than square of size-4
     * => Area would be = 3x3 = 9(ans)
     * 
     * Example-3:
     * [1, 0, 1, 0, 0]
     * [1, 0, 1, 1, 1]
     * [1, 1, 1, 1, 1] => 2 squares of size-2 => 2x2 = 4(ans)
     * [1, 0, 0, 1, 0]
     * 
     * Whenever there is a square
    */
}
