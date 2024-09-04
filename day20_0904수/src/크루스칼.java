import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 크루스칼 {
	static class Edge {
		int A, B, W;

		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}
	}

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		Edge[] edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			edges[i] = new Edge(A, B, W);
		}
		
		Arrays.sort(edges, (a, b) -> a.W - b.W);
		
//		int[][] edges2 = new int[E][3];
//		Arrays.sort(edges2, new Comparator<int[]>() {
//			public int compare(int[] o1, int[] o2) {
//				return o1[2] - o2[2];
//			}
//		});

		p = new int[V];
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}

		int ans = 0;
		int pick = 0;

		for (int i = 0; i < E; i++) {
			int x = edges[i].A;
			int y = edges[i].B;

//			if (findSet(x) != findSet(y)) {
//				union(x, y);
//				ans += edges[i].W;
//				pick++;
//			}

			int px = findSet(x);
			int py = findSet(y);
			if (px != py) {
				p[py] = px;
				ans += edges[i].W;
				pick++;
			}

			if (pick == V - 1) {
				break;
			}
		}

		System.out.println(ans);
	}

	static void makeSet(int x) {
		p[x] = x;
	}

	static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}

		return p[x];
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}
