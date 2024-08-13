package permutation_combination_impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
	int[] numbers;
	boolean[] visited;
	List<int[]> sequences;
	int size;

	Combination(int[] numbers) {
		this.numbers = numbers;
	}

	public List<int[]> distinct(int size) {
		sequences = new ArrayList<>();
		visited = new boolean[numbers.length];
		this.size = size;

		distinct(0, 0);

		return sequences;
	}

	private void distinct(int depth, int start) {
		if (depth == size) {
			int[] sequence = new int[size];
			for (int i = 0, j = 0; i < visited.length && j < size; i++, j++) {
				if (visited[i]) {
					sequence[j] = numbers[i];
				}
			}

			sequences.add(sequence);
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				distinct(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	public List<int[]> repeatible(int size) {
		sequences = new ArrayList<>();
		this.size = size;
		
		repeatible(new int[size], 0, 0);

		return sequences;
	}

	private void repeatible(int[] sequence, int depth, int start) {
		if (depth == size) {
			sequences.add(Arrays.copyOf(sequence, size));

			return;
		}

		for (int i = start; i < numbers.length; i++) {
			System.out.println("i: " + i + " in depth: " + depth);
			sequence[depth] = numbers[i];
			repeatible(sequence, depth + 1, i);
		}
	}
}
