package io.icyhins.easy.dollor;

import io.icyhins.util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**252 Meeting Rooms
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return false.
 */
public class MeetingRooms {

    public static void main(String[] args){
        MeetingRooms obj = new MeetingRooms();
        Interval[] intervals = {
                new Interval(0,16),
                new Interval(5,10),
                new Interval(15,20)
        };

        System.out.println(obj.meetingRoom(intervals));

    }

    /**
     * Solution main idea:
     *
     *  sort by start time, and if any the start (i+1) < end(i) , return false.
     *
     * */
    public boolean meetingRoom(Interval[] intervals){
        List<Interval> list = new ArrayList<>();
        //Sort meeting intervals
        Arrays.sort(intervals, Comparator.comparing(Interval::getStart));

        //Loop when start (i) < end(i-1), return false
        int i = 1;
        while(i < intervals.length){
            if(intervals[i-1].end > intervals[i].start) return false;
            i++;
        }

        //No false, return true;
        return true;
    }
}
