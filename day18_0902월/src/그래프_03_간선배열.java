import java.util.Scanner;

public class 그래프_03_간선배열 {

	static class Edge {
		int A, B, W;

		Edge(int A, int B, int W) {
			this.A = A;
			this.B = B;
			this.W = W;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		// edge by class instance
		Edge[] edges = new Edge[E];
		for (int i=0; i<E; i++) {
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		// edge by integer array
		int[][] edges2 = new int[E][3];
		for (int i=0; i<E; i++) {
			// [ A, B, W ] 
			int[] edge = new int[3];
			for (int j=0; j<3; j++) {
				edge[j] = sc.nextInt();
			}
			edges2[i] = edge;
		}

	}
}
