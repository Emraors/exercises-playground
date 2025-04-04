package com.example.binary_tree_DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeetCodeBinaryTreeDFS {

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		return Objects.equals(getLeaves(root1), getLeaves(root2));
	}

	private List<Integer> getLeaves(TreeNode root) {
		List<Integer> leaves = new ArrayList<>();
		addLeaves(root, leaves);
		return leaves;
	}

	private void addLeaves(TreeNode tree, List<Integer> leavesList) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null)
			leavesList.add(tree.val);
		else {
			addLeaves(tree.left, leavesList);
			addLeaves(tree.right, leavesList);
		}
	}

	public int goodNodes(TreeNode root) {
		if (root == null)
			return 0;
		return goodNodes(root, root.val);
	}
	
	private int goodNodes(TreeNode root, int currentMax) {
		if (root == null) {
			return 0;
		}
		return root.val >= currentMax
				? 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val)
				: goodNodes(root.left, currentMax) + goodNodes(root.right, currentMax);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "TreeNode{" +
					"val=" + val +
					", left=" + left +
					", right=" + right +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			TreeNode treeNode = (TreeNode) o;
			return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right,
					treeNode.right);
		}

		@Override
		public int hashCode() {
			return Objects.hash(val, left, right);
		}
	}
}
