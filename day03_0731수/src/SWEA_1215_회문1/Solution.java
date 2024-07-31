package SWEA_1215_회문1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			// input
			int N = sc.nextInt();
			char[][] matrix = new char[8][8];
			for (int r = 0; r < 8; r++) {
				char[] cArr = sc.next().toCharArray();
				for (int c = 0; c < 8; c++) {
					matrix[r][c] = cArr[c];
				}
			}
			int result = 0;

			// check horizontal
			for (int r = 0; r < 8; r++) {
				A: for (int c = 0; c <= 8 - N; c++) {
					int fi = c;
					int bi = c + N - 1;
					while (fi < bi) {
						if (matrix[r][fi] != matrix[r][bi]) {
							continue A;
						}
						fi++;
						bi--;
					}
					result++;
				}
			}

			// check vertical
			for (int c = 0; c < 8; c++) {
				A: for (int r = 0; r <= 8 - N; r++) {
					int fi = r;
					int bi = r + N - 1;
					while (fi < bi) {
						if (matrix[fi][c] != matrix[bi][c]) {
							continue A;
						}
						fi++;
						bi--;
					}
					result++;
				}
			}

			System.out.println("#" + t + " " + result);
		}

	}
}