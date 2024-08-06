package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		while (tc-- > 0) {
			int t = sc.nextInt();
			int result = power(sc.nextInt(), sc.nextInt());
			System.out.println("#" + t + " " + result);
		}
		
	}
	
	public static int power(int val, int count) {
		if (count == 1) {
			return val;
		}
		return val * power(val, count -1);
	}
}