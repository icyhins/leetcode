package io.icyhins.util;

/**
 * Created by icyhins on 2017/7/4.
 */
public class ListNode {
    public ListNode next;
    public String value;

    public ListNode(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
