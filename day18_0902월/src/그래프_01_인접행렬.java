import java.util.Scanner;

public class 그래프_01_인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt(); // 만약 가중치가 있다면

			adjArr[A][B] = 1; // OR W
			adjArr[B][A] = 1; // 무향 그래프라면 반대 경우 작성
			
			adjArr[A][B] = adjArr[B][A] = 1; // 한 줄 작성
		}
	}
}
