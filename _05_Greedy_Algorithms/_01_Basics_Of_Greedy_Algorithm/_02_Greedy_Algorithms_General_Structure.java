package _05_Greedy_Algorithms._01_Basics_Of_Greedy_Algorithm;

public class _02_Greedy_Algorithms_General_Structure {
    /**
     * Greedy Algorithm Overview:
     * - A greedy algorithm solves problems by making the best choice at
     *   each step.
     * - Instead of exploring all possible solutions, it picks the best 
     *   option available at the moment.
     * 
     * Example: Fractional Knapsack Problem
     * Suppose we have the following items:
     *  - Item A: Weight = 10, Value = 60
     *  - Item B: Weight = 20, Value = 100
     *  - Item C: Weight = 30, Value = 120
     *  
     * Goal: Fill a bag of capacity 50 with the highest value.
     * 
     * Solution:
     * - Take all of A (10 kg) → Remaining capacity: 40
     * - Take all of B (20 kg) → Remaining capacity: 20
     * - Take 2/3rd of C (20 kg out of 30) → Bag is full.
     * - Total Value: 60 + 100 + (2/3 * 120) = 240
     */

    /**
     * Properties of Greedy Algorithms:
     * 1. Greedy Choice Property:
     *    - Making the best choice at each step leads to the best overall
     *      solution.
     *    - If this is not true, the greedy approach may not work.
     * 2. Optimal Substructure:
     *    - The problem can be broken down into smaller subproblems.
     *    - Solving these subproblems with greedy choices leads to an 
     *      optimal solution.
     */

/**
     * How to Identify Greedy Problems:
     * 1. Can the problem be broken into smaller independent parts?
     *    - Example: In the Activity Selection problem, once an activity
     *      is selected, the remaining problem is to select non-overlapping
     *      activities.
     * 2. Greedy vs. Dynamic Programming:
     *    - Greedy: Works when the problem has the 'Greedy Choice Property'
     *      and Optimal Substructure.
     *    - Dynamic Programming: Requires Optimal Substructure and 
     *      Overlapping Subproblems.
     *    - Greedy makes a decision based on the current best choice.
     *    - Dynamic Programming depends on past computations to build a 
     *      solution.
     */

/**
     * Common Ways to Solve Greedy Problems:
     * 1. Sorting-Based Approaches:
     *    a. Job Sequencing:
     *       - Sort jobs by profit in descending order.
     *       - Schedule each job as late as possible within its deadline.
     *    b. Activity Selection:
     *       - Sort activities by their finishing time.
     *       - Select the earliest finishing activities to maximize selection.
     *    c. Disjoint Intervals:
     *       - Similar to Activity Selection.
     *       - Sort intervals and pick non-overlapping ones.
     *    d. Fractional Knapsack:
     *       - Sort items by value/weight ratio.
     *       - Take the highest ratio items first.
     *    e. Kruskal’s Algorithm (Minimum Spanning Tree):
     *       - Sort edges by weight.
     *       - Add edges one by one, avoiding cycles.
     * 
     * 2. Using Priority Queue (Heap-Based Approaches):
     *    a. Dijkstra’s Algorithm (Shortest Path):
     *       - Use a min-heap to always expand the nearest node.
     *    b. Connecting N Ropes (Minimize Cost):
     *       - Use a min-heap to repeatedly merge the smallest two ropes.
     *    c. Huffman Encoding (Data Compression):
     *       - Use a min-heap to build a binary tree for encoding characters.
     * 
     * 3. Other Greedy Problems:
     *    - Minimum Number of Jumps to Reach End:
     *      - Keep track of the maximum reachable index.
     *      - Count jumps whenever the current range is fully explored.
     */
}
