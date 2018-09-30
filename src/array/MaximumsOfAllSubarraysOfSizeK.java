package array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaximumsOfAllSubarraysOfSizeK {
	public static void main(String[] args) {
		MaximumsOfAllSubarraysOfSizeK obj = new MaximumsOfAllSubarraysOfSizeK();
		// int[] arr = {1,101,2,3,100,4,5};
		// int[] arr = {10,5,4,3};
		// int[] arr = {6,101,1,3,7,100,5};
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter the sub array size : ");
		int subArraySize = scr.nextInt();
		int[] arr = {3, 2, 8, 6, 4, 5, 1,5,7,4,2,6,7,4,3,3,6,7,5,3};
		long startTime = System.nanoTime();
//		obj.doOperation(arr, arr.length, subArraySize);
		obj.printMaxGFG(arr, arr.length, subArraySize);
		long endTime = System.nanoTime();
		System.out.println("Time taken " + (endTime - startTime));
	}

	// A Dequeue (Double ended queue) based method for printing maixmum element of
    // all subarrays of size k
    private void printMaxGFG(int arr[],int n, int k)
    {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e., 
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();
         
        /* Process first k (or first window) elements of array */
        int i;
        for(i = 0; i < k; ++i)
        {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();   // Remove from rear
             
            // Add new element at rear of queue
            Qi.addLast(i);
        }
        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        //3, 2, 6, 4, 5, 1,5,7,4,2,6,7,4,3,3,6,7,5,3
        for( ;i < n; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");
             
            // Remove the elements which are out of this window
            while((!Qi.isEmpty()) && Qi.peek() <= i-k)
                Qi.removeFirst();
             
            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
             
 
            // Add current element at the rear of Qi
            Qi.addLast(i);
             
        }
         
        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }
	
	private void doOperation(int[] arr, int length, int subArraySize) {
		int[] maxArr = new int[length];
		int maxLength = Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			maxLength = maxArr[i] = Math.max(maxLength, arr[i]);
		}
		for (int i = 0; i < length; i++) {
			if ((i+subArraySize) < length) {
				System.out.println(maxArr[i+subArraySize]);
			}
		}
	}
}
