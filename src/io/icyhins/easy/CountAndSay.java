package io.icyhins.easy;

/**
 * @author Silver.Kan
 * @date 2018/8/4
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 7.     13112221
 * 8.     1113213211
 * 9.     31131211131221
 * 10.    13211311123113112211
 *
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 *
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */
public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(6));
    }

    /**
     * 解题思路：
     *
     * 如果使用递归解题， 当n 大一点的时候（例如1000）
     * 就会OutOfMemoryError, 应该是因为压栈占用内存太多
     *
     * */
    public String countAndSay(int n) {

        String oldString = "1";

        for (int i = 1; i < n; i++) {
            oldString  = countString(oldString);
        }
        return oldString;
    }

    private String countString(String str){
        String say = "";

        // 统计
        int count = 0;
        char currentChar = str.charAt(0);

        // 遍历当前string
        for (int i = 0; i < str.length(); i++) {
            //
            if(currentChar != str.charAt(i)){
                //并入结果
                say = say+String.valueOf(count)+String.valueOf(currentChar);
                // 保存当前char
                currentChar = str.charAt(i);
                // 恢复统计数
                count = 1;
            }else {
                // 相同char 则累加
                count++;
            }

            //结尾处理
            if(i == str.length() -1){
                say = say+String.valueOf(count)+String.valueOf(currentChar);
            }
        }

        return say;
    }

}
