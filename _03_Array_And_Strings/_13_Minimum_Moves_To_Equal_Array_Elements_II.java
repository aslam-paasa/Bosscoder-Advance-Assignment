package _03_Array_And_Strings;

public class _13_Minimum_Moves_To_Equal_Array_Elements_II {
    public static void main(String[] args) {
        /**
         * Approach-2: Quick Select Algorithm
         * => Humein ek unsorted array de k bola jae unsorted array k andr
         *    kth largest element de do, to Quick-Selection Algorithm O(N)
         *    TC m dhund k de deta hai.
         * => Ab humein median nikaalna hai.
         * 
         * Here's how it works:
         * 1. Choose a pivot element from the array.
         * 2. Partition the array around the pivot element, such that all 
         *    elements less than the pivot are on the left, and all elements 
         *    greater than the pivot are on the right.
         * 3. If the pivot is the kth largest element, return it.
         * 4. If the pivot is less than the kth largest element, repeat the 
         *    process on the right partition.
         * 5. If the pivot is greater than the kth largest element, repeat the 
         *    process on the left partition.
         * 
         * => The code uses the Quick Select algorithm to find the 3rd largest 
         *    element in the array [5, 2, 9, 8, 6, 3, 4, 7].
         * => The output is 4, which is the 3rd largest element in the array.
         * 
         * Q. Find 3rd largest element :
         * => arr = [5, 2, 9, 8, 6, 3, 4, 7]
         *           0  1  2  3  4  5  6  7
         * => O/P = 4
         * 
         * Q. How to do partition?
         * => Hum last element i.e. 7 k base pe partitioning kr denge.
         * => 7 se chote walo ko ek taraf kr lenge aur 7 se bade walo ko ek
         *    taraf.
         *     i
         * => [5, 2, 9, 8, 6, 3, 4, 7]
         *     j
         * => Jb Jb humein choti value milegi to hum 'i-j' ko swap krnge aur
         *    aage badhnge. 'i-j' dono same jagha pe hai, swap hue aur dono
         *    hi aage badh gye.
         * => 1. [5] => i-j swap hue aur aage badh gye
         *     i
         * => [5, 2, 9, 8, 6, 3, 4, 7]
         *     j
         * 
         * => 2. [2] => i-j swap hue aur aage badh gye
         *        i
         * => [5, 2, 9, 8, 6, 3, 4, 7]
         *        j
         * 
         * => 3. [9] => '7' se bda hai to akela 'i' badh gya
         *              i
         * => [5, 2, 9, 8, 6, 3, 4, 7]
         *           j
         * 
         * => 4. [8] => '7' se bda hai to akela 'i' badh gya
         *                 i
         * => [5, 2, 9, 8, 6, 3, 4, 7]
         *           j
         * 
         * => 5. [6] => i-j swap hua, 6 piche aaya aur 9 piche, aur dono aage badh gya
         *                 i
         * => [5, 2, 6, 8, 9, 3, 4, 7]
         *           j
         * 
         * => 6. [3] => i-j swap hua, 3 piche aaya aur 8 aage badh gya
         *                    i
         * => [5, 2, 6, 3, 9, 8, 4, 7]
         *              j
         * 
         * => 7. [4] => i-j swap hua, 4 piche aaya aur 9 aage badh gya
         *                       i
         * => [5, 2, 6, 3, 4, 8, 9, 7]
         *                 j
         * 
         * => 8. [7] => i-j swap hua, 7 piche aaya aur 8 aage badh gya
         *                          i
         * => [5, 2, 6, 3, 4, 7, 9, 8]
         *                    j
         * Note: '7' apne correct index pe pahuch gya hai. But sorted
         *       m jo 2nd index pe jo aaega humein wo chaiye i.e. 3rd largest
         * 
         * */ 
    }
}
