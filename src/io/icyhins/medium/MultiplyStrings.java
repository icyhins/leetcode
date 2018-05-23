package io.icyhins.medium;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @author Silver.Kan
 */
public class MultiplyStrings {

    public static void main(String[] args){
        MultiplyStrings multiplyStrings = new  MultiplyStrings();

        String num1 = "1";
        String num2 = "1";
        System.out.println(multiplyStrings.multiply(num1,num2));
    }

    /**
     * Solution main idea:
     *
     *   123
     *    45
     *________
     *          15 <- num1[2] * num2[2] -> i+j = 4
     *        10   <- num1[1] * num2[2] -> i+j = 3
     *      05     <- num1[0] * num2[2] -> i+j = 2
     * -------
     *        12   <- num1[2] * num2[1] -> i+j = 3
     *      08     <- num1[1] * num2[1] -> i+j = 2
     *    04       <- num1[0] * num2[1] -> i+j = 1
     * ----------------------
     *     5 5  3  5
     *
     * */
    public String multiply(String num1, String num2) {


        int len1 = num1.length();
        int len2 = num2.length();
        int[] pos = new int[len1 + len2];


        for(int i = len1 - 1 ; i >= 0 ; i--){
            for(int j = len2 - 1; j >= 0; j--){
                //Digit mul result
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //push result value to array from end to head
                int next = i + j, cur = i + j + 1;

                //now current pointer is the next point of pre loop
                // sum is mul value + carry value
                int sum = mul + pos[cur];

                // cur value save as digit
                pos[cur] = (sum) % 10;

                //Increase carry value
                pos[next] += sum / 10;

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos){
            //In case leading '0'
            if(!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();

    }
}
