package 분할정복;

public class MergeSort {
	static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
	static int N = arr.length;
	static int[] result = new int[N];

	public static void main(String[] args) {

	}

	static void sort(int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = left + right / 2;
		sort(left, mid);
		sort(mid + 1, right);
		merge(left, mid, right);
	}

	static void merge(int start, int mid, int end) {
		int left = start, right = mid + 1, index = start;
		while (left <= mid && right <= end) {
			if (arr[left] < arr[end]) {
				result[index++] = arr[left++];
			} else {
				result[index++] = arr[end++];
			}
		}

		if (left <= mid) {
			while (left <= mid) {
				result[index++] = arr[left++];
			}
		} else {
			while (right <= end) {
				result[index++] = arr[right++];
			}
		}
		
		
	}
}
