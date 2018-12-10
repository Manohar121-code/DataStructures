package heap;

import java.util.Scanner;

public class MinHeapOps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number");
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			MinHeap h = new MinHeap(a);
			for (int i = 0; i < a; i++) {
				int c = sc.nextInt();
				int n;
				if (c == 1) {
					n = sc.nextInt();

					h.insertKey(n);
				}
				if (c == 2) {
					n = sc.nextInt();
					h.deleteKey(n);
				}
				if (c == 3) {
					System.out.print(h.extractMin() + " ");
				}

			}
			System.out.println();
		}
	}
}

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

// User function Template for Java
class MinHeap {

	public static int[] harr;
	public static int capacity;
	public static int heap_size;

	public MinHeap(int a) {
		harr = new int[a+1];
		capacity = a+1;
		heap_size = 0;
	}

	public int extractMin() {
		if (heap_size <= 0)
			return -1;
		int res= harr[1];
		deleteKey(0);
		return res;
	}
//	1
//	7
//	1 9 1 7 1 5 1 3 1 4 1 10
//	3
	
	public void insertKey(int k) {
		if (heap_size >= harr.length) {
			System.out.println("Heap size exceeded.");
			return;
		}
		harr[++heap_size] = k;
		int childIndex = heap_size, parentIndex = childIndex/2;
		while (parentIndex > 0) {
			if (k < harr[parentIndex]) {
				harr[childIndex] = harr[parentIndex];
				
				childIndex = parentIndex;
				parentIndex = childIndex/2;
			} else if (k == harr[parentIndex]) {
				deleteKey(parentIndex-1);
			} else {
				break;
			}
		}
		if (k < harr[childIndex])
			harr[childIndex] = k;
	}

	/*public void insertKey(int k) {
		if (heap_size >= harr.length) {
			System.out.println("Heap size exceeded.");
			return;
		}
		harr[++heap_size] = k;
		int childIndex = heap_size, parentIndex = childIndex/2;
		while (parentIndex > 0) {
			if (k < harr[parentIndex]) {
//				int childTemp = harr[childIndex];
				harr[childIndex] = harr[parentIndex];
//				harr[parentIndex] = childTemp;
				
				childIndex = parentIndex;
				parentIndex = childIndex/2;
			} else {
				break;
			}
		}
		if (parentIndex < 1 && k < harr[childIndex])
			harr[childIndex] = k;
	}*/

	public void deleteKey(int k) {
		if (k < 0 || k >= heap_size)
			return;
		k++;
		int lastEle = harr[heap_size--]/*, res = harr[k]*/;
		harr[k] = Integer.MAX_VALUE;
		int parentIndex = k, childIndex = parentIndex * 2;
		while (childIndex <= heap_size/* && harr[childIndex] < harr[parentIndex]*/) {
			if (childIndex+1 <= heap_size && harr[childIndex+1] < harr[childIndex])
				childIndex++;
			if (harr[childIndex] < harr[parentIndex]) {
				harr[parentIndex] = harr[childIndex];
				parentIndex = childIndex;
				childIndex = parentIndex * 2;
			} else {
				break;
			}
		}
		harr[parentIndex] = lastEle;
	}
}