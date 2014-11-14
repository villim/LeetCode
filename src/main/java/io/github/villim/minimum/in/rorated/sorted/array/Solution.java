package io.github.villim.minimum.in.rorated.sorted.array;

import java.util.Arrays;

public class Solution {

	public int findMin(int[] num) {

		if (num.length == 1)
			return num[0];

		int index = num.length / 2 - 1;

		if (num[index] > num[index + 1]) {
			return num[index + 1];
		} else if (num[index] < num[index + 1]
				&& num[index] < num[num.length - 1]) {
			int[] newnum = Arrays.copyOfRange(num, 0, index + 1);
			return findMin(newnum);
		} else {
			int[] newnum = Arrays.copyOfRange(num, index + 1, num.length);
			return findMin(newnum);
		}

	}

}
