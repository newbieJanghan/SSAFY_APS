package Stack2;

public class Stack2_Factorial {
	public static void main(String[] args) {
		System.out.println(factorial(10));
	}

	static int factorial(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}
