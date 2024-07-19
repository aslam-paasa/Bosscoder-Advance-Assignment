package _02_Maths;

public class _01_Problem_Based_On_Randomization {
    public static void main(String[] args) {
        /**
         * Q. What is random?
         * => Choosing anything between a selective range.
         * 
         * Q. Pick a number between 1-10 then what is the probability
         *    of picking '5'?
         * => There is one library available across every possible 
         *    language which we call as random() library.
         * => This random library takes a starting range and ending
         *    range and it is going to generate random numbers between
         *    starting range to ending range => random(1, 5).
         * => It will give me any random number between 1 to 5, each
         *    of which will be having equal probability of 1/5.
         * => Each number is equally likely to occure and this number
         *    is truly random.
         * 
         * Q. Given a function rand6 that returns random numbers from
         *    1 to 6 with equal probability, implement the one-liner
         *    function rand9() using rand6 that returns random numbers
         *    from 1 to 9 with equal probability.
         * => Implement a function rand9 which could generate any number
         *    from 1 to 9. Each of which must be having a probability of
         *    1/9, and we have rand6() which gives anything between 1 to 6
         *    each of which having a probablity of 1/6. So, how can we use
         *    this function rand6() function to generate rand9() such that
         *    everything must be having a equal probability of 1/9.
         * 
         * => Modulus Operator => '%'
         * => This will provide remainder.
         * => If we say x % 9 = [0-8] 
         * 
         * => If we do (x % 9) + 1, so anything which we can get, we simply
         *    adding +1 to all of them, and if we do this we are simply
         *    getting every possible number between 1-9.
         * => The problem said what we have is rand6(), what we want is 
         *    rand9(). 
         * 
         * Note: The common multiplier between 9,6 is 36.
         *       (a) (6, 9) = 36
         *       (b) (6 * 6) = 36
         *       (c) (9 * 4) = 36
         * 
         * => rand6() * rand6() 
         * => With this we can generate any number between 1 to 36.
         *    (a) 6 times 1-6.
         *    (b) 4 times 1-9 => condition is satisfied by using '%'.
         * 
         * Using [rand6() * rand6()], we can get 12, 18. But how can
         * we get 13, 14, 15, 16, 17, which is in between 12-18.
         * => For that we add:
         *    rand6() - 1
         *    (a) 1 - 1 = 0 => 12 + 0 = 12
         *    (b) 2 - 1 = 1 => 12 + 1 = 13
         *    (c) 3 - 1 = 2 => 12 + 2 = 14
         *    (d) 4 - 1 = 3 => 12 + 3 = 15
         *    (e) 5 - 1 = 4 => 12 + 4 = 16
         *    (f) 6 - 1 = 5 => 12 + 5 = 17
         * 
         * Formula: [[6 * rand6()] + [rand6() - 1]]
         * => This formula will be generating all the possible number
         *    between 1 to 36 and on this formula we just have to do
         *    "[formula % 9] + 1" to get the answer between 1-9.
         * 
         * Note: When we multiply "rand6() * 6", the only possible
         *       multiple we get are: 
         * 
         *              [Missing: 0, 1, 2, 3, 4, 5]
         * => 1*6 = 6,  [Missing: 7, 8, 9, 10, 11]
         * => 2*6 = 12, [Missing: 13, 14, 15, 16, 17]
         * => 3*6 = 18, [Missing: 19, 20, 21, 22, 23]
         * => 4*6 = 24, [Missing: 25, 26, 27, 28, 29]
         * => 5*6 = 30, [Missing: 31, 32, 33, 34, 35]
         * => 6*6 = 36
         * 
         * By using rand6()-1, we can generate 7, 8, 9, 10, 11.
         * 
         * Q. How to generate 0, 1, 2, 3, 4, 5?
         * Formula: [[6 * rand6()-1] + [rand6() - 1]]
         * 
         * 1. [6 * [1 - 1]] + [1 - 1] = 0
         *    [6 * [1 - 1]] + [2 - 1] = 1
         *    [6 * [1 - 1]] + [3 - 1] = 2
         *    [6 * [1 - 1]] + [4 - 1] = 3
         *    [6 * [1 - 1]] + [5 - 1] = 4
         *    [6 * [1 - 1]] + [6 - 1] = 5
         * 2. [6 * [2 - 1]] + [1 - 1] = 6
         *    [6 * [2 - 1]] + [2 - 1] = 7
         *    [6 * [2 - 1]] + [3 - 1] = 8
         *    [6 * [2 - 1]] + [4 - 1] = 9
         *    [6 * [2 - 1]] + [5 - 1] = 10
         *    [6 * [2 - 1]] + [6 - 1] = 11
         * 3. [6 * [3 - 1]] + [1 - 1] = 12
         * ........
         * ........
         * ........
         * 6. [6 * [6 - 1]] + [6 - 1] = 35
         *    
         * Formula: ([[6 * rand6()-1] + [rand6() - 1]] % 9) + 1
         * 
         * Logic:
         *    function rand9() {
         *       fx = (rand6() - 1) * 6 + (rand6() - 1)
         *       return (fx % 9) + 1
         *    }
         * 
         * TC: O(1)
         * SC: O(1)
         * */ 
    }
}
