package recursion;

import java.util.Random;
import java.util.Scanner;

public class ShortestPathByValue {
	private static int shortest = Integer.MAX_VALUE;
	private static int rows, cols, x2, y2;
	private static int[][] copyArr;

	public static void main(String[] args) {
		ShortestPathByValue obj = new ShortestPathByValue();
//		obj.getRandomArr();
		Scanner scr = new Scanner(System.in);
		rows = 15;
		cols = 13;
		/*int[][] arr = new int[][]{{5, 9, 8, 3, 8, 4, 6, 2, 2, 2, 8, 9, 7}, 
								  {3, 8, 6, 1, 1, 3, 4, 7, 9, 6, 7, 1, 3}, 
								  {1, 8, 9, 4, 8, 3, 2, 7, 7, 3, 9, 4, 5}, 
								  {6, 4, 6, 8, 6, 9, 9, 9, 9, 8, 9, 9, 1}, 
								  {7, 6, 3, 2, 9, 6, 5, 8, 6, 9, 4, 2, 7}, 
								  {7, 8, 2, 1, 9, 8, 3, 4, 4, 5, 1, 7, 7}, 
								  {2, 1, 4, 9, 3, 1, 2, 1, 2, 5, 1, 9, 9}, 
								  {2, 5, 4, 6, 8, 4, 3, 6, 8, 3, 4, 9, 2}, 
								  {9, 6, 8, 1, 2, 1, 2, 5, 4, 9, 5, 9, 8}, 
								  {3, 8, 5, 3, 3, 9, 9, 2, 8, 8, 2, 3, 3}, 
								  {2, 2, 3, 6, 1, 3, 6, 3, 7, 5, 4, 7, 7}, 
								  {4, 7, 4, 4, 5, 3, 7, 8, 1, 8, 8, 4, 8}, 
								  {8, 6, 8, 5, 2, 1, 8, 1, 1, 1, 7, 5, 8}, 
								  {7, 3, 9, 6, 9, 3, 6, 1, 6, 2, 1, 4, 4}, 
								  {5, 9, 4, 6, 9, 2, 2, 4, 9, 7, 9, 7, 4}};*/
		int[][] arr = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 8, 9, 7}, 
								  {1, 8, 6, 1, 1, 3, 4, 1, 9, 6, 7, 1, 3}, 
								  {1, 8, 9, 4, 8, 3, 2, 1, 7, 3, 9, 4, 5}, 
								  {1, 4, 6, 8, 6, 9, 9, 1, 9, 8, 9, 9, 1}, 
								  {1, 6, 3, 2, 9, 6, 5, 8, 6, 9, 4, 2, 7}, 
								  {1, 8, 2, 1, 9, 8, 3, 4, 4, 5, 1, 7, 7}, 
								  {1, 1, 4, 9, 3, 1, 2, 1, 2, 5, 1, 9, 9}, 
								  {1, 5, 4, 6, 8, 4, 3, 6, 8, 3, 4, 9, 2}, 
								  {1, 6, 8, 1, 2, 1, 2, 5, 4, 9, 5, 9, 8}, 
								  {1, 8, 5, 3, 3, 9, 9, 2, 8, 8, 2, 3, 3}, 
								  {1, 2, 3, 6, 1, 3, 6, 3, 7, 5, 4, 7, 7}, 
								  {1, 7, 4, 4, 5, 3, 7, 8, 1, 8, 8, 4, 8}, 
								  {1, 6, 1, 1, 1, 1, 8, 1, 1, 1, 7, 5, 8}, 
								  {1, 3, 1, 5, 1, 3, 6, 1, 6, 2, 1, 4, 4}, 
								  {1, 1, 1, 1, 1, 2, 2, 4, 9, 7, 9, 7, 4}};
		copyArr = new int[rows][cols];
		obj.fillMaxValues();
		// start & end points
		/*int x1 = 0, y1 = 0;
		x2 = 14;
		y2 = 12;*/
		int x1 = 12, y1 = 5;
		x2 = 3;
		y2 = 7;
		// validation
		if (obj.validate(x1, y1, x2, y2)) {
			long startTime = System.nanoTime();
			copyArr[x1][y1] = arr[x1][y1];
			obj.doRecursion(arr, x1, y1, arr[x1][y1]);
			long endTime = System.nanoTime();
			obj.printArray(arr);
			System.out.println("------------------------");
			obj.printArray(copyArr);
			System.out.println(shortest);
			System.out.println(endTime - startTime);
		}
	}

	private void doRecursion(int[][] arr, int i, int j, int sum) {
		if (i == x2 && j == y2) {
			shortest = Math.min(sum, shortest);
			return;
		}
		if (i > 0 && sum + arr[i - 1][j] < copyArr[i - 1][j]) { // top
			copyArr[i - 1][j] = sum + arr[i - 1][j];
			doRecursion(arr, i - 1, j, sum + arr[i - 1][j]);
		}
		if (j > 0 && sum + arr[i][j - 1] < copyArr[i][j - 1]) { // left
			copyArr[i][j - 1] = sum + arr[i][j - 1];
			doRecursion(arr, i, j - 1, sum + arr[i][j - 1]);
		}
		if (i < rows - 1 && sum + arr[i + 1][j] < copyArr[i + 1][j]) { // bottom
			copyArr[i + 1][j] = sum + arr[i + 1][j];
			doRecursion(arr, i + 1, j, sum + arr[i + 1][j]);
		}
		if (j < cols - 1 && sum + arr[i][j + 1] < copyArr[i][j + 1]) { // right
			copyArr[i][j + 1] = sum + arr[i][j + 1];
			doRecursion(arr, i, j + 1, sum + arr[i][j + 1]);
		}
	}

	private void fillMaxValues() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				copyArr[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	private boolean validate(int x1, int y1, int x2, int y2) {
		return !(x1 >= rows || y1 >= cols || x2 >= rows || y2 >= cols);
	}

	private void printArray(int[][] arr) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void getRandomArr() {
		Random rand = new Random();
		for (int i = 0; i < 15; i++) {
			System.out.print("{");
			for (int j = 0; j < 13; j++) {
				String ss = ", ";
				if (j == 12) {
					ss = "";
				}
				System.out.print(rand.nextInt(9) + 1+ss);
			}
			System.out.print("}\n");
		}
	}
	
}


