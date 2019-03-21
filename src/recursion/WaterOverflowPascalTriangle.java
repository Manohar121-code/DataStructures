package recursion;

import java.util.Scanner;

public class WaterOverflowPascalTriangle {
	private static int ROWS, COLS;
	private int UNIT = 1;
	public static void main(String[] args) {
		WaterOverflowPascalTriangle obj = new WaterOverflowPascalTriangle();
		Scanner scr = new Scanner(System.in);
		System.out.println("Please enter number of testcases : ");
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			System.out.println("-------------------------------------");
			System.out.println("Enter Num of rows of pascal triangle : ");
			int n = scr.nextInt();
			ROWS = n;
			COLS = (2*n)-1;
			double[][] arr = new double[ROWS][COLS];
			System.out.println("Enter source & destination place : ");
			int destI = scr.nextInt() - 1; //taking not by index based
			int destJ = scr.nextInt() - 1; //taking not by index based
			
			double resultUnit = obj.doOperation(arr, 0, n-1, n, destI, ((n-1)-destI)+(2*destJ));// start index
			System.out.println("Water at destination : "+resultUnit);
		}
	}

	private double doOperation(double[][] arr, int i, int j, int numOfGlasses, int destI, int destJ) {
		for (int z = 0; z < numOfGlasses; z++)
			doRecursive(arr, i, j, UNIT);
		for (int k = 0; k < ROWS; k++) {
			for (int k2 = 0; k2 < COLS; k2++)
				System.out.print(arr[k][k2]+" ");
			System.out.println();
		}
		return arr[destI][destJ];
	}

	private void doRecursive(double[][] arr, int i, int j, double inputUnit) {
		if (i < 0 || j < 0 || i == ROWS || j == COLS)
			return;
		arr[i][j] += inputUnit;
		double half = 0;
		if (arr[i][j] > UNIT) {
			half = (arr[i][j] - UNIT) / 2;
			arr[i][j] = UNIT;
			if (half > 0) {
				doRecursive(arr, i+1, j-1, half); //bottom left
				doRecursive(arr, i+1, j+1, half); //bottom right
			}
		}
	}
}
