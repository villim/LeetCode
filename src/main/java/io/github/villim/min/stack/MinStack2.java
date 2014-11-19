package io.github.villim.min.stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 *
 */

public class MinStack2 {

	private int[] stack = new int[100];

	int head = 0;
	int capacity = 0;

	public void push(int x) {
		if (head >= 0 && capacity == stack.length) {
			stack = resize();
		}
		stack[head] = x;
		capacity++;
		head++;
	}

	public void pop() {
		if (head > 1) {
			head--;
		}
		if (capacity > 0) {
			capacity--;
		}
	}

	public int top() {
		return stack[head - 1];
	}

	public int getMin() {
		int minValue = stack[0];
		for (int i = 0; i < head; i++) {
			minValue = stack[i] < minValue ? stack[i] : minValue;
		}
		return minValue;
	}

	private int[] resize() {
		int[] newstack = new int[stack.length + 100];
		System.arraycopy(stack, 0, newstack, 0, capacity);
		return newstack;
	}
}
