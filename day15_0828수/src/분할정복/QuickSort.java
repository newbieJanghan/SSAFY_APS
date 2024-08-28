package 분할정복;

import java.util.Arrays;

public class QuickSort {
	static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };

	public static void main(String[] args) {
		sort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int left, int right) {
		if (left < right) {
			int pivot = lomutoPartition(left, right);
			sort(left, pivot - 1);
			sort(pivot + 1, right);
		}
	}

	static int hoarePartition(int left, int right) {
		int pivot = arr[left], L = left + 1, R = right;
		
		while (L <= R) {
			while (L <= R && arr[L] <= pivot) {
				L++;
			}

			while (R > left && arr[R] > pivot) {
				R--;
			}

			if (L < R) {
				int temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}

		}

		arr[left] = arr[R];
		arr[R] = pivot;
		
		return R;
	}

	static int lomutoPartition(int left, int right) {
		int pivot = arr[right];
		int L = left - 1; // pivot 보다 작은 값들의 경계
		for (int R = left; R < right; R++) {
			if (arr[R] <= pivot) {
				L++;
				if (L != R) {
					int temp = arr[L];
					arr[L] = arr[R];
					arr[R] = temp;
				}
			}
		}

		arr[right] = arr[L + 1];
		arr[L + 1] = pivot;

		return L + 1;

	}
}
