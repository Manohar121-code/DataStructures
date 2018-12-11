package heap;

import java.util.Scanner;

public class HeightOfHeap {
	public static void main(String[] args) {
		System.out.println("Enter num of testcases");
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		/*while (testCases-- > 0) {
			int arrSize = scr.nextInt();
			int[] arr = new int[arrSize];
			for (int i = 0; i < arrSize; i++) {
				arr[i] = scr.nextInt();
			}
			int height = 1, lastIndex = arr.length-1;
			while (lastIndex != 0) {
				height++;
				lastIndex = lastIndex/2;
			}
			System.out.println(height);
		}*/
		while (testCases-- > 0) {
			int arrSize = scr.nextInt();
			int[] arr = new int[arrSize+1];
			
			for (int i = 1; i < arr.length; i++) {
				arr[i] = scr.nextInt();
			}
			int height = -1, rootIndex = 1;
			while (rootIndex < arr.length) {
				height++;
				rootIndex = rootIndex*2;
			}
			System.out.println(height);
		}
	}
}
