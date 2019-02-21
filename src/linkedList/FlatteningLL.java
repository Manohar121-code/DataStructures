package linkedList;

public class FlatteningLL {
	public static void main(String[] args) {
		FL_Node head = new FL_Node(5);
		head.bottom = new FL_Node(7);
		head.bottom.bottom = new FL_Node(8);
		head.bottom.bottom.bottom = new FL_Node(30);
		
		head.next = new FL_Node(10);
		head.next.bottom = new FL_Node(20);
		
		head.next.next = new FL_Node(19);
		head.next.next.bottom = new FL_Node(22);
		head.next.next.bottom.bottom = new FL_Node(50);
		
		head.next.next.next = new FL_Node(28);
		head.next.next.next.bottom = new FL_Node(35);
		head.next.next.next.bottom.bottom = new FL_Node(40);
		head.next.next.next.bottom.bottom.bottom = new FL_Node(45);
		
		FlatteningLL obj = new FlatteningLL();
		FL_Node resultHead = obj.doFlatten(head);
		obj.printLL(resultHead);
	}

	private void printLL(FL_Node resultHead) {
		while (resultHead != null) {
			System.out.print(resultHead.data+" ");
			resultHead = resultHead.bottom;
		}
	}

	private FL_Node doFlatten(FL_Node head) {
		return doOperation(head, head.next);
	}

	private FL_Node doOperation(FL_Node head, FL_Node headNext) {
		if (headNext != null && headNext.next != null)
			headNext = doOperation(headNext, headNext.next);
		return sortIt(head, headNext);
	}

	private FL_Node sortIt(FL_Node first, FL_Node second) {
		if (first == null)
			return second;
		if (second == null)
			return first;
		FL_Node res = null;
		if (first.data <= second.data) {
			res = first;
			res.bottom = sortIt(first.bottom, second);
		} else {
			res = second;
			res.bottom = sortIt(first, second.bottom);
		}
		return res;
	}
}

//5 -> 10 -> 19 -> 28
//|    |     |     |
//V    V     V     V
//7    20    22    35
//|          |     |
//V          V     V
//8          50    40
//|                |
//V                V
//30               45

class FL_Node {
	int data;
	FL_Node next;
	FL_Node bottom;
	
	FL_Node(int d) {
		data = d;
		next = null;
		bottom = null;
	}
}