package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RemoveAllAdjacentDupsByRecursion {
	
	
	
	
	/*public static void main(String[] args) {
		RemoveAllAdjacentDupsByRecursion obj = new RemoveAllAdjacentDupsByRecursion();
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases > 0) {
			String s = scr.next();
			obj.doOperation(s);
			testCases--;
		}
	}*/

	public static void main(String[] args) {
		RemoveAllAdjacentDupsByRecursion obj = new RemoveAllAdjacentDupsByRecursion();
		String[] strArr = {/*"geeksforgeek", "acaaabbacdddd", */"mississipie"};
		long startTime = System.nanoTime();
		for (String s : strArr) {
			obj.doOperation(s);
		}
		long endTime = System.nanoTime();
		System.out.println("Time taken old " + (endTime - startTime));
		long startTime2 = System.nanoTime();
		for (String s : strArr) {
			obj.doOperation2(s);
		}
		long endTime2 = System.nanoTime();
		System.out.println("Time taken new " + (endTime2 - startTime2));
	}
	
	//working but more objs
	/*private void doOperation2(String s) {
		Map<Integer, Integer> mapObj = new LinkedHashMap<>();
		for (int i = 0; i < s.length()-1; i++) {
			int tempStart=0,count = 0;
			while (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
				tempStart = tempStart == 0 ? i : tempStart;
				i++;count++;
			}
			if (count > 0) {
				mapObj.put(tempStart, tempStart+count);
			}
		}
		if (!mapObj.isEmpty()) {
			Set<Integer> keySet = mapObj.keySet();
			List<Integer> listObj = new ArrayList<>(keySet);
			Collections.reverse(listObj);
			for (Integer key : listObj) {
				s = s.substring(0, key) + s.substring(mapObj.get(key)+1, s.length());
			}
			doOperation2(s);
		} else {
			System.out.println(s);
		}
	}*/
	
	//mississipie
	private void doOperation2(String s) {
		int tempStart, count;
		boolean isConsecutive = false;
		for (int i = 0; i < s.length()-1; i++) {
			tempStart=-1; count = 0;
			while (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
				tempStart = tempStart == -1 ? i : tempStart;
				i++;count++;
			}
			if (count > 0) {
				i = tempStart;isConsecutive = true;
				s = s.substring(0, tempStart) + s.substring(tempStart+count+1, s.length());
			}
		}
		if (isConsecutive) {
			doOperation2(s);
		} else {
			System.out.println(s);
		}
	}
	
	//not working fine for mississipie : final ans is : mpie
	private void doOperation(String s) {
		int tempStart=-1,count=0;
		for (int i = 0; i < s.length()-1; i++) {
			while (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
				tempStart = tempStart == -1 ? i : tempStart;
				i++;count++;
			}
			if (count > 0) {
				break;
			}
		}
		if (count > 0) {
			doOperation(s.substring(0, tempStart)+s.substring(tempStart+count+1, s.length()));
		} else {
			System.out.println(s);
		}
	}

	/*private String doOperation(String s) {
		if (s.length() == 1) {
			return s;
		}
		int temp = 0;
		while (temp+1 < s.length() && s.charAt(temp) == s.charAt(temp+1)) {
			temp++;
		}
		if (temp > 0 && temp+1 == s.length()-1) {
			return doOperation(s.substring(temp+1));
		} else if (temp > 0 && temp+2 < s.length()-1) {
			return ""+s.charAt(temp+1) + doOperation(s.substring(temp+2));
		} else if (temp == 0) {
			return ""+s.charAt(temp) + doOperation(s.substring(temp+1));
		} else {
			return "";
		}
	}*/
}
