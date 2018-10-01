package array;

public class LessLeftMoreRight {
	public static void main(String[] args) {
		LessLeftMoreRight obj = new LessLeftMoreRight();
//		int[] arr = {2,5,3,7,9,14,15,13,18,19};
		int[] arr = {2,5,3,7,9,14,15,13,18,19,14,16,18,17,28,25,27};
//		int[] arr = {1,2,3,4,5,6,7,8,9};
//		int[] arr = {2,4,3,7,14,12,11,10};
		obj.doOperation(arr);
		System.out.println("Starts from hereXXXXXXXXXXXXXXXXXXXXXXXXXX");
		long startTime = System.nanoTime();
		obj.doOperation(arr);
		long endTime = System.nanoTime();
		System.out.println("Time taken for old logic "+ (endTime - startTime));
		System.out.println("----------------------------------");
		long startTime2 = System.nanoTime();
		obj.doOperation2(arr);
		long endTime2 = System.nanoTime();
		System.out.println("Time taken for new logic "+ (endTime2 - startTime2));
		System.out.println("----------------------------------");
		long startTime3 = System.nanoTime();
		obj.GFGAnswer(arr);
		long endTime3 = System.nanoTime();
		System.out.println("Time taken for GFG logic "+ (endTime3 - startTime3));
	}

	private void doOperation(int[] arr) {
		for (int i = 1; i < arr.length-1; i++) {
			int left = i - 1, right = i + 1;
			while (arr[left] < arr[i] && arr[i] < arr[right]) {
				if (left == 0 && right == arr.length - 1) {
					System.out.print(arr[i]+" ");
					break;
				}
				left = left != 0 ? left-1 : left;
				right = right != arr.length - 1 ? right+1 : right;
			}
		}
		System.out.println();
	}
	
	private void doOperation2(int[] arr) {
		int leftHighest = 0,rightLowest = arr[getMinValue(arr, 1)];
		for (int i = 1; i < arr.length-1; i++) {
			leftHighest = leftHighest < arr[i-1] ? arr[i-1] : leftHighest;
			if (rightLowest == arr[i]) {
				rightLowest = arr[getMinValue(arr, i+1)];
			}
			if (arr[i] > leftHighest && arr[i] < rightLowest) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	}
	
	private int getMinValue(int[] arr, int index) {
		int minIndex = index;
		for (int i = index; i < arr.length; i++) {
			if (arr[i] < arr[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	private void GFGAnswer(int[] arr) {
		int lowestRight = Integer.MAX_VALUE;
		int n = arr.length;
		int[] copyArr = new int[n];
		for (int i = n-1; i >= 0; i--) {
			copyArr[i] = lowestRight = arr[i] < lowestRight ? arr[i] : lowestRight;
		}
		int leftHighest = 0;
		for (int i = 1; i < n-1; i++) {
			leftHighest = Math.max(leftHighest, arr[i-1]);
			if (arr[i] > leftHighest && arr[i] < copyArr[i+1]) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	}
}
