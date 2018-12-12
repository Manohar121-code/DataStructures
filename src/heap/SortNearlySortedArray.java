package heap;

import java.util.Scanner;

public class SortNearlySortedArray {
	public static void main(String[] args) {
		/*Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			int length = scr.nextInt();
			int k = scr.nextInt();
			int[] arr = new int[length];
			for (int i = 0; i < length; i++) {
				arr[i] = scr.nextInt();
			}
			sortIt(arr, k);
		}*/
//		int[] arr = {2, 1, 3};
		int[] arr = {2, 6, 3, 12, 56, 8};
		int k = 3;
		SortNearlySortedArray obj = new SortNearlySortedArray();
		obj.sortIt(arr, k);
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private void sortIt(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			int smallIndex = i;
			for (int j = i+1; j <= i+k && j < arr.length; j++) {
				smallIndex = (arr[smallIndex] > arr[j]) ? j : smallIndex;
			}
			if (smallIndex != i) {
				int tempSmall = arr[smallIndex];
				arr[smallIndex] = arr[i];
				arr[i] = tempSmall;
			}
		}
	}
}
