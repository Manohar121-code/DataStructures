package binarySearchTree;

import java.util.Scanner;

public class PrintLeafsFromPreOrderBST {
//	public static void main(String[] args) {
//		int[] arr = {890, 325, 290, 530, 965};
//		
//		PrintLeafsFromPreOrderBST obj = new PrintLeafsFromPreOrderBST();
//		int[] copyArr = new int[arr.length];
////		obj.getNextGreaterElement(arr, copyArr);
//		obj.doOperation(arr, 0, arr.length-1);
//	}
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases > 0) {
			PrintLeafsFromPreOrderBST obj = new PrintLeafsFromPreOrderBST();
			int length = scr.nextInt();
			int[] arr = new int[length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scr.nextInt();
			}
			obj.doOperation(arr, 0, arr.length-1);
			System.out.println();
			testCases--;
		}
	}

	private void doOperation(int[] arr, int start, int end) {
		if (start == end) {
			System.out.print(arr[start]+" ");
			return;
		}
		int tempEnd = start+1;
		while (tempEnd < arr.length && arr[start] > arr[tempEnd])
			tempEnd++;
		if (tempEnd < arr.length) {
			doOperation(arr, start+1, tempEnd-1);
			doOperation(arr, tempEnd, end);
		} else {
			doOperation(arr, start+1, end);
		}
	}
	
	/*private void doOperation(int[] arr, int start, int end) {
		if (start == end) {
			System.out.print(arr[start]+" ");
			return;
		}
		int tempEnd = end;
		while (tempEnd < arr.length && start > tempEnd)
			tempEnd++;
		if (tempEnd < arr.length) {
			doOperation(arr, start+1, tempEnd-1);
			doOperation(arr, tempEnd, end);
		} else {
			doOperation(arr, start+1, end);
		}
	}*/

	/*private void getNextGreaterElement(int[] arr, int[] copyArr) {
		for (int i = 0; i < arr.length; i++) {
			int tempIndex = i+1;
			while (tempIndex < arr.length && arr[i] > arr[tempIndex])
				tempIndex++;
			if (tempIndex < arr.length)
				copyArr[i] = tempIndex;
			else
				copyArr[i] = -1;
		}
	}*/
}
