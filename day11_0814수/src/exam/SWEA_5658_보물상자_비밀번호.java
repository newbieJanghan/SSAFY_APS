package exam;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class SWEA_5658_보물상자_비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			Integer K = Integer.parseInt(sc.nextLine().split(" ")[1]);
			String[] nums = sc.nextLine().split("");
			Queue<String> cap = new LinkedList<>();
			for (int i = 0; i < nums.length; i++) {
				cap.add(nums[i]);
			}

			int numberLength = nums.length / 4;
			int cycleCount = nums.length / 4;
			Set<Integer> numberSet = new HashSet<>();

			while (cycleCount-- > 0) {
				// 경우의 수
				int count = 0;
				LinkedList<String> temp = new LinkedList<>();
				while (count++ < nums.length) {
					temp.add(cap.poll());

					if (temp.size() == numberLength) {
						int number = 0;
						while (!temp.isEmpty()) {
							double position = temp.size() - 1;
							String numStr16 = temp.poll();
							number += Math.pow(16, position) * parse16to10(numStr16);

							cap.add(numStr16);
						}
						numberSet.add(number);
						temp.clear();
					}
				}

				// 턴 종료
				/**
				 * 완벽한 시계 방향 회전은 구현하지 못했다. Dequeue 를 잘 다루지 못해 아쉽다.
				 * 하지만 반대로 회전을 해도 단어의 경우의 수는 달라지지 않아서 통과할 수 있었다.
				 */
				cap.add(cap.poll());
			}

			Integer[] sorted = numberSet.stream().sorted((a, b) -> b - a).toArray(Integer[]::new);
			System.out.println("#" + t + " " + sorted[K - 1]);
		}
	}

	static int parse16to10(String string) {
		switch (string) {
		case "A":
			return 10;
		case "B":
			return 11;
		case "C":
			return 12;
		case "D":
			return 13;
		case "E":
			return 14;
		case "F":
			return 15;
		default:
			return Integer.parseInt(string);
		}
	}
}
