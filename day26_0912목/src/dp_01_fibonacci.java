import java.util.Scanner;

public class dp_01_fibonacci {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		System.out.println(fibo3(N));
		System.out.println(fibo2(N));
		System.out.println(fibo1(N));
	}

	static int fibo3(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		return dp[n];
	}

	// memoization
	static int[]  memo = new int[1000];
	static {
		memo[0] = 0;
		memo[1] = 1;
	}
	static int fibo2(int n) {
		if (n >= 2 && memo[n] == 0) {
			memo[n] = fibo2(n - 1) + fibo2(n - 2);
		}

		return memo[n];
	}

	// manually
	static int[] callFibo = new int[1000];
	
	static int fibo1(int n) {
		callFibo[n]++;

		if (n <= 1) {
			return n;
		}

		return fibo1(n - 1) + fibo1(n - 2);
	}
}
