package recursion;

public class FloodFillAlgorithm {
	public static void main(String[] args) {
		
	}
	
	/*private static int rows, cols;
	public static void main(String[] args) {
		FloodFillAlgorithm obj = new FloodFillAlgorithm();
		rows = 3;
		cols = 4;
		int[][] arr = {{0, 1, 1, 0}, {1, 1, 1, 1}, {0, 1, 2, 3}};
		obj.printArray(arr, rows, cols);
		int inputRow = 0;
		int inputCol = 1;
		int fillNum = 5;
		int oldNum = arr[inputRow][inputCol];
		long startTime = System.nanoTime();
		obj.doRecursion(arr, inputRow, inputCol, oldNum, fillNum);
		long endTime = System.nanoTime();
		System.out.println("Total time taken "+ (endTime - startTime));
		obj.printArray(arr, rows, cols);
	}
	
	public static void main(String[] args) {
		FloodFillAlgorithm obj = new FloodFillAlgorithm();
		Scanner scr = new Scanner(System.in);
		int t = scr.nextInt();
		while (t > 0) {
			rows = scr.nextInt();
			cols = scr.nextInt();
			int[][] arr = new int[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					arr[i][j] = scr.nextInt();
				}
			}
			int inputRow = scr.nextInt();
			int inputCol = scr.nextInt();
			int fillNum = scr.nextInt();
			obj.doRecursion(arr, inputRow, inputCol, arr[inputRow][inputCol], fillNum);
			obj.printArray(arr, rows, cols);
			t--;
		}
	}

	private void doRecursion(int[][] arr, int i, int j, int oldNum, int fillNum) {
		arr[i][j] = fillNum;
		//top
		if (i > 0 && arr[i-1][j] == oldNum)
			doRecursion(arr, i-1, j, oldNum, fillNum);
		//bottom
		if (i < rows-1 && arr[i+1][j] == oldNum)
			doRecursion(arr, i+1, j, oldNum, fillNum);
		//left
		if (j > 0 && arr[i][j-1] == oldNum)
			doRecursion(arr, i, j-1, oldNum, fillNum);
		//right
		if (j < cols-1 && arr[i][j+1] == oldNum)
			doRecursion(arr, i, j+1, oldNum, fillNum);
	}

	private void printArray(int[][] arr, int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(arr[i][j]+" ");
			}
//			System.out.println();
		}
	}*/
}
