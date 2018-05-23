package io.icyhins.medium;

import sun.jvm.hotspot.utilities.Assert;

import java.util.*;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 *
 *
 * Rows = 3
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * Rows = 4
 *
 * P     I     N
 * A   L S   I G
 * Y A   H R
 * P     I
 *
 *
 *
 * ABC(2) -> ACB
 *
 * A C
 * B
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 * @author Silver.Kan
 */
public class ZigZagConversion {

    public static void main(String[] args){

        String test = "PAYPALISHIRING";
        String expected = "ACB";

        System.out.println(zigZagConver(test,3));
        //Assert.that(expected.equals(zigZagConversion2(test , 3)),"s");



    }

    /**
     * This solution mind is loop the string and append to result
     * from column TOP to column BOTTOM,
     * then from column BOTTOM to column TOP
     * */
    private static String zigZagConver(String text, int nRows){

        //Each Row as a StringBuilder
        StringBuilder[] sbs = new StringBuilder[nRows];
        //Initial each StringBuilder
        for(int i =0;i<nRows;i++){
            sbs[i] = new StringBuilder("");
        }


        //Loop the String , append char to StringBuilder
        int increase = 0;
        int sbIndex = 0;
        for(int i = 0;i<text.length();i++){
            sbs[sbIndex].append(text.charAt(i));
            //sbIndex increase
            if(sbIndex  == 0){
                increase = 1;
            }
            if (sbIndex == nRows-1){
                //when touch bottom , sbIndex reduce
                increase = -1;
            }
            sbIndex += increase;//Update sbIndex
        }

        String result = "";
        for(StringBuilder sb: sbs){
            result += sb;
        }

        return result;
    }
}
