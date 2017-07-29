package io.icyhins.easy.dollor;

/** 157 Read N Characters Given Read4
 * Read N Characters Given Read4 Total
 * The API:
 *      int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read.
 * For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 *
 * Note:
 * The read function will only be called once for each test case.
 */
public class ReadNCharactersGivenRead4 {

    public static void main(String[] args){
        ReadNCharactersGivenRead4 obj = new ReadNCharactersGivenRead4 ();
        char[] buf = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','s','t','u','v','t','u','v'};
        int n = 20;

        System.out.println(buf.length);
        System.out.println(obj.read(buf,n));
    }

    /**
     * Solution main idea:
     *
     *      we will use the API read4(char[] buf), so read 4 char each time.
     *
     * */
    public int read(char[] buf, int n){
        int result = 0;

        for(int i = 0; i < buf.length ; i += 4){
            //Clean tmp each time
            char[] tmp = new char[4];
            //Copy 4 char from buf until is done.
            System.arraycopy(buf, i,tmp,0,Math.min(buf.length - i,4));
            //System.out.println(Arrays.toString(tmp));
            int len = read4(tmp);
            if(len == 0) break;
            result += len;
        }

        return Math.min(result,n);
    }

    private int read4(char[] buf){
        int len = 0;
        for(int i= 0 ;i < buf.length || i < 4; i++){
            //System.out.print("[" +(buf[i] + 0) + "]");
            if(buf[i] >= 'A'){
                len++;
            }
        }

        return len;
    }


}
