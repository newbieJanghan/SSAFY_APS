package SWEA_7102_준홍이의카드놀이;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] sumCounts = new int[N + M + 1];
			int max = 0; // max sumCount

			// sum 값의 출현 빈도 계산
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					int sum = i + j;
					sumCounts[sum]++;
					max = Math.max(max, sumCounts[sum]);
				}
			}

			// print
			System.out.print("#" + t);
			for (int sum = 2; sum <= N + M; sum++) {
				if (sumCounts[sum] == max) {
					System.out.print(" " + sum);
				}
			}
			System.out.println();

		}
	}
}