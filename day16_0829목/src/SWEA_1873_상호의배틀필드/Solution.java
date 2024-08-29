package SWEA_1873_상호의배틀필드;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	static HashMap<Character, Character> turn;
	static HashMap<Character, int[]> directions;
	static {
		turn = new HashMap<>();
		turn.put('U', '^');
		turn.put('D', 'v');
		turn.put('L', '<');
		turn.put('R', '>');

		directions = new HashMap<>();
		directions.put('^', new int[] { -1, 0 });
		directions.put('v', new int[] { 1, 0 });
		directions.put('<', new int[] { 0, -1 });
		directions.put('>', new int[] { 0, 1 });

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");

			int H = sc.nextInt(), W = sc.nextInt();
			// inputs
			int th = 0, tw = 0; // tank
			char tank = '>';
			char[][] map = new char[H][W];

			for (int h = 0; h < H; h++) {
				String input = sc.next();
				for (int w = 0; w < W; w++) {
					char c = input.charAt(w);
					if (c == '^' || c == '>' || c == '<' || c == 'v') {
						th = h;
						tw = w;
						tank = c;
					}
					map[h][w] = c;
				}
			}

			// execute commands
			int commandCnt = sc.nextInt();
			String commands = sc.next();
			for (int i = 0; i < commandCnt; i++) {
				char command = commands.charAt(i);

				switch (command) {
				case 'U':
				case 'D':
				case 'L':
				case 'R':
					tank = turn.get(command); // turn tank
					map[th][tw] = tank;

					int nh = th + directions.get(tank)[0];
					int nw = tw + directions.get(tank)[1];
					if (0 <= nh && nh < H && 0 <= nw && nw < W && map[nh][nw] == '.') {
						map[th][tw] = '.'; // set current cell as field

						th = nh;
						tw = nw;
						map[th][tw] = tank; // set new tank position
					}

					break;
				case 'S':
					// shoot height, shoot width
					int sh = th + directions.get(tank)[0];
					int sw = tw + directions.get(tank)[1];
					while (0 <= sh && sh < H && 0 <= sw && sw < W) {
						if (map[sh][sw] == '*') { // brick wall
							map[sh][sw] = '.';
							break;
						} else if (map[sh][sw] == '#') { // iron wall
							break;
						}

						sh += directions.get(tank)[0];
						sw += directions.get(tank)[1];
					}

					break;
				default:
					break;
				}
			}

			for (int i = 0; i < H; i++) {
				char[] row = map[i];
				for (char c : row) {
					sb.append(c);
				}
				if (i != H - 1) {
					sb.append("\n");
				}
			}

			System.out.println(sb);
		}
	}
}