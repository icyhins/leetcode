package io.icyhins.model;

/**
 * Definition for a list node.
 */
public class ListNode {
    public ListNode next;
    public int value;

    public ListNode(int value){
        this.value = value;
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
