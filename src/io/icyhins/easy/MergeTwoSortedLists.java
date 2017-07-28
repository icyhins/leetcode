package io.icyhins.easy;

import io.icyhins.util.ListNode;


/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {


    public static void main(String[] args){
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);

        System.out.println(obj.mergeTwoLists(l1,l2));

    }

    /**
     * Solution main idea:
     *
     * Create a head node to save head position and
     * and a current node to save the new list tail;
     *
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0), cur = head;

        while ( l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            //Move current node pointer
            cur = cur.next;
        }

        //For rest part of linked list
        cur.next = l1 !=null ? l1:l2;

        return head.next;
    }

    /**
     * Recursion solution
     * */
    public ListNode mergeTwoListsR(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = (l1.val < l2.val) ? l1 : l2;
        ListNode nonhead = (l1.val < l2.val) ? l2 : l1;
        head.next = mergeTwoListsR(head.next, nonhead);
        return head;
    }

    /**
     * Recursion solution 2
     * */
    public ListNode mergeTwoListsR2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsR2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsR2(l1, l2.next);
            return l2;
        }
    }
}
