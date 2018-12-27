package recursion;

import java.util.Scanner;

public class PrintPattern {
	private static final int constant = 5, dec = 1, inc = 2;
	private static int actualVal;
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		PrintPattern obj = new PrintPattern();
		while (testCases-- > 0) {
			int n = scr.nextInt();
			actualVal = n;
			obj.doOperation(n, dec);
			System.out.println();
		}
	}

	private void doOperation(int n, int incDec) {
		if (n > actualVal)
			return;
		if (n <= 0) incDec = inc;
		System.out.print(n+" ");
		doOperation((incDec == inc) ? n+constant : n-constant, incDec);
	}
}
