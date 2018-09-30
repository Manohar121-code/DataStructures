package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquilibriumPoint {
	/*public static void main(String[] args) {
		EquilibriumPoint obj = new EquilibriumPoint();
//		int[] arr = {1,2,4,3,7,5,7,8,5,4,3,5,6,7,6,4,3,4,6,7,7,6,4,4,5,6,67,7,7,6,5,4,5};
//		int[] arr = {1,2,4,3,7,5,7,8,5,4,3,2,1,2,4,3,7,5,7,8,5,4,3};
//		int[] arr = {1};
		int[] arr = {3,13,37,36,16,2,8,25};
		long startTime = System.nanoTime();
		obj.doOperation(arr, arr.length);
		long endTime = System.nanoTime();
		System.out.println("Time taken " + (endTime-startTime));
	}*/
	
	/*public static void main (String[] args) {
		GFG obj = new GFG();
        Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		List<int[]> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			int len = scr.nextInt();
			int[] arr = new int[len];
			for (int x = 0; x < len ; x++) {
				arr[x] = scr.nextInt();
			}
			list.add(arr);
		}
		for (int[] arr : list) {
		    System.out.println(obj.doOperation(arr, arr.length));
		}
	}*/
	
	public static void main (String[] args) {
		EquilibriumPoint obj = new EquilibriumPoint();
		Scanner scr = new Scanner(System.in);
		int[] arr;
		String[] arrayStr;
		List<int[]> list = new ArrayList<>();
		int numOfTestCases = scr.nextInt();
		for (int i = 1; i <= numOfTestCases; i++) {
			int lengthOfArray = scr.nextInt();
			arr = new int[lengthOfArray];
			arrayStr = new String[lengthOfArray];
			for (int j = 0; j < arrayStr.length; j++) {
				arrayStr[j] = scr.next();
				arr[j] = Integer.parseInt(arrayStr[j]);
			}
			list.add(arr);
		}
		for (int[] finalArray : list) {
			obj.doOperation(finalArray, finalArray.length);
		}
	}

	private void doOperation(int[] arr, int length) {
		if (length == 1) {
			System.out.println(arr[0]);
			return;
		}
		int totalSum = 0;
		int tempSum = 0;
		for (int i = 0; i < length; i++) {
			totalSum+=arr[i];
		}
		for (int i = 1; i < length; i++) {
			tempSum += arr[i-1];
			if (totalSum-arr[i] == 2*tempSum) {
				System.out.println(i+1);
				return;
			}
			if (tempSum > totalSum/2) {
				System.out.println("-1");
				return;
			}
		}
	}

	private int doSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
}
