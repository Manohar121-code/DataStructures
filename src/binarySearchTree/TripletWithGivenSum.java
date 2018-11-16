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
		
		//---------------By Hashing start--------------
		System.out.println("----------------By My Hashing");
		obj.doByHashing(bstObj.root, sum);
		System.out.println("----------------By GFG Hashing");
		if (obj.byGFGHashing(bstObj.root, sum))
			System.out.println("Triplet is found");
		else
			System.out.println("Triplet is not found");
		//---------------By Hashing end----------------
		
		System.out.println("----------------By Inc/Dec");
		//---------------By Inc/Dec start--------------
		obj.doByIncDec(bstObj.root, sum);
		//---------------By Inc/Dec end----------------
	}

	private void doByIncDec(MyBSTNode root, int sum) {
		List<Integer> list = new ArrayList<Integer>();
		fillInList(root, list);
		for (int i = 0; i < list.size() - 2; i++) {
			int nextIndex = i+1;
			int lastIndex = list.size() - 1;
			while (nextIndex < lastIndex) {
				if (list.get(i) + list.get(nextIndex) + list.get(lastIndex) == sum) {
					System.out.println("Triplet found : "+ list.get(i)+ ", " + list.get(nextIndex)+ ", " + list.get(lastIndex));
					break;
				} else if (list.get(i) + list.get(nextIndex) + list.get(lastIndex) < sum) {
					nextIndex++;
				} else {
					lastIndex--;
				}
			}
		}
	}

	public boolean byGFGHashing(MyBSTNode root, int sum) {
		List<Integer> list = new ArrayList<Integer>();
		fillInList(root, list);
		for (int i = 0; i < list.size() - 1; i++) {
			Set<Integer> set = new HashSet<Integer>();
			int rem = sum - list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (set.contains(rem - list.get(j))) { 
					System.out.println(list.get(i)+" "+list.get(j)+" "+(rem - list.get(j)));
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
		fillInListMap(root, list, map);
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int value = sum - (list.get(i) + list.get(j));
				if (map.containsKey(value) && map.get(value) != i && map.get(value) != j) {
					System.out.println("Triplet found : " + list.get(i) + ", " + list.get(j) + ", " + value);
				}
			}
		}
	}

	private void fillInListMap(MyBSTNode root, List<Integer> list, Map<Integer, Integer> map) {
		if (root == null)
			return;
		fillInListMap(root.left, list, map);
		list.add(root.data);
		map.put(root.data, list.size() - 1);
		fillInListMap(root.right, list, map);
	}
}
