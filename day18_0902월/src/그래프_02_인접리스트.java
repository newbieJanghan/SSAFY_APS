import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		List<Integer>[] adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt(); // 만약 가중치가 있다면

			adjList[A].add(B);
			adjList[B].add(A);
		}
	}
	
	/**
	 * 인접 행렬 VS. 인접 리스트
	 * 
	 * 1. 정점의 개수는 큰데 막상 간선이 적은 경우에 인접 리스트가 효율적.
	 *    메모리 낭비가 없기 때문. 
	 * 2. 단순히 i to j 가 연결되어있는가?만 확인하려면 인접 행렬이 효율적. 
	 * 	  인접 리스트는 리스트 내부를 순회해야 하기 때문.
	 */
}
