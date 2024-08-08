package Queue2;

import java.util.Arrays;

/**
 * 이미 정렬된 데이터가 많고 새로 들어올 데이터가 적을 때
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 69, 10, 30, 2, 16, 8, 31, 22 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int unsorted = arr[i];
			// j: sorted, ASC
			int j;
			for (j = i - 1; j >= 0 && arr[j] > unsorted; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = unsorted;
		}
	}
}
