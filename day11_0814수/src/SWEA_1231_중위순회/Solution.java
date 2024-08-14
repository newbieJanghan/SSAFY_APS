package SWEA_1231_중위순회;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {

			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");

			int N = Integer.parseInt(sc.nextLine());
			char[] tree = new char[N + 1];
			for (int i = 1; i <= N; i++) {
				String[] inputs = sc.nextLine().split(" ");
				tree[i] = inputs[1].charAt(0);
			}

			Traverse traverse = new Traverse(tree, sb);
			traverse.inorder(1);

			System.out.println(sb);
		}
	}

	static class Traverse {
		char[] tree;
		StringBuilder sb;

		Traverse(char[] tree, StringBuilder sb) {
			this.tree = tree;
			this.sb = sb;
		}

		void inorder(int root) {
			if (root < 1 || root >= tree.length) {
				return;
			}

			int left = 2 * root;
			int right = 2 * root + 1;

			inorder(left);
			visit(root);
			inorder(right);
		}

		private void visit(int idx) {
			sb.append(tree[idx]);
		}
	}
}