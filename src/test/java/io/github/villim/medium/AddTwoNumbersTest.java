package io.github.villim.medium;

import static org.junit.Assert.assertEquals;
import io.github.villim.ListNode;

import org.junit.Before;
import org.junit.Test;

public class AddTwoNumbersTest {
	AddTwoNumbers classUnderTest = new AddTwoNumbers();

	private ListNode l243 = null;
	private ListNode l564 = null;
	private ListNode l0 = null;

	@Before
	public void setup() {
		l243 = new ListNode(2);
		ListNode l243of4 = new ListNode(4);
		ListNode l243of3 = new ListNode(3);
		l243.next = l243of4;
		l243of4.next = l243of3;

		l564 = new ListNode(5);
		ListNode l564of6 = new ListNode(6);
		ListNode l564of4 = new ListNode(4);
		l564.next = l564of6;
		l564of6.next = l564of4;

		l0 = new ListNode(0);

	}

	@Test
	public void testSameLenthList() {
		ListNode rtnValue = this.classUnderTest.addTwoNumbers(l243, l564);
		assertEquals(7, rtnValue.val);
		assertEquals(0, rtnValue.next.val);
		assertEquals(8, rtnValue.next.next.val);
	}

	@Test
	public void testDifferentLenthList() {
		ListNode rtnValue = this.classUnderTest.addTwoNumbers(l243, l0);
		assertEquals(2, rtnValue.val);
		assertEquals(4, rtnValue.next.val);
		assertEquals(3, rtnValue.next.next.val);
	}
}
