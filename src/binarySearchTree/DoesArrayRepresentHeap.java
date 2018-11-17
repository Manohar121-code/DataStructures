package binarySearchTree;

public class DoesArrayRepresentHeap {
	public static void main(String[] args) {
		int[] arr = {0, 90, 15, 10, 7, 12, 2};
		DoesArrayRepresentHeap obj = new DoesArrayRepresentHeap();
		System.out.println(obj.doesArrRepresentsMaxHeap(arr, 1) ? "1" : "0");
	}
	
	private boolean doesArrRepresentsMaxHeap(int[] arr, int i) {
		boolean check = true;
		if (i*2 < arr.length)
			if (arr[i*2] > arr[i])
				return false;
			else
				check = doesArrRepresentsMaxHeap(arr, i*2);
		if ((i*2)+1 < arr.length && check)
			if (arr[(i*2)+1] > arr[i])
				return false;
			else
				check = doesArrRepresentsMaxHeap(arr, (i*2)+1);
		return check;
	}

	/*private boolean doesArrRepresentsMaxHeap(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (i*2 < arr.length)
				if (arr[i*2] > arr[i])
					return false;
			if ((i*2)+1 < arr.length)
				if (arr[(i*2)+1] > arr[i])
					return false;
		}
		return true;
	}*/
}
