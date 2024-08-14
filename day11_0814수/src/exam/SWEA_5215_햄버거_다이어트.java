package exam;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_5215_햄버거_다이어트 {
	static int CALORY_LIMIT;
	static Ingredient[] INGREDIENTS;
	static int TASTE = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			int[] constraints = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int N = constraints[0];
			CALORY_LIMIT = constraints[1];

			INGREDIENTS = new Ingredient[N];
			for (int i = 0; i < INGREDIENTS.length; i++) {
				int[] inputs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				INGREDIENTS[i] = new Ingredient(inputs[0], inputs[1]);
			}

			for (int size = 1; size <= N; size++) {
				combination(new Ingredient[size], 0, 0, 0, 0);
			}

			System.out.println("#" + t + " " + TASTE);
			TASTE = 0;
		}
	}

	static void combination(Ingredient[] sequence, int accCalory, int accTaste, int depth, int start) {
		if (depth == sequence.length) {
			TASTE = Math.max(TASTE, accTaste);
			return;
		}

		for (int i = start; i < INGREDIENTS.length; i++) {
			Ingredient ingredient = INGREDIENTS[i];
			if (accCalory + ingredient.calory > CALORY_LIMIT) {
				continue;
			}
			sequence[depth] = ingredient;

			combination(sequence, accCalory + ingredient.calory, accTaste + ingredient.taste, depth + 1, i + 1);
		}
	}

	static class Ingredient {
		int taste;
		int calory;

		Ingredient(int taste, int calory) {
			this.taste = taste;
			this.calory = calory;
		}
	}
}
