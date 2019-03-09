package linkedList;

public class CheckPalindrome {
	public static void main(String[] args) {
		Block head = new Block(1);
		head.next = new Block(2);
		head.next.next = new Block(3);
		head.next.next.next = new Block(3);
		head.next.next.next.next = new Block(2);
		head.next.next.next.next.next = new Block(1);
		
		CheckPalindrome obj = new CheckPalindrome();
		System.out.println(obj.checkPalindrome(head));
	}

	private boolean checkPalindrome(Block head) {
		//get middle
		boolean isEven = false;
		Block mid = head, fast = head;
		while (fast != null && fast.next != null) {
			mid = mid.next;
			fast = fast.next.next;
		}
		if (fast == null)
			isEven = true;
		
		//reverse upto middle
		Block prev = null, curr = head;
		while (curr != mid) {
			Block temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		Block firstStart = prev, secondStart = curr;
		
		if (!isEven)
			secondStart = secondStart.next;
		
		while (firstStart != null && firstStart.value == secondStart.value) {
			firstStart = firstStart.next;
			secondStart = secondStart.next;
		}
		
		return firstStart == null;
	}
}
