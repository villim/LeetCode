package io.github.villim.medium.trains;

import java.util.HashMap;
import java.util.Map;

public final class TownMapBuilder {

	private TownMapBuilder() {
	}

	/**
	 * Build RailwaysMap based on the towns number and railways information
	 * 
	 * For example we have 2 towns A and B {A,B} <br>
	 * and have one railway form A->B with distance 3
	 * 
	 * We will build a two-dimension array <br>
	 * 1. row[0] to represent A and row[1] to represent B <br>
	 * 2. Column[0] means A, column[1] means B <br>
	 * 
	 * the array will look like: <br>
	 * [ <br>
	 * [0,3], //row[0] Town A's railways <br>
	 * [0,0] //row[1] Town B's railways <br>
	 * ]
	 * 
	 * @param townName2IdMap
	 * @param railways
	 *            one railway's format should like "A-B-5", means from town A to
	 *            town B the distance is 5
	 * @return
	 */
	public static int[][] buildRailwayMap(Map<String, Integer> townName2IdMap, String[] railways) {

		if (townName2IdMap == null || townName2IdMap.size() == 0) {
			throw new IllegalArgumentException("The townName2IdMap shouldn't be null or empty!");
		}

		if (railways == null || railways.length == 0) {
			throw new IllegalArgumentException("The railways shouldn't be null or empty!");
		}

		int[][] railwayMap = new int[townName2IdMap.size()][townName2IdMap.size()];

		for (String railway : railways) {

			String[] railwayArray = railway.split("-");

			if (railwayArray.length != 3) {
				throw new IllegalArgumentException("The railway [" + railway + "] is incorrect, format should like 'A-B-5'!");
			}

			String startTownName = railwayArray[0];
			String endTownName = railwayArray[1];
			if (!townName2IdMap.keySet().contains(startTownName)) {
				throw new IllegalArgumentException("The town name [" + startTownName + "] is incorrect!");
			}
			if (!townName2IdMap.keySet().contains(endTownName)) {
				throw new IllegalArgumentException("The town name [" + endTownName + "] is incorrect!");
			}

			int x = townName2IdMap.get(startTownName);
			int y = townName2IdMap.get(endTownName);
			int distance = Integer.valueOf(railwayArray[2]);
			railwayMap[x][y] = distance;
		}

		return railwayMap;
	}

	public static HashMap<String, Integer> buildTownName2IdMap(String[] towns) {

		if (towns == null || towns.length == 0) {
			throw new IllegalArgumentException("Please passin your towns !!");
		}

		HashMap<String, Integer> townName2IdMap = new HashMap<String, Integer>();
		for (int i = 0; i < towns.length; i++) {
			townName2IdMap.put(towns[i], i);
		}
		return townName2IdMap;
	}

}
