package _03_Array_And_Strings;

public class _05_Max_Chunks_To_Make_Sorted {
    public static void main(String[] args) {
        /**
         * Sorting the array by breaking them into chunks:
         * => 'n' length ka array hai aur uske andr [0 to n-1] values
         * aane wali thi but elements humein sorted nhi mila.
         * => For example, arr[6] = [1, 2, 0, 4, 3, 5]
         * => Isse hum kitne hisso m baat skte hai such that harr hisse ko
         * sort kr diya jae ki wo poora hi sort ho jae.
         * => Bich m hum pipe lga de to sorting kr paenge:
         * => [1, 2, 0, | 4, 3, | 5]
         * => [0, 1, 2, | 3, 4, | 5]
         * => Means hum isse kitne hisse m tod skte hai ki such that every
         * part is sorted so the entire part become sorted.
         * 
         * TC: O(n)
         * SC: O(1)
         * 
         * Q. Pehle dkhnge kaise hm pipe lga skte hai?
         * => arr = [3, 1, 0, 2, | 5, 6, 4, | 8, 7, | 9]
         * idx = 0 1 2 3 4 5 6 7 8 9
         * max = 3 3 3 3 5 6 6 8 8 9
         * Note: max '3' hone ka mtlb hai ki avi tk maine '3' se badi value
         * encounter nhi kiya. Aur agar ye sorted hota to iss index
         * pe 3 hi aata aur mai 3rd index pe hi pahuch gya hu. To mai
         * yha pe ek line khich skta hu, aur similarly aage v aise hi
         * krnge.
         * => Basically jb v humaara 'max' == 'idx' ho tb counter badha lo,
         * to humaare paas utne hisse ho jaenge.
         * 
         *
         * Input: arr = {4, 3, 2, 1, 0};
         * => [4, 3, 2, | 1, 0] => 1 chunk
         * 
         * Output: 1
         */

        int[] arr = { 2, 1, 3, 4, 4 };

        /**
         * Initialize the count of chunks to 0
         */
        int count = 0;

        /**
         * Initialize the maximum value seen so far to negative infinity
         */
        int max = Integer.MIN_VALUE;

        /**
         * Iterate through the array
         */
        for (int i = 0; i < arr.length; i++) {
            /**
             * Update the maximum value seen so far
             */
            max = Math.max(max, arr[i]);

            /**
             * If the current value is equal to the maximum value seen so far,
             * it means we can start a new chunk
             * The condition here ensures that if the maximum value seen so far is equal
             * to the current index, all previous elements can form a valid chunk.
             */
            if (max == i) {
                /**
                 * Increment the count of chunks
                 */
                count++;
            }
        }

        /**
         * Print the total count of chunks
         */
        System.out.println("Maximum number of chunks: " + count);
    }
}
