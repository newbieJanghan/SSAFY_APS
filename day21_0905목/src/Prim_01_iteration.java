import java.util.Arrays;
import java.util.Scanner;

public class Prim_01_iteration {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt();
		int E = sc.nextInt();

		// adjacent matrix
		int[][] adjArr = new int[V][V];
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			adjArr[A][B] = adjArr[B][A] = W;
		}

		boolean[] visited = new boolean[V];
		int[] from = new int[V];
		Arrays.fill(from, -1);
		int[] dist = new int[V];
		Arrays.fill(dist, INF);

		dist[0] = 0;
		int ans = 0;

		int round = 0;
		while (round++ < V) {
			// pick minimum edge from i
			int min = INF;
			int idx = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			// check other vertex
			visited[idx] = true;

			// accumulate it's distance from i to result
			ans += dist[idx];

			// update target vertex's edge weight to minimum value;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					from[j] = idx;
				}
			}
		}

		System.out.println(ans);

	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
