package _03_Array_And_Strings;

public class _15_Maximum_Swap {
    public static void main(String[] args) {
        /**
         * Approach: Greedy algorithm
         * => Saari combinations naa check kr k koi ek flow ko check kr k
         *    bta de ye wala hi answer dega.
         * 
         * Input: num = 2736
         * Output: 7236
         * Explanation: Swap the number 2 and the number 7.
         * => You can swap two digits at most once to get the maximum
         *    values number.
         * 
         * num = 4 5 3 7 9 6 8 2
         *     = 9 5 3 7 4 6 8 2 (swap)
         * 
         * num = 9 5 3 8 4 6 7 2 (already 9 is max)
         * 
         * => Hume right se left ki aur move krnge
         * => Element ki right side ki sbse bde wale element ka index store krnge:
         * arr[] = [8(Idx-3), 8(Idx-3), 8(Idx-3), 7(Idx-6), 7(Idx-6), 7(Idx-6), 2(Idx-7), -1(null)]
         * 1. Element-9 ne dekha mere right m sbse badi value 8(Idx-3) hai, to wo swap nhi hoga.
         * 2. Element-9 ne dekha mere right m sbse badi value 8(Idx-3) hai, wo swap ho jaega.
         * => Iss array ko hum O(n) m bna skte hai.
         * */ 

        int num = 2736;

        // Convert the number to a character array
        char[] arr = (num + "").toCharArray();

        /// Initialize an array to keep track of the rightmost index of the maximum digit
        int[] right = new int[arr.length];


        // Traverse the array from the second last element to the first element
        for (int i = arr.length - 2; i >= 0; i--) {
            // If the current element is the last element, set right[i] to -1
            if (i == arr.length - 1) {
                right[i] = -1;
            // If the current element is the second last element, set right[i] to the last index
            } else if (i == arr.length - 2) {
                right[i] = arr.length - 1;
            } else {
                // If the next element is greater than the rightmost maximum digit of the next element
                if (arr[i + 1] > arr[right[i + 1]]) {
                    right[i] = i + 1;
                } else {
                    // Otherwise, propagate the rightmost maximum index
                    right[i] = right[i + 1];
                }
            }
        }
        
        // Traverse the array from the beginning to the second last element
        for (int i = 0; i < arr.length - 1; i++) {
            // If the current element is less than the rightmost maximum digit
            if (arr[i] < arr[right[i]]) {
                // Swap the current element with the rightmost maximum digit
                char temp = arr[i];
                arr[i] = arr[right[i]];
                arr[right[i]] = temp;
                // Break after the first swap to ensure maximum swap
                break;
            }
        }
        
        // Convert the character array back to an integer and return it
        // return Integer.parseInt(new String(arr));
        System.out.println(Integer.parseInt(new String(arr)));
    }
}
