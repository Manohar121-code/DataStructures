package array;

public class RottenOranges {
	private static int count = 0;
	private static int FRESH = 1;
	private static int ROTTEN = 2;
	private static int DEFAULT = -1;
	private static int VISITED = 3;
	private static int rows, cols;
	int[][] arr;
	private static int[][] copyArr;
	public static void main(String[] args) {
		RottenOranges obj = new RottenOranges();
		rows = 3;
		cols = 5;
		copyArr = new int[rows][cols];
		obj.fillDefaultValues();
//		2 1 0 2 1 
//		1 0 1 2 1 
//		1 0 0 2 1 
		int[][] arr = {{2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
		obj.printArray(arr, rows, cols);
		long startTime = System.nanoTime();
		System.out.println(obj.doOperation(arr));
		long endTime = System.nanoTime();
		System.out.println("Total time taken "+ (endTime - startTime));
		obj.printArray(arr, rows, cols);
		obj.printArray(copyArr, rows, cols);
	}

	private String doOperation(int[][] arr) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (copyArr[i][j] == DEFAULT && arr[i][j] == ROTTEN)
					doRecursion(arr, i, j);
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (arr[i][j] == FRESH) {
					return "Failure";
				}
			}
		}
		System.out.println("Total Count is : "+count);
		return "Success";
	}
	
	private void doRecursion(int[][] arr, int i, int j) {
		//top
		if (i > 0 && arr[i-1][j] == FRESH) {
			arr[i-1][j] = ROTTEN;copyArr[i-1][j] = VISITED;
			doRecursion(arr, i-1, j);
		}
		//bottom
		if (i < rows-1 && arr[i+1][j] == FRESH) {
			arr[i+1][j] = ROTTEN;copyArr[i+1][j] = VISITED;
			doRecursion(arr, i+1, j);
		}
		//left
		if (j > 0 && arr[i][j-1] == FRESH) {
			arr[i][j-1] = ROTTEN;copyArr[i][j-1] = VISITED;
			doRecursion(arr, i, j-1);
		}
		//right
		if (j < cols-1 && arr[i][j+1] == FRESH) {
			arr[i][j+1] = ROTTEN;copyArr[i][j+1] = VISITED;
			doRecursion(arr, i, j+1);
		}
	}

	private void fillDefaultValues() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				copyArr[i][j] = DEFAULT;
			}
		}
	}
	
	private void printArray(int[][] arr, int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
