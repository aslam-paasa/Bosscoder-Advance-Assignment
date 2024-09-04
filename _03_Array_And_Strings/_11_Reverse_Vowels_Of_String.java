package _03_Array_And_Strings;

/**
 * Topic: String
*/

public class _11_Reverse_Vowels_Of_String {
    public static void main(String[] args) {
        /**
         * In-Place Vowel Swapping: Two Pointer + Swapping Approach:
         * => l e e t c o d e
         *      e o     e   e
         * => l e o t c e d e
         * 
         * => Basically humein vowels m rukna hai, consonants ko ignore
         *    krna hai.
         * => Ek String bna k baith jaana hai => "a e i o u A E I O U"
         * => Kisi v character ko isme "indexOf()" kr k dekh skte hai.
         *    Iss String k saath character pe "indexOf()" krnge to agar
         *    wo consonant hoga to -1 aaega aur vowel hoga to +1 aaega.
         * => Isko use kr k hm pehchan lenge kn consonant h aur kn vowel h.
         * 
         * => 2 Pointer lenge => left & right
         * =>  left wala jbtk right se chota rhega tbtk kaam krega. Aur
         *     left wala badhta rahega aur usse jb vowel milega tb wo rukega
         *     aur right kam hote rahega jbtk usse vowel naa mil jae aur fir
         *     left and right swap maar lega. Aur ye process hote rhega jbtk
         *     left right k equal ya greater na ho jae.
         *
         * => l e e t c o d e
         *      e o     e   e
         * => l e o t c e d e
         * */ 

        String s = "leetcode";

        StringBuilder sb = new StringBuilder(s);
        String check = "aeiouAEIOU";

        // 2-Pointer:
        int leftIdx = 0;
        int rightIdx = sb.length() - 1;

        while(leftIdx < rightIdx) {
            while(leftIdx < rightIdx && check.indexOf(sb.charAt(leftIdx)) == -1) {
                leftIdx++;
            }

            while(leftIdx < rightIdx && check.indexOf(sb.charAt(rightIdx)) == -1) {
                rightIdx--;
            } 

            // Swapping:
            char temp = sb.charAt(leftIdx);
            sb.setCharAt(leftIdx, sb.charAt(rightIdx));
            sb.setCharAt(rightIdx, temp);
            leftIdx++;
            rightIdx--;
        }
        // return sb.toString();
        System.out.println(sb.toString());
    }
}
