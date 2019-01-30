package graph;

import java.util.Scanner;

public class RottenOranges {
	private int rows, cols, steps = 0;
	private static int FRESH = 1, ROTTEN = 2, PARTIAL = 3;
	public static void main(String[] args) {
		RottenOranges obj = new RottenOranges();
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			int rows = scr.nextInt();
			int cols = scr.nextInt();
			int[][] arr = new int[rows][cols];int[][] printOriginalArr = new int[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					printOriginalArr[i][j] = arr[i][j] = scr.nextInt();
				}
			}
			int[][] maxCounter = new int[rows][cols];
			boolean[][] visited = new boolean[rows][cols];
			obj.doRotten(rows, cols, arr, maxCounter, visited);
			System.out.println(obj.finalCheckForFreshOranges(arr, maxCounter));
			obj.print(printOriginalArr, maxCounter);
		}
	}
	
	private void print(int[][] printOriginalArr, int[][] maxCounter) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(printOriginalArr[i][j]+" ");
			}
			System.out.print(" ->  ");
			for (int j = 0; j < cols; j++) {
				System.out.print(maxCounter[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private void doRotten(int rows, int cols, int[][] arr, int[][] maxCounter, boolean[][] visited) {
		this.rows = rows;
		this.cols = cols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (arr[i][j] == ROTTEN || arr[i][j] == PARTIAL)
					doRecursion(i, j, arr, maxCounter, visited);
			}
		}
	}
	private void doRecursion(int i, int j, int[][] arr, int[][] maxCounter, boolean[][] visited) {
		visited[i][j] = true;
		//top
		if (i > 0 && (arr[i-1][j] == FRESH || (arr[i-1][j] == PARTIAL && !visited[i-1][j]))) {
			maxCounter[i-1][j] = (arr[i-1][j] == FRESH) ? maxCounter[i][j] + 1 : Math.min(maxCounter[i-1][j], maxCounter[i][j] + 1);
			if (arr[i-1][j] == FRESH)
				arr[i-1][j] = PARTIAL;
			doRecursion(i-1, j, arr, maxCounter, visited);
		}
		//left
		if (j > 0 && (arr[i][j-1] == FRESH || (arr[i][j-1] == PARTIAL && !visited[i][j-1]))) {
			maxCounter[i][j-1] = (arr[i][j-1] == FRESH) ? maxCounter[i][j] + 1 : Math.min(maxCounter[i][j-1], maxCounter[i][j] + 1);
			if (arr[i][j-1] == FRESH)
				arr[i][j-1] = PARTIAL;
			doRecursion(i, j-1, arr, maxCounter, visited);
		}
		//bottom
		if (i < rows-1 && (arr[i+1][j] == FRESH || (arr[i+1][j] == PARTIAL && !visited[i+1][j]))) {
			maxCounter[i+1][j] = (arr[i+1][j] == FRESH) ? maxCounter[i][j] + 1 : Math.min(maxCounter[i+1][j], maxCounter[i][j] + 1);
			if (arr[i+1][j] == FRESH)
				arr[i+1][j] = PARTIAL;
			doRecursion(i+1, j, arr, maxCounter, visited);
		}
		//right
		if (j < cols-1 && (arr[i][j+1] == FRESH || (arr[i][j+1] == PARTIAL && !visited[i][j+1]))) {
			maxCounter[i][j+1] = (arr[i][j+1] == FRESH) ? maxCounter[i][j] + 1 : Math.min(maxCounter[i][j+1], maxCounter[i][j] + 1);
			if (arr[i][j+1] == FRESH)
				arr[i][j+1] = PARTIAL;
			doRecursion(i, j+1, arr, maxCounter, visited);
		}
		
		visited[i][j] =false;
	}
	
	private int finalCheckForFreshOranges(int[][] arr, int[][] maxCounter) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (arr[i][j] == FRESH)
					return steps = -1;
				steps = Math.max(steps, maxCounter[i][j]);
			}
		}
		return steps;
	}
	
	//below logic is for doRecursion(int i, int j, int[][] arr, int[][] maxCounter, boolean[][] visited) simplification
//	//top
//			if (i > 0) {
//				if (arr[i-1][j] == FRESH) {
//					arr[i-1][j] = PARTIAL;
//					maxCounter[i-1][j] = maxCounter[i][j] + 1;
//					doRecursion(i-1, j, arr, maxCounter, visited);
//				} else if (arr[i-1][j] == PARTIAL && !visited[i-1][j]) {
//					maxCounter[i-1][j] = Math.min(maxCounter[i-1][j], maxCounter[i][j] + 1);
//					doRecursion(i-1, j, arr, maxCounter, visited);
//				}
//			}
//			//left
//			if (j > 0) {
//				if (arr[i][j-1] == FRESH) {
//					arr[i][j-1] = PARTIAL;
//					maxCounter[i][j-1] = maxCounter[i][j] + 1;
//					doRecursion(i, j-1, arr, maxCounter, visited);
//				} else if (arr[i][j-1] == PARTIAL && !visited[i][j-1]) {
//					maxCounter[i][j-1] = Math.min(maxCounter[i][j-1], maxCounter[i][j] + 1);
//					doRecursion(i, j-1, arr, maxCounter, visited);
//				}
//			}
//			//bottom
//			if (i < rows-1) {
//				if (arr[i+1][j] == FRESH) {
//					arr[i+1][j] = PARTIAL;
//					maxCounter[i+1][j] = maxCounter[i][j] + 1;
//					doRecursion(i+1, j, arr, maxCounter, visited);
//				} else if (arr[i+1][j] == PARTIAL && !visited[i+1][j]) {
//					maxCounter[i+1][j] = Math.min(maxCounter[i+1][j], maxCounter[i][j] + 1);
//					doRecursion(i+1, j, arr, maxCounter, visited);
//				}
//			}
//			//right
//			if (j < cols-1) {
//				if (arr[i][j+1] == FRESH) {
//					arr[i][j+1] = PARTIAL;
//					maxCounter[i][j+1] = maxCounter[i][j] + 1;
//					doRecursion(i, j+1, arr, maxCounter, visited);
//				} else if (arr[i][j+1] == PARTIAL && !visited[i][j+1]) {
//					maxCounter[i][j+1] = Math.min(maxCounter[i][j+1], maxCounter[i][j] + 1);
//					doRecursion(i, j+1, arr, maxCounter, visited);
//				}
//			}
}
