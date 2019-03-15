package linkedList;

public class RemoveEveryKthNodeInLL {
	public static void main(String[] args) {
		Node head = new Node(34), prev = head;
		prev = prev.next = new Node(12);
		prev = prev.next = new Node(65);
		prev = prev.next = new Node(384);
		prev = prev.next = new Node(237);
		prev = prev.next = new Node(322);
		prev = prev.next = new Node(374);
		prev = prev.next = new Node(132);
		
		int k = 1;
		RemoveEveryKthNodeInLL obj = new RemoveEveryKthNodeInLL();
		Node result = obj.doOperation(head, k);
		obj.printLL(result);
	}

	private void printLL(Node result) {
		while (result != null) {
			System.out.print(result.data+" ");
			result = result.next;
		}
	}

	private Node doOperation(Node head, int k) {
		if (k == 1 || head == null) return null;
		int temp = k;
		Node tempNode = head;
		while (head != null) {
			if (--temp == 1 && head.next != null) {
				head.next = head.next.next;
				temp = k;
			}
			head = head.next;
		}
		return tempNode;
	}
}
