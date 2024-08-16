package test;

import java.util.Scanner;

public class SWEA_21886_스위치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] switches = new boolean[sc.nextInt() + 1];
		for (int i = 1; i < switches.length; i++) {
			switches[i] = sc.nextInt() == 1;
		}

		int trialCnt = sc.nextInt();
		while (trialCnt-- > 0) {
			int gender = sc.nextInt();
			int target = sc.nextInt();

			switch (gender) {
			case 1:
				for (int i = target; i < switches.length; i += target) {
					switches[i] = !switches[i];
				}

				break;
			default:
				int l = target;
				int r = target;

				while (switches[l] == switches[r] && l >= 1 && r < switches.length) {
					switches[l] = !switches[l];
					if (l != r) {
						switches[r] = !switches[r];
					}

					l--;
					r++;
				}

				break;

			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < switches.length; i++) {
			int status = switches[i] ? 1 : 0;
			sb.append(status + " ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
