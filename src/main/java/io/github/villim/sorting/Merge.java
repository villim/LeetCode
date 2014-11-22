package io.github.villim.sorting;

public class Merge implements Sort {

	@Override
	public int[] sort(final int[] array) {
		int[] nums = array.clone();

		if (nums.length == 1) {
			return nums;
		}

		int pivot = nums.length / 2;
		int[] left = new int[pivot];
		System.arraycopy(nums, 0, left, 0, left.length);
		int[] right = new int[nums.length - pivot];
		System.arraycopy(nums, pivot, right, 0, right.length);

		left = sort(left);
		right = sort(right);

		nums = mergeSortedSub(left, right);

		return nums;
	}

	private int[] mergeSortedSub(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];

		int x = 0, y = 0;

		for (int i = 0; i < result.length; i++) {

			if (x > left.length - 1) {
				result[i] = right[y];
				y++;
				continue;
			}

			if (y > right.length - 1) {
				result[i] = left[x];
				x++;
				continue;
			}

			if (x <= left.length - 1 && y <= right.length - 1) {
				if (left[x] < right[y]) {
					result[i] = left[x];
					x++;
				} else {
					result[i] = right[y];
					y++;
				}
				continue;
			}

		}

		return result;
	}

}
