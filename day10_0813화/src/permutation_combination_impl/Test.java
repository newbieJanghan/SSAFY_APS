package permutation_combination_impl;

import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		int[] numbers = { 7, 3, 2, 4, 1, 5, 6 };
		
		Combination c = new Combination(numbers);
		List<int[]> distinct = c.distinct(2);
		for (int[] sequence : distinct) {
			System.out.println(Arrays.toString(sequence));
		}
		System.out.println("*********************");
		List<int[]> repeatible = c.repeatible(2);
		for (int[] sequence : repeatible) {
			System.out.println(Arrays.toString(sequence));
		}
		
		System.out.println("*********************");
		System.out.println("*********************");
		
		Permutation p = new Permutation(numbers);
		distinct = p.distinct(2);
		for (int[] sequence : distinct) {
			System.out.println(Arrays.toString(sequence));
		}

		repeatible = p.repeatible(2);
		for (int[] sequence : repeatible) {
			System.out.println(Arrays.toString(sequence));
		}
	}
}
