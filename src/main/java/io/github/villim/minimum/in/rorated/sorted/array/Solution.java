package io.github.villim.minimum.in.rorated.sorted.array;

import java.util.Arrays;

public class Solution {

	public int findMin(int[] num) {

		boolean isAsn = true;

		if (num[0] > num[num.length - 1]) {
			isAsn = true;
		} else {
			isAsn = false;
		}

		return findMin(num, isAsn);
	}

	private int findMin(int[] num, boolean isAsn) {

		if (num.length == 1)
			return num[0];

		int index = num.length / 2 - 1;

		if (isAsn) {
			if (num[index] > num[index + 1]) {
				return num[index + 1];
			} else if (num[index] < num[index + 1]
					&& num[index] < num[num.length - 1]) {
				int[] newnum = Arrays.copyOfRange(num, 0, index + 1);
				return findMin(newnum, isAsn);
			} else {
				int[] newnum = Arrays.copyOfRange(num, index + 1, num.length);
				return findMin(newnum, isAsn);
			}
		}

		if (!isAsn) {
			if (num[index] < num[index + 1]) {
				return num[index];
			} else if (num[index] > num[index + 1]
					&& num[index] > num[num.length - 1]) {
				int[] newnum = Arrays.copyOfRange(num, 0, index + 1);
				return findMin(newnum, isAsn);
			} else {
				int[] newnum = Arrays.copyOfRange(num, index + 1, num.length);
				return findMin(newnum, isAsn);
			}
		}

		return -1;

	}

}
