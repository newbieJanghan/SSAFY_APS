package 위상정렬;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TopologicalSortStack {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	
	static int V, E;
	static int[][] adjArr;
	static int[] degree;
	static boolean[] visited;
	static Deque<Integer> answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();

		adjArr = new int[V + 1][V + 1];
		degree = new int[V + 1];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adjArr[A][B] = 1;
			degree[B]++;
		}

		visited = new boolean[V + 1];
		answer = new ArrayDeque<>();
		for (int i = 1; i < V + 1; i++) {
			if (degree[i] == 0) {
				dfs(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!answer.isEmpty()) {
			sb.append(cook[answer.pop()]).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int start) {
		for (int i = 1; i < V + 1; i++) {
			if (adjArr[start][i] == 1) {
				visited[i] = true;
				dfs(i);
			}
		}

		answer.push(start);
	}

	static String input = "9 9\r\n" + "	1 4\r\n" + "	1 8\r\n" + "	2 3\r\n" + "	4 3\r\n" + "	8 5\r\n"
			+ "	3 5\r\n" + "	5 6\r\n" + "	9 6\r\n" + "	6 7";
}