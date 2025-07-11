package com.example.binary_tree;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeBinaryTree {

	private final Map<Key, Integer> memoizationMap = new HashMap<>();

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

	public int pathSum(TreeNode root, int targetSum) {
		HashMap<Long, Integer> sumMap = new HashMap<>();
		sumMap.put(0L, 1);
		return pathsNumDFS(root, 0L, targetSum, sumMap);
	}

	private int pathsNumDFS(TreeNode root, long currentSum, int targetSum, Map<Long, Integer> sumMap) {
		if (root == null) {
			return 0;
		}
		currentSum = currentSum + root.val;
		int numPaths = sumMap.getOrDefault(currentSum - targetSum, 0);

		sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
		numPaths = numPaths
				+ pathsNumDFS(root.left, currentSum, targetSum, sumMap)
				+ pathsNumDFS(root.right, currentSum, targetSum, sumMap);
		sumMap.put(currentSum, sumMap.get(currentSum) - 1);

		return numPaths;
	}

	public int longestZigZag(TreeNode root) {
		return dfsZigZagMem(root);
	}

	private int dfsZigZagMem(TreeNode node) {
		if (node == null)
			return 0;

		int startHere = Math.max(
				maxZigZag(node, Direction.LEFT),
				maxZigZag(node, Direction.RIGHT));

		int bestLeft = longestZigZag(node.left);
		int bestRight = longestZigZag(node.right);

		return Math.max(startHere, Math.max(bestLeft, bestRight));
	}

	private int maxZigZag(TreeNode node, Direction direction) {
		if (node == null)
			return 0;

		Key k = new Key(node, direction);
		Integer info = memoizationMap.get(k);
		if (info != null)
			return info;

		TreeNode nextNode = switch (direction) {
			case RIGHT -> node.right;
			case LEFT -> node.left;
		};

		int length = nextNode == null ? 0 : 1 + maxZigZag(nextNode, direction.opposite());
		memoizationMap.put(k, length);

		return length;
	}

	// Faster solution without using memoization
	private Info dfsZigZag(TreeNode node) {
		if (node == null)
			return new Info(0, 0, 0);

		Info l = dfsZigZag(node.left);
		Info r = dfsZigZag(node.right);

		int goLeft = node.left == null ? 0 : 1 + l.right();
		int goRight = node.right == null ? 0 : 1 + r.left();

		int bestHere = Math.max(Math.max(l.best(), r.best()), Math.max(goLeft, goRight));

		return new Info(goLeft, goRight, bestHere);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		if (root.equals(p) || root.equals(q))
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		boolean isLeftNull = left == null;
		boolean isRightNull = right == null;

		if (!isLeftNull && !isRightNull)
			return root;

		return isLeftNull ? right : left;
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> levels = new LinkedList<>();

		if (root == null)
			return levels;

		record Pair(TreeNode node, int level) {
		}
		int currentLevel = 0;

		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			TreeNode node = p.node();
			int lvl = p.level();
			if (lvl == currentLevel) {
				levels.add(node.val);
				currentLevel++;
			}
			if (node.right != null)
				q.offer(new Pair(node.right, lvl + 1));
			if (node.left != null)
				q.offer(new Pair(node.left, lvl + 1));
		}
		return levels;
	}

	// This is the first solution I came up with. I wanted to write a more general method to group values by levels, but in this way I need to traverse the resulting map another time to extract the first value
	public List<Integer> rightSideViewWithLevels(TreeNode root) {
		return groupByLevels(root).values().stream()
				.map(List::getFirst)
				.collect(Collectors.toList());
	}

	private TreeMap<Integer, List<Integer>> groupByLevels(TreeNode root) {
		TreeMap<Integer, List<Integer>> levels = new TreeMap<>();
		if (root == null)
			return levels;

		record Pair(TreeNode node, int level) {
		}

		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));

		while (!q.isEmpty()) {
			Pair p = q.poll();
			TreeNode node = p.node();
			int lvl = p.level();

			levels.computeIfAbsent(lvl, k -> new ArrayList<>()).add(node.val);

			if (node.right != null)
				q.offer(new Pair(node.right, lvl + 1));
			if (node.left != null)
				q.offer(new Pair(node.left, lvl + 1));
		}
		return levels;
	}

	private TreeMap<Integer, Integer> getLevelSums(TreeNode root) {
		TreeMap<Integer, Integer> sums = new TreeMap<>();
		if (root == null)
			return sums;

		record Pair(TreeNode node, int level) {
		}

		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 1));

		while (!q.isEmpty()) {
			Pair p = q.poll();
			TreeNode node = p.node();
			int lvl = p.level();

			sums.merge(lvl, node.val, Integer::sum);

			if (node.right != null)
				q.offer(new Pair(node.right, lvl + 1));
			if (node.left != null)
				q.offer(new Pair(node.left, lvl + 1));
		}
		return sums;
	}

	public int maxLevelSum(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);

		int level = 1;
		int bestLevel = 1;
		int bestSum = Integer.MIN_VALUE;

		while (!q.isEmpty()) {
			int levelSize = q.size();
			int curSum = 0;

			for (int i = 0; i < levelSize; i++) {
				TreeNode n = q.poll();
				curSum += n.val;

				if (n.left != null)
					q.offer(n.left);
				if (n.right != null)
					q.offer(n.right);
			}

			if (curSum > bestSum) {
				bestSum = curSum;
				bestLevel = level;
			}

			level++;
		}
		return bestLevel;
	}

	// This is the first solution I came up with, but it is slower than the one above
	public int maxLevelSumWithLevels(TreeNode root) {
		return getLevelSums(root).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
				.orElse(0);
	}

	public enum Direction {
		RIGHT,
		LEFT;

		public Direction opposite() {
			return this == LEFT ? RIGHT : LEFT;
		}
	}

	private record Key(TreeNode node, Direction dir) {
	}

	private record Info(int left, int right, int best) {
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

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

		boolean isLeaf() {
			return right == null && left == null;
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
