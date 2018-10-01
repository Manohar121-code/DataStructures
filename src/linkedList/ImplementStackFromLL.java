package linkedList;

import java.util.Scanner;

class StackNode {
	int data;
	StackNode next;
}

class ImplementStackFromLL {
	StackNode top;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			ImplementStackFromLL qn = new ImplementStackFromLL();
			GfG3 obj = new GfG3();
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

class GfG3 {
	void push(int a, ImplementStackFromLL ob) {
		StackNode node = new StackNode();
		node.data = a;
		node.next = ob.top;
		ob.top = node;
	}

	int pop(ImplementStackFromLL ob) {
		if (ob.top == null)
			return -1;
		int temp = ob.top.data;
		ob.top = ob.top.next;
		return temp;
	}

}