package linkedList;

import java.util.Scanner;

class QueueNode {
	int data;
	QueueNode next;
}

class ImplementQueueFromLL {
	QueueNode front;
	QueueNode rear;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			ImplementQueueFromLL qn = new ImplementQueueFromLL();
			GfG2 obj = new GfG2();
			int Q = sc.nextInt();
			while (Q > 0) {
				int QueryType = 0;
				QueryType = sc.nextInt();
				if (QueryType == 1) {
					int a = sc.nextInt();

					obj.push(a, qn);

				} else if (QueryType == 2) {
					System.out.print(obj.pop(qn) + " ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		}
	}
}

class GfG2 {
	void push(int a, ImplementQueueFromLL ob) {
		QueueNode node = new QueueNode();
		node.data = a;
		if (ob.front == null) {
			ob.front = node;
			ob.rear = node;
		} else {
			ob.rear.next = node;
			ob.rear = node;
		}
	}

	int pop(ImplementQueueFromLL ob) {
		if (ob.front == null) {
			return -1;
		}
		int temp = ob.front.data;
		ob.front = ob.front.next;
		return temp;
	}
}
