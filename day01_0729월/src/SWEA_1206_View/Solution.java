package SWEA_1206_View;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			int[] list = new int[N + 4];
			int result = 0;

			// Mapping
			for (int n = 2; n < N + 2; n++) {
				list[n] = sc.nextInt();
			}

			// 좌우 2칸씩 탐색
			for (int i = 2; i < N + 2; i++) {
				int F = list[i];
				int L1 = list[i - 1];
				int L2 = list[i - 2];
				int R1 = list[i + 1];
				int R2 = list[i + 2];

				// 시야 갖힌 경우 무시
				if (L1 >= F)
					continue;
				if (L2 >= F)
					continue;
				if (R1 >= F)
					continue;
				if (R2 >= F)
					continue;

				result += F - Math.max(Math.max(L1, L2), Math.max(R1, R2));
			}

			System.out.println("#" + t + " " + result);

		}
	}

}
