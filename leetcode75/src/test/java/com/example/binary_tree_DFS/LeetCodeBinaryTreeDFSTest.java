package com.example.binary_tree_DFS;

import org.junit.jupiter.api.Test;

import java.util.*;

import static com.example.binary_tree_DFS.LeetCodeBinaryTreeDFS.TreeNode;
import static org.junit.jupiter.api.Assertions.*;

class LeetCodeBinaryTreeDFSTest {

	private final LeetCodeBinaryTreeDFS leetCode = new LeetCodeBinaryTreeDFS();

	@Test
	void testCreateTreeNodeFromList() {
		TreeNode firstTest = createTreeNodeFromList(Arrays.asList(3, 9, 20, null, null, 15, 7));
		TreeNode secondTest = createTreeNodeFromList(
				Arrays.asList(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1));

		assertEquals(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
				firstTest);
		assertEquals(firstTest,
				createTreeNodeFromList(fromTreeNodeToList(firstTest)));
		assertEquals(secondTest,
				createTreeNodeFromList(fromTreeNodeToList(secondTest)));
	}

	@Test
	void testMaxDepth() {
		TreeNode firstTest = createTreeNodeFromList(Arrays.asList(3, 9, 20, null, null, 15, 7));
		TreeNode secondTest = new TreeNode(3);

		assertEquals(3, leetCode.maxDepth(firstTest));
		assertEquals(1, leetCode.maxDepth(secondTest));
	}

	@Test
	void testLeafSimilar() {
		TreeNode firstTest1 = createTreeNodeFromList(Arrays.asList(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4));
		TreeNode firstTest2 = createTreeNodeFromList(
				Arrays.asList(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8));
		TreeNode secondTest1 = createTreeNodeFromList(Arrays.asList(1, 2, 3));
		TreeNode secondTest2 = createTreeNodeFromList(Arrays.asList(1, 3, 2));
		TreeNode thirdTest1 = createTreeNodeFromList(Arrays.asList(1, 2));
		TreeNode thirdTest2 = createTreeNodeFromList(Arrays.asList(2, 2));

		assertTrue(leetCode.leafSimilar(firstTest1, firstTest2));
		assertFalse(leetCode.leafSimilar(secondTest1, secondTest2));
		assertTrue(leetCode.leafSimilar(thirdTest1, thirdTest2));
	}

	@Test
	void testGoodNodes() {
		TreeNode firstTest = createTreeNodeFromList(Arrays.asList(3, 1, 4, 3, null, 1, 5));

		assertEquals(4, leetCode.goodNodes(firstTest));
	}

	@Test
	void testPathSum() {
		TreeNode firstTest = createTreeNodeFromList(Arrays.asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1));
		TreeNode secondTest = createTreeNodeFromList(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1));
		TreeNode thirdTest = createTreeNodeFromList(
				Arrays.asList(1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null,
						1000000000));

		assertEquals(3, leetCode.pathSum(firstTest, 8));
		assertEquals(3, leetCode.pathSum(secondTest, 22));
		assertEquals(0, leetCode.pathSum(thirdTest, 0));
	}

	@Test
	void longestZigZag() {
		TreeNode firstTest = createTreeNodeFromList(List.of(1));
		TreeNode secondTest = createTreeNodeFromList(
				Arrays.asList(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1));
		TreeNode thirdTest = createTreeNodeFromList(Arrays.asList(1, 1, 1, null, 1, null, null, 1, 1, null, 1));

		assertEquals(0, leetCode.longestZigZag(firstTest));
		assertEquals(3, leetCode.longestZigZag(secondTest));
		assertEquals(4, leetCode.longestZigZag(thirdTest));

	}

	private TreeNode createTreeNodeFromList(List<Integer> list) {
		if (Objects.isNull(list) || list.isEmpty() || list.getFirst() == null) {
			return null;
		}
		TreeNode root = new TreeNode(list.getFirst());
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.offer(root);

		int i = 1;
		while (!nodeQueue.isEmpty() && i < list.size()) {
			TreeNode parent = nodeQueue.poll();

			if (i < list.size()) {
				Integer leftVal = list.get(i++);
				if (leftVal != null) {
					parent.left = new TreeNode(leftVal);
					nodeQueue.offer(parent.left);
				}
			}

			if (i < list.size()) {
				Integer rightVal = list.get(i++);
				if (rightVal != null) {
					parent.right = new TreeNode(rightVal);
					nodeQueue.offer(parent.right);
				}
			}
		}
		return root;
	}

	private List<Integer> fromTreeNodeToList(TreeNode root) {
		List<Integer> list = new ArrayList<>();

		if (Objects.isNull(root)) {
			return list;
		}

		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.offer(root);

		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.poll();

			if (node == null) {
				list.add(null);
			} else {
				list.add(node.val);
				nodeQueue.offer(node.left);
				nodeQueue.offer(node.right);
			}
		}

		for (int k = list.size() - 1; k >= 0 && list.get(k) == null; k--) {
			list.remove(k);
		}

		return list;

	}
}