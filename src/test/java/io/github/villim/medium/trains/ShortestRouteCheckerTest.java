package io.github.villim.medium.trains;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ShortestRouteCheckerTest extends BaseRouteAnalyserTest {
	private ShortestRouteAnalyser classUnderTest = null;

	@Before
	public void setup() {
		this.classUnderTest = new ShortestRouteAnalyser(townName2IdMap, railwaysMap);
	}

	@Test
	public void shortestRoute() {
		assertEquals(9, this.classUnderTest.getTheShortestRoute("A", "C"));
		assertEquals(4, this.classUnderTest.getTheShortestRoute("B", "C"));
		assertEquals(9, this.classUnderTest.getTheShortestRoute("B", "B"));
	}
}
