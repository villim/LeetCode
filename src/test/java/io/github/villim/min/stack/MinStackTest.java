package io.github.villim.min.stack;

import org.junit.Assert;
import org.junit.Test;

public class MinStackTest {
	private MinStack3 classUnderTest = new MinStack3();

	@Test
	public void testStack() {

		this.classUnderTest.push(1);
		this.classUnderTest.push(2);

		this.classUnderTest.pop();

		Assert.assertEquals(1, this.classUnderTest.top());
	}

	@Test
	public void testGetMin() {
		this.classUnderTest.push(4);
		this.classUnderTest.push(2);
		this.classUnderTest.push(1);
		this.classUnderTest.push(2);

		Assert.assertEquals(1, this.classUnderTest.getMin());
	}

	@Test
	public void test() {
		classUnderTest.push(512);
		classUnderTest.push(-1024);
		classUnderTest.push(-1024);
		classUnderTest.push(512);

		classUnderTest.pop();
		Assert.assertEquals(-1024, classUnderTest.top());

		classUnderTest.pop();
		Assert.assertEquals(-1024, classUnderTest.top());

		classUnderTest.pop();
		Assert.assertEquals(512, classUnderTest.top());

	}

}
