package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeKSortedArrays {
	public static void main(String[] args) {
		MergeKSortedArrays obj = new MergeKSortedArrays();
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			int length = scr.nextInt();
			int[][] arr = new int[length][length];
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					arr[i][j] = scr.nextInt();
				}
			}
			ArrayList<Integer> mergeKArrays = obj.mergeKArrays(arr, length);
			for (int i = 1; i < mergeKArrays.size(); i++) {
				System.out.print(mergeKArrays.get(i)+" ");
			}
			System.out.println();
		}
	}

	public static ArrayList<Integer> mergeKArrays(int[][] array, int k) {
		Integer[] arr = new Integer[array.length*array.length + 1];
		int count = 0;
		arr[count++] = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				arr[count++] = array[i][j];
			}
		}
		doMaxHeapify(arr);
		doHeapSort(arr, arr.length-1);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}
	
	private static void doHeapSort(Integer[] arr, int lastIndex) {
		while (lastIndex > 0) {
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

	private static void doMaxHeapify(Integer[] arr) {
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
