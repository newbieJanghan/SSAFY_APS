package SWEA_1208_flatten;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			int[] map = new int[100];
			int min = 100;
			int max = 0;

			// Mapping
			for (int i = 0; i < 100; i++) {
				int val = sc.nextInt();
				min = Math.min(min, val);
				max = Math.max(max, val);

				map[val - 1]++;
			}

			// Calculating
			while (N > 0) {
				map[min - 1]--;
				map[min]++;
				map[max - 1]--;
				map[max - 2]++;
				N--;

				while (map[min - 1] == 0) {
					min++;
				}
				while (map[max - 1] == 0) {
					max--;
				}
			}

			System.out.println("#" + t + " " + (max - min));
		}
	}

}
