package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		while (tc-->0) {
			int t = sc.nextInt();
			int number = sc.nextInt();
			int exponent = sc.nextInt();

			System.out.println("#" + t + " " + power(number, exponent));
		}
	}

	static int power(int number, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		
		int temp;
		if (exponent % 2 == 0) {
			temp = power(number, exponent / 2);
			return temp * temp;
		} else {
			temp = power(number, (exponent - 1) / 2);;
			return temp * temp * number;
		}
	}
}