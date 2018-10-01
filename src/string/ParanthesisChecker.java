package string;

import java.util.HashMap;
import java.util.Map;

public class ParanthesisChecker {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Map<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		String inStr = "{[()]}(){}";
//		String inStr = "{()})";
//		String inStr = "{[](})";
		String outStr = "";
		for (int i = 0; i < inStr.length(); i++) {
			char temp = inStr.charAt(i);
			if (map.containsKey(temp) && !outStr.isEmpty() && map.get(temp) == outStr.charAt(outStr.length()-1)) {
				outStr = outStr.substring(0, outStr.length()-1);
			} else if (map.containsKey(temp) && !outStr.isEmpty() && map.get(temp) != outStr.charAt(outStr.length()-1)) {
				System.out.println("NNOO");
				System.out.println(System.nanoTime() - startTime);
				return;
			} else {
				outStr += temp;
			}
		}
		if (outStr.length() == 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		System.out.println(System.nanoTime() - startTime);
	}
}
