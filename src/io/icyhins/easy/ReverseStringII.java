package io.icyhins.easy;

/**
 * Given a string and an integer k,
 * you need to reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are less than k characters left,
 * reverse all of them.
 * If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 *
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 * Restrictions:
 *  - The string consists of lower English letters only.
 *  - Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {


    public static void main(String[] args){
        ReverseStringII obj = new ReverseStringII();

        String s = "abcdefg";
        int k = 2;

        System.out.println(obj.solution(s, k));
    }

    /****
     * Solution idea:
     * Reverse str[i] to str[i+k],
     * next pointer position is  i = i + k
     * and handle the rest part shorter than then i + k,
     * reverse the (len - i) part
     *
     * k = 2
     *
     * [a b][c d][e f][g]
     *  ^    ^    ^
     *  |    |    |
     *  i   i+k  i+2*k
     *
     * */
    private String solution(String s, int k){
        StringBuilder result = new StringBuilder();
        int i = 0;
        char[] chS = s.toCharArray();
        while(i < chS.length){

            //Reverse Part(From i to i + k - 1)
            int lenCopy = i+k > chS.length?(chS.length - i):k;
            char[] tmp = new char[lenCopy];
            System.arraycopy(chS,i,tmp,0,lenCopy);
            for(int j = tmp.length - 1 ; j >= 0; j--){
                result.append(tmp[j]);
            }
            i = i + k;// point to this direct copy part

            //Direct Copy Part(Copy from i + k to i + 2k)
            lenCopy = i+k > chS.length?(chS.length - i):k;
            for(int j = i; j < i + lenCopy ;j++){
                result.append(chS[j]);
            }
            i = i + k; // point to next reverse part
        }

        return result.toString();

    }



}
