package sortingAlgos;

public class MergeSort {
	private int[] arr, tempMergeArr;
	private int length;
	public static void main(String[] args) {
		int[] array = {45,23,11,89,77,98,4,28,65,43};
		MergeSort obj = new MergeSort();
		long s = System.nanoTime();
		obj.doMergeSort(array);
		long e = System.nanoTime();
		System.out.println(e-s);
		for(int i : array){
            System.out.print(i+" ");
        }
	}
	private void doMergeSort(int[] array) {
		this.arr = array;
		this.length = array.length;
		this.tempMergeArr = new int[this.length];
		doMergeSort(0, this.length-1);
	}
	private void doMergeSort(int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			doMergeSort(start, mid);
			doMergeSort(mid+1, end);
			mergeIt(start, mid, end);
		}
	}
	private void mergeIt(int start, int mid, int end) {
		for (int i = start; i <= end; i++)
			tempMergeArr[i] = arr[i];
		int i = start, k = start;
		int j = mid + 1;
		while (i <= mid && j <= end) {
			if (tempMergeArr[i] <= tempMergeArr[j]) {
				arr[k] = tempMergeArr[i];
				i++;
			} else {
				arr[k] = tempMergeArr[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			arr[k] = tempMergeArr[i];
			k++;i++;
		}
	}
}
