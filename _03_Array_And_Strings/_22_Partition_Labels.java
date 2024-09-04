package _03_Array_And_Strings;

public class _22_Partition_Labels {
    public static void main(String[] args) {
        /**
         * Partition Labels:
         * => Input: s = "ababcbacadefegdehijhklij"
         * => Output: [9, 7, 8]
         * => Explanation:
         *    The partition of "ababcbaca", "defegde", "hijhklij".
         *    This is a partition so that each letter appears in at most
         *    one part. A partition like "ababcbacadefegde", "hijhklij"
         *    is incorrect because it splits 's' into less parts.
         * 
         * Note: Poori string ko aise todna. But kaise todna hai?
         * => ababcbaca|defegde: Left wala ek v character right m nhi hai.
         * => defegde|hijhklij: Yha ek aur line khich skte hai qki left wale
         *                      character right side m nhi hai.
         * => Humein btana hai ki iske andr kaha kaha line khich skte hai
         *    aur unn separated strings m kitne characters hai.
         * => [9characters, 7characters, 8characters]
         * 
         * Approach:
         * => Ek hashmap bna lenge aur store krnge ki ye character aakhri 
         *    kis index pe store hua:
         *    [a, b, a, b, c, b, a, c, a, d, e, f, e, g, d, e, h, i, j, h, k, l, i, j]
         * => 54:40 => 25 July
         * 
         * */ 
    }
}
