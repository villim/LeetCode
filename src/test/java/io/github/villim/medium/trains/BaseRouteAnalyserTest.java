package io.github.villim.medium.trains;

import java.util.Map;

public class BaseRouteAnalyserTest {

	protected int railwaysMap[][] = null;
	protected Map<String, Integer> townName2IdMap = null;

	public BaseRouteAnalyserTest() {
		this.townName2IdMap = TownMapBuilder.buildTownName2IdMap(new String[] { "A", "B", "C", "D", "E" });
		this.railwaysMap = TownMapBuilder.buildRailwayMap(townName2IdMap, new String[] { "A-B-5", "B-C-4", "C-D-8", "D-C-8", "D-E-6",
				"A-D-5", "C-E-2", "E-B-3", "A-E-7" });
	}

}
