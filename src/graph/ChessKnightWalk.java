package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ChessKnightWalk {
	private int[] xArr = { 2, 2, -2, -2, 1, 1, -1, -1 };
	private int[] yArr = { -1, 1, 1, -1, 2, -2, 2, -2 };
	public static void main(String[] args) {
		ChessKnightWalk obj = new ChessKnightWalk();
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			int X = scr.nextInt(), Y = scr.nextInt();
			ChessBlock src = new ChessBlock(scr.nextInt()-1, scr.nextInt()-1, 0);
			ChessBlock dst = new ChessBlock(scr.nextInt()-1, scr.nextInt()-1, 0);
			System.out.println(obj.doOperation2(src, dst, X, Y));
		}
	}

	/*adding into map after poll
	 private int doOperation(ChessBlock src, ChessBlock dst, int X, int Y) {
		Map<ChessBlock, Boolean> mapObj = new HashMap<ChessBlock, Boolean>();
		Queue<ChessBlock> queueObj = new LinkedList<ChessBlock>();
		queueObj.add(src);
		while (!queueObj.isEmpty()) {
			ChessBlock frontBlock = queueObj.poll();
			int x = frontBlock.x, y = frontBlock.y;
			if (dst.x == x && dst.y == y)
				return frontBlock.moves;
			if (mapObj.get(frontBlock) == null) {
				mapObj.put(frontBlock, true);
				for (int j = 0; j < xArr.length; j++) {
					if (isSafe(x+xArr[j], y+yArr[j], X, Y)) {
						queueObj.add(new ChessBlock(x+xArr[j], y+yArr[j], frontBlock.moves+1));
					}
				}
			}
		}
		return 0;
	}*/
	
	//adding into map in for loop
	private int doOperation2(ChessBlock src, ChessBlock dst, int X, int Y) {
		if (src.equals(dst))
			return 0;
		Queue<ChessBlock> queueObj = new LinkedList<ChessBlock>();
		queueObj.add(src);
		Map<ChessBlock, Boolean> mapObj = new HashMap<ChessBlock, Boolean>();
		mapObj.put(src, true);
		while (!queueObj.isEmpty()) {
			ChessBlock frontBlock = queueObj.poll();
			int x = frontBlock.x, y = frontBlock.y;
			for (int j = 0; j < xArr.length; j++) {
				ChessBlock curr = new ChessBlock(x+xArr[j], y+yArr[j], frontBlock.moves+1);
				if (isSafe(curr.x, curr.y, X, Y) && mapObj.get(curr) == null) {
					if (dst.x == curr.x && dst.y == curr.y)
						return curr.moves;
					queueObj.add(curr);
					mapObj.put(curr, true);
				}
			}
		}
		return 0;
	}
	
	private boolean isSafe(int x, int y, int X, int Y) {
		if (x < 0 || y < 0 || x >= X || y >= Y) return false;
		return true;
	}
}

class ChessBlock {
	int x, y, moves;

	public ChessBlock(int x, int y, int moves) {
		this.x = x;
		this.y = y;
		this.moves = moves;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		ChessBlock other = (ChessBlock) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}