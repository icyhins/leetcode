package io.icyhins.easy;

import java.util.List;

/**
 * Write a function to find the longest common prefix(最长公共前缀) string amongst an array of strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args){

        String[] test = new String[1];
        test[0] = "a";
//        test[1] = "aa";
//        test[2] = "aaa";
//        test[3] = "helloSilver";
//        test[4] = "helloCCB";

        System.out.println(longestCommonPrefix(test));

    }

    /** This solution reduce first string to compare
     *  Until match the prefix
     * */
    private static String longestCommonPrefix2(String[] strs){
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

    /**
     * My solution, get char from first string 1 by 1, then compare with others.
     * */
    private static String longestCommonPrefix(String[] strings){

        if(strings.length<=0){
            return "";
        }
        String result = "";
        //Input helloworlditsme,hellodavenice
        //output hello
        String firstStr = strings[0];
        boolean isCommonPrefix = true;

        String tmpPrefix = "";
        for(int i = 0; i < firstStr.length(); i++){
            tmpPrefix += String.valueOf(firstStr.charAt(i));
            for(int j = 1; j < strings.length ; j++){
                isCommonPrefix = strings[j].startsWith(tmpPrefix)?true:false;
                if(!isCommonPrefix)break;
            }
            if(isCommonPrefix)result = tmpPrefix;

        }

        return result;
    }
}
