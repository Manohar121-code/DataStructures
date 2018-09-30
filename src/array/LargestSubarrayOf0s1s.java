package array;

public class LargestSubarrayOf0s1s {
	public static void main(String[] args) {
		LargestSubarrayOf0s1s obj = new LargestSubarrayOf0s1s();
//		int[] arr = {0,1,0,1};
		int[] arr = {0,0,1,0,0,1};
		long startTime = System.nanoTime();
		obj.doOperation(arr, arr.length);
		long endTime = System.nanoTime();
		System.out.println("\nTime taken " + (endTime - startTime));
	}

	private void doOperation(int[] arr, int length) {
		int maxCount = 0;
		for (int i = length-1; i >= maxCount && i >= 0; i--) {
			int count = 0;
			for (int j = i; j >= 0; j--) {
				count = arr[j] == 0 ? count-1 : count+1;
				if (count == 0)
					maxCount = Math.max((i-j)+1, maxCount);
			}
		}
		System.out.println(maxCount);
	}
}
