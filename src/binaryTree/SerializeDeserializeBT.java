package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerializeDeserializeBT {
	public static void main(String[] args) {
		MyBTNode root = new MyBTNode(1);
		root.left = new MyBTNode(2);
		root.left.left = new MyBTNode(4);
		root.left.right = new MyBTNode(5);
		root.left.right.left = new MyBTNode(7);
		
		root.right = new MyBTNode(3);
		root.right.right = new MyBTNode(6);
		root.right.right.left = new MyBTNode(8);

		SerializeDeserializeBT obj = new SerializeDeserializeBT();
		root = obj.doOperation(root);
		obj.inOrder(root);
		System.out.println();
	}

	private MyBTNode doOperation(MyBTNode root) {
		List<Integer> list = new ArrayList<Integer>();
		String serializedStr = serialize(root, list);
		return deserialize(serializedStr);
	}

	private String serialize(MyBTNode root, List<Integer> list) {
		fillPreOrderInList(root, list);
		return list.toString();
	}
	
	private void fillPreOrderInList(MyBTNode root, List<Integer> list) {
		list.add(root != null ? root.data : null);
		if (root == null)
			return;
		fillPreOrderInList(root.left, list);
		fillPreOrderInList(root.right, list);
	}

	private MyBTNode deserialize(String serializedStr) {
		serializedStr = serializedStr.substring(1, serializedStr.length()-1);
		String[] split = serializedStr.split(", ");
		
		Stack<MyBTNode> stkObj = new Stack<MyBTNode>();
		MyBTNode root = new MyBTNode(Integer.parseInt(split[0]));
		stkObj.add(root);
		for (int i = 1; i < split.length; i++) {
			MyBTNode peekElement = stkObj.peek();
			
		}
		return root;
	}
	
	private void inOrder(MyBTNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
}
