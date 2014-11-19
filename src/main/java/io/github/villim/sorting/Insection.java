package io.github.villim.sorting;

public class Insection implements Sort {

	@Override
	public int[] sort(final int[] array) {

		int[] nums = array.clone();

		int[] result = new int[nums.length];
		initResultArray(nums, result);

		for (int i = 2; i < nums.length; i++) {
			for (int j = 0; j < i - 1; j++) {
				if (nums[i] > result[j] && nums[i] < result[j + 1]) {

					for (int z = i - 1; z >= j + 1; z--) {
						result[z + 1] = result[z];
					}

					result[j + 1] = nums[i];
					break;
				}

				if (nums[i] <= result[j]) {
					for (int z = i - 1; z >= j; z--) {
						result[z + 1] = result[z];
					}
					result[j] = nums[i];
					break;
				}

				if (nums[i] >= result[i - 1]) {
					result[i] = nums[i];
					break;
				}
			}
		}

		return result;
	}

	private void initResultArray(int[] nums, int[] result) {
		if (nums[0] < nums[1]) {
			result[0] = nums[0];
			result[1] = nums[1];
		} else {
			result[0] = nums[1];
			result[1] = nums[0];
		}
	}
}
