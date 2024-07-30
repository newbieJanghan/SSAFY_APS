package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int result = 0;

			int[][] matrix = new int[N][N];
			Killer killer = new Killer(matrix, M);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// Input
					matrix[r][c] = sc.nextInt();

					// Calculate when it's possible
					result = Math.max(result, killer.kill(r, c));
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

	public static class Killer {
		private int[][] matrix;
		private int range;

		Killer(int[][] matrix, int M) {
			this.matrix = matrix;
			this.range = M;
		}

		int kill(int rIdx, int cIdx) {
			int rowStart = rIdx - range + 1;
			int rowEnd = rIdx;
			int colStart = cIdx - range + 1;
			int colEnd = cIdx;
			if (rowStart < 0 || rowEnd > matrix.length - 1 || colStart < 0 || colEnd > matrix.length - 1) {
				return 0;
			}

			int sum = 0;
			for (int r = rowStart; r <= rowEnd; r++) {
				for (int c = colStart; c <= colEnd; c++) {
					sum += matrix[r][c];
				}
			}

			return sum;
		}
	}
}
