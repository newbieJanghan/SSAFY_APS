package 분할정복;

import java.util.Arrays;

public class MergeSort {
	static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
	static int[] temp = new int[arr.length];

	public static void main(String[] args) {
		sort(0, arr.length - 1);
		System.out.println(Arrays.toString(temp));
	}

	static void sort(int start, int end) {

		if (start >= end) {
			return;
		}

		int mid = (start + end) / 2;
		sort(start, mid);
		sort(mid + 1, end);
		merge(start, mid, end);
	}

	static void merge(int start, int mid, int end) {
		int L = start, R = mid + 1, index = start;

		while (L <= mid && R <= end) {
			if (arr[L] < arr[R]) {
				temp[index++] = arr[L++];
			} else {
				temp[index++] = arr[R++];
			}
		}

		if (L <= mid) {
			while (L <= mid) {
				temp[index++] = arr[L++];
			}
		} else {
			while (R <= end) {
				temp[index++] = arr[R++];
			}
		}
		
		for (int i = start; i <= end; i++) {
			arr[i] = temp[i];
		}

	}
}
