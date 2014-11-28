package io.github.villim.easy.minstack;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 *
 */
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
