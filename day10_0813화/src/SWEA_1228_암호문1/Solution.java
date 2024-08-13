package SWEA_1228_암호문1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int codeCount = sc.nextInt();
			LinkedList<Integer> codes = new LinkedList<>();
			while (codeCount-- > 0) {
				codes.add(sc.nextInt());
			}

			int commandCount = sc.nextInt();
			while (commandCount-- > 0) {
				String command = sc.next(); // Insert
				int idx = sc.nextInt();
				int insertCount = sc.nextInt();
				while (insertCount-- > 0) {
					codes.add(idx++, sc.nextInt());
				}
			}

			System.out.print("#" + t);
			Iterator<Integer> it = codes.iterator();
			int count = 10;
			while (it.hasNext() && count-- > 0) {
				System.out.print(" " + it.next());
			}
			System.out.println();
		}
	}
}