package array;

import java.util.HashMap;
import java.util.Map;

public class MinDistanceBW_RepeatedElements {
	public static void main(String[] args) {
		MinDistanceBW_RepeatedElements obj = new MinDistanceBW_RepeatedElements();
		int[] arr = {1,2,3,2,1};
		int res = obj.doOperation(arr, arr.length);
		System.out.println(res);
	}

	private int doOperation(int[] arr, int length) {
		int res = Integer.MAX_VALUE;
		Map<Integer, Integer> mapObj = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			if (mapObj.containsKey(arr[i])) {
				res = Math.min(res, i - mapObj.get(arr[i]));
				mapObj.put(arr[i], i);
			} else {
				mapObj.put(arr[i], i);
			}
		}
		return res;
	}
}
