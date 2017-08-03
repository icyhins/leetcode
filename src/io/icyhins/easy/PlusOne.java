package io.icyhins.easy;

import java.util.Arrays;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.


 */
public class PlusOne {


    public static void main(String[] args){
        PlusOne obj = new PlusOne();

        int[] digits = {9,9};

        System.out.println(Arrays.toString(obj.plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                //if the last digit is not 9, plus 1 & return the result
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        //for 999...99 case
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }

    public int[] plusOne2(int[] digits){
        int carry = 1;//Carry digit
        int len = digits.length;

        for(int i = len - 1; i >=0 ; i--){
            if(carry == 0) return digits;
            int sum = digits[i] + carry;

            digits[i] = sum % 10;//
            carry = sum / 10;//Carry digit update
        }

        //for 999...99 case
        int[] res = new int[len + 1];
        res[0] = 1;

        return carry == 0? digits:res;

    }


}
