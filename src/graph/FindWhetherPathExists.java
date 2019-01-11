package graph;

import java.util.Scanner;

public class FindWhetherPathExists {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		FindWhetherPathExists obj = new FindWhetherPathExists();
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			int N = scr.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = scr.nextInt();
				}
			}
			System.out.println(obj.findWhetherPathExists(arr, N) ? "Exists" : "NotExists");
		}
	}

	private boolean result;
	private boolean findWhetherPathExists(int[][] arr, int n) {
		result = false;
		boolean breakIt = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					boolean[][] boolArr = new boolean[arr.length][arr.length];
					doOperation(arr, boolArr, i, j);
					breakIt = true;
					break;
				}
			}
			if (breakIt)
				break;
		}
		return result;
	}

	private void doOperation(int[][] arr, boolean[][] boolArr, int i, int j) {
		if (result) return;
		if (i >= 0 && i < arr.length && j >= 0 && j < arr.length && arr[i][j] != 0 && !boolArr[i][j]) {			
			if (arr[i][j] == 2) {
				result = true;
				return;
			}
			boolArr[i][j] = true;
			doOperation(arr, boolArr, i-1, j);//top
			doOperation(arr, boolArr, i, j-1);//left
			doOperation(arr, boolArr, i+1, j);//bottom
			doOperation(arr, boolArr, i, j+1);//right
		}
	}
}
