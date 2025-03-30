package com.example.binary_tree_DFS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.example.binary_tree_DFS.LeetCodeBinaryTreeDFS.TreeNode;
import static org.junit.jupiter.api.Assertions.*;

class LeetCodeBinaryTreeDFSTest {

	private final LeetCodeBinaryTreeDFS leetCode = new LeetCodeBinaryTreeDFS();

	@Test
	void testCreateTreeNodeFromList() {
		List<Integer> firstTest = Arrays.asList(3, 9, 20, null, null, 15, 7);

		assertEquals(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
				createTreeNodeFromList(firstTest));
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

	public TreeNode createTreeNodeFromList(List<Integer> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		return createTreeNodeHelper(list, 0);
	}

	private TreeNode createTreeNodeHelper(List<Integer> list, int index) {
		if (index >= list.size() || list.get(index) == null) {
			return null;
		}

		TreeNode node = new TreeNode(list.get(index));
		node.left = createTreeNodeHelper(list, 2 * index + 1);
		node.right = createTreeNodeHelper(list, 2 * index + 2);

		return node;
	}
}