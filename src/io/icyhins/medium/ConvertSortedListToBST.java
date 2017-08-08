package io.icyhins.medium;

import io.icyhins.util.ListNode;
import io.icyhins.util.TreeNode;


/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced Binary Search Tree.
 */
public class ConvertSortedListToBST {

    public static void main(String[] args){
        ConvertSortedListToBST obj = new ConvertSortedListToBST();

        ListNode head = new ListNode(1);
        ListNode tmp = head;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(3);
        tmp = tmp.next;
        tmp.next = new ListNode(4);
        tmp = tmp.next;
        tmp.next = new ListNode(5);
        tmp = tmp.next;
        tmp.next = new ListNode(6);
        tmp = tmp.next;
        tmp.next = new ListNode(7);
        tmp = tmp.next;
        tmp.next = new ListNode(8);
        tmp = tmp.next;
        tmp.next = new ListNode(9);
        tmp = tmp.next;

        TreeNode root = obj.sortedListToBST(head);
        System.out.println(root);


    }

    /**
     * Solution main idea:
     *
     *  Like sorted array to BST, we need to find the middle .
     *
     *  For listed node, we use fast pointer & slow pointer to locate middle node
     *
     * */
    public TreeNode sortedListToBST(ListNode head) {

        //Corner case
        if(head == null){
            return null;
        }else if(head.next == null){
            return new TreeNode(head.val);
        }

        ListNode fast = head;
        ListNode slow = head;
        TreeNode root ;

        ListNode dummy = slow;//dummy node point to slow.next head

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            dummy  = slow; //dummy node point to slow.next head
            slow = slow.next;

        }

        //Remove the root from list & break the list
        dummy.next = null;

        root = new TreeNode(slow.val);

        ListNode lHead = head;
        ListNode rHead = slow.next;

        root.left = sortedListToBST(lHead);
        root.right = sortedListToBST(rHead);

        return root;
    }
}
