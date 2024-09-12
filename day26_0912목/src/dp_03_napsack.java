import java.util.Scanner;

public class dp_03_napsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 물건의 개수
		int W = sc.nextInt(); // 배낭의 무게

		int[] weights = new int[N + 1];
		int[] costs = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			costs[i] = sc.nextInt();
		}

		int[][] dp = new int[N + 1][W + 1];

		for (int i = 1; i <= N; i++) {
			for (int w = 0; w <= W; w++) {
				if (weights[i] <= w) {
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + costs[i]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		
		System.out.println(dp[N][W]);
	}
}
