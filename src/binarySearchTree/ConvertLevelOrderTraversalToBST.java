package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertLevelOrderTraversalToBST {
	public static void main(String[] args) {
		int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};
		ConvertLevelOrderTraversalToBST obj = new ConvertLevelOrderTraversalToBST();
		obj.doOperation(arr);
	}
	
	private void doOperation(int[] arr) {
		Queue<MyBSTNode> queueObj = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			queueObj.add(new MyBSTNode(i));
		}
		//constructBSTByLevelOrder(queueObj, 0, Integer.MAX_VALUE);
	}

//	     7        
//	    / \       
//	   4   12      
//	  / \  /     
//	 3   6 8    
//	/   /   \
// 1   5     10

	/*private MyBSTNode constructBSTByLevelOrder(Queue<MyBSTNode> queueObj, int start, int end) {
		MyBSTNode root = queueObj.poll();
		if (roo) {
			
		}
	}*/
	
	/*private MyBSTNode constructBSTByLeelOrder(int[] arr) {
		Queue<MyBSTNode> queueObj = new LinkedList<>();
		MyBSTNode root = new MyBSTNode(arr[0]);
		queueObj.add(new MyBSTNode(-1));
		queueObj.add(root);
		for (int i = 1; i < arr.length; i++) {
			queueObj.poll();
			
		}
		return root;
	}*/
}
