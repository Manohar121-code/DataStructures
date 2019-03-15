package linkedList;

public class GetNthElementInLL {
	public static void main(String[] args) {
		Node head = new Node(34), prev = head;
		prev = prev.next = new Node(12);
		prev = prev.next = new Node(65);
		prev = prev.next = new Node(384);
		prev = prev.next = new Node(237);
		prev = prev.next = new Node(322);
		prev = prev.next = new Node(374);
		prev = prev.next = new Node(132);
		
		int index = 5;
		GetNthElementInLL obj = new GetNthElementInLL();
		int result = obj.doOperation(head, index);
		System.out.println(result);
	}

	private int doOperation(Node head, int index) {
		int count = 0;
		while (count++ != index && head != null) {
			head = head.next;
		}
		return (head != null) ? head.data : -1;
	}
}
