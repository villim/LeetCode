package io.github.villim.medium;

import io.github.villim.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 * 
 * @author williamwang
 *
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean isCarry = false;
		ListNode rtnNode = null;

		ListNode currentL1 = l1;
		ListNode currentL2 = l2;
		ListNode currentRtnNode = null;

		while (currentL1 != null || currentL2 != null) {
			int il1 = currentL1 == null ? 0 : currentL1.val;
			int il2 = currentL2 == null ? 0 : currentL2.val;

			int value = computerNodeValue(isCarry, il1, il2);
			isCarry = value >= 10 ? true : false;
			value = value >= 10 ? value - 10 : value;

			if (currentRtnNode == null) {
				rtnNode = new ListNode(value);
				currentRtnNode = rtnNode;
			} else {
				ListNode newNode = new ListNode(value);
				currentRtnNode.next = newNode;
				currentRtnNode = currentRtnNode.next;
			}

			currentL1 = currentL1 == null ? null : currentL1.next;
			currentL2 = currentL2 == null ? null : currentL2.next;
		}

		if (isCarry) {
			ListNode newNode = new ListNode(1);
			currentRtnNode.next = newNode;
			currentRtnNode = currentRtnNode.next;
		}

		return rtnNode;
	}

	private int computerNodeValue(boolean isCarry, int currentL1, int currentL2) {
		int value = currentL1 + currentL2;

		if (isCarry) {
			value = value + 1;
		}
		return value;
	}

}
