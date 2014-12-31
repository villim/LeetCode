package io.github.villim.medium;

/**
 * “在这个图片里我们有不同高度的墙。这个图片由一个整数数组所代表，数组中每个数是墙的高度。
 * 
 * 上边的图可以表示为数组[2,5,1,2,3,4,7,7,6]”
 * 
 * “假如开始下雨了，那么墙之间的水坑能够装多少水呢？”
 * 
 * @author villim
 *
 */
public class VolumeOfWater {

	public int caculateVolume(int[] terrain) {

		if (terrain == null | terrain.length <= 0) {
			throw new IllegalArgumentException("terrain can't empty!");
		}

		int len = terrain.length;

		int cusorLeft = 0;
		int maxLeft = terrain[0];
		int cusorRight = len - 1;
		int maxRight = terrain[len - 1];

		int volume = 0;

		while (cusorLeft < cusorRight) {
			if (maxLeft <= maxRight) {
				if (terrain[cusorLeft] <= maxLeft) {
					volume = volume + maxLeft - terrain[cusorLeft];
					cusorLeft++;
					continue;
				} else {
					maxLeft = terrain[cusorLeft];
					continue;
				}
			} else {
				if (terrain[cusorRight] <= maxRight) {
					volume = volume + maxRight - terrain[cusorRight];
					cusorRight--;
					continue;
				} else {
					maxRight = terrain[cusorRight];
					continue;
				}
			}
		}

		return volume;
	}

}
