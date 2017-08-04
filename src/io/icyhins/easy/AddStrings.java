package io.icyhins.easy;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {

    public static void main(String[] args){
        AddStrings obj = new AddStrings();
        String num1 = "9";
        String num2 = "99";
        System.out.println(obj.addStrings(num1,num2));
    }

    /**
     * Solution main idea:
     *      678
     * +    456
     * -----------
     *       14     <- num1[3] + num2[2] + carry
     *      12      <- num1[2] + num2[1] + carry
     *     10       <- num1[1] + num2[0] + carry
     * ----------
     *     1634     <- last carry
     * */
    public String addStrings(String num1, String num2) {

        int p1 = num1.length() - 1; // Pointer
        int p2 = num2.length() - 1; // pointer
        int carry = 0;
        String result = "";

        while (p1 >= 0 || p2 >=0 ){
            int numA = p1 >= 0 ? (num1.charAt(p1) - '0'):0;
            int numB = p2 >= 0 ? (num2.charAt(p2) - '0'):0;
            int sum = numA + numB + carry;
            carry = sum/10; //Get carry value
            result = String.valueOf(sum % 10) + result;//get Digit
            if(p1 >= 0)p1--;
            if(p2 >= 0)p2--;
        }

        //the rest carry value
        if(carry!=0)result = carry + result;

        return  result == ""? "0":result;

    }
}
