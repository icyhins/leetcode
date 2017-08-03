package io.icyhins.easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {

    public static void main(String[] args){
        String a = "11", b="1";

       System.out.println(addBinary(a,b));
    }

    /**
     * Solution main idea:
     *
     * The key problem is on the carry digit for 1 + 1 = 10
     * 1. Fill '0' until the length of string a & b euqal.
     *
     * */
    public static String addBinary(String a, String b){

        int maxLen = Math.max(a.length() ,b.length());

        boolean carry = false;

        //Fill '0'
        StringBuilder sb = new StringBuilder();
        if( a.length() < maxLen){
            while(a.length() < b.length()){
                a = new String("0").concat(a);
            }
        }else {
            while(b.length() < a.length()){
                b = new String("0").concat(b);
            }
        }

        //calculate
        char[] aS = a.toCharArray();
        char[] bS = b.toCharArray();
        String res = "";

        for(int i = maxLen-1; i >= 0; i--) {
            int ai = aS[i] - '0';//Same as Character.getNumericValue();
            int bi = bS[i] - '0';

            int tmp = 0;
            tmp = carry ? ai + bi + 1 : ai + bi;

            //case 0 + 0 without carry
            if (tmp == 0) {
                res = new String("0").concat(res);
                carry = false;
            }
            //case 1 + 0 without carry
            else if (tmp == 1) {
                res = new String("1").concat(res);
                carry = false;
            }
            //case 1 + 1 without carry || case 1 + 0 with carry
            else if (tmp == 2) {
                res = new String("0").concat(res);
                carry = true;
            }
            //case 1 + 1 with carry
            else if (tmp == 3) {
                res = new String("1").concat(res);
                carry = true;
            }
        }
        //Final carry
        if(carry) res = new String("1").concat(res);

        return res;
    }
}
