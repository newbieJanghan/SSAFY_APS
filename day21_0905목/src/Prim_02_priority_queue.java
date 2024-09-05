import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim_02_priority_queue {
	static final int INF = Integer.MAX_VALUE;

	static class Edge {
		int A, B, W;

		public Edge(int a, int b, int w) {
			this.A = a;
			this.B = b;
			this.W = w;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt();
		int E = sc.nextInt();

		// adjacent list
		List<Edge>[] adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt(), B = sc.nextInt(), W = sc.nextInt();

			adjList[A].add(new Edge(A, B, W));
			adjList[B].add(new Edge(B, A, W));
		}

		boolean[] visited = new boolean[V];
		int ans = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		int pick = 1;
		visited[0] = true;
		pq.addAll(adjList[0]);

		while (pick != V) {
			Edge e = pq.poll();
			if (visited[e.B]) {
				continue;
			}

			ans += e.W;
			visited[e.B] = true;
			pick++;
			
			pq.addAll(adjList[e.B]);
		}

		System.out.println(ans);

	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
