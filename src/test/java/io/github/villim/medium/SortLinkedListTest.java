package io.github.villim.medium;

import io.github.villim.ListNode;

import org.junit.Before;
import org.junit.Test;

public class SortLinkedListTest {
	private SortLinkedList classUnderTest = new SortLinkedList();

	ListNode head = null;

	@Before
	public void setUp() {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node5 = new ListNode(5);
		node2.next = node5;
		ListNode node7 = new ListNode(7);
		node5.next = node7;
		ListNode node4 = new ListNode(4);
		node7.next = node4;
		ListNode node6 = new ListNode(6);
		node4.next = node6;
		ListNode node3 = new ListNode(3);
		node6.next = node3;
		head = node1;

	}

	@Test
	public void sort() {
		ListNode p = classUnderTest.sortList(head);
		int val = 1;
		while (p.next != null) {
			assert (p.val == val++);
			p = p.next;
		}

	}
}
