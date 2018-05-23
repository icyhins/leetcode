package io.icyhins.medium;

import io.icyhins.model.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * @author Silver.Kan
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		testCase01();
		testCase02();
		testCase03();
		testCase04();
		testCase05();

	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode rl = new ListNode(-1);
		ListNode tmpl = rl;
		
		// Over flow part
		int overflow = 0;
		while (l1 != null || l2 != null) {
			int l1val = l1 == null ? 0 : l1.value;
			int l2val = l2 == null ? 0 : l2.value;
			int tmpInt = l1val + l2val + overflow;
			// Only get the unit digit
			tmpl.value = tmpInt >= 10 ? tmpInt % 10 : tmpInt;
			//
			overflow = tmpInt >= 10 ? tmpInt / 10 : 0;

			// Next level
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
			// Only when l1/l2 is null and overflow is 0, 
			// then there is no next for the result ListNode
			if (!(l1 == null && l2 == null && overflow == 0)) {
				tmpl.next = new ListNode(overflow);
				tmpl = tmpl.next;
			}
		}

		return rl;
	}

	/**
	 * (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	 * 
	 */
	private static void testCase01() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode rl = addTwoNumbers(l1, l2);

		outputListNode(rl);
	}

	/**
	 * (5) + (5) Output: 0 -> 1
	 * 
	 */
	private static void testCase02() {
		ListNode l1 = new ListNode(5);

		ListNode l2 = new ListNode(5);

		ListNode rl = addTwoNumbers(l1, l2);

		outputListNode(rl);
	}

	/**
	 * (1) + (1 -> 8) Output: 2 -> 8
	 * 
	 */
	private static void testCase03() {
		ListNode l1 = new ListNode(1);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(8);

		ListNode rl = addTwoNumbers(l1, l2);

		outputListNode(rl);
	}

	/**
	 * (1 -> 8) + (0) Output: 1 -> 8
	 * 
	 */
	private static void testCase04() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(8);

		ListNode l2 = new ListNode(0);

		ListNode rl = addTwoNumbers(l1, l2);

		outputListNode(rl);
	}

	/**
	 * (1 -> 8 -> 2) + (1 -> 8 -> 8) Output: 1 -> 6 -> 1 -> 1
	 * 
	 */
	private static void testCase05() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(8);
		l1.next.next = new ListNode(2);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(8);
		l2.next.next = new ListNode(8);

		ListNode rl = addTwoNumbers(l1, l2);

		outputListNode(rl);
	}

	private static void outputListNode(ListNode rl) {
		while (rl != null) {

			if (rl.next != null) {
				System.out.printf("%s->", rl.value);
			} else {
				System.out.println(rl.value);
			}
			rl = rl.next;

		}
	}

}

