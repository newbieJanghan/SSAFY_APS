package 백트래킹;

import java.util.Arrays;

public class 순열02_swap {
	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2, 3 };
		N = nums.length;

		perm(0);
	}

	static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(nums));
		}

		for (int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx);
		}

	}

	static void swap(int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
