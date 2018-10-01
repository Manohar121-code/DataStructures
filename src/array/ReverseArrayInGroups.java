package array;

import java.util.Scanner;

public class ReverseArrayInGroups {
	public static void main(String[] args) {
		ReverseArrayInGroups obj = new ReverseArrayInGroups();
		Scanner scr = new Scanner(System.in);
		// int[] arr = {1,101,2,3,100,4,5};
		// int[] arr = {10,5,4,3};
		// int[] arr = {6,101,1,3,7,100,5};
		int[] arr = { 3, 2, 6, 4, 5, 1, 5, 7, 4, 2, 6, 7, 4, 3, 3, 6, 7, 5, 3, 3, 2, 6, 4, 5, 1, 5, 7, 4, 2, 6, 7, 4, 3, 3, 6, 7, 5, 3 };
		System.out.println("Please enter the number to group arrays : ");
		int k = scr.nextInt();
		long startTime = System.nanoTime();
		obj.doOperation(arr, arr.length, k);
		long endTime = System.nanoTime();
		System.out.println("Time taken : " + (endTime - startTime));
	}

	private void doOperation(int[] arr, int length, int k) {
		if (k > length) {
			System.out.println("-1");
			return;
		}
		for (int i = 0; i < length; i += k) {
			int tempStart = i;
			// int end = (tempStart+k-1) < length ? (tempStart+k-1) : length-1;
			int end = Math.min((tempStart + k - 1), length - 1);
			// System.out.print(tempStart+" "+end+" -> ");
			while (tempStart < end) {
				int temp = arr[end];
				arr[end--] = arr[tempStart];
				arr[tempStart++] = temp;
			}
			// System.out.println(tempStart+" "+end);
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
