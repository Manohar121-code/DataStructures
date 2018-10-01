package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Anagram {
	public static void main(String[] args) {
		String s1 = "tictac";
		String s2 = "tacttc";
		long startTime = System.nanoTime();
		doOperationByMap(s1, s2);
		long endTime = System.nanoTime();
		System.out.println("Total time taken : " + (endTime - startTime));
		long startTime2 = System.nanoTime();
		doOperation(s1, s2);
		long endTime2 = System.nanoTime();
		System.out.println("Total time taken : " + (endTime2 - startTime2));
	}
	
	private static void doOperation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			System.out.println("NO");
			return;
		}
		int[] arr = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			arr[s1.charAt(i)]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			if (arr[s2.charAt(i)] == 0) {
				System.out.println("NOo");
				return;
			} else {
				arr[s2.charAt(i)]--;
			}
		}
		/*for (int i = 0; i < s2.length(); i++) {
			arr[s2.charAt(i)]--;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				System.out.println("NO");
				return;
			}
		}*/
		System.out.println("YES");
	}

	private static void doOperationByMap(String s1, String s2) {
		if (s1.length() != s2.length()) {
			System.out.println("NO");
			return;
		}
		Map<Character, Integer> mapObj = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			if (mapObj.containsKey(s1.charAt(i))) {
				mapObj.put(s1.charAt(i), mapObj.get(s1.charAt(i))+1);
			} else {
				mapObj.put(s1.charAt(i), 1);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if (mapObj.containsKey(s2.charAt(i))) {
				mapObj.put(s2.charAt(i), mapObj.get(s2.charAt(i))-1);
			} else {
				System.out.println("NO");
				return;
			}
		}
		Set<Character> keySet = mapObj.keySet();
		for (Character ch : keySet) {
			if (mapObj.get(ch) != 0)  {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
