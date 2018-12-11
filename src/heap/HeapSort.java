package heap;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = {0,1,3,5,2,6,10,8,15};
		HeapSort obj = new HeapSort();
		obj.doMaxHeapify(arr);
		obj.doHeapSort(arr, arr.length);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}

	private void doHeapSort(int[] arr, int length) {
		
	}

	private void doMaxHeapify(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int childIndex = i, k = arr[i];
			int parentIndex = childIndex/2;
			if (parentIndex < 1)
				continue;
			while (parentIndex > 0) {
				if (k > arr[parentIndex]) {
					arr[childIndex] = arr[parentIndex];
					
					childIndex = parentIndex;
					parentIndex = childIndex/2;
				} else {
					break;
				}
			}
			if (k > arr[childIndex])
				arr[childIndex] = k;
		}
	}
}
