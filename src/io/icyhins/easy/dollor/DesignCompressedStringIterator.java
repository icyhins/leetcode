package io.icyhins.easy.dollor;

import java.util.ArrayDeque;
import java.util.Deque;

/** 604
 * Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

 The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

 next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
 hasNext() - Judge whether there is any letter needs to be uncompressed.

 Note:
 Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

 Example:

 StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

 iterator.next(); // return 'L'
 iterator.next(); // return 'e'
 iterator.next(); // return 'e'
 iterator.next(); // return 't'
 iterator.next(); // return 'C'
 iterator.next(); // return 'o'
 iterator.next(); // return 'd'
 iterator.hasNext(); // return true
 iterator.next(); // return 'e'
 iterator.hasNext(); // return false
 iterator.next(); // return ' '
 */
public class DesignCompressedStringIterator {


    public static void main(String[] args){
        DesignCompressedStringIterator obj = new DesignCompressedStringIterator();
        obj.callStringIterator("L1e5t1C7o1d9e1");

    }


    public void callStringIterator(String s){
        StringIterator iterator = new StringIterator(s);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }



}

/**
 * This problem main idea is using Queue to store each group include [char, number]
 *
 * In construct method, use char - 'A'(ASCII code is 65) < 0 to judge the char is letter or number.
 *
 * hasNext(): if the queue is empty , return false, else true;
 *
 * next(): peek the top , and check the count of num have been reduce to 0 or not( poll it of yes)
 * empty queue return ' '.
 *
 * */
class StringIterator {
    private Deque<int[]> queue = new ArrayDeque<>();

    public StringIterator(String s){
        int current = 0;
        int size = s.length();

        while (current < size){
            int numCurrent = current + 1;//num pointer

            while (numCurrent < size
                    && s.charAt(numCurrent) - 'A' < 0)//Judge the char is letter or number
                // Here we also can use Character.isDigit() for judgement
                numCurrent++; // number char. move the num pointer

            queue.add(new int[]{s.charAt(current) - 'A' ,// char
                    Integer.parseInt(s.substring(current+1, numCurrent))});

            current = numCurrent;
        }

    }

    public Character next(){
        if(queue.isEmpty()) return ' ';
        int[] top = queue.peek();
        if(-- top[1] == 0) //reduce & judge the num is 0
            queue.poll();
        //How above code work.
//        top[1] = top[1] - 1;
//        if(top[1]== 0){
//            queue.poll();
//        }
        return (char) ('A' + top[0]);
    }

    public boolean hasNext(){
        return !queue.isEmpty();
    }
}



