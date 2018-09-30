package string;

import java.util.Scanner;

public class RotateStringBy2Places {
	/*public static void main(String[] args) {
		RotateStringBy2Places obj = new RotateStringBy2Places();
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases > 0) {
			String a = scr.next();
			String b = scr.next();
			obj.doOperation(a, b);
			testCases--;
		}
	}*/

	public static void main(String[] args) {
		RotateStringBy2Places obj = new RotateStringBy2Places();
		String a = "geeksforgeeks";
		String b = "geeksgeeksfogr";
		long startTime = System.nanoTime();
		obj.doOperation(a, b);
		long endTime = System.nanoTime();
		System.out.println("Time taken old " + (endTime - startTime));
	}

	private void doOperation(String a, String b) {
		if (a.length() == b.length() && ((b.substring(b.length()-2) + b.substring(0, b.length()-2)).equalsIgnoreCase(a) 
				|| (b.substring(2, b.length()) + b.substring(0, 2)).equalsIgnoreCase(a))) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
}
