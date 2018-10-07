package doneByAnything;

import java.util.Hashtable;

class DLinkedNode {
	int key;
	int value;
	DLinkedNode prev;
	DLinkedNode next;
}

public class LRUCache {
	
	private int count;
	private int capacity;
	private Hashtable<Integer, DLinkedNode> lruCache;
	private DLinkedNode head, tail;
	
	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		lruCache = new Hashtable<>();
		
		head = new DLinkedNode();
		head.prev = null;
		tail = new DLinkedNode();
		tail.next = null;
		
		head.next = tail;
		tail.prev = head;
	}
	
	private void addNode(DLinkedNode node) {
		node.prev = head;
		node.next = head.next;
		
		head.next.prev = node;
		head.next = node;
	}
	
	private void removeNode(DLinkedNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	private void moveToHead(DLinkedNode node) {
		this.removeNode(node);
		this.addNode(node);
	}
	
	private DLinkedNode popTail() {
		DLinkedNode result = tail.prev;
		this.removeNode(result);
		return result;
	}
	
	//LRU Cache operations here
	public int get(int key) {
		DLinkedNode node = lruCache.get(key);
		if (node == null) {
			return -1;
		}
		this.moveToHead(node);
		return node.value;
	}
	
	public void set(int key, int value) {
		DLinkedNode node = lruCache.get(key);
		if (node == null) {
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
			this.addNode(newNode);
			this.lruCache.put(key, newNode);
			count++;
			if (count > capacity) {
				DLinkedNode lastNode = this.popTail();
				this.lruCache.remove(lastNode.key);
				count--;
			}
		} else {
			node.value = value;
			this.moveToHead(node);
		}
	}
	
	public static void main(String[] args) {
		LRUCache obj = new LRUCache(3);
		obj.set(1, 10);
		obj.set(2, 20);
		obj.set(3, 30);
		obj.set(4, 40);
		obj.set(5, 50);
		obj.set(6, 60);
		obj.get(4);
		obj.set(1, 100);
		
		System.out.println("1 -> " + obj.get(1));
		System.out.println("2 -> " + obj.get(2));
		System.out.println("3 -> " + obj.get(3));
		System.out.println("4 -> " + obj.get(4));
		System.out.println("5 -> " + obj.get(5));
		System.out.println("6 -> " + obj.get(6));
	}
	
}
