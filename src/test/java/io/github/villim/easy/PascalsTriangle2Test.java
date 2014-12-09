package io.github.villim.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PascalsTriangle2Test {

	private PascalsTriangle2 classUnderTest = new PascalsTriangle2();

	@Test
	public void oneRow() {
		assertEquals("[1]", classUnderTest.getRow(0).toString());
	}

	@Test
	public void towRow() {
		assertEquals("[1, 1]", classUnderTest.getRow(1).toString());
	}

	@Test
	public void threeRow() {
		assertEquals("[1, 2, 1]", classUnderTest.getRow(2).toString());
	}

	@Test
	public void fourRow() {
		assertEquals("[1, 3, 3, 1]", classUnderTest.getRow(3).toString());
	}

	@Test
	public void fiveRow() {
		assertEquals("[1, 4, 6, 4, 1]", classUnderTest.getRow(4).toString());
	}

	@Test
	public void sixRow() {
		assertEquals("[1, 5, 10, 10, 5, 1]", classUnderTest.getRow(5)
				.toString());
	}

	@Test
	public void sevenRow() {
		assertEquals("[1, 6, 15, 20, 15, 6, 1]", classUnderTest.getRow(6)
				.toString());
	}

}
