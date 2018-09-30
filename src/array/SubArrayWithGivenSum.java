package array;

public class SubArrayWithGivenSum {
	public static void main(String[] args) {
		SubArrayWithGivenSum obj = new SubArrayWithGivenSum();
		int[] arr = {1,2,4,3,7,5,7,8,5,4,3,5,6,7,6,4,3,4,6,7,7,6,4,4,5,6,67,7,7,6,5,4,5};
		int inputSum = 120;
		long startTime = System.nanoTime();
		obj.doOperation(arr, inputSum);
		long endTime = System.nanoTime();
		System.out.println("Time taken " + (endTime-startTime));
	}

	private void doOperation(int[] arr, int inputSum) {
		for (int i = 0; i < arr.length; i++) {
			int temp = i;int sum = arr[i];
			while (sum < inputSum && temp < arr.length-1) {
				sum += arr[++temp];
			}
			if (sum == inputSum) {
				System.out.println("Index from : "+i + "-" + temp);
				return;
			}
		}
	}
}
