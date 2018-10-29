package stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ServiceCounterByQueue {
	
	private static final int serviceDuration = 3;
	
	public static void main(String[] args) {
		ServiceCounterByQueue obj = new ServiceCounterByQueue();
		Scanner scr = new Scanner(System.in);
		System.out.println("enter total time");
		int totalTime = scr.nextInt();
		int[] arr = {0, 2, 5, 6, 6, 8, 10, -1};
		obj.doService(totalTime, arr);
	}

	private void doService(int totalTime, int[] arr) {
		int arrCounter = 0;
		Queue<Integer> queueObj = new LinkedList<Integer>();
		boolean exit = false;
		for (int i = -1; i < totalTime;) {
			i++;
			if (!queueObj.isEmpty()) {
				queueObj.poll();
				i = i+(serviceDuration-1);
				if (i >= totalTime) {
					i = totalTime-1;
					exit = true;
				}
			}
			while (arrCounter < arr.length && arr[arrCounter] >= 0 && arr[arrCounter] <= i) {
				queueObj.add(arr[arrCounter++]);
			}
			if (exit) {
				break;
			}
		}
		while (!queueObj.isEmpty()) {
			System.out.print(queueObj.poll()+" ");
		}
	}
}