package heap;

import java.util.Scanner;

public class K_LargestElements {
	public static void main(String[] args) {/*
//		int[] arr = {0, 12, 5, 787, 1, 23};
//		int k = 2;
		
		int[] arr = {0, 486, 94, 344};
		int k = 1, count = 0;
		K_LargestElements obj = new K_LargestElements();
		obj.doMaxHeapify(arr);
		obj.get_K_Elements(arr, k);
		for (int i = arr.length-1; count++ < k; i--) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	*/

		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			int length = scr.nextInt();
			int k = scr.nextInt(), count = 0;
			int[] arr = new int[length+1];
			for (int i = 1; i <= length; i++) {
				arr[i] = scr.nextInt();
			}
			K_LargestElements obj = new K_LargestElements();
	    	obj.doMaxHeapify(arr);
		    obj.get_K_Elements(arr, k);
		    for (int i = arr.length-1; count++ < k; i--) {
		    	System.out.print(arr[i]+" ");
		    }
		    System.out.println();
		}
	}
	
	private void get_K_Elements(int[] arr, int k) {
		int lastIndex = arr.length-1;
		while (lastIndex > (arr.length-1) - k) {
			int smallTemp = arr[lastIndex];
			arr[lastIndex] = arr[1];
			arr[1] = smallTemp;
			lastIndex--;
			int parentIndex = 1, childIndex = parentIndex*2, parentVal = arr[parentIndex];
			while (childIndex <= lastIndex) {
				if (childIndex+1 <= lastIndex && arr[childIndex+1] > arr[childIndex])
					childIndex++;
				if (arr[childIndex] > parentVal) {
					arr[parentIndex] = arr[childIndex];
					parentIndex = childIndex;
					childIndex = parentIndex*2;
				} else {
					break;
				}
			}
			arr[parentIndex] = parentVal;
		}
	}

	private void doMaxHeapify(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int childIndex = i, k = arr[i];
			int parentIndex = childIndex/2;
			if (parentIndex < 1)
				continue;
			while (parentIndex > 0) {
				if (k > arr[parentIndex]) {
					arr[childIndex] = arr[parentIndex];
					
					childIndex = parentIndex;
					parentIndex = childIndex/2;
				} else {
					break;
				}
			}
			if (k > arr[childIndex])
				arr[childIndex] = k;
		}
	}
}
