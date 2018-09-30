package string;

import java.util.Scanner;

public class ReverseWordsInString {

	/*public static void main(String[] args) {
		ReverseWordsInString obj = new ReverseWordsInString();
		String s = "abc.def.ghi.jkl.mno.pqrs.tuv.wx.yz";
		long startTime = System.nanoTime();
		obj.doOperation(s);
		System.out.println("\nTime taken " + (System.nanoTime() - startTime));
		System.out.println("---------------");
		long startTime2 = System.nanoTime();
		System.out.println(obj.doRecursion(s));
		System.out.println("\nTime taken " + (System.nanoTime() - startTime2));
	}*/
	
	public static void main(String[] args) {
		ReverseWordsInString obj = new ReverseWordsInString();
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		for (int i = 1; i <= testCases; i++) {
			System.out.println(obj.doRecursion(scr.next()));
		}
	}

	private String doRecursion(String s) {
		if (s.indexOf('.') == -1) {
			return s;
		}
		return doRecursion(s.substring(s.indexOf('.')+1))+ "." + s.substring(0, s.indexOf('.'));
	}

	private void doOperation(String s) {
		StringBuilder sbl = new StringBuilder();
		String[] split = s.split("\\.");
		for (int i = split.length-1; i >= 0; i--) {
			sbl.append(split[i]+".");
		}
		sbl.deleteCharAt(sbl.length()-1);
		System.out.println(sbl.toString());
	}

}
