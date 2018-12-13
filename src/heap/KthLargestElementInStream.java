package heap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KthLargestElementInStream {
	//It's not for stream
	/*public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		KthLargestElementInStream obj = new KthLargestElementInStream();
		while (testCases-- > 0) {
			int k = scr.nextInt();
			int length = scr.nextInt();
			int[] arr = new int[length];
			Queue<Integer> queueObj = new PriorityQueue<Integer>();
			for (int i = 0; i < length; i++) {
				arr[i] = scr.nextInt();
			}
			obj.doOperation(arr, queueObj, k);
			System.out.println();
		}
	}
	
	private void doOperation(int[] arr, Queue<Integer> queueObj, int k) {
		for (int i = 0; i < arr.length; i++) {
			if (i < k - 1) {
				queueObj.add(arr[i]);
				System.out.print(-1+" ");
			} else {
				if (queueObj.size() < k)
					queueObj.add(arr[i]);
				else if (queueObj.peek() < arr[i]) {
					queueObj.poll();
					queueObj.add(arr[i]);
				}
				System.out.print(queueObj.peek()+" ");
			}
		}
	}
	*/
	
//	1
//	47 84
//	778 916 794 336 387 493 650 422 363 28 691 60 764 927 541 427 173 737 212 369 568 430 783 531 863 124 68 136 930 803 23 59 70 168 394 457 12 43 230 374 422 920 785 538 199 325 316 371 414 527 92 981 957 874 863 171 997 282 306 926 85 328 337 506 847 730 314 858 125 896 583 546 815 368 435 365 44 751 88 809 277 179 789 585

	//It's for stream
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		KthLargestElementInStream obj = new KthLargestElementInStream();
		while (testCases-- > 0) {
			int k = scr.nextInt();
			int length = scr.nextInt();
			Queue<Integer> queueObj = new PriorityQueue<Integer>();
			while (true) {
				int curr = scr.nextInt();
				obj.doOperationInStream(queueObj, curr, k);
			}
		}
	}

	private void doOperationInStream(Queue<Integer> queueObj, int curr, int k) {
		if (queueObj.size() < k-1) {
			queueObj.add(curr);
			System.out.print(-1+" ");
		} else {
			if (queueObj.size() < k)
				queueObj.add(curr);
			else if (queueObj.peek() < curr) {
				queueObj.poll();
				queueObj.add(curr);
			}
			System.out.print(queueObj.peek()+" ");
		}
	}
}
