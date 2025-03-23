package com.example.linked_list;

import java.util.Objects;

public class LeetCodeLinkedList {

	public ListNode deleteMiddle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode prevNode = null;
		ListNode slowNode = head;
		ListNode fastNode = head;

		while (fastNode != null && fastNode.next != null) {
			prevNode = slowNode;
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}

		prevNode.next = slowNode.next;
		slowNode.next = null;

		return head;
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode evenHead = head.next;
		ListNode oddNode = head;
		ListNode evenNode = head.next;

		while (true) {
			oddNode.next = evenNode.next;
			if (oddNode.next == null)
				break;
			oddNode = oddNode.next;
			evenNode.next = oddNode.next;
			if (evenNode.next == null)
				break;
			evenNode = evenNode.next;
		}
		oddNode.next = evenHead;
		return head;
	}

	public ListNode reverseList(ListNode head) {
		ListNode prevNode = null;
		ListNode nextNode;
		while (head != null) {
			nextNode = head.next;
			head.next = prevNode;
			prevNode = head;
			head = nextNode;
		}
		return prevNode;
	}

	public int pairSum(ListNode head) {
		return 0;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return "ListNode{" +
					"val=" + val +
					", next=" + next +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			ListNode listNode = (ListNode) o;
			return val == listNode.val && Objects.equals(next, listNode.next);
		}

		@Override
		public int hashCode() {
			return Objects.hash(val, next);
		}
	}

}
