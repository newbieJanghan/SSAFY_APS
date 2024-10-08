package test;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_21885_신입사원_분반_교육 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			int[] constraints = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int studentCnt = constraints[0];
			int MIN = constraints[1];
			int MAX = constraints[2];
			int result = 1000;

			int[] scores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] scoreCnt = new int[101];
			int highDiv = 0, lowDiv = 100;
			for (int score : scores) {
				if (highDiv < score) {
					highDiv = score;
				}
				if (lowDiv > score) {
					lowDiv = score;
				}
				scoreCnt[score]++;
			}

			int highCnt = 0, lowCnt = 0, midCnt = 0;
			for (int score = lowDiv; score < highDiv; score++) {
				if (scoreCnt[score] == 0) {
					continue;
				}

				highCnt = scoreCnt[highDiv];
				lowCnt += scoreCnt[score];
				midCnt = studentCnt - (highCnt + lowCnt);
				
				if (midCnt < MIN) {
					break;
				}

				if (MIN <= lowCnt && lowCnt <= MAX && MIN <= midCnt && midCnt <= MAX && MIN <= highCnt
						&& highCnt <= MAX) {
					int diff = Math.max(highCnt, Math.max(midCnt, lowCnt))
							- Math.min(highCnt, Math.min(midCnt, lowCnt));
					result = Math.min(result, diff);
				}
			}

			highCnt = 0;
			lowCnt = 0;
			midCnt = 0;
			for (int score = highDiv; score > lowDiv; score--) {
				if (scoreCnt[score] == 0) {
					continue;
				}

				highCnt += scoreCnt[score];
				lowCnt = scoreCnt[lowDiv];
				midCnt = studentCnt - (highCnt + lowCnt);
				
				if (midCnt < MIN) {
					break;
				}

				if (MIN <= lowCnt && lowCnt <= MAX && MIN <= midCnt && midCnt <= MAX && MIN <= highCnt
						&& highCnt <= MAX) {
					int diff = Math.max(highCnt, Math.max(midCnt, lowCnt))
							- Math.min(highCnt, Math.min(midCnt, lowCnt));
					result = Math.min(result, diff);
				}
			}

			if (result == 1000) {
				result = -1;
			}

			System.out.println("#" + t + " " + result);
		}
	}
}
