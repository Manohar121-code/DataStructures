package stackQueue;

import java.util.NoSuchElementException;

public class MyStack {
	
	private static int LIMIT = 1000;
	private int[] arr;
	private int top;
	
	public MyStack() {
		super();
		arr = new int[LIMIT];
		top = -1;
	}
	
	public void push(int n) {
		if (top >= LIMIT) {
			throw new IndexOutOfBoundsException("stack overflown");
		}
		arr[++top] = n;
	}
	
	public int pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack underflown");
		}
		return arr[top--];
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack underflown");
		}
		return arr[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public void popAllElements() {
		System.out.println("Showing all elements in stack");
		while (!isEmpty()) {
			System.out.print(pop()+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyStack stkObj = new MyStack();
		stkObj.push(1);stkObj.push(2);stkObj.push(3);stkObj.push(4);
		System.out.println("top element is : "+stkObj.peek());
		System.out.println("Popped element : "+stkObj.pop());
		stkObj.push(5);stkObj.push(6);stkObj.push(7);
		System.out.println("Popped element : "+stkObj.pop());
		stkObj.popAllElements();
	}
}
