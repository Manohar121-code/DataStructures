package recursion;

import java.util.Scanner;

public class ShortestPath {
	private static int shortest = Integer.MAX_VALUE;
	private static int rows, cols, x2, y2;
	private static int TOP = 1, LEFT = 2, BOTTOM = 3, RIGHT = 4, TOP_RIGHT = 5, TOP_LEFT = 6, BOTTOM_LEFT = 7, BOTTOM_RIGHT = 8;
	private static int[][] copyArr;
	
	public static void main(String[] args) {
		ShortestPath obj = new ShortestPath();
		Scanner scr = new Scanner(System.in);
		System.out.println("enter num of testcases");
		int t = scr.nextInt();
		while (t > 0) {
			rows = scr.nextInt();
			cols = scr.nextInt();
			int[][] arr = new int[rows][cols];
			copyArr = new int[rows][cols];
			//start & end points
			int x1 = scr.nextInt(), y1 = scr.nextInt();
			x2 = scr.nextInt(); y2 = scr.nextInt();
			//validation
			if (obj.validate(x1, y1, x2, y2)) {
				long startTime = System.nanoTime();
				obj.doRecursion(arr, x1, y1, obj.getMargin(x1, y1), 0);
				long endTime = System.nanoTime();
				System.out.println(shortest);
				obj.printArray(copyArr);
				System.out.println(endTime-startTime);
			}
			t--;
		}
	}

	private void doRecursion(int[][] arr, int i, int j, int margin, int counter) {
		if (i == x2 && j == y2) {
			shortest = Math.min(counter, shortest);
			return;
		}
		if (margin == LEFT && j > 0 && copyArr[i][j-1] == 0) { // left
			copyArr[i][j-1] = counter+1;doRecursion(arr, i, j - 1, getMargin(i, j-1), counter+1);
		}
		if (margin == RIGHT && j < cols - 1 && copyArr[i][j+1] == 0) { // right
			copyArr[i][j+1] = counter+1;doRecursion(arr, i, j + 1, getMargin(i, j+1), counter+1);
		}
		if (margin == TOP || margin == TOP_RIGHT || margin == TOP_LEFT) {
			if (i > 0 && copyArr[i-1][j] == 0) { // top
				copyArr[i-1][j] = counter+1;doRecursion(arr, i - 1, j, getMargin(i-1, j), counter+1);
			}
			if (margin == TOP_RIGHT && j < cols - 1 && copyArr[i][j+1] == 0) { // right
				copyArr[i][j+1] = counter+1;doRecursion(arr, i, j + 1, getMargin(i, j+1), counter+1);
			}
			if (margin == TOP_LEFT && j > 0 && copyArr[i][j-1] == 0) { // left
				copyArr[i][j-1] = counter+1;doRecursion(arr, i, j - 1, getMargin(i, j-1), counter+1);
			}
		}
		if (margin == BOTTOM || margin == BOTTOM_LEFT || margin == BOTTOM_RIGHT) {
			if (i < rows - 1 && copyArr[i+1][j] == 0) { // bottom
				copyArr[i+1][j] = counter+1;doRecursion(arr, i + 1, j, getMargin(i+1, j), counter+1);
			}
			if (margin == BOTTOM_LEFT && j > 0 && copyArr[i][j-1] == 0) { // left
				copyArr[i][j-1] = counter+1;doRecursion(arr, i, j - 1, getMargin(i, j-1), counter+1);
			}
			if (margin == BOTTOM_RIGHT && j < cols - 1 && copyArr[i][j+1] == 0) { // right
				copyArr[i][j+1] = counter+1;doRecursion(arr, i, j + 1, getMargin(i, j+1), counter+1);
			}
		}
	}

	//1 1 1
	//1 1 1
	//1 1 1
	private int getMargin(int x1, int y1) {
		if (x1 == x2)
			return y1 < y2 ? RIGHT : LEFT;
		else if (y1 == y2)
			return x1 < x2 ? BOTTOM : TOP;
		else if (x1 < x2 && y1 < y2)
			return BOTTOM_RIGHT;
		else if (x1 < x2 && y1 > y2)
			return BOTTOM_LEFT;
		else if (x1 > x2 && y1 < y2)
			return TOP_RIGHT;
		else if (x1 > x2 && y1 > y2)
			return TOP_LEFT;
		else
			return 0;
	}
	
	private boolean validate(int x1, int y1, int x2, int y2) {
		return !(x1 >= rows || y1 >= cols || x2 >= rows || y2 >= cols); 
	}
	
	private void printArray(int[][] arr) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
