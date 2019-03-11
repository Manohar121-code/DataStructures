package linkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionOfThreeLL {
	public static void main(String[] args) {
		Node head1 = new Node(5);
		head1.next = new Node(2);
		head1.next.next = new Node(12);
		head1.next.next.next = new Node(9);

		Node head2 = new Node(1);
		head2.next = new Node(4);
		head2.next.next = new Node(10);
		head2.next.next.next = new Node(7);
		head2.next.next.next.next = new Node(2);
		head2.next.next.next.next.next = new Node(6);

		Node head3 = new Node(14);
		head3.next = new Node(3);
		head3.next.next = new Node(17);
		head3.next.next.next = new Node(4);
		head3.next.next.next.next = new Node(1);
		head3.next.next.next.next.next = new Node(12);
		
		MergeSortUtil mObj = new MergeSortUtil();
		UnionOf_N_LL_Util nLLObj = new UnionOf_N_LL_Util();
		List<Node> inputList = new ArrayList<Node>();
		inputList.add(mObj.mergeSort(head1));
		inputList.add(mObj.mergeSort(head2));
		inputList.add(mObj.mergeSort(head3));
		Node resultNode = nLLObj.doUnionFor_N_LL(inputList);
		UnionOfThreeLL mainObj = new UnionOfThreeLL();
		mainObj.printLL(resultNode);
		
		System.out.println("\n************************************");
		
		UnionOfThreeLLUtil obj = new UnionOfThreeLLUtil();
		Node resultHead = obj.doUnionForThreeLL(mObj.mergeSort(head1), mObj.mergeSort(head2), mObj.mergeSort(head3));
		
		mainObj.printLL(resultHead);
	}

	private void printLL(Node resultHead) {
		while (resultHead != null) {
			System.out.print(resultHead.data + " ");
			resultHead = resultHead.next;
		}
	}

}

class UnionOf_N_LL_Util {
	Set<Integer> setObj = new HashSet<>();
	public Node doUnionFor_N_LL(List<Node> inputList) {
		Node prev = null;
		if (inputList != null && !inputList.isEmpty()) prev = inputList.get(0);
		for (int i = 1; i < inputList.size(); i++) {
			setObj.removeAll(setObj);
			prev = doMergeParts(prev, inputList.get(i));
		}
		return prev;
	}
	
	private Node doMergeParts(Node a, Node b) {
		Node result = null;
		if (a == null) {
			if (!setObj.contains(b.data)) {
				setObj.add(b.data);
				return b;
			} else {
				return doMergeParts(a, b.next);
			}
		}
		if (b == null) {
			if (!setObj.contains(a.data)) {
				setObj.add(a.data);
				return a;
			} else {
				return doMergeParts(a.next, b);
			}
		}

		if (a.data <= b.data) {
			if (!setObj.contains(a.data)) {
				result = a;
				setObj.add(a.data);
			} else {
				return doMergeParts(a.next, b);
			}
			result.next = doMergeParts(a.next, b);
		} else {
			if (!setObj.contains(b.data)) {
				result = b;
				setObj.add(b.data);
			} else {
				return doMergeParts(a, b.next);
			}
			result.next = doMergeParts(a, b.next);
		}
		return result;
	}
}

class UnionOfThreeLLUtil {
	Set<Integer> setObj = new HashSet<>();

	public Node doUnionForThreeLL(Node head1, Node head2, Node head3) {
		Node res = null;
		if (head1 == null) {
			if (head2 == null) {
				res = (!setObj.contains(head3.data)) ? head3 : head3.next;
				setObj.add(head3.data);
				return res;
			}
			if (head3 == null) {
				res = (!setObj.contains(head2.data)) ? head2 : head2.next;
				setObj.add(head2.data);
				return res;
			}
			if (head2 != null && head3 != null) {
				res = (head2.data <= head3.data) ? head2 : head3;
				if (!setObj.contains(res.data)) {
					setObj.add(res.data);
					res.next = (head2.data <= head3.data) ? doUnionForThreeLL(head1, head2.next, head3) : doUnionForThreeLL(head1, head2, head3.next);
					return res;
				} else {
					return (head2.data <= head3.data) ? doUnionForThreeLL(head1, head2.next, head3) : doUnionForThreeLL(head1, head2, head3.next);
				}
			}
		}
		if (head2 == null) {
			if (head1 == null) {
				res = (!setObj.contains(head3.data)) ? head3 : head3.next;
				setObj.add(head3.data);
				return res;
			}
			if (head3 == null){
				res = (!setObj.contains(head1.data)) ? head1 : head1.next;
				setObj.add(head1.data);
				return res;
			}
			if (head1 != null && head3 != null) {
				res = (head1.data <= head3.data) ? head1 : head3;
				if (!setObj.contains(res.data)) {
					setObj.add(res.data);
					res.next = (head1.data <= head3.data) ? doUnionForThreeLL(head1.next, head2, head3) : doUnionForThreeLL(head1, head2, head3.next);
					return res;
				} else {
					return (head1.data <= head3.data) ? doUnionForThreeLL(head1.next, head2, head3) : doUnionForThreeLL(head1, head2, head3.next);
				}
			}
		}
		if (head3 == null) {
			if (head1 == null) {
				res = (!setObj.contains(head2.data)) ? head2 : head2.next;
				setObj.add(head2.data);
				return res;
			}
			if (head2 == null) {
				res = (!setObj.contains(head1.data)) ? head1 : head1.next;
				setObj.add(head1.data);
				return res;
			}
			if (head1 != null && head2 != null) {
				res = (head1.data <= head2.data) ? head1 : head2;
				if (!setObj.contains(res.data)) {
					setObj.add(res.data);
					res.next = (head1.data <= head2.data) ? doUnionForThreeLL(head1.next, head2, head3) : doUnionForThreeLL(head1, head2.next, head3);
					return res;
				} else {
					return (head1.data <= head2.data) ? doUnionForThreeLL(head1.next, head2, head3) : doUnionForThreeLL(head1, head2.next, head3);
				}
			}
		}
		if (head1.data <= ((head2.data <= head3.data) ? head2.data : head3.data)) {
			if (!setObj.contains(head1.data)) {
				res = head1;
				setObj.add(head1.data);
				res.next = doUnionForThreeLL(head1.next, head2, head3);
			} else {
				return doUnionForThreeLL(head1.next, head2, head3);
			}
		} else if (head2.data <= ((head1.data <= head3.data) ? head1.data : head3.data)) {
			if (!setObj.contains(head2.data)) {
				res = head2;
				setObj.add(head2.data);
				res.next = doUnionForThreeLL(head1, head2.next, head3);
			} else {
				return doUnionForThreeLL(head1, head2.next, head3);
			}
		} else if (head3.data <= ((head1.data <= head2.data) ? head1.data : head2.data)) {
			if (!setObj.contains(head3.data)) {
				res = head3;
				setObj.add(head3.data);
				res.next = doUnionForThreeLL(head1, head2, head3.next);
			} else {
				return doUnionForThreeLL(head1, head2, head3.next);
			}
		}
		return res;
	}
}

class MergeSortUtil {

	public Node mergeSort(Node h) {
		if (h == null || h.next == null)
			return h;

		MergeSortUtil gfg = new MergeSortUtil();
		Node middle = gfg.getMiddle(h);
		Node nextofmiddle = middle.next;

		middle.next = null;

		Node left = mergeSort(h);
		Node right = mergeSort(nextofmiddle);

		Node sortedlist = gfg.sortedMerge(left, right);
		return sortedlist;
	}

	private Node sortedMerge(Node a, Node b) {
		Node result = null;

		if (a == null)
			return b;
		if (b == null)
			return a;

		if (a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}

	private Node getMiddle(Node h) {
		if (h == null)
			return h;
		Node fastptr = h.next;
		Node slowptr = h;

		while (fastptr != null) {
			fastptr = fastptr.next;
			if (fastptr != null) {
				slowptr = slowptr.next;
				fastptr = fastptr.next;
			}
		}
		return slowptr;
	}
}