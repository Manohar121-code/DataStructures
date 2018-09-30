package array;

public class LeadersInAnArray {
	public static void main(String[] args) {
		LeadersInAnArray obj = new LeadersInAnArray();
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
//		int[] arr = {10,6,4,3,2,1};
//		int[] arr = {3, 2, 6, 4, 5, 1};
		long startTime = System.nanoTime();
		obj.doOperation1(arr);//right side small
		System.out.println("----------------");
		obj.doOperation2(arr);//left side small
		long endTime = System.nanoTime();
		System.out.println("Time taken " + (endTime-startTime));
	}

	private void doOperation1(int[] arr) {
		int large = 0;
		for (int i = arr.length-1; i >= 0; i--) {
			if (arr[i] > large) {
				large = arr[i];
				System.out.println(arr[i]);
			}
		}
	}
	
	private void doOperation2(int[] arr) {
		int large = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > large) {
				large = arr[i];
				System.out.println(arr[i]);
			}
		}
	}
	
}
