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


    public String solution(int i){
        if(i<= 0 || i > 3999){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int tmp = 0 ;
        //1. Thousand
        if( i / 1000 != 0 ){
            tmp = i / 1000;
            switch (tmp){
                case 1:sb.append("M");
                    break;
                case 2:sb.append("MM");
                    break;
                case 3:sb.append("MMM");
                    break;
            }
            i = i % 1000;
        }

        //2. Hundred
        if( i / 100 != 0){
            tmp = i / 100;
            switch (tmp){
                case 1:sb.append("C");
                    break;
                case 2:sb.append("CC");
                    break;
                case 3:sb.append("CCC");
                    break;
                case 4:sb.append("CD");
                    break;
                case 5:sb.append("D");
                    break;
                case 6:sb.append("DC");
                    break;
                case 7:sb.append("DCC");
                    break;
                case 8:sb.append("DCCC");
                    break;
                case 9:sb.append("CM");
                    break;
            }

            i = i % 100;
        }


        //3. Ten
        if( i / 10 != 0){
            tmp = i / 10;
            switch (tmp){
                case 1:sb.append("X");
                    break;
                case 2:sb.append("XX");
                    break;
                case 3:sb.append("XXX");
                    break;
                case 4:sb.append("XL");
                    break;
                case 5:sb.append("L");
                    break;
                case 6:sb.append("LX");
                    break;
                case 7:sb.append("LXX");
                    break;
                case 8:sb.append("LXXX");
                    break;
                case 9:sb.append("XC");
                    break;
            }

            i = i % 10;
        }

        //4. Digital
        if( i  != 0){
            tmp = i ;
            switch (tmp){
                case 1:sb.append("I");
                    break;
                case 2:sb.append("II");
                    break;
                case 3:sb.append("III");
                    break;
                case 4:sb.append("IV");
                    break;
                case 5:sb.append("V");
                    break;
                case 6:sb.append("VI");
                    break;
                case 7:sb.append("VII");
                    break;
                case 8:sb.append("VIII");
                    break;
                case 9:sb.append("IX");
                    break;
            }

            i = i % 10;
        }

        return sb.toString();
    }
}
