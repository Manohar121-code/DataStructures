package binarySearchTree;

import java.util.Stack;

public class MergeTwoBST {
	public static void main(String[] args) {
		MyBST bstObj1 = new MyBST();
		String s = "1 33 4";
		String[] split = s.split(" ");
		for (String str : split) {
			bstObj1.insert(Integer.parseInt(str));
		}

		MyBST bstObj2 = new MyBST();
		String s2 = "6 7 1";
		String[] split2 = s2.split(" ");
		for (String str : split2) {
			bstObj2.insert(Integer.parseInt(str));
		}

		MergeTwoBST obj = new MergeTwoBST();

		obj.mergeTwoBST(bstObj1.root, bstObj2.root);
		System.out.println();
	}

	private void mergeTwoBST(MyBSTNode root1, MyBSTNode root2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		fillIntoStack(root1, stack1);
		fillIntoStack(root2, stack2);
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.peek().intValue() == stack2.peek().intValue()) {
				System.out.print(stack1.pop() + " "+ stack2.pop() + " ");
			} else if (stack1.peek() < stack2.peek()) {
				System.out.print(stack1.pop() + " ");
			} else {
				System.out.print(stack2.pop() + " ");
			}
		}
		printElementsInStack(stack1);
		printElementsInStack(stack2);
	}

	private void printElementsInStack(Stack<Integer> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void fillIntoStack(MyBSTNode root, Stack<Integer> stack) {
		if (root == null)
			return;
		fillIntoStack(root.right, stack);
		stack.push(root.data);
		fillIntoStack(root.left, stack);
	}
}
