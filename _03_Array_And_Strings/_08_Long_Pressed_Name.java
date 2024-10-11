package _03_Array_And_Strings;

public class _08_Long_Pressed_Name {
    public static void main(String[] args) {
        /**
         * Humein ek name diya hai "alex" lekin kuch key dabi reh gyi
         * to aise type ho gya "aaleex" => True, because 'a' and 'e'
         * in 'alex' were long pressed.
         * 
         * 'saeed' likhte hue 'ssaedd' type hue, lekin ye sahi nhi hai
         * qki asal m 'ee' 2 baar dabna tha lekin ek baar daba. => false
         * 
         *        'i'
         * typed = a a l e e x
         * name  = a l e x
         *        'j'
         * 
         * => typed wale case m idx apne piche wale idx se same hona chaiye.
         * => Aur agar piche wale k saath same hai to niche wale k saath
         *    match ho jaega.
         * => Means upar aur niche wala agar same hai to dono pointer badhao.
         *    aur agar same nhi hai typed wala element apne piche wale element
         *    se same hona chaiye fir sirf upar wala pointer badhao.
         * 
         * typed = s-s a-a e d-d
         * name  = s a e e d
         * => typed wala 'e' niche wale 'e' k equal hai to dono pointer
         *    badha diye.
         * => typed wala 'd'' niche k equal 'e' k equal nhi hai, to fir humne
         *    check kiya wo apne piche wale element k v equal nhi hai. Isliye
         *    ye False hai.
         * 
         * typed = a a l e e x a
         * name  = a l e x
         * => typed m last element 'a' hai jo ki niche se compare nhi ho skta
         *    aur apne piche wale element k equal v nhi hai.
         * => False
        */

        String name = "alex";
        String typed = "aaleex";

        int i = 0; 
        int j = 0;

        while(i < typed.length()) {
            // Agar typed wala name wale character k same h to dono pointer badhao
            if(j < name.length() && typed.charAt(i) == name.charAt(j)) {
                i++;
                j++;
            } 
            // Agar dono same nhi hai to typed character apne pichle character se same hona chaiye
            else if(i > 0 && typed.charAt(i) == typed.charAt(i - 1)) {
                i++;
            }
            // Dono satisfy nhi kr rhe to false hoga
            else {
                System.out.println(false);
                // return false; // ssaaedd saeed
            }
        }
        // Aur last m j-pointer name k end tk pahuch jaana chaiye
        // return j == name.length(); // aalexx alexa
        System.out.println(j == name.length());
    }
}
