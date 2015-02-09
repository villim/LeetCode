package io.github.villim.medium;

import io.github.villim.ListNode;

/**
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author villim
 *
 */
public class SortLinkedList {
	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		int length = 0;
		ListNode currentNode = head;
		while (currentNode.next != null) {
			length++;
			currentNode = currentNode.next;
		}

		int pivot = length / 2;
		ListNode pivotHead = head;
		for (int i = 0; i < pivot; i++) {
			pivotHead = pivotHead.next;
		}

		ListNode rightHead = pivotHead.next;
		pivotHead.next = null;

		return merge(sortList(head), sortList(rightHead));
	}

	private ListNode merge(ListNode leftHead, ListNode rightHead) {

		ListNode newHead = new ListNode(0);
		ListNode pointer = newHead;
		ListNode left = leftHead;
		ListNode right = rightHead;

		while (left != null && right != null) {
			if (left.val > right.val) {
				pointer.next = right;
				pointer = right;
				right = right.next;
			} else {
				pointer.next = left;
				pointer = left;
				left = left.next;
			}
		}

		while (left != null) {
			pointer.next = left;
			pointer = left;
			left = left.next;
		}

		while (right != null) {
			pointer.next = right;
			pointer = right;
			right = right.next;
		}

		return newHead.next;
	}
}