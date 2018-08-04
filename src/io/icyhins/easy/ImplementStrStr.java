package io.icyhins.easy;

/**
 * @author Silver.Kan
 * @date 2018/8/4
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();

        String haystack = "a", needle = "a";

        int index = implementStrStr.strStr(haystack,needle);
        System.out.print(index);
    }

    /**
     * 解题思路：
     * 双指针，p0 遍历 haystack， p1 遍历 needle
     * 当遇到 haystack[p0] == needle[p1], 记录当前p0,并开始遍历needle，
     * 如果 p0 != p1, 则p1 恢复初始位置，并把位置记录恢复为 -1
     * 直到 p1 == needle.length , 则，返回 位置
     * */
    public int strStr(String haystack, String needle) {

        // Corner case
        if(null == haystack || null == needle) return -1;
        if("".equals(needle)) return 0;

        // 双指针
        int p0 = 0, p1 =0;

        // 位置
        int index = -1;

        // 遍历 source
        while (p0 < haystack.length()){
            // 遇到相同字符, 则进行遍历needle对比
            if(haystack.charAt(p0) == needle.charAt(p1)){
                // 临时变量，保存遍历 needle 前的 p0位置
                int curP0 = p0;
                while (p1 < needle.length() && p0 < haystack.length()){
                    // 当遇到不同的字符，则中断比较
                    if(haystack.charAt(p0) != needle.charAt(p1)){
                        p0 = curP0; p1=0;
                        break;
                    }
                    // 指针前进，注意溢出
                    p0++;p1++;
                }
                //如果needle遍历完毕，则成功定位到
                if(p1 == needle.length()) return curP0;
            }
            p0 ++;
        }
        return -1;
    }


    /**
     * 讨论区比较优雅的解法， 直接使用 return 来代替结束循环的条件
     * */
    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
