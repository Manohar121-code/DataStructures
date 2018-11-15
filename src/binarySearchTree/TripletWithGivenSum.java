package binarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TripletWithGivenSum {
	public static void main(String[] args) {
		MyBST bstObj = new MyBST();
		int[] arr = { 5, -8, -2, 10, 11 };
		for (int data : arr) {
			bstObj.insert(data);
		}

		TripletWithGivenSum obj = new TripletWithGivenSum();
		int sum = 0;
		obj.doByHashing(bstObj.root, sum);
		
		if (obj.byGFG(bstObj.root, sum))
			System.out.println("Triplet is found");
		else
			System.out.println("Triplet is not found");
	}

	public boolean byGFG(MyBSTNode root, int sum) {
		List<Integer> list = new ArrayList<Integer>();
		fillInList(root, list);
		for (int i = 0; i < list.size() - 1; i++) {
			Set<Integer> set = new HashSet<Integer>();
			int rem = sum - list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (set.contains(rem - list.get(j)) == true) {// System.out.println(list.get(i)+" "+list.get(j)+" "+(rem - list.get(j)));
					return true;
				}
				set.add(list.get(j));
			}
		}
		return false;
	}
	
	private void fillInList(MyBSTNode root, List<Integer> list) {
		if (root == null)
			return;
		fillInList(root.left, list);
		list.add(root.data);
		fillInList(root.right, list);
	}

	private void doByHashing(MyBSTNode root, int sum) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		fillInList(root, list, map);
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int value = sum - (list.get(i) + list.get(j));
				if (map.containsKey(value) && map.get(value) != i && map.get(value) != j) {
					System.out.println("Triplet found is : " + list.get(i) + ", " + list.get(j) + ", " + value);
				}
			}
		}
	}

	private void fillInList(MyBSTNode root, List<Integer> list, Map<Integer, Integer> map) {
		if (root == null)
			return;
		fillInList(root.left, list, map);
		list.add(root.data);
		map.put(root.data, list.size() - 1);
		fillInList(root.right, list, map);
	}
}
