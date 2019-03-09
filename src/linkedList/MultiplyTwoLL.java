package linkedList;

public class MultiplyTwoLL {
	private static int ADD_VALUE = 1;
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next= new Node(4);
		head.next.next.next.next = new Node(5);
		
		Node head2 = new Node(12);
		head2.next = new Node(1);
		head2.next.next = new Node(3);
		head2.next.next.next = new Node(2);
		head2.next.next.next.next = new Node(5);

		System.out.println(9 % 10);
		
		MultiplyTwoLL obj = new MultiplyTwoLL();
		
		long multiplyTwoListsByGFG = obj.multiplyTwoListsByGFG(head, head2);
		System.out.println(multiplyTwoListsByGFG);

		long s = System.nanoTime();
		long mul = obj.multiply(obj.reverseLL(head), obj.reverseLL(head2));
		long e = System.nanoTime();
		
		System.out.println(mul);
		System.out.println("e - s : "+ (e-s));
	}
	
	//by gfg
	public long multiplyTwoListsByGFG(Node l1,Node l2){
        String count=new String("");
        Node tmp=l1;
        long sum1=0,sum2=0;
        while(tmp!=null)
        {
            sum1 = (sum1*10 + tmp.data)%(1000000007);
            //System.out.println(sum1+"g");
            tmp = tmp.next;
        }
        count ="";
        tmp=l2;
        while(tmp!=null)
        {
            sum2 = (sum2*10 + tmp.data)%(1000000007);
            //System.out.println(sum2+"g");
            tmp = tmp.next;
        }
        return (sum1*sum2)%(1000000007);
 }

	private Node reverseLL(Node head) {
		Node prev = null, next = null;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

//	111 * 32
	private long multiply(Node head, Node head2) {
		long res = 0;
		int count = 0;
		while (head != null) {
			res += (doMultiplyWithEach(head.data, head2) * (int) Math.pow(10, count));
			count++;
			head = head.next;
		}
		return res;
	}

	private long doMultiplyWithEach(int data, Node head) {
		long res = 0;
		int count = 0;
		while (head != null) {
			res += ((head.data * data) * (int) Math.pow(10, count));
			count++;
			head = head.next;
		}
		return res;
	}
	
	
	
}
