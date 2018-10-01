package recursion;

import java.util.Scanner;

public class NumberOfPaths {
	private static int count;
	private static int rows, cols;
	public static void main(String[] args) {
		NumberOfPaths obj = new NumberOfPaths();
		Scanner scr = new Scanner(System.in);
		int t = scr.nextInt();
		while (t > 0) {
			count = 0;
			rows = scr.nextInt();
			cols = scr.nextInt();
			int[][] arr = new int[rows][cols];
			long startTime = System.nanoTime();
			obj.doRecursion(arr, 0, 0);
			long endTime = System.nanoTime();
			System.out.println(count);
			System.out.println(endTime-startTime);
			t--;
		}
	}

	private void doRecursion(int[][] arr, int i, int j) {
		if (i == rows-1 && j == cols-1) {
			count++;
		}
		//bottom
		if (i < rows-1)
			doRecursion(arr, i+1, j);
		//right
		if (j < cols-1)
			doRecursion(arr, i, j+1);
	}

}
