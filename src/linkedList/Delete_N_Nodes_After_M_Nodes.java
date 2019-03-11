package linkedList;

public class Delete_N_Nodes_After_M_Nodes {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = new Node(9);
		head.next.next.next.next.next.next.next.next.next = new Node(10);
		
		int N =3, M = 3;
		Delete_N_Nodes_After_M_Nodes obj = new Delete_N_Nodes_After_M_Nodes();
//		Node res = obj.doOperation(head, N, M);
		Node resRec = obj.doRecursion(head, N, M, N, M);
//		obj.printLL(res);
		obj.printLL(resRec);
	}

	private Node doRecursion(Node head, int N, int M, int loopN, int loopM) {
		if (head == null)
			return null;
		if (loopM == 0) {
			if (loopN == 0)
				return doRecursion(head, N, M, N, M);
			return doRecursion(head.next, N, M, loopN - 1, loopM);
		}
		
		head.next = doRecursion(head.next, N, M, loopN, loopM - 1);
		return head;
	}

	private void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}

	private Node doOperation(Node head, int N, int M) {
		Node res = head;
		int tempN = N, tempM = M;
		while (head != null) {
			Node tempHead = null;
			if (--tempM == 0) {
				tempHead = head;
				while (tempHead != null && tempN-- > 0) {
					tempHead = tempHead.next;
				}
				tempN = N;
				tempM = M;
			}
			head = (tempHead != null) ? tempHead.next : head.next;
		}
		return res;
	}
}
