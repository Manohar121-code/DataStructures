package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MedianInStream {
	//copied from GFG
	public static void main (String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		Queue<Integer> minpq=new PriorityQueue<Integer>(n);
		Queue<Integer> maxpq=new PriorityQueue<Integer>(n,Collections.reverseOrder());
		int x=sc.nextInt();
		minpq.add(x);
		n=n-1;
		System.out.println(x);
		while(n>0)
		{	
		    x=sc.nextInt();
		    if(x>minpq.peek())
		        minpq.add(x);
		    else
		        maxpq.add(x);
		    if(minpq.size()-maxpq.size()==2)
		        maxpq.add(minpq.remove());
		    else if(minpq.size()-maxpq.size()==-2)
		        minpq.add(maxpq.remove());
		    if(minpq.size()>maxpq.size())
		        System.out.println(minpq.peek());
		    else if(minpq.size()<maxpq.size())
		        System.out.println(maxpq.peek());
		    else
		        System.out.println((minpq.peek()+maxpq.peek())/2);
		    n=n-1;
		}
	}
	/*public static void main(String[] args) {
		MedianInStream obj = new MedianInStream();
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			int length = Integer.parseInt(scr.nextLine());
			int[] arr = new int[length];
			for (int i = 0; i < length; i++) {
				arr[i] = Integer.parseInt(scr.nextLine());
				System.out.print(obj.doOperation(arr, i+1));
			}
			System.out.println();
		}
	}*/
//	Flow in stream : 5, 15, 1, 3 
//	5 goes to stream --> median 5 (5)
//	15 goes to stream --> median 10 (5, 15)
//	1 goes to stream --> median 5 (5, 15, 1)
//	3 goes to stream --> median 4 (5, 15, 1, 3)

	private int doOperation(int[] arr, int count) {
		if (count%2 != 0) {
			return arr[count/2]/count;
		} else {
			int scndIndex = count/2;
			return (arr[scndIndex-1] + arr[scndIndex])/count;
		}
	}
}
