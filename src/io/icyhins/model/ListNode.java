package io.icyhins.model;

/**
 * Definition for a list node.
 */
public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString(){
        return String.valueOf(val);
    }
}
