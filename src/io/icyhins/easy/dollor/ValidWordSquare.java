package io.icyhins.easy.dollor;

import java.util.ArrayList;
import java.util.List;

/** 422 Valid Word Square
 * Given a sequence of words, check whether it forms a valid word square.
 *
 * A sequence of words forms a valid word square if the kth row and column read the exact same string,
 * where 0 ≤ k < max(numRows, numColumns).
 *
 * Note:
 * The number of words given is at least 1 and does not exceed 500.
 * Word length will be at least 1 and does not exceed 500.
 * Each word contains only lowercase English alphabet a-z.
 *
 * Example 1:
 *
 * Input:
 * [
 * "abcd",
 * "bnrt",
 * "crmy",
 * "dtye"
 * ]
 *
 * Output:
 * true
 *
 * Explanation:
 * The first row and first column both read "abcd".
 * The second row and second column both read "bnrt".
 * The third row and third column both read "crmy".
 * The fourth row and fourth column both read "dtye".
 *
 * Therefore, it is a valid word square.
 *
 * Example 2:
 *
 * Input:
 * [
 * "abcd",
 * "bnrt",
 * "crm",
 * "dt"
 * ]
 *
 * Output:
 * true
 *
 * Explanation:
 * The first row and first column both read "abcd".
 * The second row and second column both read "bnrt".
 * The third row and third column both read "crm".
 * The fourth row and fourth column both read "dt".
 *
 * Therefore, it is a valid word square.
 * Example 3:
 *
 * Input:
 * [
 * "ball",
 * "area",
 * "read",
 * "lady"
 * ]
 *
 * Output:
 * false
 *
 * Explanation:
 * The third row reads "read" while the third column reads "lead".
 *
 * Therefore, it is NOT a valid word square
 */
public class ValidWordSquare {

    public static void main(String[] args){
        ValidWordSquare obj = new ValidWordSquare();

        List<String> words = new ArrayList<>();
        words.add("abcd");
        System.out.println(obj.validWordSquare(words));
    }

    /***
     * Solution main idea:
     *
     *   compare char[row][col] by char[col][row]
     *
     * */
    public boolean validWordSquare(List<String> words){

        for(String s : words){
            if(s.length() > words.size()) return false;
        }

        for (int row = 0 ; row < words.size(); row++){
            for(int col = 0; col < words.get(row).length(); col ++){

                if(col >= words.size() || // col pointer should not over row size
                   row >= words.get(col).length() || // row pointer should not over col size
                   words.get(col).charAt(row) != words.get(row).charAt(col)//compare char
                        )
                    return false;
            }
        }

        return true;

    }
}
