package _03_Array_And_Strings;

import java.util.Stack;

public class _26_Trapping_Rainwater {
    /**
     * Trapping Rainwater:
     * 
     * Problem: 42. Trapping Rain Water
     * Given n non-negative integers representing an elevation map where the
     * width of each bar is 1, compute how much water it can trap after raining.
     * 
     * Explanation:
     * 1. The elevation map is represented by an array of integers where each
     *    integer represents the height of the bar at that index.
     * 2. The width of each bar is 1.
     * 3. The elevation map is:
     *    [4, 2, 0, 3, 2, 5]
     * 4. The amount of water that can be trapped after raining is:
     *    [4, 2, 0, 3, 2, 5]
     *    [4, 2, 0, 3, 2, 5]
     *    [4, 2, 0, 3, 2, 5]
     *    [4, 2, 0, 3, 2, 5]
     *    [4, 2, 0, 3, 2, 5]
     * 
     * Input : height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
     * Output: 6
     * 
     * Explanation: The elevation map is represented by array. In this case,
     *              6units of rain water are being trapped.
     * 
    */    

    /**
     * Steps-1:
     * 1. Left side se maximum height of bar find kro.
     * 2. Right side se maximum height of bar find kro.
     * 3. Then for each index, find the minimum of the left and right maximum
     *    height of bar.
     * 4. Then subtract the height of the bar from the minimum of the left 
     *    and right maximum height of bar.
     * 5. Add all the values to get the total amount of water trapped.
     * 
     * TC: O(n)
     * SC: O(n)
     * 
    */
    public static int trap(int[] height) {

        /**
         * Step-1: Find the left and right maximum height of bar.   
        */
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        
        /**
         * Step-2: Calculate the amount of water trapped.
        */
        int waterTrapped = 0;
        for(int i = 0; i < n; i++) {
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        /**
         * Step-3: Return the total amount of water trapped.
        */
        return waterTrapped;
    }


    /**
     * Approach-2: Using two pointers.
     * 
     * TC: O(n)
     * SC: O(1)
    */
    public static int trapII(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int waterTrapped = 0;

        while(left <= right) {
            if(height[left] <= height[right]) {
                if(height[left] > leftMax) leftMax = height[left];
                else waterTrapped += leftMax - height[left];
                left++;
            } else {
                if(height[right] > rightMax) rightMax = height[right];
                else waterTrapped += rightMax - height[right];
                right--;
            }
        }
        return waterTrapped;
    }

    /**
     * Approach-3: Using stack.
     * TC: O(n)
     * SC: O(n)
    */
    public static int trapIII(int[] height) {
        int n = height.length;
        int waterTrapped = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) break;
                int width = i - stack.peek() - 1;
                int heights = Math.min(height[i], height[stack.peek()]) - height[top];
                waterTrapped += width * heights;
            }
            stack.push(i);
        }
        return waterTrapped;
    }   

    /** 
     * Approach-4: Using dynamic programming.
     * TC: O(n)
     * SC: O(n)
    */
    public static int trapIV(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int waterTrapped = 0;

        leftMax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        } 

        for(int i = 0; i < n; i++) {
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return waterTrapped;
    }   
    

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
        System.out.println(trapII(height));
        System.out.println(trapIII(height));    
        System.out.println(trapIV(height));
    }
}
