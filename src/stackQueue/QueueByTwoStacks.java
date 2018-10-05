package stackQueue;

import java.util.NoSuchElementException;

public class QueueByTwoStacks {
	private MyStack stk1;
	private MyStack stk2;
	
	public QueueByTwoStacks() {
		stk1 = new MyStack();
		stk2 = new MyStack();
	}
	
	void push(int n) {
		stk1.push(n);
	}
	
	int pop() {
		if (stk2.isEmpty()) {
			while (!stk1.isEmpty()) {
				stk2.push(stk1.pop());
			}
		}
		if (!stk2.isEmpty()) {
			return stk2.pop();
		} else {
			throw new NoSuchElementException("queue underflown");
		}
	}
	
	public void popAllElements() {
		System.out.println("Showing all elements in queue");
		while (!stk2.isEmpty()) {
			System.out.println("Showing elements : "+stk2.pop());
		}
		while (!stk1.isEmpty()) {
			stk2.push(stk1.pop());
		}
		while (!stk2.isEmpty()) {
			System.out.println("Showing elements : "+stk2.pop());
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		QueueByTwoStacks queueObj = new QueueByTwoStacks();
		queueObj.push(1);queueObj.push(2);queueObj.push(3);
		System.out.println("Popped element : "+queueObj.pop());
		System.out.println("Popped element : "+queueObj.pop());
		queueObj.push(4);
		queueObj.push(5);
		System.out.println("Popped element : "+queueObj.pop());
		System.out.println("Popped element : "+queueObj.pop());
		System.out.println("Popped element : "+queueObj.pop());
		queueObj.push(6);
		System.out.println("Popped element : "+queueObj.pop());
		queueObj.push(7);
		queueObj.popAllElements();
	}
	
}
