package com.example.linked_list;

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

		assertEquals(new ListNode(2, new ListNode(1, null)), leetCode.reverseList(firstTest));
		assertNull(leetCode.reverseList(secondTest));
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
		assertEquals(createListNodeFromList((new ArrayList<>(List.of(1, 2, 4)))),
				leetCode.deleteMiddle(secondTest));
		assertEquals(createListNodeFromList(new ArrayList<>()), leetCode.deleteMiddle(thirdTest));
		assertEquals(createListNodeFromList(new ArrayList<>(List.of(2))), leetCode.deleteMiddle(forthTest));
		assertEquals(createListNodeFromList(new ArrayList<>()), leetCode.deleteMiddle(fifthTest));
	}

	@Test
	void testOddEvenList() {
		ListNode firstTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
		ListNode secondTest = createListNodeFromList(new ArrayList<>(Arrays.asList(2, 1, 3, 5, 6, 4, 7)));
		ListNode thirdTest = createListNodeFromList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));

		assertEquals(createListNodeFromList(new ArrayList<>(List.of(1, 3, 5, 2, 4))),
				leetCode.oddEvenList(firstTest));
		assertEquals(createListNodeFromList(new ArrayList<>(List.of(2, 3, 6, 7, 1, 5, 4))),
				leetCode.oddEvenList(secondTest));
		assertEquals(createListNodeFromList(new ArrayList<>(List.of(1, 3, 2, 4))),
				leetCode.oddEvenList(thirdTest));
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

	private ListNode createListNodeFromList(List<Integer> list) {
		return list.isEmpty()
				? null
				: new ListNode(list.removeFirst(), createListNodeFromList(list));
	}
}