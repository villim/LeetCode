package io.github.villim.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ <br>
 * [1], <br>
 * [1,1], <br>
 * [1,2,1], <br>
 * [1,3,3,1], <br>
 * [1,4,6,4,1],<br>
 * [1,5,10,10,5,1]<br>
 * ]
 * 
 * @author villim
 *
 */
public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {

		ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = null;
		int i = 0;
		while (i < numRows) {
			row = (ArrayList<Integer>) getNextRow(row);
			list.add(row);
			i++;
		}
		return list;
	}

	private ArrayList<Integer> getNextRow(List<Integer> previousRow) {

		if (previousRow == null || previousRow.size() == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			return list;
		}

		if (previousRow.size() == 1) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			list.add(1);
			return list;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= previousRow.size(); i++) {
			if (i == 0) {
				list.add(previousRow.get(i));
				continue;
			}

			if (i < previousRow.size()) {
				list.add(previousRow.get(i - 1) + previousRow.get(i));
			}

			if (i == previousRow.size()) {
				list.add(previousRow.get(i - 1));
			}
		}

		return list;
	}
}
