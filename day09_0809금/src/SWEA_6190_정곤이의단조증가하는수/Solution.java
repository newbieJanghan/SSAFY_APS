package SWEA_6190_정곤이의단조증가하는수;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}

			int result = -1;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int number = nums[i] * nums[j];
					if (check(number) && result < number) {
						result = number;
					}
				}
			}

			System.out.println("#" + t + " " + result);

		}
	}

	public static boolean check(int number) {
		String string = (number + "");
		if (string.length() == 1) {
			return true;
		}

		for (int i = 0; i < string.length() - 1; i++) {
			int int1 = Character.getNumericValue(string.charAt(i));
			int int2 = Character.getNumericValue(string.charAt(i + 1));

			if (int1 >= int2)
				return false;

		}
		return true;
	}
}