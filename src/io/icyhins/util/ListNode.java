package io.icyhins.util;

/**
 * Definition for a list node.
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
