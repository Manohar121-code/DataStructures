package array;

import java.util.Scanner;

public class IncreasingSubSeqMaxSum {
	public static void main(String[] args) {
		IncreasingSubSeqMaxSum obj = new IncreasingSubSeqMaxSum();
//		int[] arr = {1,101,2,3,100,4,5};
//		int[] arr = {10,5,4,3};
//		int[] arr = {6,101,1,3,7,100,5};
//		int[] arr = {3, 2, 6, 4, 5, 1,5,7,4,2,6,7,4,3,3,6,7,5,3};
		int[] arr = {726, 32, 493, 143, 223, 287, 65, 901, 188, 361, 414, 975, 271, 171, 236, 834, 712, 761, 897, 668, 286, 551, 141, 695, 696, 625, 20, 126, 577, 695, 659, 303, 372, 467, 679, 594, 852, 485, 19, 465, 120, 153, 801, 88, 61, 927, 11, 758, 171, 316, 577, 228, 44, 759, 165, 110, 883, 87, 566, 488, 578, 475, 626, 628, 630, 929, 424, 521, 903, 963, 124, 597, 738, 262, 196, 526, 265, 261, 203, 117, 31, 327, 12, 772, 412, 548, 154, 521, 791, 925, 189, 764, 941, 852};
		long startTime = System.nanoTime();
		obj.doOperation(arr);
		long endTime = System.nanoTime();
		System.out.println("Time taken "+ (endTime - startTime));
	}
	
	/*public static void main(String[] args) {
		IncreasingSubSeqMaxSum obj = new IncreasingSubSeqMaxSum();
		Scanner scr = new Scanner(System.in);
		int numOfTestCases = scr.nextInt();
		for (int i = 1; i <= numOfTestCases; i++) {
			int lengthOfArray = scr.nextInt();
			int[] arr = new int[lengthOfArray];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = scr.nextInt();
			}
			obj.doOperation(arr);
		}
	}*/
	
	private void doOperation(int[] arr) {
		int length = arr.length;
		//copying the array into another array
		int[] copyArr = arr.clone();
		int finalSum = arr[0];
		for (int i = 1; i < length; i++) {
			int tempSum = 0, backTrackIndex = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				//getting Max sum(copyArr) less than the current index value
				if (copyArr[j] > tempSum && arr[j] < arr[i]) {
					tempSum = copyArr[j];
					backTrackIndex = j;
				}
			}
			copyArr[i] = backTrackIndex >= 0 ? copyArr[backTrackIndex] + arr[i] : arr[i];
			//calculating max sum
			finalSum = copyArr[i] > finalSum ? copyArr[i] : finalSum;
		}
		System.out.println(finalSum);
		for (int i = 0; i < length; i++) {
			System.out.print(copyArr[i]+" ");
		}
		System.out.println();
	}


	/*if(arr[i-1]<=arr[i]) {
		copyArr[i] = copyArr[bckTrckIndex] + arr[i];
	} else if(arr[i-1]>arr[i]&&bckTrckIndex>=0) {
		copyArr[i] = copyArr[bckTrckIndex] + arr[i];
	}else {
		copyArr[i] = arr[i];
	}*/

	
	private void doOperation2(int[] arr) {
		int[] copyArr = arr.clone();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] < arr[i]) {
				int tempSum = 0, bckTrckIndex = -1;
				for (int j = 0; j < i; j++) {
					if (copyArr[j] > tempSum && arr[j] <= arr[i]) {
						tempSum = copyArr[j];
						bckTrckIndex = j;
					}
				}
				copyArr[i] = copyArr[bckTrckIndex] + arr[i];
			} else {
				int tempSum = 0, bckTrckIndex = -1;
				for (int j = 0; j < i; j++) {
					if (copyArr[j] > tempSum && arr[j] <= arr[i]) {
						tempSum = copyArr[j];
						bckTrckIndex = j;
					}
				}
				if (bckTrckIndex >= 0) {
					copyArr[i] = copyArr[bckTrckIndex] + arr[i];
				} else {
					copyArr[i] = arr[i];
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+" ");
		}
		System.out.println();
	}
	
}
