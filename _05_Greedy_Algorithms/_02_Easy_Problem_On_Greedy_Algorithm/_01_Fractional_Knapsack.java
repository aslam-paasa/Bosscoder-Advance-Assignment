package _05_Greedy_Algorithms._02_Easy_Problem_On_Greedy_Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class _01_Fractional_Knapsack {
    /**
     * Fractional Knapsack:
     * Given the weights and profits of N-items, in the form of
     * {profit, weight}, put these items in a knapsack of capacity W
     * to get the maximum total profit in the knapsack. In Fractional
     * Knapsack, we can break items for maximizing the total value of
     * the knapsack.
     * 
     * Input : arr[] = {{60, 10}, {100, 20}, {120, 30}}, W = 50
     * Output: 240
     * Explanation: 
     * - By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg.
     * - Hence total price will be 60+100+(2/3)(120) = 240
     * 
     * Input : arr[] = {{500, 30}}, W = 10 
     * Output: 166.667
    */

    /**
     * Approach-1: To solve the proble follows the below idea:
     * - Tru all possible subsets with all different fractions.
     * - TC: O(2^N)
     * - SC: O(N)
    */

    /**
     * Approach-2: Knapsack Problem using Greedy Algorithm
     * - The basic idea of the greedy approach is to calculate the
     *   ratio profit/weight for each item and sort the item on the
     *   basis of this ratio. Then take the item with the highest ratio
     *   and add them as much as we can(can be the whole element or a
     *   fraction of it).
     * - This will always give the maximum profit because, in each step
     *   it adds an element such that this is the maximum possible
     *   profit for that much weight.
     * 
     * 1. Consider the example: 
     *    arr[] = {{100, 20}, {60, 10}, {120, 30}},  W=50
     * 2. Sorting:
     *    Initially sort the array based on the profit/weight ratio.
     *    The sorted array will be {{60, 10}, {100, 20}, {120, 30}}.
     * 3. Iteration:
     *    - For i=0, weight=10, which is less than W. So, add this element
     *      in the knapsack. Profit=60, remaining W=50-10 = 40
     *    - For i = 1, weight = 20 which is less than W. So add this 
     *      element too. profit = 60 + 100 = 160 and remaining 
     *      W = 40 – 20 = 20.
     *    - For i = 2, weight = 30 is greater than W. So add 20/30 
     *      fraction = 2/3 fraction of the element. Therefore 
     *      profit = 2/3 * 120 + 160 = 80 + 160 = 240 and remaining 
     *      W becomes 0.
     * So the final profit becomes 240 for W = 50.
    */

    /**
     * Steps:
     * 1. Calculate the ratio (profit/weight) for each item.
     * 2. Sort all the items in decreasing order of the ratio.
     * 3. Initialize res = 0, curr_cap = given_cap.
     * 4. Do the following for every item i in the sorted order:
     *    a. If the weight of the current item is less than or equal to the remaining capacity then add the value of that item into the result
     *    b. Else add the current item as much as we can and break out of the loop.
     * 5. Return res.
    */

    /**
     * Represent an item with its profit and weight
    */
    public static class Item {
        int profit;
        int weight;

        public Item(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
        }
    }

    /**
     * Calculats the max value that can be carries in the knapsack:
    */
    public static double getMaxKnapsackValue(Item[] items, int capacity) {
        /**
         * Sort items by their profit-to-weight ratio(heighest first)
        */
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double ratio1 = (double) item1.profit / item1.weight;
                double ratio2 = (double) item2.profit / item2.weight;
                // Sort in descending order (highest ratio first)
                return Double.compare(ratio2, ratio1); 
            }
        });

        double totalValue = 0; // Total value of items we can carry
        int remainingCapacity = capacity; // How much space is left in our knapsack

        // Go through each item (starting with the best ratio)
        for (Item item : items) {
            if (remainingCapacity >= item.weight) {
                // The whole item fits!
                totalValue += item.profit;
                remainingCapacity -= item.weight;
            } else {
                // Only part of the item fits
                double fraction = (double) remainingCapacity / item.weight; // Calculate the fraction we can take
                totalValue += item.profit * fraction; // Add the fractional value
                remainingCapacity = 0; // Knapsack is now full
                break; // We're done - no more space
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        // Example items: (profit, weight)
        Item[] items = {
                new Item(60, 10),  // Item 1: Profit 60, Weight 10
                new Item(100, 20), // Item 2: Profit 100, Weight 20
                new Item(120, 30)  // Item 3: Profit 120, Weight 30
        };

        int knapsackCapacity = 50; // Our knapsack can hold a max weight of 50

        // Calculate and print the maximum value we can carry
        double maxValue = getMaxKnapsackValue(items, knapsackCapacity);
        System.out.println("Maximum knapsack value: " + maxValue); 
    }
}