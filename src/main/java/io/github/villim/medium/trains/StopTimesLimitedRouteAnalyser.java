package io.github.villim.medium.trains;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StopTimesLimitedRouteAnalyser extends RouteAnalyser {

	public enum StopTimesLimitStrategy {
		Equals, NoMoreThan;
	}

	private List<String> routes = null;

	public StopTimesLimitedRouteAnalyser(Map<String, Integer> townName2IdMap, int[][] railwaysMap) {
		super(townName2IdMap, railwaysMap);
	}

	public int getRoutesWithStopTimesLimit(String startTownName, String endTownName, int stopTimes, StopTimesLimitStrategy strategy) {
		validateParameter(startTownName, endTownName, stopTimes);

		routes = new ArrayList<String>();
		findRoutes(townName2IdMap.get(startTownName), townName2IdMap.get(endTownName), stopTimes, startTownName, strategy);
		return routes.size();
	}

	private void findRoutes(int start, int end, int stopnum, String route, StopTimesLimitStrategy strategy) {

		if (stopnum == 1) {
			if (railwaysMap[start][end] > 0) {
				routes.add(route + id2TownNameMap.get(end));
			}
			return;
		}

		for (int i = 0; i < railwaysMap[start].length; i++) {
			if (railwaysMap[start][i] > 0) {
				String newRoute = route + id2TownNameMap.get(i);
				if (strategy.equals(StopTimesLimitStrategy.NoMoreThan) && i == end) {
					routes.add(newRoute);
				}
				findRoutes(i, end, stopnum - 1, newRoute, strategy);
			}
		}

	}

	private void validateParameter(String startTownName, String endTownName, int stopNumber) {
		if (startTownName == null || endTownName == null || stopNumber <= 0) {
			throw new IllegalArgumentException("Please input correct stopNumber, startTownName and endTownName");
		}

		if (!townName2IdMap.keySet().contains(startTownName) || !townName2IdMap.keySet().contains(endTownName)) {
			throw new IllegalArgumentException("Please make shure [" + startTownName + "] and [" + endTownName
					+ "] using correct town name!");
		}
	}
}
