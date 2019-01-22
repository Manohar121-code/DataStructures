package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class QueenAttack {
	public static void main(String[] args) {
		QueenAttack obj = new QueenAttack();
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			int N = scr.nextInt();
			int numOfObstacles = scr.nextInt();
			ChessBlock4Q queenPos = new ChessBlock4Q(scr.nextInt(), scr.nextInt());
			Set<ChessBlock4Q> obstaclesSet = new HashSet<ChessBlock4Q>();
			for (int i = 0; i < numOfObstacles; i++) {
				obstaclesSet.add(new ChessBlock4Q(scr.nextInt(), scr.nextInt()));
			}
			long s = System.nanoTime();
			int calculateNumOfAttacksByQueen = obj.calculateNumOfAttacksByQueen(N, queenPos, obstaclesSet);
			long e = System.nanoTime();
			System.out.println(calculateNumOfAttacksByQueen);
			System.out.println(e-s);
		}
	}
	
/*1
5 3
4 3
5 5
4 2
2 3*/
	
	private int calculateNumOfAttacksByQueen(int N, ChessBlock4Q queenPos,
			Set<ChessBlock4Q> obstaclesSet) {
		List<ChessBlock4Q> attackingPositions = new ArrayList<ChessBlock4Q>();
		//top
		ChessBlock4Q top = new ChessBlock4Q(queenPos.row+1, queenPos.col);
		while (isSafe(N, top, obstaclesSet)) {
			attackingPositions.add(top);
			top = new ChessBlock4Q(top.row+1, top.col);
		}
		//left-top
		ChessBlock4Q leftTop = new ChessBlock4Q(queenPos.row+1, queenPos.col-1);
		while (isSafe(N, leftTop, obstaclesSet)) {
			attackingPositions.add(leftTop);
			leftTop = new ChessBlock4Q(leftTop.row+1, leftTop.col-1);
		}
		//left
		ChessBlock4Q left = new ChessBlock4Q(queenPos.row, queenPos.col-1);
		while (isSafe(N, left, obstaclesSet)) {
			attackingPositions.add(left);
			left = new ChessBlock4Q(left.row, left.col-1);
		}
		//left-bottom
		ChessBlock4Q leftBottom = new ChessBlock4Q(queenPos.row-1, queenPos.col-1);
		while (isSafe(N, leftBottom, obstaclesSet)) {
			attackingPositions.add(leftBottom);
			leftBottom = new ChessBlock4Q(leftBottom.row-1, leftBottom.col-1);
		}
		//bottom
		ChessBlock4Q bottom = new ChessBlock4Q(queenPos.row-1, queenPos.col);
		while (isSafe(N, bottom, obstaclesSet)) {
			attackingPositions.add(bottom);
			bottom = new ChessBlock4Q(bottom.row-1, bottom.col);
		}
		//bottom-right
		ChessBlock4Q bottomRight = new ChessBlock4Q(queenPos.row-1, queenPos.col+1);
		while (isSafe(N, bottomRight, obstaclesSet)) {
			attackingPositions.add(bottomRight);
			bottomRight = new ChessBlock4Q(bottomRight.row-1, bottomRight.col+1);
		}
		//right
		ChessBlock4Q right = new ChessBlock4Q(queenPos.row, queenPos.col+1);
		while (isSafe(N, right, obstaclesSet)) {
			attackingPositions.add(right);
			right = new ChessBlock4Q(right.row, right.col+1);
		}
		//top-right
		ChessBlock4Q topRight = new ChessBlock4Q(queenPos.row+1, queenPos.col+1);
		while (isSafe(N, topRight, obstaclesSet)) {
			attackingPositions.add(topRight);
			topRight = new ChessBlock4Q(topRight.row+1, topRight.col+1);
		}
		queenPos.attackingPositions = attackingPositions;
		return queenPos.attackingPositions.size();
	}

	private boolean isSafe(int N, ChessBlock4Q currBlock, Set<ChessBlock4Q> obstaclesSet) {
		if (currBlock.row < 1 || currBlock.row > N || currBlock.col < 1 || currBlock.col > N || obstaclesSet.contains(currBlock)) return false;
		return true;
	}
}

class ChessBlock4Q {
	int row, col;
	List<ChessBlock4Q> attackingPositions;

	public ChessBlock4Q(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChessBlock4Q other = (ChessBlock4Q) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}