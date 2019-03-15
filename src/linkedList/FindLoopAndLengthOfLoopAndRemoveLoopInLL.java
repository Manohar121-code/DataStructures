package linkedList;

import java.util.HashSet;
import java.util.Set;

public class FindLoopAndLengthOfLoopAndRemoveLoopInLL {
	public static void main(String[] args) {
		Node head = new Node(1);
		Node temp = head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		Node last = head.next.next.next.next.next.next.next.next = new Node(9);
		last.next = temp;
		
		FindLoopAndLengthOfLoopAndRemoveLoopInLL obj = new FindLoopAndLengthOfLoopAndRemoveLoopInLL();
		boolean isLoop = obj.isLoopThere(head);
		System.out.println("Loop : "+ isLoop);
		if (isLoop) {
			int loopLength = obj.getLoopLength(head);
			System.out.println("Loop length : "+loopLength);
//			obj.removeLoop(head);
			obj.removeTheLoopByGFG(head);
			System.out.println("Loop : "+obj.isLoopThere(head));
		}
	}

	private void removeLoop(Node head) {
		Set<Node> setObj = new HashSet<Node>();
		while (head != null) {
			setObj.add(head);			
			if (setObj.contains(head.next)) {
				head.next = null;
				System.out.println("Loop removed");
			}
			head = head.next;
		}
	}
	
	public void removeTheLoopByGFG(Node head) {
		Node slow = head;
		Node fast = head;
		int flag = 0;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (slow == fast) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}

			/* since fast->next is the looping point */
			fast.next = null; /* remove loop */
			System.out.println("Loop removed");
		}

	}

	private int getLoopLength(Node head) {
		boolean startedLoop = false;
		int count = 0;
		Node slow, fast;
		slow = fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (startedLoop && slow == fast)
				break;
			if (slow == fast)
				startedLoop = true;
			if (startedLoop)
				count++;
		}
		return count;
	}

	private boolean isLoopThere(Node head) {
		Node slow, fast;
		slow = fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}
