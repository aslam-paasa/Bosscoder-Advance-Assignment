package _03_Array_And_Strings;

public class _32_Gas_Station {
    /**
     * 134. Gas Station (Greedy) => Refer Scalar Module
     * Input : gas = [1,2,3,4,5], cost = [3,4,5,1,2]
     * Output: 3
     * Explanation:
     *  - Start at station 3(idx-3) and fill up with 4 units of gas.
     *    Your tank = 0 + 4 = 4
     *  - Travel to station 4. Your tank = 4 - 1 + 5 = 8
     *  - Travel to station 0. Your tank = 8 - 2 + 1 = 7
     *  - Travel to station 1. Your tank = 7 - 3 + 2 = 6
     *  - Travel to station 2. Your tank = 6 - 4 + 3 = 5
     *  - Travel to station 3. The cost is 5. Your gas is enough to travel
     *    back to station 3.
     *  - Therefore, return 3 as the starting index.
    */ 

    /**
     * Approach: 
     * 1. Check if the total gas is enough to travel around the circuit.
     *    - If not, return -1.
     * 2. If yes, then we need to find the starting index.
     *    - We will use a tank to store the gas.
     *    - If the tank is negative, then we need to start from the next index.
     *    - If the tank is positive, then we can continue to the next index.
     * 3. If we can complete the circuit, then we return the starting index.
     *    - If we can't complete the circuit, then we return -1.
    */

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost) {
            return -1;
        }
        int tank = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }   
        return start;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
