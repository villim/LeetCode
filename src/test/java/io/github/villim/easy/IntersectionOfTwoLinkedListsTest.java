package io.github.villim.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntersectionOfTwoLinkedListsTest {

	private IntersectionOfTwoLinkedLists classUnderTest = new IntersectionOfTwoLinkedLists();

	private ListNode list01256 = null;

	private ListNode list1256 = null;

	private ListNode list3456 = null;

	private ListNode list78 = null;

	private ListNode list91011128 = null;

	@Before
	public void setup() {
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node0.next = node1;
		node1.next = node2;
		node2.next = node5;
		node5.next = node6;

		list01256 = node0;
		list1256 = node1;

		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		node4.next = node5;

		list3456 = node3;

		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		node7.next = node8;

		list78 = node7;

		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(10);
		ListNode node11 = new ListNode(11);
		ListNode node12 = new ListNode(12);
		node9.next = node10;
		node10.next = node11;
		node11.next = node12;
		node12.next = node8;
		list91011128 = node9;

	}

	@Test
	public void noIntersection() {
		Assert.assertNull(this.classUnderTest.getIntersectionNode(list01256,
				list78));

		Assert.assertNull(this.classUnderTest.getIntersectionNode(null, list78));

		Assert.assertNull(this.classUnderTest.getIntersectionNode(list3456,
				null));
	}

	@Test
	public void findIntersection() {
		ListNode intersection = null;

		intersection = this.classUnderTest.getIntersectionNode(list01256,
				list3456);
		assertEquals(5, intersection.val);

		intersection = this.classUnderTest.getIntersectionNode(list1256,
				list3456);
		assertEquals(5, intersection.val);

		intersection = this.classUnderTest.getIntersectionNode(list78,
				list91011128);
		assertEquals(8, intersection.val);
	}
}
