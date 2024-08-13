package SWEA_1230_암호문3;

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
				char command = sc.next().charAt(0);
				switch (command) {
				case 'I':
					int idx = sc.nextInt();
					int insertCount = sc.nextInt();
					while (insertCount-- > 0) {
						codes.add(idx++, sc.nextInt());
					}
					break;

				case 'D':
					idx = sc.nextInt();
					int deleteCount = sc.nextInt();
					while (deleteCount-- > 0) {
						codes.remove(idx);
					}
					break;

				case 'A':
					int addCount = sc.nextInt();
					while (addCount-- > 0) {
						codes.add(sc.nextInt());
					}
					break;
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