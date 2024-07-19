package _03_Array_And_Strings;

public class _04_Majority_Element {
    public static void main(String[] args){
        /**
         * Q. Majority Element:
         * => Majority element wo h jo [n/2] se jyda baar appear krega.
         * => For example, agar 10 element h to km se km 6 baar appear krega.
         * => Assume kr lo majority element isme hai.
         * 
         * Approach: Moore's Algorithm:
         * For solving this we can use Moore's Algorithm.
         * => Let's say humaare saamne 10 elements hai aur usme se element 7
         *    six times aaya hai: [7, 7, 2, 7, 4, 7, 7, 6, 7, 8]
         * => Moore's Algorithm ye kehta hai ki startElement ko majority element
         *    maan lo, aur count kr lo '1'.
         *    int majority = 7;
         *    int count = 1;
         * => Ab aage badho aur dekho kya ye element mere majority element se
         *    same hai? Agar hai to count ++ kr do:
         *    int majority = 7;
         *    int count = 2;
         * => Check next element = 2, agar alag hai to count ghata do:
         *    int majority = 7;
         *    int count = 1;
         * => Check next element = 2:
         *    int majority = 7;
         *    int count = 2;
         * => Check next element = 2:
         *    int majority = 7;
         *    int count = 3;
         * => Check next element = 6:
         *    int majority = 7;
         *    int count = 2;
         * => Check next element = 7:
         *    int majority = 7;
         *    int count = 3;
         * => Check next element = 8:
         *    int majority = 7;
         *    int count = 1;
         * => Agar kvi count '0' ho jae aur uss element ko majority element
         *    maan lo aur count dobara se kro. Isse jo large element humein
         *    milta hai wo majority element hota hai.
         * 
         * For example: [7, 7, 2, 7, 4, 6, 7, 7, 7, 8]
         * 
         * 1. Check Element: 7
         * int majortiy = 7
         * int count = 1
         * 
         * 2. Check Element: 7
         * int majortiy = 7
         * int count = 2
         * 
         * 3. Check Element: 2
         * int majortiy = 7
         * int count = 1
         * 
         * 4. Check Element: 7
         * int majortiy = 7
         * int count = 2
         * 
         * 5. Check Element: 4
         * int majortiy = 7
         * int count = 1
         * 
         * 6. Check Element: 6
         * int majortiy = 7 -> 6
         * int count = 0 -> 1
         * 
         * Note: Ab count=0 ho gya to majority element ko 6 maan lo aur count kro:
         * 
         * 7. Check Element = 7
         * int majority = 6 -> 7
         * int count = 0 -> 1
         * 
         * 8. Check Element = 7
         * int majority = 7
         * int count = 2
         * 
         * 9. Check Element = 7
         * int majority = 7
         * int count = 3
         * 
         * 10. Check Element = 8
         * int majority = 7
         * int count = 2
         * 
         * Q. Actually ho kya rha hai?
         * => Count agar same hai to ++ aur alag hai to --.
         * => It means hum same element ko alag element se kaat rhe hai.
         * => Hum majority element wale set ko non majority element wale 
         *    set se cancel kr rhe hai.
         * => Aur katne k baad jo v count bach rha hai jo ki n/2 se jyda hai
         *    wo majority element hai.
         * 
         * TC: O(n)
         * SC: O(1)
         * */

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int count = 0;
        Integer majElem = null;

        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                /**
                 * New set begins:
                 * */
                majElem = nums[i];
                count = 1;
            } else if(nums[i] == majElem) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println(majElem);
        
        
    }
}
