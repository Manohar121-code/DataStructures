package array;

public class SearchEleInSortedArrWithOutLength {
	public static void main(String[] args) {
		SearchEleInSortedArrWithOutLength obj = new SearchEleInSortedArrWithOutLength();
		int[] arr = {1, 3, 4, 5, 7, 8, 11, 14, 15};
		int k = 2;
		int index = obj.doOperation(arr, k);
		System.out.println(index);
	}

	private int doOperation(int[] arr, int k) {
		int i = 0;
		for (; true; i++) {
			try {
				if (arr[i] == k) return i;
				if (arr[i] > k) return -1;
			} catch (ArrayIndexOutOfBoundsException e) {
				return -1;
			}
		}
	}
}
