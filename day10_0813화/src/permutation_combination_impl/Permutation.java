package permutation_combination_impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
	int[] numbers;
	boolean[] visited;
	List<int[]> result;

	Permutation(int[] numbers) {
		this.numbers = numbers;
	}

	public List<int[]> distinct(int groupSize) {
		result = new ArrayList<>();
		visited = new boolean[numbers.length];

		int[] group = new int[groupSize];
		distinct(group, 0);

		return result;
	}

	private void distinct(int[] group, int depth) {
		if (depth == group.length) {
			result.add(Arrays.copyOf(group, group.length));
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			if (!visited[i]) {
				visited[i] = true;
				group[depth] = number;
				distinct(group, depth + 1);
				visited[i] = false;
			}
		}
	}

	public List<int[]> repeatible(int groupSize) {
		result = new ArrayList<>();

		int[] group = new int[groupSize];
		repeatible(group, 0);

		return result;
	}

	private void repeatible(int[] group, int depth) {
		if (depth == group.length) {
			result.add(Arrays.copyOf(group, group.length));
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			group[depth] = number;
			repeatible(group, depth + 1);
		}
	}
}