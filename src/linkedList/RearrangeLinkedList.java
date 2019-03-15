package linkedList;

public class RearrangeLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1), prev = head;
		
		prev = prev.next = new Node(2);
		prev = prev.next = new Node(3);
		prev = prev.next = new Node(4);
		prev = prev.next = new Node(5);
		prev = prev.next = new Node(6);
		
		RearrangeLinkedList obj = new RearrangeLinkedList();
		Node res = obj.rearrangeGFG(head);
		obj.printLL(res);
	}

	private void printLL(Node head) {
		while (head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
	private Node reArrange2(Node head) {
		if (head == null || head.next == null) return head;
		
		Node oddRes, odd, evenRes, even;
		odd = oddRes = head;
		even = evenRes = head.next;
		head = head.next.next;
		while (head != null) {
			odd = odd.next = head;
			if (head.next != null) {
				even = even.next = head.next;
			} else {
				break;
			}
			head = head.next.next;
		}
		odd.next = evenRes;
		return oddRes;
	}
	
	Node rearrangeGFG(Node head) {
          //  The task is to complete this method
          Node odd = head;
          Node n = head.next;
          Node even = n;
          while(odd.next!=null && even.next!=null)
          {
              odd.next = odd.next.next;
              odd = odd.next;
              even.next = even.next.next;
              even = even.next;
          }
          odd.next = n;
          return head;
     }

	//1 2 3 4 5 6
	private Node reArrange(Node head) {
		if (head == null || head.next == null) return head;
		
		Node oddRes, odd, evenRes, even;
		odd = oddRes = head;
		even = evenRes = head.next;
		int oddEven = 1;
		head = head.next.next;
		while (head != null) {
			if (oddEven++ % 2 == 0) {
				even = even.next = head;
			} else {
				odd = odd.next = head;
			}
			head = head.next;
		}
		odd.next = evenRes;
		return oddRes;
	}
}
