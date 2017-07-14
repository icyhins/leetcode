package io.icyhins.medium;

/**
 * Given an integer,
 * convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Integer2Roman {

    /**
     * I (1), V(5), X(10), L(50), C(100), D(500), M(1000)
     * step :
     * 1. 3999 /1000 = 3 ....999 -> MMM
     * 2. 999/100 = 9...99 -> CM
     * 3. 99/10 = 9...9 --> XC
     * 4. 9/1 = 9...0 --> IX
     *
     * 621
     * 600 - DC
     * 20 - XX
     * 1 - I
     * --> DCXXI
     *
     * */

    public static void main(String[] args){
        Integer2Roman integer2Roman = new Integer2Roman();

        System.out.println(integer2Roman.solution(3999));
    }


    public String solution(int num){
        if(num<= 0 || num > 3999){
            return "";
        }

        int tmp = 0 ;
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];

    }
}
