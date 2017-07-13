package io.icyhins.easy;

/**
 * Given a roman numeral,
 * convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Roman's Rule
 * 1. I (1), V(5), X(10), L(50), C(100), D(500), M(1000)
 * 2. Max repeat times for same Char is 3
 * 3. Left part is plus & right part is sub (Only for I X C)
 */
public class Roman2Integer {

    public static void main(String[] args){
        Roman2Integer obj = new Roman2Integer();

        System.out.println(obj.solution("DCXXI"));
    }

    public int solution(String s){
        if(s == null || s.length() <= 0){
            return 0;
        }

        int sum = 0;

        char[] chS = new char[s.length()+1];//The last pointer for comparison is out of the string.
        System.arraycopy(s.toCharArray(),0,chS,0,s.length());

        for(int i = 0;i < chS.length;i++){

            switch (chS[i]){
                case 'I': sum = chS[i + 1]  == 'V'||chS[i + 1] == 'X' ? sum - 1:sum + 1;
                    break;
                case 'V': sum += 5;
                    break;
                case 'X': sum = chS[i + 1]  == 'L'||chS[i + 1] == 'C' ? sum - 10:sum + 10;
                    break;
                case 'L': sum += 50;
                    break;
                case 'C': sum = chS[i + 1]  == 'D'||chS[i + 1] == 'M' ? sum - 100:sum + 100;
                    break;
                case 'D': sum += 500;
                    break;
                case 'M': sum += 1000;
                    break;
            }
        }

        return sum;
    }
}
