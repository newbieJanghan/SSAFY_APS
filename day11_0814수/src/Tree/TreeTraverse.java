package Tree;

public class TreeTraverse {
	static char[] tree = { 0, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 0, 0, 'H', 'I' };

	public static void main(String[] args) {
		preorder(1);
		inorder(1);
		postorder(1);
	}

	// 전위 순회 V L R
	public static void preorder(int root) {
		if (root >= tree.length || tree[root] == 0) {
			return;
		}

		int left = 2 * root;
		int right = 2 * root + 1;

		visit(root);
		preorder(left); // L
		preorder(right); // R
	}

	// 중위 순회 L V R
	public static void inorder(int root) {
		if (root >= tree.length || tree[root] == 0) {
			return;
		}

		int left = 2 * root;
		int right = 2 * root + 1;

		inorder(left);
		visit(root);
		inorder(right);
	}

	// 후위 순회 L R V
	public static void postorder(int root) {
		if (root >= tree.length || tree[root] == 0) {
			return;
		}

		int left = 2 * root;
		int right = 2 * root + 1;

		inorder(left);
		inorder(right);
		visit(root);
	}
	
	private static void visit(int root) {
		System.out.print(tree[root] + " ->");
	}
}
