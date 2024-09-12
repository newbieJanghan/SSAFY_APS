package SWEA__1970_쉬운거스름돈;

import java.util.Scanner;

public class Solution {
	static int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
	static int[] answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append("\n");
			int N = sc.nextInt();

			answer = new int[8];
			for (int i = 0; i < 8; i++) {
				answer[i] = N / money[i];
				N -= answer[i] * money[i];
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}