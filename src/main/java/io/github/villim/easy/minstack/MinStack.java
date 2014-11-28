package io.github.villim.easy.minstack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 *
 */
class MinStack {

	private Node currentNode = null;

	private int min;

	public void push(int x) {
		Node node = new Node(x);
		node.pre = currentNode;

		if (currentNode != null) {
			currentNode.next = node;
		}

		currentNode = node;
	}

	public void pop() {
		if (currentNode.pre != null) {
			this.currentNode.pre.next = null;
			this.currentNode = currentNode.pre;
		} else {
			currentNode = null;
		}
	}

	public int top() {
		return currentNode.value;
	}

	public int getMin() {
		return this.getMin(currentNode, currentNode.value);
	}

	private int getMin(Node node, int min) {
		this.min = min;
		if (node.value < min) {
			this.min = node.value;
		}

		if (node.pre != null) {
			getMin(node.pre, this.min);
		}

		return this.min;
	}

	class Node {
		private int value;
		private Node pre = null;
		private Node next = null;

		public Node(int value) {
			this.value = value;
		}

	}
}
