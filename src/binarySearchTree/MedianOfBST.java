package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class MedianOfBST {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		String input = "1 3 4 6 7 8";
		String[] split = input.split(" ");
		for (String s : split) {
			bstObj.insert(Integer.parseInt(s));
		}
		
		MedianOfBST obj = new MedianOfBST();
		System.out.println(obj.getMedian(bstObj.root));
	}

	private int getMedian(MyBSTNode root) {
		List<Integer> list = new ArrayList<>();
		fillInList(root, list);
		int length = list.size(), mid = length/2;
		int median = (length % 2 == 0) ? (list.get(mid-1) + list.get(mid)) / 2 : list.get(mid);
		return median;
	}
	
	private void fillInList(MyBSTNode root, List<Integer> list) {
		if (root == null)
			return;
		fillInList(root.left, list);
		list.add(root.data);
		fillInList(root.right, list);
	}
}
