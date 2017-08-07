package io.icyhins.easy.dollor;

import java.util.ArrayDeque;
import java.util.Deque;

/** 346 Moving Average from Data Stream
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3

 */
public class MovingAverageFromDataStream {

    public static void main(String[] args){
        MovingAverageFromDataStream obj = new MovingAverageFromDataStream();
        obj.callMovingAverage();
    }

    public void callMovingAverage(){

        MovingAverage m = new MovingAverage(3);

        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));

    }

    /**
     * Solution main idea:
     *
     * Use queue to store the m.next();
     * */
    class MovingAverage{

        int size;

        Deque<Integer> queue = new ArrayDeque<>();


        public MovingAverage(int size){
            this.size = size;
        }

        public double next(int num){
            //Corner case
            if (size == 0)return 0.0;

            //offer under window size
            if(queue.size() >= size){
                queue.pollFirst();
            }
            queue.offerLast(num);

            //Cal average
            int sum  = 0;
            for(int i : queue){
                sum += i;
            }

            return sum*1.0/queue.size();
        }
    }
}
