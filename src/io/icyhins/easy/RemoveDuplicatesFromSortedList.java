package io.icyhins.easy;

import io.icyhins.model.ListNode;

/**
 * @author Silver.Kan
 * @date 2018/7/22
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * 解题思路：
     *
     *  递归访问，把cur节点的cur.next 指针指向 cur.next.next
     *
     * */
    public ListNode deleteDuplicates(ListNode head) {

        helper(head);

        return head;
    }

    /**
     * 递归函数helper 删除重复节点
     * */
    private void helper(ListNode cur){
        // side case
        if(cur == null || cur.next == null){
            return;
        }
        if(cur.val == cur.next.val){
            cur.next = cur.next.next;
        }else {
            cur = cur.next;
        }
        helper(cur);
    }
}
