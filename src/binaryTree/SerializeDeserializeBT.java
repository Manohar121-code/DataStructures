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
		return deSerialize(serializedStr);
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

	//1, 2, 4, null, null, 5, 7, null, null, null, 3, null, 6, 8, null, null, null
	private MyBTNode deSerialize(String serializedStr) {
		serializedStr = serializedStr.substring(1, serializedStr.length()-1);
		String[] arr = serializedStr.split(", ");
		
		Stack<MyBTNode> stkObj = new Stack<MyBTNode>();
		MyBTNode root = new MyBTNode(Integer.parseInt(arr[0]));
		stkObj.add(root);
		for (int i = 1; i < arr.length; i++) {
			MyBTNode peekElement = stkObj.peek();
			String curr = arr[i];
			if (!curr.equals("null")) {
				MyBTNode childNode = new MyBTNode(Integer.parseInt(curr));
				if (peekElement.left == null)
					peekElement.left = childNode;
				else {
					stkObj.pop();
					peekElement.right = childNode;
				}
				stkObj.push(childNode);
			} else {
				stkObj.pop();
				String rightVal = (peekElement.left != null) ? arr[i] : arr[++i];
				if (!rightVal.equals("null")) {
					MyBTNode childNode = new MyBTNode(Integer.parseInt(rightVal));
					peekElement.right = childNode;
					stkObj.push(childNode);
				}
			}
		}
		return root;
	}
	
	/*private int counter = 0;
	private int ele[];
	public MyBTNode deSerializeByGFG(String data) {
	    String elements[] = data.split(" ");
	        
	        ele = new int[elements.length-1];
	        for(int i = 0 ; i < elements.length-1; i++) {
	            ele[i] = Integer.parseInt(elements[i]); // in serialize add -1 for null
	        }
	        return deSerializeHelperByGFG(ele);
	}
	
	public MyBTNode deSerializeHelperByGFG(int[] data) {
        if(data.length <= counter || data[counter] == -1) {
            counter++;
            return null;
        }
      
        int currentValue = data[counter];
        counter++;
        MyBTNode root = new MyBTNode(currentValue);
        root.left = deSerializeHelperByGFG(data);
        root.right = deSerializeHelperByGFG(data);
        
        return root;
    }*/
	
	private void inOrder(MyBTNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
}
