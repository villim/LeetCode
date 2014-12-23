package io.github.villim.medium.trains;

import java.util.HashMap;
import java.util.Map;

public abstract class RouteAnalyser {

	protected Map<String, Integer> townName2IdMap = null;
	protected Map<Integer, String> id2TownNameMap = null;
	protected int[][] railwaysMap = null;

	public RouteAnalyser(Map<String, Integer> townName2IdMap, int[][] railwaysMap) {
		this.townName2IdMap = townName2IdMap;
		this.railwaysMap = railwaysMap;

		if (townName2IdMap != null) {
			id2TownNameMap = new HashMap<Integer, String>();
			for (String key : townName2IdMap.keySet()) {
				id2TownNameMap.put(Integer.valueOf(townName2IdMap.get(key)), key);
			}
		}
	}
}
