package recursion;

import java.util.Scanner;

public class JosephusProblem {
	public static void main(String[] args) {
		JosephusProblem obj = new JosephusProblem();
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		
		while (testCases-- > 0) {
			int n = scr.nextInt();
			int k = scr.nextInt();
			int resultPos = obj.doOperation(n, k);
			System.out.println(resultPos);
		}
	}

	private int doOperation(int n, int k) {
		boolean[] arr = new boolean[n];
		return doRecursion(arr, 1, k);
	}
	
	private int allRubs = 0, currRub = 0;
	
	private int doRecursion(boolean[] arr, int curr, int k) {
		if (allRubs == arr.length-1 && !arr[curr-1])
			return curr;
		if (!arr[curr-1]) {
			if (++currRub == k) {
				arr[curr - 1] = true;
				allRubs++;
				currRub = 0;
			}
		}
		if (curr == arr.length)
			curr = 0;
		return doRecursion(arr, curr+1, k);
	}
}
