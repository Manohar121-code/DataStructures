package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicates {
	public static void main(String[] args) {
		RemoveDuplicates obj = new RemoveDuplicates();
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter No of testcases...");
		int testCases = scr.nextInt();
		scr.nextLine();
		while (testCases > 0) {
			System.out.println("Enter String...");
			String s = scr.nextLine();
			long startTime = System.nanoTime();
			obj.doOperationByArray(s);
			long endTime = System.nanoTime();
			System.out.println("\nTime taken for array : "+(endTime-startTime));
			long startTime2 = System.nanoTime();
			obj.doOperationByList(s);
			long endTime2 = System.nanoTime();
			System.out.println("\nTime taken for list : "+(endTime2-startTime2));
			testCases--;
		}
	
		
		/*Scanner s1 = new Scanner(System.in);
	    System.out.println("Enter your name");
//	    String w = s1.next();
//	    System.out.println("Your name is " + w);
	    System.out.println("Again enter your name");
	    String st = s1.nextLine();
	    System.out.println("Your name is " + st);

	    System.out.println("Again enter your name2");
	    String st2 = s1.nextLine();
	    System.out.println("Your name is2 " + st2);*/
	}

	private void doOperationByArray(String s) {
		StringBuilder sbl = new StringBuilder();
		int[] arr = new int[256];
		for (int i = 0; i < s.length(); i++) {
			if (arr[s.charAt(i)] == 0) {
				sbl.append(s.charAt(i));
				arr[s.charAt(i)]++;
			}
		}
		System.out.println(sbl.toString());
	}

	private void doOperationByList(String s) {
		List<Character> list = new ArrayList<>();
		char[] charArray = s.toCharArray();
		for (char ch : charArray) {
			if (!list.contains(ch)) {
				list.add(ch);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
}
