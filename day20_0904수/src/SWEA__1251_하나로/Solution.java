package SWEA__1251_하나로;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static class Edge {
		int a, b;
		double val;

		Edge(int a, int b, double val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
	}

	static int[] parents;

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
			int E = V * (V - 1) / 2;
			Edge[] edges = new Edge[E];

			int idx = 0;
			for (int i = 0; i < V; i++) {
				for (int j = i + 1; j < V; j++) {
					int xDiff = x[i] - x[j];
					int yDiff = y[i] - y[j];
					double val = Math.sqrt((long) xDiff * xDiff + (long) yDiff * yDiff);
					edges[idx] = new Edge(i, j, val);
					idx++;
				}
			}

			Arrays.sort(edges, (a, b) -> Double.compare(a.val, b.val));
			
			parents = new int[V];
			for (int i = 0; i < V; i++) {
				parents[i] = i;
			}
			
			int picked = 0;
			double result = 0;
			for (int i=0; i<E; i++) {
				int pa = findSet(edges[i].a);
				int pb = findSet(edges[i].b);
				
				if (pa != pb) {
					parents[pb] = pa;
					picked++;
					result += edges[i].val * edges[i].val * tax;
				}
				
				if (picked == V-1) {
					break;
				}
			}
			
			sb.append(Math.round(result)).append("\n");
		}
		System.out.println(sb);
	}

	static int findSet(int x) {
		if (parents[x] != x) {
			parents[x] = findSet(parents[x]);
		}

		return parents[x];
	}
}