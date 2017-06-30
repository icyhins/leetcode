package io.icyhins.easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * click to show spoilers.
 *
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 *
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 *
 * You could also try reversing an integer. However,
 * if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 *
 * There is a more generic way of solving this problem.
 *
 */
public class PalindromeNumber {

    public static void main(String[] args){

        int test = 123321;

        System.out.print(palindromeNumber(test));



    }

    /**
     *
     *  1. Negative num is NOT palindrome.
     *  2. 0 is palindrome.
     *
     *  Main solution is use Math (divide by 10) ， and get the remainder(余数)
     *  to reverse the original number (ie. 1234 -> 4321),
     *  then compare the new number is equal to original number or not
     *
     * */
    private static boolean palindromeNumber(int number){

        if(number < 0){
            return false;
        }else if(number == 0){
            return true;
        }

        int original = number;
        int newNum = 0;

        while(original != 0){
            newNum = newNum * 10 + original % 10;
            original = original / 10;
        }

        return newNum == number;
    }
}
