package io.icyhins.medium;

import io.icyhins.model.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * @author Silver.Kan
 */
public class RemoveNthNodeFromEndOfList {

    private ListNode solution(ListNode head, int n){

        int count = 0;

        Deque<ListNode> queue = new ArrayDeque<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while(pointer!= null){
            count++;
            if(count > n + 1){
                queue.pollFirst();
                queue.offerLast(pointer);
            }else{
                queue.offerLast(pointer);
            }

            pointer = pointer.next;
        }

        //L(N-n)
        pointer = queue.getFirst();
        if(pointer.next!=null){
            pointer.next = pointer.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);


        int n = 1;
        sysout(head);
        System.out.println();
        head = obj.solution(head, n);
        sysout(head);

    }

    private static void sysout(ListNode head){
        while(head != null){
            System.out.print(head);
            System.out.print(" --> ");
            head = head.next;

        }
    }
}
