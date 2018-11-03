package binarySearchTree;

import java.util.Scanner;

public class CheckInOrderOrNot {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int NumOfTests = scr.nextInt();
		while (NumOfTests-- > 0) {
		    int flag = 1;
			int arrLen = scr.nextInt();
			int number = Integer.MIN_VALUE;
			for (int i = 0; i < arrLen; i++) {
				int enteredNum = scr.nextInt();
				if (enteredNum <= number) {
					flag = 0;
//					break;
					number = enteredNum;
				}
				number = enteredNum;
			}
			System.out.println(flag);
		}
	}
}
