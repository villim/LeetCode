package io.github.villim.sorting;

public class Bubble implements Sort {

	public int[] sort(final int[] array) {

		int[] nums = array.clone();

		for (int j = 0; j < nums.length - 1; j++)
			for (int i = 0; i < nums.length - 1 - j; i++) {
				if (nums[i] > nums[i + 1]) {
					swap(nums, i, i + 1);
				}
			}

		return nums;
	}
}
