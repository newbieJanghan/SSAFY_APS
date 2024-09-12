import java.util.Scanner;

public class dp_02_coins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int money = sc.nextInt();
		int[] dp = new int[money + 1];

		for (int i = 1; i <= money; i++) {
			int minCnt = dp[i - 1] + 1; // 1원짜리 계산

			if (i >= 4) { // 4원짜리 계산
				minCnt = Math.min(minCnt, dp[i - 4] + 1);
			}

			if (i >= 6) { // 6원짜리 계산
				minCnt = Math.min(minCnt, dp[i - 6] + 1);
			}

			dp[i] = minCnt;
		}
		
		System.out.println(dp[money]);
	}
}
