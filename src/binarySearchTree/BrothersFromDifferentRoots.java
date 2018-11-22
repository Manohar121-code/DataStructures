package binarySearchTree;

import java.util.Stack;

public class BrothersFromDifferentRoots {

	public static void main(String[] args) {
		MyBST bstObj1 = new MyBST();
		String s = "5 3 7 2 4 6 8";
		String[] split = s.split(" ");
		for (String str : split) {
			bstObj1.insert(Integer.parseInt(str));
		}

		MyBST bstObj2 = new MyBST();
		String s2 = "10 6 15 3 8 11 18";
		String[] split2 = s2.split(" ");
		for (String str : split2) {
			bstObj2.insert(Integer.parseInt(str));
		}

		BrothersFromDifferentRoots obj = new BrothersFromDifferentRoots();

		System.out.println(obj.getBrothers(bstObj1.root, bstObj2.root, 16));
	}

	private int getBrothers(MyBSTNode root1, MyBSTNode root2, int target) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		fillIntoStack(root1, stack1); //small elements on top
		fillIntoStackReverse(root2, stack2); //big elements on top
		int count = 0;
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.peek().intValue() + stack2.peek().intValue() == target) {
				stack1.pop();
				stack2.pop();
				count++;
			} else if (stack1.peek() + stack2.peek() < target) {
				stack1.pop();
			} else {
				stack2.pop();
			}
		}
		return count;
	}
	
	private void fillIntoStack(MyBSTNode root, Stack<Integer> stack) {
		if (root == null)
			return;
		fillIntoStack(root.right, stack);
		stack.push(root.data);
		fillIntoStack(root.left, stack);
	}
	
	private void fillIntoStackReverse(MyBSTNode root, Stack<Integer> stack) {
		if (root == null)
			return;
		fillIntoStackReverse(root.left, stack);
		stack.push(root.data);
		fillIntoStackReverse(root.right, stack);
	}

}
