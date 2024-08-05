package SWEA_8931_제로;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int result = 0;

			int[] numbers = new int[sc.nextInt()];
			int lastIdx = -1;

			for (int i = 0; i < numbers.length; i++) {
				int number = sc.nextInt();
				if (number != 0) {
					if (lastIdx < -1) {
						lastIdx = -1;
					}
					numbers[++lastIdx] = number;
				} else {
					if (lastIdx < 0) {
						lastIdx = 0;
					}
					numbers[lastIdx--] = 0;
				}
			}

			for (int i = 0; i < numbers.length; i++) {
				result += numbers[i];
			}

			System.out.println("#" + t + " " + result);
		}
	}

}