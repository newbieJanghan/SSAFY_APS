package SWEA_1232_사칙연산;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {

			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");

			int N = Integer.parseInt(sc.nextLine());

			String[] tree = new String[N + 1];
			// input
			for (int i = 1; i <= N; i++) {
				tree[i] = sc.nextLine();
			}
			
			float result = calculate(tree, 1);
			sb.append((int) Math.floor(result));

			System.out.println(sb);
		}
	}

	static float calculate(String[] tree, int idx) {
		String[] inputs = tree[idx].split(" ");

		if (inputs.length == 2) {
			return (float) Integer.parseInt(inputs[1]);
		}

		String operator = inputs[1];
		int left = Integer.parseInt(inputs[2]);
		int right = Integer.parseInt(inputs[3]);
		if (operator.equals("+")) {
			return calculate(tree, left) + calculate(tree, right);
		} else if (operator.equals("-")) {
			return calculate(tree, left) - calculate(tree, right);
		} else if (operator.equals("*")) {
			return calculate(tree, left) * calculate(tree, right);
		} else {
			return (float) calculate(tree, left) / (float) calculate(tree, right);
		}

	}

}