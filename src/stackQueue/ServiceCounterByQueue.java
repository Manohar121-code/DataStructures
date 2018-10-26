package stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ServiceCounterByQueue {
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
		/*while (arrCounter < arr.length && arr[arrCounter] >= 0 && arr[arrCounter] <= 0) {
			queueObj.add(arr[arrCounter++]);
		}*/
		for (int i = -1; i < totalTime;) {
			if (!queueObj.isEmpty()) {
				queueObj.poll();
				i = i+2;
			}
			i++;
			if (i >= totalTime) {
				i = totalTime;
			}
			while (arrCounter < arr.length && arr[arrCounter] >= 0 && arr[arrCounter] <= i) {
				queueObj.add(arr[arrCounter++]);
			}
		}
		while (!queueObj.isEmpty()) {
			System.out.print(queueObj.poll()+" ");
		}
	}
}