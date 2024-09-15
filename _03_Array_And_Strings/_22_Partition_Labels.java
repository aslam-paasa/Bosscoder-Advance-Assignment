package _03_Array_And_Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
         *     0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 
         *    [a, b, a, b, c, b, a, c, a, d, e, f, e, g, d, e, h, i, j, h, k, l, i, j]
         * => Hum ek baar parse krnge aur ye store krnge ki wo aakhri idx 
         *    kispe aaya tha.
         *    a -> 0 -> 2 -> 6 -> 8
         *    b -> 1 -> 3 -> 5
         *    c -> 4 -> 7
         *    d -> 9 -> 14
         *    e -> 10 -> 12 -> 15
         *    f -> 11
         *    g -> 13
         *    h -> 16 -> 19
         *    i -> 17 -> 22
         *    j -> 18 -> 23
         *    k -> 20
         *    l -> 21
         * 
         * => Hum line waha khichnge jisme uske left wala koi v right
         *    side m naa aa sake.
         * 
         * Loop-1: Isme hm hashmap tyar kr lenge jisme set krnge ki har
         *         character aakhri baar kb aaya.
         * 
         * Char-1: 'a' ka last idx-8 hai
         * (i) start idx: 0
         * (ii) end idx: 8
         * => Ab end idx tk string leni hi padegi. 
         *    (a) 'b' ko scan kra to pta chla iska end idx: 5 tk hi aata hai.
         *    (b) 'a' ko scan kra to pta chla iska end idx: 8 tk aata hai.
         *    (c) 'b' ko scan kra to pta chla iska end idx: 5 tk aata hai.
         *    (d) 'c' ko scan kra to pta chla iska end idx: 7 tk aata hai.
         *    (e) 'b' ko scan kra to pta chla iska end idx: 5 tk aata hai.
         *    (f) 'a' ko scan kra to pta chla iska end idx: 8 tk aata hai.
         *    (g) 'c' ko scan kra to pta chla iska end idx: 7 tk aata hai.
         *    (h) 'a' ka last idx 8 hai aur hm 8 pe hi baithe hai, means jitne
         *        elements humne avi tk dekhe hai unme se kisi v element ka
         *        idx iss 'a' k beyond nhi jaa rha. To hm krnge: 
         *        => endIdx - startIdx + 1
         *        => 8 - 0 + 1
         *        => 9 elements
         * 
         * 
         * Char-2: 'd' pe dkhnge:
         * (i) start idx: 9
         * (ii) end idx: 14 -> 15
         * => Ab 'd' se string start ho k 14 tk to jaegi. Ab start ko wahi
         *    rkhnge aur 'j' ko bdhaenge:
         *    (a) 'e' ka last idx: 15 pe hai to end idx badha k 15 kr denge
         *    (b) 'f' ka last idx: 11 pe hai
         *    (c) 'e' ka last idx: 15 pe hai
         *    (d) 'g' ka last idx: 13 pe hai
         *    (e) 'd' ka last idx: 14 pe hai lekin hm 15 tk jaa rhe hai
         *    (f) 'e' ka last idx: 15 par aata hai aur hm 15 pe hi hai
         *     => endIdx - startIdx + 1
         *     => 15 - 9 + 1
         *     => 7
         * 
         * Char-3: 'h' pe dkhnge:
         * (i) start Idx: 16
         * (ii) end idx: 19 -> 22
         * => Ab 'h' se string start ho k 19 tk to jaegi. Ab start ko wahi
         *    rkhnge aur end ko bdhaenge:
         *    (a) 'h' ka last idx: 19 tk hai
         *    (b) 'i' ka last idx: 22 tk hai to end idx ko 22 tk update kr denge
         *    (c) 'j' ka last idx: 23 tk hai to end idx ko 23 tk update kr denge
         *    (d) 'h' ka last idx: 19 tk hai lekin hm 23 tk jaenge
         *    (e) 'k' ka last idx: 20 tk hai
         *    (f) 'l' ka last idx: 21 tk hai
         *    (g) 'i' ka last idx: 22 tk hai
         *    (h) 'j' ka last idx: 23 tk hai, aur hm 23 pe hi hai
         *    => endIdx - startIdx + 1
         *    => 23 - 16 + 1
         *    => 8
         * */ 

        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        Arrays.fill(map, -1); // Starting m sb jagha -1 fill kr diya

        // Har char aakhri baar kis index pe aaya tha
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map[ch - 'a'] = i;
        }

        // Saari string ko parse krte jaenge
        int start = 0;
        int end = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            end = Math.max(end, map[ch - 'a']);

            if(i == end) {
                int len = end - start + 1;
                result.add(len);  
                end = start = i + 1;
            }
        }

        return result;
    }
}
