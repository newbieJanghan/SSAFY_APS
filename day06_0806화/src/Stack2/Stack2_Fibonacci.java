package Stack2;

public class Stack2_Fibonacci {
	public static void main(String[] args) {
		System.out.println(mFibo(45));
		System.out.println(fibonacci(45));
	}

	// 재귀함수가 간결하긴 하지만 시간 복잡도 측면에서 반복문이 효율적일 수 있음.
	static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	// memoization 을 활용하는 것은 dynamic programming 의 일종
	// 최대값은 임의로
	static int[] dp = new int[500];
	static int mFibo(int n) {
		if (n <= 1) {
			return n;
		}
		if (dp[n] > 0) {
			return dp[n];
		}
		return dp[n] = mFibo(n - 1) + mFibo(n - 2);
	}
}
