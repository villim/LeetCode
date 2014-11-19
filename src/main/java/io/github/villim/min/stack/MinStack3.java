package io.github.villim.min.stack;

import java.util.Stack;

public class MinStack3 {

	Stack<Integer> stack;
	Stack<Integer> minstack;

	public MinStack3() {
		stack = new Stack<>();
		minstack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (minstack.isEmpty()) {
			minstack.push(x);
		} else {
			if (minstack.peek() >= x) {
				minstack.push(x);
			}
		}
	}

	public void pop() {
		if (minstack.peek().intValue() == stack.peek().intValue()) {
			minstack.pop();
		}
		stack.pop();
	}

	public int top() {
		return stack.peek();

	}

	public int getMin() {
		return minstack.peek();

	}
}
