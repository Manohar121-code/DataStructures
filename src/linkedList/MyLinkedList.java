package linkedList;

public class MyLinkedList {
	private Block head;
	private static int count;
	private Block lastBlock;
	
	public MyLinkedList() {
		super();
	}

	public int size() {
		return count;
	}
	
	public Block getLastBlock() {
		return lastBlock;
	}
	
	public Block getHead() {
		return head.next;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public void add(int value) {
		if (head == null) {
			head = new Block(value);
		}
		Block temp = new Block(value);
		Block current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = temp;
		lastBlock = temp;
		count++;
		System.out.println(value +" is Inserted");
	}
	
	public void add(int value, int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Failed to store "+value+" at "+index+" index");
		}
		if (head == null) {
			head = new Block(value);
		}
		Block temp = new Block(value);
		Block current = head;
		for (int i = 0; i < index && current.next != null; i++) {
			current = current.next;
		}
		temp.next = current.next;
		current.next = temp;
		count++;
		System.out.println(value +" is Inserted");
	}
	
	public int get(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Failed to get value at "+index+" index");
		}
		Block current = head;
		for (int i = 0; i <= index && current.next != null; i++) {
			current = current.next;
		}
		return current.value;
	}
	
	public void remove(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Failed to remove value at "+index+" index");
		}
		Block current = head;
		for (int i = 0; i < index && current.next != null; i++) {
			current = current.next;
		}
		if (current.next != null) {
			current.next = current.next.next;
		}
		System.out.println("removed element at "+(index+1)+" position");
		count--;
	}

	public void showAllElemets() {
		Block temp = head;
		if (temp != null) {
			while (temp.next != null) {
				System.out.print(temp.next.value+" ");
				temp = temp.next;
			}
			System.out.println();
		} else {
			System.out.println("List is empty!!!");
		}
	}
	
	public void getMiddleElement() {
		if (head != null) {
			Block fastBlock = head;
			Block slowBlock = head;
			while (fastBlock != null && fastBlock.next != null) {
				fastBlock = fastBlock.next.next;
				slowBlock = slowBlock.next;
			}
			System.out.println("Middle Element is : "+slowBlock.value);
		} else {
			System.out.println("No elements present in Linkedlist to get the middle element!!!");
		}
	}
	
	public void deleteMiddleElement() {
		if (head != null) {
			Block fastBlock = head;
			Block slowBlockParent = null;
			Block slowBlock = head;
			while (fastBlock != null && fastBlock.next != null) {
				fastBlock = fastBlock.next.next;
				slowBlockParent = slowBlock;
				slowBlock = slowBlock.next;
			}
			slowBlockParent.next = slowBlock.next;
			System.out.println("Middle element "+slowBlock.value+" deleted!!!");
		} else {
			System.out.println("No elements present in Linkedlist to delete the middle element!!!");
		}
	}
	
	public void makeLLNull() {
		head = null;
		count = 0;
		System.out.println("Linkedlist is empty now!!!");
	}
	
	public void deleteDuplicateElements() {
		if (head != null && head.next != null) {
			Block startBlock = head.next;
			while (startBlock.next != null) {
				if (startBlock.value == startBlock.next.value) {
					startBlock.next = startBlock.next.next;
				} else {
					startBlock = startBlock.next;
				}
			}
		}
	}

}
