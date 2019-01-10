package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeAndLadderProblem {
	private final static int TOTALBLOCKS = 30, dice = 6;
	private int[] arr;
	public static void main(String[] args) {
		SnakeAndLadderProblem obj = new SnakeAndLadderProblem();
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter Something");
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			int[] arr = new int[TOTALBLOCKS];
			boolean[] boolArr = new boolean[TOTALBLOCKS];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
			//start filling snakes and ladders into array
			int snakesAndLadders = scr.nextInt();
			while (snakesAndLadders-- > 0) {
				//11 26 3 22 5 8 20 29 27 1 21 9
				arr[scr.nextInt()-1] = scr.nextInt()-1;
			}
			obj.doOperation(arr, boolArr);
		}
	}
	private void doOperation(int[] arr, boolean[] boolArr) {
		Queue<Block> queueObj = new LinkedList<>();
		queueObj.add(new Block(0, 0));//starting position
		boolArr[0] = true;
		Block result = null;
		while (!queueObj.isEmpty()) {
			result = queueObj.poll();
			int vertex = result.vertex;
			if (vertex == TOTALBLOCKS-1)
				break;
			for (int i = vertex+1; i <= vertex+dice && i < TOTALBLOCKS; i++) {
				if (boolArr[i] == false) {
					Block obj = new Block(arr[i], result.moves+1);
					queueObj.add(obj);
					boolArr[i] = true;
				}
			}
		}
		System.out.println(result.moves);
	}
}

class Block {
	int vertex, moves;
	public Block(int vertex, int moves) {
		this.vertex = vertex;
		this.moves = moves;
	}
}