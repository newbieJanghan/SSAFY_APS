package SWEA__1251_하나로;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			int V = Integer.parseInt(sc.nextLine());
			int[] x = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] y = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			double tax = Double.parseDouble(sc.nextLine());

			double[][] adjArr = new double[V][V];

			for (int i = 0; i < V; i++) {
				for (int j = i + 1; j < V; j++) {
					int xDiff = x[i] - x[j];
					int yDiff = y[i] - y[j];
					double dist = Math.sqrt((long) xDiff * xDiff + (long) yDiff * yDiff);
					adjArr[i][j] = adjArr[j][i] = dist;
				}
			}
			boolean[] visited = new boolean[V];
			double[] dist = new double[V];
			Arrays.fill(dist, Integer.MAX_VALUE);

			// pick first element
			dist[0] = 0;
			double answer = 0d;

			int round = 0;
			while (round++ < V) {
				double min = Double.MAX_VALUE;
				int idx = -1;
				for (int j = 0; j < V; j++) {
					if (!visited[j] && dist[j] < min) {
						idx = j;
						min = dist[j];
					}
				}

				visited[idx] = true;
				answer += dist[idx] * dist[idx] * tax;

				for (int j = 0; j < V; j++) {
					if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
						dist[j] = adjArr[idx][j];
					}
				}
			}

			sb.append(Math.round(answer)).append("\n");
		}
		System.out.println(sb);
	}

}