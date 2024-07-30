package SWEA_1209_Sum;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		while (tc-- > 0) {
			int t = sc.nextInt();
			int result = 0;

			// Input
			int[][] matrix = new int[100][100];
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					matrix[r][c] = sc.nextInt();
				}
			}

			// Calculate sum row by row
			for (int r = 0; r < 100; r++) {
				int sum = 0;
				for (int c = 0; c < 100; c++) {
					sum += matrix[r][c];
				}
				result = Math.max(result, sum);
			}

			// sum col by col
			for (int c = 0; c < 100; c++) {
				int sum = 0;
				for (int r = 0; r < 100; r++) {
					sum += matrix[r][c];
				}
				result = Math.max(result, sum);
			}

			// sum NW => SE cross
			int dr = 1;
			int dc = 1;
			int nr = 0;
			int nc = 0;
			int sum = 0;
			while (nr < 100 & nc < 100) {
				sum += matrix[nr][nc];
				nr += dr;
				nc += dc;
						
			}
			result = Math.max(result, sum);
			
			// sum NE => SW cross
			dr = -1;
			dc = -1;
			nr = 99;
			nc = 99;
			sum = 0;
			while (nr >= 0 & nc >= 0) {
				sum += matrix[nr][nc];
				nr += dr;
				nc += dc;
			}
			result = Math.max(result, sum);

			System.out.println("#" + t + " " + result);	
		}
	}
}