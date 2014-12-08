package io.github.villim.easy;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * ____ A: a1 → a2 <br>
 * ______________ ↘ <br>
 * ________________ c1 → c2 → c3 <br>
 * ______________ ↗ <br>
 * B: b1 → b2 → b3 <br>
 * 
 * begin to intersect at node c1.
 * 
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null. <br>
 * The linked lists must retain their original structure after the function
 * returns. <br>
 * You may assume there are no cycles anywhere in the entire linked structure. <br>
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * @author villim
 *
 */
public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		if (headA == headB) {
			return headA;
		}

		ListNode pa = headA;
		int lena = 1;
		while (pa.next != null) {
			pa = pa.next;
			lena++;
		}

		ListNode pb = headB;
		int lenb = 1;
		while (pb.next != null) {
			pb = pb.next;
			lenb++;
		}

		if (pa == pb) {
			pa = headA;
			pb = headB;

			int looplen = 0;

			if (lena == lenb) {
				looplen = lena;
			} else if (lena > lenb) {
				int differ = lena - lenb;
				looplen = lenb;
				while (differ > 0) {
					pa = pa.next;
					differ--;
				}
			} else if (lenb > lena) {
				int differ = lenb - lena;
				looplen = lena;
				while (differ > 0) {
					pb = pb.next;
					differ--;
				}
			}

			while (looplen > 0) {
				if (pa == pb) {
					return pa;
				}
				pa = pa.next;
				pb = pb.next;
				looplen--;
			}
		}

		return null;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
