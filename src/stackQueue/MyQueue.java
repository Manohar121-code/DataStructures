package stackQueue;

import java.util.NoSuchElementException;

public class MyQueue {
	private static int LIMIT = 7;
	private int[] arr;
	private int front, rear;
	
	public MyQueue() {
		super();
		arr = new int[LIMIT];
		rear = front = -1;
	}
	
	private void push(int n) {
		if (size() >= LIMIT) {
			throw new IndexOutOfBoundsException("queue overflown");
		}
		if(front == -1)
			front = 0;
		arr[++rear] = n;
	}
	
	private int pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("queue underflown");
		}
		return arr[front++];
	}
	
	private int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("queue underflown");
		}
		return arr[front];
	}
	
	private boolean isEmpty() {
		return size() == 0;
	}
	
	private int size() {
		return (rear+1) - front;
	}
	
	private void popAllElements() {
		System.out.println("Showing all elements in queue");
		while (!isEmpty()) {
			System.out.print(pop()+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyQueue queueObj = new MyQueue();
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
		System.out.println("size is : "+queueObj.size());
		queueObj.popAllElements();
//		System.out.println("front element is : "+queueObj.peek());
	}
}
