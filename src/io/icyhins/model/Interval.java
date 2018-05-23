package io.icyhins.model;

/**
 * Created by icyhins on 2017/8/4.
 */
public class Interval {
    public int start;
    public int end;
    public Interval() {
        start = 0;
        end = 0;
    }
    public Interval(int s, int e) {
        start = s;
        end = e;
    }
    public  int getStart(){
        return this.start;
    }
    public  int getEnd(){
        return this.end;
    }
}
