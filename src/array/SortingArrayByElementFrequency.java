package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortingArrayByElementFrequency {
	public static void main(String[] args) {
		SortingArrayByElementFrequency obj = new SortingArrayByElementFrequency();
//		int[] arr = {7, 3, 2, 7, 3, 2, 4, 5, 3, 12, 7, 2, 3, 12};
		int[] arr = {1, 3, 7, 7, 7, 3, 2, 7, 2, 2, 7, 3, 1, 7, 1, 6, 3, 5, 5, 4, 5, 6, 2, 1, 2, 4, 7, 3, 1, 3, 5, 4, 1, 7, 2, 6, 1, 2};
		long startTime = System.nanoTime();
		obj.doOperation(arr, arr.length);
		long endTime = System.nanoTime();
		System.out.println("\nTime taken " + (endTime - startTime));
		
		/*Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		for (int i = 1; i <= n; i++) {
			int len = scr.nextInt();
			int[] arr = new int[len];
			for (int x = 0; x < len ; x++) {
				arr[x] = scr.nextInt();
			}
			obj.doOperation(arr, arr.length);
		}*/
	}

	private void doOperation(int[] arr, int length) {
		Map<Integer, Integer> mapObj = new HashMap<>();
		//put unique numbers with count
		for (int i = 0; i < arr.length; i++) {
			mapObj.put(arr[i], mapObj.containsKey(arr[i]) ? mapObj.get(arr[i])+1 : 1);
		}
		int size = mapObj.size();
		//store keys in keyArr & values in valueArr
		Integer[] keyArr = mapObj.keySet().toArray(new Integer[size]);
		Integer[] valueArr = mapObj.values().toArray(new Integer[size]);
		
		//apply sorting on valueArr in desc order & as well as sort keyArr with valueArr
		bubble_srt_InReverse(keyArr, valueArr, size);
		//apply sorting on keyArr for those having equal number of presence in valueArr
		for (int i = 0; i < size-1; i++) {
			if (valueArr[i] == valueArr[i+1]) {
				int tempStart = i;
				while (i < size-1 && valueArr[i] == valueArr[i+1]) {
					i++;
				}
				bubble_srt(keyArr, tempStart, i+1);
			}
		}
		//print keyArr element for valueArr element times
		StringBuilder sbl = new StringBuilder();
		for (int i = 0; i < size; i++) {
			int numOfTimes = valueArr[i];
			for (int j = 1; j <= numOfTimes; j++) {
				sbl.append(keyArr[i]+" ");
			}
		}
		System.out.println(sbl.substring(0, sbl.length()-1));
	}
	
	public static void bubble_srt_InReverse(Integer[] keyArr, Integer[] valueArr, int n) {
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (valueArr[i].intValue() < valueArr[k].intValue()) {
                	//key
            		int tempKey = keyArr[i];
            		keyArr[i] = keyArr[k];
            		keyArr[k] = tempKey;
            		//value
            		int tempValue = valueArr[i];
            		valueArr[i] = valueArr[k];
            		valueArr[k] = tempValue;
                }
            }
        }
    }
	
	public static void bubble_srt(Integer[] keyArr, int start, int end) {
        int k;
        for (int m = end; m >= start; m--) {
            for (int i = start; i < end - 1; i++) {
                k = i + 1;
                if (keyArr[i].intValue() > keyArr[k].intValue()) {
                	int tempKey = keyArr[i];
                    keyArr[i] = keyArr[k];
                    keyArr[k] = tempKey;
                }
            }
        }
    }
  
}
