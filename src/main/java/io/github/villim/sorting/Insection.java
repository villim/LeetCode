package io.github.villim.sorting;

public class Insection implements Sort {

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

			int temp = nums[i];
			nums[i] = nums[minindex];
			nums[minindex] = temp;
		}

		return nums;
	}
}
