package com.glearning.main;

import com.glearning.node.Node;

public class Main {
	private static Node node;
	static Node otherNode = null;
	static Node rootNode = null;

	static void Conversion(Node root, int key) {
		if (root == null) {
			return;
		}
		if (key > 0) {
			Conversion(root.right, key);
		} else {
			Conversion(root.left, key);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;
		if (rootNode == null) {
			rootNode = root;
			root.left = null;
			otherNode = root;
		} else {
			otherNode.right = root;
			root.left = null;
			otherNode = root;
		}
		if (key > 0) {
			Conversion(leftNode, key);
		} else {
			Conversion(rightNode, key);
		}
	}

	static void RightSkew(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		RightSkew(root.right);
	}

	public static void main(String[] args) {
		Main tree = new Main();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);
		int key = 0;
		Conversion(node, key);
		RightSkew(rootNode);
	}
}