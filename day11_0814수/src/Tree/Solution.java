package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();

		Map<Integer, Node> nodeMap = new HashMap<>();
		Node root = null;
		Node vertex = null;
		
		int count = 0;
		while (count++ < 2 * V) {
			int parentVal = sc.nextInt();
			int childVal = sc.nextInt();

			if (vertex == null) {
				vertex = new Node(parentVal);
			}

			if (vertex.value != parentVal) {
				vertex = nodeMap.get(parentVal);
			}

			if (vertex.left == null) {
				vertex.left = new Node(childVal);
				nodeMap.put(vertex.left.value, vertex.left);
			} else {
				vertex.right = new Node(childVal);
				nodeMap.put(vertex.right.value, vertex.right);
			}
			
			nodeMap.put(vertex.value, vertex);

			if (root == null) {
				root = vertex;
			}

			if (childVal == V) {
				break;
			}
		}

		System.out.print("preorder: "); 
		preorder(root);
		System.out.println();
		
		System.out.print("inorder: ");
		inorder(root);
		System.out.println();
		
		System.out.print("postorder: ");
		postorder(root);

	}

	static class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
		}
	}

	static void preorder(Node root) {
		if (root == null) {
			return;
		}
		visit(root);
		preorder(root.left);
		preorder(root.right);
	}
	
	static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		visit(root);
		inorder(root.right);
	}
	
	static void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		visit(root);
	}

	static void visit(Node node) {
		System.out.print(node.value + " -> " );
	}
}