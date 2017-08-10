package io.icyhins.easy.dollor;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/** 266 Palindrome Permutation
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 *
 * Hint:
 *
 * Consider the palindromes of odd vs even length. What difference do you notice?
 * Count the frequency of each character.
 * If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */
public class PalindromePermutation {

    public static void main(String[] args){
        PalindromePermutation obj = new PalindromePermutation();

        String s = "carerac";

        System.out.println(obj.canPermutePalindrome3(s));

    }

    /**
     * Solution main idea:
     *  if len is odd, only 1 char's total is odd and other's are even.
     *  id len os even , all chars' total should be even.
     *
     * */
    public boolean canPermutePalindrome(String s){
        int len = s.length();
        int[] array = new int['z' + 1];

        for(int i = 0; i < len;i++) {
            array[s.charAt(i)] ++ ;
        }

        //Cal odd chat total
        int totalOddChar = 0;
        for(int i : array){
            if(i%2==1) totalOddChar++;
        }

        return totalOddChar == 0 || (len % 2 == 1 && totalOddChar == 1);
    }


    /**
     * Solution main idea:
     *      As the features of this problem.
     *      We also can use Set to see the final set size
     * */
    public boolean canPermutePalindrome2(String s){
        int len = s.length();
        Set<Character> set = new HashSet();

        for(int i = 0; i < len;i++) {
            Character c = s.charAt(i);
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }

        return set.isEmpty() || (len % 2 == 1 && set.size() == 1);
    }


    /**
     * Solution main idea:
     *      We also can use BitSet to toggle 0 or 1 to see the char appear or not
     *      flip when appear.
     *      Finally return number of bits set to true in this BitSet
     *
     * */
    public boolean canPermutePalindrome3(String s){

        BitSet bs = new BitSet();
        for(char c : s.toCharArray()){
            bs.flip(c);
        }
        //Returns the number of bits set to true in this BitSet.
        return bs.cardinality() < 2;


    }
}
