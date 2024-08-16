package test;

import java.util.Scanner;

public class SWEA_6485_삼성시의_버스_노선 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t);

			int[] stops = new int[5001];
			int busCnt = sc.nextInt();
			while (busCnt-- > 0) {
				int start = sc.nextInt();
				int end = sc.nextInt();

				for (int i = start; i <= end; i++) {
					stops[i]++;
				}
			}

			int printCnt = sc.nextInt();
			while (printCnt-- > 0) {
				sb.append(" " + stops[sc.nextInt()]);
			}

			System.out.println(sb);
		}
	}
}
