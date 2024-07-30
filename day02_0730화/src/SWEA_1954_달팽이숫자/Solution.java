package SWEA_1954_달팽이숫자;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int dIdx = 0;

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];

			// Initial value 1
			int r = 0;
			int c = 0;
			map[r][c] = 1;

			for (int i = 2; i <= N * N; i++) {
				while (true) {
					// Search valid direction
					// checking there is any value on it or it is out of bounds 
					int nr = r + dr[dIdx];
					int nc = c + dc[dIdx];
					if (nr >= N || nc >= N || nr < 0 || nc < 0 || map[nr][nc] > 0) {
						dIdx = (dIdx + 1) % 4;
					}
					// go
					else {
						r = nr;
						c = nc;
						map[r][c] = i;

						break;
					}
				}
			}

			// print
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
