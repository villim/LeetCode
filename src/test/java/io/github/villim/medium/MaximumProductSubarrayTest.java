package io.github.villim.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumProductSubarrayTest {
	private MaximumProductSubarray classUnderTest = new MaximumProductSubarray();

	@Test
	public void getMax() {
		int[] nums = { 2, 3, -2, 4 };
		assertEquals(6, classUnderTest.maxProduct(nums));

		nums = new int[] { -1, -1 };
		assertEquals(1, classUnderTest.maxProduct(nums));

		nums = new int[] { -2, 3, -4 };
		assertEquals(24, classUnderTest.maxProduct(nums));

		nums = new int[] { -2 };
		assertEquals(-2, classUnderTest.maxProduct(nums));

		nums = new int[] { 0, 2 };
		assertEquals(2, classUnderTest.maxProduct(nums));

		nums = new int[] { -2, 0, -1 };
		assertEquals(0, classUnderTest.maxProduct(nums));

		nums = new int[] { 3, -1, 4 };
		assertEquals(4, classUnderTest.maxProduct(nums));

		nums = new int[] { -3, 0, 1, -2 };
		assertEquals(1, classUnderTest.maxProduct(nums));

		nums = new int[] { 2, -5, -2, -4, 3 };
		assertEquals(24, classUnderTest.maxProduct(nums));
	}
}
