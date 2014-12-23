package io.github.villim.medium.trains;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class TownMapBuiderTest {

	@Before
	public void setup() {
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowErrorWhenParameterIsNullToBuildIdMap() {
		TownMapBuilder.buildTownName2IdMap(new String[] {});
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowErrorWhenParameterIsNullToBuildTownsMap() {
		HashMap<String, Integer> name2id = TownMapBuilder.buildTownName2IdMap(new String[] { "A", "B" });
		TownMapBuilder.buildRailwayMap(name2id, new String[] {});
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowErrorWhenParameterIsNullToBuildTownsMapWhenRailysInvalid() {
		HashMap<String, Integer> name2id = TownMapBuilder.buildTownName2IdMap(new String[] { "A", "B" });
		TownMapBuilder.buildRailwayMap(name2id, new String[] { "AB5", "CDa6" });
	}

	@Test
	public void buildOnlyOneTown() {
		HashMap<String, Integer> oneTownName2IdMap = TownMapBuilder.buildTownName2IdMap(new String[] { "A" });
		assertEquals("{A=0}", oneTownName2IdMap.toString());
		int[][] oneTownMap = TownMapBuilder.buildRailwayMap(oneTownName2IdMap, new String[] { "A-A-0" });
		assertEquals("[[0]]", Arrays.deepToString(oneTownMap));
	}

	@Test
	public void buildWithTwoTowns() {
		HashMap<String, Integer> twoTownsName2IdMap = TownMapBuilder.buildTownName2IdMap(new String[] { "A", "B" });
		assertEquals("{A=0, B=1}", twoTownsName2IdMap.toString());
		int[][] oneTownMap = TownMapBuilder.buildRailwayMap(twoTownsName2IdMap, new String[] { "A-B-2" });
		assertEquals("[[0, 2], [0, 0]]", Arrays.deepToString(oneTownMap));
	}

	@Test
	public void buildWithFiveTowns() {
		HashMap<String, Integer> fiveTownsName2IdMap = TownMapBuilder.buildTownName2IdMap(new String[] { "A", "B", "C", "D", "E" });
		assertEquals("{A=0, B=1, C=2, D=3, E=4}", fiveTownsName2IdMap.toString());
		int[][] oneTownMap = TownMapBuilder.buildRailwayMap(fiveTownsName2IdMap, new String[] { "A-B-5", "B-C-4", "C-D-8", "D-C-8",
				"D-E-6", "A-D-5", "C-E-2", "E-B-3", "A-E-7" });
		assertEquals("[[0, 5, 0, 5, 7], [0, 0, 4, 0, 0], [0, 0, 0, 8, 2], [0, 0, 8, 0, 6], [0, 3, 0, 0, 0]]",
				Arrays.deepToString(oneTownMap));
	}

}
