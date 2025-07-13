package com.example.binary_tree;

import org.junit.jupiter.api.Test;

import java.util.*;

import static com.example.binary_tree.LeetCodeBinaryTree.TreeNode;
import static org.junit.jupiter.api.Assertions.*;

class LeetCodeBinaryTreeTest {

	private final LeetCodeBinaryTree leetCode = new LeetCodeBinaryTree();

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
	void longestZigZagTest() {
		TreeNode firstTest = createTreeNodeFromList(List.of(1));
		TreeNode secondTest = createTreeNodeFromList(
				Arrays.asList(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1));
		TreeNode thirdTest = createTreeNodeFromList(Arrays.asList(1, 1, 1, null, 1, null, null, 1, 1, null, 1));

		assertEquals(0, leetCode.longestZigZag(firstTest));
		assertEquals(3, leetCode.longestZigZag(secondTest));
		assertEquals(4, leetCode.longestZigZag(thirdTest));
	}

	@Test
	void lowestCommonAncestorTest() {
		TreeNode rootFist = createTreeNodeFromList(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
		TreeNode pFirst = createTreeNodeFromList(Arrays.asList(5, 6, 2, null, null, 7, 4));
		TreeNode qFirst = createTreeNodeFromList(Arrays.asList(1, 0, 8));

		assertEquals(createTreeNodeFromList(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)),
				leetCode.lowestCommonAncestor(rootFist, pFirst, qFirst));
	}

	@Test
	void rightSideViewTest() {
		TreeNode firstTest = createTreeNodeFromList(Arrays.asList(1, 2, 3, null, 5, null, 4));
		TreeNode secondTest = createTreeNodeFromList(Arrays.asList(1, 2, 3, 4, null, null, null, 5));
		TreeNode thirdTest = createTreeNodeFromList(new ArrayList<>());

		assertEquals(Arrays.asList(1, 3, 4), leetCode.rightSideView(firstTest));
		assertEquals(Arrays.asList(1, 3, 4, 5), leetCode.rightSideView(secondTest));
		assertEquals(new ArrayList<>(), leetCode.rightSideView(thirdTest));
	}

	@Test
	void maxLevelSumTest() {
		TreeNode firstTest = createTreeNodeFromList(Arrays.asList(1, 7, 0, 7, -8, null, null));
		TreeNode secondTest = createTreeNodeFromList(
				Arrays.asList(989, null, 10250, 98693, -89388, null, null, null, -32127));
		TreeNode thirdTest = createTreeNodeFromList(Arrays.asList(-100, -200, -300, -20, -5, -10, null));
		TreeNode fourthTest = createTreeNodeFromList(Arrays.asList(1, 1, 0, 7, -8, -7, 9));

		assertEquals(1, leetCode.maxLevelSum(fourthTest));
		assertEquals(2, leetCode.maxLevelSum(firstTest));
		assertEquals(2, leetCode.maxLevelSum(secondTest));
		assertEquals(3, leetCode.maxLevelSum(thirdTest));
	}

	@Test
	void searchBSTTest() {
		TreeNode firstTest = createTreeNodeFromList(Arrays.asList(4, 2, 7, 1, 3));
		TreeNode firstTestResult = createTreeNodeFromList(Arrays.asList(2, 1, 3));
		TreeNode secondTest = createTreeNodeFromList(Arrays.asList(4, 2, 7, 1, 3));
		TreeNode secondTestResult = createTreeNodeFromList(new ArrayList<>());

		assertEquals(firstTestResult, leetCode.searchBST(firstTest, 2));
		assertEquals(secondTestResult, leetCode.searchBST(secondTest, 5));
	}

	@Test
	void deleteNodeTest() {
		TreeNode firstTest = createTreeNodeFromList(Arrays.asList(5, 3, 6, 2, 4, null, 7));
		TreeNode firstTestResult = createTreeNodeFromList(Arrays.asList(5, 4, 6, 2, null, null, 7));
		TreeNode secondTest = createTreeNodeFromList(Arrays.asList(5, 3, 6, 2, 4, null, 7));
		TreeNode secondTestResult = createTreeNodeFromList(Arrays.asList(5, 3, 6, 2, 4, null, 7));

		assertEquals(firstTestResult, leetCode.deleteNode(firstTest, 3));
		assertEquals(secondTestResult, leetCode.deleteNode(secondTest, 0));
	}

	@Test
	void insertIntoBSTTest() {
		TreeNode firstTest = createTreeNodeFromList(Arrays.asList(4, 2, 7, 1, 3));
		TreeNode firstTestResult = createTreeNodeFromList(Arrays.asList(4, 2, 7, 1, 3, 5));
		TreeNode secondTest = createTreeNodeFromList(Arrays.asList(40, 20, 60, 10, 30, 50, 70));
		TreeNode secondTestResult = createTreeNodeFromList(Arrays.asList(40, 20, 60, 10, 30, 50, 70, null, null, 25));

		assertEquals(firstTestResult, leetCode.insertIntoBST(firstTest, 5));
		assertEquals(secondTestResult, leetCode.insertIntoBST(secondTest, 25));
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

	public List<Integer> preorder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (Objects.isNull(root))
			return result;

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			result.add(curr.val);

			if (curr.right != null)
				stack.push(curr.right);
			if (curr.left != null)
				stack.push(curr.left);
		}
		return result;
	}
}