package stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {
	public static void main(String[] args) {
		CircularTour obj = new CircularTour();
		// int numOfPetrolPumps = 4;
//		int[] petrol = new int[] { 4, 6, 7, 4 };
//		int[] distance = new int[] { 6, 5, 3, 5 };
		
		int[] petrol = new int[] { 4, 6, 5, 5 };
		int[] distance = new int[] { 4, 5, 6, 5 };
		
		long startTime = System.nanoTime();
		System.out.println(obj.doOperation(petrol, distance));
		long endTime = System.nanoTime();
		System.out.println("Total time taken : "+(endTime - startTime));
		
		int tour = obj.byGFG(petrol, distance);
		System.out.println(tour);
	}
	
	private int byGFG(int petrol[], int distance[]) {
		int n = petrol.length;
		int tpetrol = 0;
		int tdistance = 0;
		for (int i = 0; i < n; i++) {
			tpetrol += petrol[i];
			tdistance += distance[i];
		}
		if (tdistance > tpetrol)
			return -1;
		int cal = 0, start = 0;
		for (int i = 0; i < n; i++) {
			cal += (petrol[i] - distance[i]);
			if (cal < 0) {
				start = i + 1;
				cal = 0;
			}
		}
		return start;
	}

	private int doOperation(int[] petrol, int[] distance) {
		Queue<Integer> queueObj = new LinkedList<Integer>();
		for (int i = 0; i < petrol.length; i++) {
			if (doCheck(i, petrol, distance, new LinkedList<Integer>(queueObj)))
				return i;
			queueObj.add(petrol[i]);
			queueObj.add(distance[i]);
		}
		return -1;
	}

	private boolean doCheck(int i, int[] petrol, int[] distance,
			LinkedList<Integer> queueObj) {
		int storedPetrol = 0;
		for (int j = i; j < distance.length; j++) {
			storedPetrol += petrol[j];
			if (distance[j] > storedPetrol)
				return false;
			storedPetrol -= distance[j];
		}
		while (!queueObj.isEmpty()) {
			int intPetrol = queueObj.poll();
			int intDistance = queueObj.poll();
			storedPetrol += intPetrol;
			if (intDistance > storedPetrol)
				return false;
			storedPetrol -= intDistance;
		}
		return true;
	}
}
