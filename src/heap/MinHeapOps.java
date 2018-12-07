package heap;

import java.util.Scanner;

public class MinHeapOps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
		harr = new int[a];
		capacity = a;
		heap_size = 0;
	}

	public int extractMin() {
		return 0;
	}

	public void insertKey(int k) {
		
	}

	public void deleteKey(int i) {
		
	}
}