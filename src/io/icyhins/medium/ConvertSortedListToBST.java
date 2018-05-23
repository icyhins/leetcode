package io.icyhins.medium;

import io.icyhins.model.ListNode;
import io.icyhins.model.TreeNode;


/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced Binary Search Tree.
 * @author Silver.Kan
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
            return new TreeNode(head.value);
        }

        ListNode fast = head;
        ListNode slow = head;
        TreeNode root ;

        //dummy node point to slow.next head
        ListNode dummy = slow;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            //dummy node point to slow.next head
            dummy  = slow;
            slow = slow.next;

        }

        //Remove the root from list & break the list
        dummy.next = null;

        root = new TreeNode(slow.value);

        ListNode lHead = head;
        ListNode rHead = slow.next;

        root.left = sortedListToBST(lHead);
        root.right = sortedListToBST(rHead);

        return root;
    }
}
