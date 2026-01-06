package com.example.linked_list;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.linked_list.LeetCodeLinkedList.ListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LeetCodeLinkedListTest {

	private final LeetCodeLinkedList leetCode = new LeetCodeLinkedList();

	@Test
	void testCreateListNodeFromLinkedList() {
		List<Integer> firstTest = new ArrayList<>(Arrays.asList(1, 2));
		List<Integer> secondTest = new ArrayList<>();

		assertNull(createListNodeFromList(secondTest));
		assertEquals(new ListNode(1, new ListNode(2, null)), createListNodeFromList(firstTest));
	}

	@Test
	void testReverseLinkedList() {
		ListNode firstTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2)));
		ListNode secondTest = createListNodeFromList(new ArrayList<>());
		ListNode thirdTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3)));

		assertEquals(new ListNode(2, new ListNode(1, null)), leetCode.reverseList(firstTest));
		assertNull(leetCode.reverseList(secondTest));
		assertEquals(new ListNode(3, new ListNode(2, new ListNode(1, null))), leetCode.reverseList(thirdTest));
	}

	@Test
	void testDeleteMiddle() {
		ListNode firstTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 3, 4, 7, 1, 2, 6)));
		ListNode secondTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
		ListNode thirdTest = createListNodeFromList(new ArrayList<>());
		ListNode forthTest = createListNodeFromList(new ArrayList<>(Arrays.asList(2, 1)));
		ListNode fifthTest = createListNodeFromList(new ArrayList<>(List.of(1)));

		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(1, 3, 4, 1, 2, 6))),
				leetCode.deleteMiddle(firstTest));
		assertEquals(createListNodeFromList((new ArrayList<>(List.of(1, 2, 4)))), leetCode.deleteMiddle(secondTest));
		assertEquals(createListNodeFromList(new ArrayList<>()), leetCode.deleteMiddle(thirdTest));
		assertEquals(createListNodeFromList(new ArrayList<>(List.of(2))), leetCode.deleteMiddle(forthTest));
		assertEquals(createListNodeFromList(new ArrayList<>()), leetCode.deleteMiddle(fifthTest));
	}

	@Test
	void testOddEvenList() {
		ListNode firstTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
		ListNode secondTest = createListNodeFromList(new ArrayList<>(Arrays.asList(2, 1, 3, 5, 6, 4, 7)));
		ListNode thirdTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));

		assertEquals(createListNodeFromList(new ArrayList<>(List.of(1, 3, 5, 2, 4))), leetCode.oddEvenList(firstTest));
		assertEquals(createListNodeFromList(new ArrayList<>(List.of(2, 3, 6, 7, 1, 5, 4))),
				leetCode.oddEvenList(secondTest));
		assertEquals(createListNodeFromList(new ArrayList<>(List.of(1, 3, 2, 4))), leetCode.oddEvenList(thirdTest));
	}

	@Test
	void testPairSum() {
		ListNode firstTest = createListNodeFromList(new ArrayList<>(Arrays.asList(5, 4, 2, 1)));
		ListNode secondTest = createListNodeFromList(new ArrayList<>(Arrays.asList(4, 2, 2, 3)));
		ListNode thirdTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 100000)));

		assertEquals(6, leetCode.pairSum(firstTest));
		assertEquals(7, leetCode.pairSum(secondTest));
		assertEquals(100001, leetCode.pairSum(thirdTest));
	}

	@Test
	void testInterleave() {
		ListNode first1 = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 3, 5)));
		ListNode second1 = createListNodeFromList(new ArrayList<>(Arrays.asList(2, 4, 6)));

		ListNode first2 = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 3, 5, 7)));
		ListNode second2 = createListNodeFromList(new ArrayList<>(Arrays.asList(2, 4)));

		ListNode first3 = null;
		ListNode second3 = createListNodeFromList(new ArrayList<>(Arrays.asList(2, 4, 6)));

		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
				leetCode.interleave(first1, second1));
		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))),
				leetCode.interleave(first2, second2));
		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(2, 4, 6))),
				leetCode.interleave(first3, second3));
	}

	@Test
	void testAddLast() {
		ListNode firstTest = createListNodeFromList(new ArrayList<>(Arrays.asList(5, 4, 2, 1)));

		leetCode.addLast(new ListNode(3, null), firstTest);
		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(5, 4, 2, 1, 3))), firstTest);
	}

	private ListNode createListNodeFromList(List<Integer> list) {
		return list.isEmpty() ? null : new ListNode(list.removeFirst(), createListNodeFromList(list));
	}

	@Test
	void testReverseBetween() {

		ListNode firstTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		ListNode secondTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
		ListNode thirdTest = createListNodeFromList(new ArrayList<>(List.of(1)));

		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(1, 4, 3, 2, 5, 6))),
				leetCode.reverseBetween(firstTest, 2, 4));
		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(2, 1, 3, 4))),
				leetCode.reverseBetween(secondTest, 1, 2));
		assertEquals(createListNodeFromList(new ArrayList<>(List.of(1))), leetCode.reverseBetween(thirdTest, 1, 1));
	}

	@Test
	void testRemoveNthFromEnd() {
		ListNode firstTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
		ListNode secondTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2)));
		ListNode thirdTest = createListNodeFromList(new ArrayList<>(List.of(1)));

		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 5))),
				leetCode.removeNthFromEnd(firstTest, 2));
		assertEquals(createListNodeFromList(new ArrayList<>(List.of(2))), leetCode.removeNthFromEnd(secondTest, 2));
		assertNull(leetCode.removeNthFromEnd(thirdTest, 1));
	}

	@Test
	void testPartition() {
		ListNode firstTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 4, 3, 2, 5, 2)));
		ListNode secondTest = createListNodeFromList(new ArrayList<>(Arrays.asList(2, 1)));
		ListNode thirdTest = createListNodeFromList(new ArrayList<>(Arrays.asList(3, 3, 3)));

		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 2, 4, 3, 5))),
				leetCode.partition(firstTest, 3));
		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2))), leetCode.partition(secondTest, 2));
		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(3, 3, 3))), leetCode.partition(thirdTest, 3));
	}

	@Test
	@Disabled
	void testReorderList() {
		ListNode firstTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
		ListNode secondTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
		ListNode thirdTest = createListNodeFromList(new ArrayList<>(List.of(1)));
		ListNode fourthTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2)));

		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(1, 4, 2, 3))),
				leetCode.reorderList(firstTest));
		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(1, 5, 2, 4, 3))),
				leetCode.reorderList(secondTest));
		assertEquals(createListNodeFromList(new ArrayList<>(List.of(1))), leetCode.reorderList(thirdTest));
		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2))), leetCode.reorderList(fourthTest));
	}

	@Test
	void testRemoveElements() {
		ListNode firstTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 6, 3, 4, 5, 6)));

		assertEquals(createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))),
				leetCode.removeElements(firstTest, 6));
	}
}