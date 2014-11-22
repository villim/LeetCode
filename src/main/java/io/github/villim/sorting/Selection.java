package io.github.villim.sorting;

public class Selection implements Sort {

	@Override
	public int[] sort(final int[] array) {

		int[] nums = array.clone();

		for (int i = 0; i < nums.length - 1; i++) {

			int min = nums[i];
			int minindex = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] <= min) {
					min = nums[j];
					minindex = j;
				}
			}

			swap(nums, i, minindex);
		}

		return nums;
	}
}
