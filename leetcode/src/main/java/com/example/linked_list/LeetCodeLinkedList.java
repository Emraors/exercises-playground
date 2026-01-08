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

	public ListNode reverseListRec(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		var rest = reverseListRec(head.next);

		head.next = null;
		addLast(head, rest);

		return rest;
	}

	public int pairSum(ListNode head) {
		if (head == null || head.next == null)
			return 0;

		int sum = 0;
		ListNode slowNode = head;
		ListNode fastNode = head;

		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}

		ListNode secondHalf = reverseList(slowNode);
		while (head != null && secondHalf != null) {
			sum = Math.max(head.val + secondHalf.val, sum);
			head = head.next;
			secondHalf = secondHalf.next;
		}
		return sum;
	}

	public void addLast(ListNode node, ListNode head) {
		ListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
	}

	public ListNode interleave(ListNode a, ListNode b) {
		if (a == null)
			return b;
		if (b == null)
			return a;

		var node = a;

		while (a != null && b != null) {
			var aNext = a.next;
			var bNext = b.next;

			a.next = b;
			b.next = aNext;

			b = bNext;
			a = aNext;
		}
		return node;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m == n)
			return head;

		var dummy = new ListNode(0, head);
		var prev = dummy;

		for (int i = 0; i < m - 1; i++) {
			prev = prev.next;
		}

		var start = prev.next;
		var tail = start;
		for (int i = m; i < n; i++) {
			tail = tail.next;
		}

		var after = tail.next;
		tail.next = null;

		prev.next = reverseList(start);
		start.next = after;

		return dummy.next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);

		ListNode fast = dummy;
		ListNode slow = dummy;

		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return dummy.next;
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;

		ListNode dummy = new ListNode(0, head);
		ListNode current = dummy.next;
		ListNode prev = dummy;

		while (current != null) {
			if (current.val == val) {
				prev.next = current.next;
			} else {
				prev = prev.next;
			}
			current = current.next;
		}

		return dummy.next;
	}

	public ListNode partition(ListNode head, int x) {
		var leftDummy = new ListNode();
		var rightDummy = new ListNode();

		var left = leftDummy;
		var right = rightDummy;

		var current = head;

		while (current != null) {
			var next = current.next;
			current.next = null;

			if (current.val < x) {
				left.next = current;
				left = left.next;
			} else {
				right.next = current;
				right = right.next;
			}

			current = next;
		}

		left.next = rightDummy.next;
		return leftDummy.next;
	}

	public ListNode reorderList(ListNode head) {

		return null;
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
