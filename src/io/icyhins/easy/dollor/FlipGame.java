package io.icyhins.easy.dollor;

import java.util.ArrayList;
import java.util.List;

/** 293
 * You are playing the following Flip Game with your friend:
 *
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
 * For example, given s = "++++", after one move, it may become one of the following states:
 * [
 *  "--++",
 *  "+--+",
 *  "++--"
 *
 * If there is no valid move, return an empty list [].
 */
public class FlipGame {

    public static void main(String[] args){
        FlipGame obj = new FlipGame();
        String s = "++++";
        System.out.println(obj.flipGame(s).toString());
    }

    /**
     * We can start from 2nd char, an get the pre char to see both equal '+' or not
     *
     * Yes for replacement & store the result
     *
     * */
    public List<String> flipGame(String s){
        int i = 1;//Start from 2nd char

        List<String> result = new ArrayList<>();
        while (i< s.length()){
            //Judge same as pre char
            if(s.charAt(i-1) == '+' && s.charAt(i) == '+'){
                char[] chS = s.toCharArray();
                chS[i]= '-';
                chS[i-1]= '-';
                result.add(new String(chS));
            }
            i++;
        }

        return result;
    }

}
