package _05_Greedy_Algorithms._01_Basics_Of_Greedy_Algorithm;

import java.util.Arrays;

public class _01_Greedy_Algorithm {
    /**
     * Greedy Algorithm is a problem-solving approach where we make 
     * the best possible choice at each step, hoping to get the best 
     * overall solution.
     * 
     * Examples of Greedy Algorithms:
     * 1. Fractional Knapsack (Maximizing profit by taking items with 
     *    the best value per weight)
     * 2. Dijkstra's Algorithm (Finding the shortest path in a graph)
     * 3. Kruskal's Algorithm (Finding the Minimum Spanning Tree in a 
     *    graph)
     * 4. Huffman Coding (Data compression technique)
     * 5. Prim's Algorithm (Another way to find the Minimum Spanning 
     *    Tree)
     */

    /**
     * Characteristics of Greedy Algorithms:
     * 1. Simple and easy to implement.
     * 2. Usually fast and efficient in solving problems.
     * 3. Works well when choosing the best local option leads to the 
     *    best global solution.
     * 4. It does not go back to previous choices. Once a decision is 
     *    made, it moves forward.
     * 
     * Example: 
     * - In the "Jump Game" problem, where we decide how far to jump 
     *   to reach the end quickly, a Greedy approach works well.
     * - In the "Shortest Path" problem, Dijkstra's Algorithm (Greedy) 
     *   is preferred over Bellman-Ford if there are no negative weights.
     */

    /**
     * How does a Greedy Algorithm work?
     * - A Greedy Algorithm solves a problem by making the best possible 
     *   choice at each step, hoping to reach the best overall solution.
     * - It always picks the option that looks best at the moment without 
     *   worrying about future consequences.
     * 
     * Steps of a Greedy Algorithm:
     * 1. Start with an initial state (the starting point of the problem).
     * 2. Look at all possible choices from the current state.
     * 3. Pick the best choice available at the moment (this is the "greedy" part).
     * 4. Move to the next state based on the chosen option.
     * 5. Repeat steps 2-4 until you reach the goal or no more moves are possible.
     */

    /**
     * Example: Coin Change Problem
     * 
     * Suppose you have coins of values [1, 2, 5, 10] and need to make 
     * change for 39 using the fewest coins.
     * 
     * - The greedy algorithm works as follows:
     *   1. Take the largest coin that is less than or equal to the amount (39). 
     *      → The largest coin is 10.
     *   2. Subtract this coin from the total and add it to the solution. 
     *      → 39 - 10 = 29 (used one 10-coin).
     *   3. Repeat steps 1 and 2 until the remaining amount is 0.
     *   
     *   Steps:
     *   - Take 10 → Remaining: 29
     *   - Take 10 → Remaining: 19
     *   - Take 10 → Remaining: 9
     *   - Take 5  → Remaining: 4
     *   - Take 2  → Remaining: 2
     *   - Take 2  → Remaining: 0
     *   
     *   Solution: 10, 10, 10, 5, 2, 2 (Total coins used: 6)
     */

    public static int minCoins(int[] coins, int targetAmount) {

        /**
         * 1. Sort the coins in descending order(largest to smallest)
         * 2. Initialize the count of coins
        */
        Arrays.sort(coins);
        int n = coins.length;
        int minNumberOfCoins = 0;


        /**
         * 3. Iterate through the coins from largest to smallest
         *    a. The value of the current coins
         *    b. While the current coins can be used(amount remaining is 
         *       greater than or equal to coin value)
         *       - Use the current coin
         *       - Reduce the remaining amount
         *    c. If the target amount becomes zero, we have our answer
         * 4. Return the minimum number of coins
        */
        for(int i = n-1; i >= 0; i--) {
            int coinValue = coins[i];

            while(targetAmount >= coinValue) {
                minNumberOfCoins++;
                targetAmount -= coinValue;
            }

            if(targetAmount == 0) {
                break;
            }
        }
        return minNumberOfCoins;
    }

    public static void main(String[] args) {
        int[] coins = {5, 2, 10, 1};
        int amount = 39;

        int result = minCoins(coins, amount);
        System.out.println(result); // Output: 4
    }
}
