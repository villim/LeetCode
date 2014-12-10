package io.github.villim.easy.fuzzbuzzwhizz;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzWhizzTest {

	private FizzBuzzWhizz classUnderTest = null;
	HashMap<Integer, String> fbzNumber = null;
	ContainsFBWChain containsFBWChain = null;
	MuliTimesFBWChain multiTimesFBWChain = null;
	// TimesFBWChain timesFBWChain = null;
	NoramlChain normalChain = null;

	@Before
	public void setup() {
		fbzNumber = new HashMap<Integer, String>();
		fbzNumber.put(3, "Fizz");
		fbzNumber.put(5, "Buzz");
		fbzNumber.put(7, "Whizz");

		// configure chains
		normalChain = new NoramlChain();
		// timesFBWChain = new TimesFBWChain(normalChain);
		multiTimesFBWChain = new MuliTimesFBWChain(normalChain);
		containsFBWChain = new ContainsFBWChain(multiTimesFBWChain);

		classUnderTest = new FizzBuzzWhizz();
		classUnderTest.setChain(containsFBWChain);

	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWithFBZNumberIs0() {
		fbzNumber.put(0, "Zeor");
		this.classUnderTest.countOff(fbzNumber, 10);
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWithFBZNumberIsGreaterThan9() {
		fbzNumber.put(10, "GreaterThan9");
		this.classUnderTest.countOff(fbzNumber, 10);
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWithTotalNumberLessThan1() {
		this.classUnderTest.countOff(fbzNumber, 0);
	}

	@Test
	public void testTototalNumberIs10() {
		assertEquals("1,2,Fizz,4,Buzz,Fizz,Whizz,8,Fizz,Buzz",
				this.classUnderTest.countOff(fbzNumber, 10));
	}

	@Test
	public void testTototalNumberIs21() {
		assertEquals(
				"1,2,Fizz,4,Buzz,Fizz,Whizz,8,Fizz,Buzz,11,Fizz,Fizz,Whizz,Buzz,16,Whizz,Fizz,19,Buzz,FizzWhizz",
				this.classUnderTest.countOff(fbzNumber, 21));
	}
}
