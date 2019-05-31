package recursion;

import java.util.Scanner;

public class DecodeStringByRecursion {
	public static void main(String[] args) {
		DecodeStringByRecursion obj = new DecodeStringByRecursion();
//		String res = obj.doOperation("3[b2[ca]]");
//		String res = obj.doOperation("rth3[fg2[dfg]3[gyh]]4[rt3[dyy]hjj]");
		System.out.println("Enter number of testcases");
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			String s = scr.next();
			System.out.println(obj.doOperation(s));
		}
	}

	// bcacabcacabcaca
	//rth10[fg2[dfg]3[gyh]]4[rt3[dyy]hjj]
	//rth10[fg8[reer]dfdf]9[swds]
	private String doOperation(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			
			int indexOfOpen = s.indexOf('[', i);
			if (indexOfOpen == -1) {
				res += s.substring(i);
				break;
			}
			
			int temp = indexOfOpen-1, count = 0;
			while (temp > -1 && Character.isDigit(s.charAt(temp--))) {
				count++;
			}
			res += s.substring(i, indexOfOpen-count);
			String substring = s.substring(indexOfOpen-count, indexOfOpen);
			int number = Integer.parseInt(!substring.equals("") ? substring : "1");
			int lastIndex = getEndIndex(s, indexOfOpen+1);
			String response = doOperation(s.substring(indexOfOpen+1, lastIndex));
			for (int j = 1; j <= number; j++) {
				res += response;
			}
			i = lastIndex;
		}
		return res;
	}

	private int getEndIndex(String s, int startIndex) {
		int count = 0;
		for (int i = startIndex; i < s.length(); i++) {
			if (count == 0 && s.charAt(i) == ']')
				return  i;
			if (s.charAt(i) == '[')
				count++;
			else if (s.charAt(i) == ']')
				count--;
		}
		return -1;
	}

	// bcacabcacabcaca
	private String doOperation2(String s) {
		String res = "";
		int i;
		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				res = res.substring(0, res.length() - 1);
				int number = Integer.parseInt(s.charAt(i - 1) + "");
				int lastIndex = s.lastIndexOf(']');
				String response = doOperation(s.substring(i + 1, lastIndex));
				i = lastIndex + 1;
				for (int j = 1; j <= number; j++) {
					res += response;
				}
			} else {
				res += s.charAt(i);
			}
		}
		return res;
	}
}
