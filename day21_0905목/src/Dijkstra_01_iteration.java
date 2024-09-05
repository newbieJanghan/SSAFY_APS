

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dijkstra_01_iteration {
	static class Node {
		int V, W;

		public Node(int v, int w) {
			V = v;
			W = w;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();

		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt())); // uni-direction graph
		}

		dist = new int[V];
		Arrays.fill(dist, INF);

		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
	}

	static void dijkstra(int start) {
		boolean[] visited = new boolean[V];

		dist[start] = 0;

		// determine when to finish iteration based on the problem.
		int round = 0;
		while (round++ < V) {
			// 1. pick minimum node
			int min = INF;
			int minNodeIdx = -1;
			for (int i = 0; i < V; i++) {
				if (!visited[i] && dist[i] < min) {
					min = dist[i];
					minNodeIdx = i;
				}
			}
			// can't pick any node to move on
			if (minNodeIdx == -1) {
				break;
			}

			// 2. visit current node
			visited[minNodeIdx] = true;

			// 3. search adjacent nodes of cur node
			for (Node node : adjList[minNodeIdx]) {
				if (!visited[node.V] && dist[node.V] > dist[minNodeIdx] + node.W) {
					dist[node.V] = dist[minNodeIdx] + node.W;
				}
			}	
		}
	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";
}
