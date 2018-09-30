package array;

//Kadane's Algorithm
public class LargestSumContiguousSubArray {
	public static void main(String[] args) {
		LargestSumContiguousSubArray obj = new LargestSumContiguousSubArray();
		int[] arr = { -2, 4, -1, -2, -3, 12, 16 };
		// int[] arr = {-2,-1,-4,-3}; // will not work for -2,4,-1,-2,-3,12,16
		long startTime = System.nanoTime();
		obj.doOperation(arr);
		long endTime = System.nanoTime();
		System.out.println("Time taken " + (endTime-startTime));
	}

	private void doOperation(int[] arr) {
		int sum = arr[0];
		int tempSum = arr[0];
		for (int i = 0; i < arr.length; i++) {
			// for first positive number
			if (sum <= 0 && arr[i] > 0) {
				sum = arr[i];
				tempSum = arr[i];
				continue;
			}
			tempSum += arr[i];
			if (tempSum > sum) {
				sum = tempSum;
			}
		}
		System.out.println(sum);
	}

	private int maxSubArraySumGFG(int a[]) {
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < a.length; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

}
