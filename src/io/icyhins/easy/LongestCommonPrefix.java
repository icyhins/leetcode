package io.icyhins.easy;

import java.util.List;

/**
 * Write a function to find the longest common prefix(最长公共前缀) string amongst an array of strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args){

        String[] test = new String[3];
        test[0] = "c";
        test[1] = "c";
        test[2] = "c";
//        test[3] = "helloSilver";
//        test[4] = "helloCCB";

        System.out.println(longestCommonPrefix(test));

    }

    /** This solution reduce first string to compare
     *  Until match the prefix
     * */
    private static String longestCommonPrefix(String[] strs){
        //Null check
        if(strs == null || strs.length == 0)    return "";

        //first string as prefix
        String pre = strs[0];
        int i = 1;//comparion start with second string

        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)//Judge the prefix is match or not.
                pre = pre.substring(0,pre.length()-1);//Not match, reduce prefix string
            i++;
        }
        return pre;
    }
}
