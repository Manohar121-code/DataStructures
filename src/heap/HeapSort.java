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

	// 0 15 10 8 5 2 3 6 1
	private void doHeapSort(int[] arr, int length) {
		while (length > 0) {
			int smallTemp = arr[length-1];
			arr[length-1] = arr[1];
			arr[1] = smallTemp;
			length--;
			int parentIndex = 1, childIndex = parentIndex*2, parentVal = arr[parentIndex];
			while (childIndex <= length) {
				if (childIndex+1 <= length && arr[childIndex+1] > arr[childIndex])
					childIndex++;
				if (arr[childIndex] > parentVal) {
					arr[parentIndex] = arr[childIndex];
					parentIndex = childIndex;
					childIndex = parentIndex*2;
				}
			}
			arr[parentIndex] = parentVal;
		}
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
