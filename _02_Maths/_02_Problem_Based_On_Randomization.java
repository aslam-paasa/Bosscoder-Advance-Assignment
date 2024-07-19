package _02_Maths;

public class _02_Problem_Based_On_Randomization {
    public static void main(String[] args) {
        /**
         * Q. Given a function rand5() that returns random numbers
         *    from 1 to 5 with equal probability, implement the one-liner
         *    function rand7() using rand5() that returns random numbers
         *    from 1 to 5 with equal probability.
         * => rand5() => 1, 2, 3, 4, 5
         * => Scope it to 7 numbers.
         * 
         * Formula: [5 * (rand5() - 1)] + (rand5() - 1)
         * => Covers 0 to 24
         * 1. 0, 1, 2, 3, 4, 5, 6
         * 2. 7, 8, 9, 10, 11, 12, 13
         * 3. 14, 15, 16, 17, 18, 19, 20
         * 4, [21, 22, 23, 24]=> extra 4 numbers which we don't want.
         * 
         * Q. How to reject it and let's ask for the no. once again?
         * 
         * Logic: 
         * rand7() {
         *    fx = [5 * (rand5() - 1)] + (rand5() - 1)
         *    if (fx > 20) {
         *       call again rand7() 
         *    }
         *    return (fx % 7) + 1
         * }
         * */ 
    }
}
