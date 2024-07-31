package SWEA_1213_String;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 10;
		while (count-- > 0) {
			int t = sc.nextInt();
			String target = sc.next();
			String string = sc.next();
			int result = 0;
			int fromIdx = 0;
			while (true) {
				fromIdx = string.indexOf(target, fromIdx + 1);
				if (fromIdx == -1) {
					break;
				} else {
					result++;
				}

			}
			System.out.println("#" + t + " " + result);
		}
	}
}