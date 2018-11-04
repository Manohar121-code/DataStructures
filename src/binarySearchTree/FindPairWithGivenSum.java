package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class FindPairWithGivenSum {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		bstObj.insert(1);
		bstObj.insert(2);
		bstObj.insert(3);
		bstObj.insert(4);
		bstObj.insert(5);
		bstObj.insert(6);
		bstObj.insert(7);

		FindPairWithGivenSum obj = new FindPairWithGivenSum();
		int key = 10;
		System.out.println(obj.findPairWithGivenSum(bstObj.root, key) ? "Found" : "Not found");
	}

	private List<Integer> storeNodesToList(MyBSTNode root, List<Integer> list) {
		if (root == null)
			return list;
		storeNodesToList(root.left, list);
		if (!list.contains(root.data))
			list.add(root.data);
		storeNodesToList(root.right, list);
		return list;
	}
	
	private boolean findPairWithGivenSum(MyBSTNode root, int key) {
		List<Integer> list = new ArrayList<>();
		list = storeNodesToList(root, list);
		int start = 0, end = list.size()-1;
		while (start < end) {
			if (list.get(start) + list.get(end) == key) {
				return true;
			}
			if (list.get(start) + list.get(end) < key) {
				start++;
			}
			if (list.get(start) + list.get(end) > key) {
				end--;
			}
		}
		return false;
	}
}
