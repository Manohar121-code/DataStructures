package linkedList;

public class SinglyLinkedListImplementation {
	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.add(10);
		obj.add(20);
		obj.add(20);
		obj.add(40);
		obj.add(40);
		obj.add(40);
		obj.add(70);
		obj.add(80);
		obj.add(80);
		obj.add(100);
		obj.add(100);
		System.out.println("----------------");
		try {
			obj.add(35, 3);
			obj.showAllElemets();
			System.out.println("Size is : "+obj.size());
			System.out.println("------------");
			System.out.println("4th element is : "+obj.get(3));
			System.out.println("------------");
			obj.remove(3);
			System.out.println("Size is : "+obj.size());
			obj.showAllElemets();
			System.out.println("------------");
			obj.getMiddleElement();
			System.out.println("------------");
//			obj.makeLLNull();
//			obj.getMiddleElement();
//			System.out.println("------------");
			obj.deleteMiddleElement();
			obj.showAllElemets();
			System.out.println("------------");
			obj.deleteDuplicateElements();
			obj.showAllElemets();
			System.out.println("------------");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
}

class MyLinkedList {
	private Block head;
	private static int count;

	public MyLinkedList() {
		super();
	}

	public int size() {
		return count;
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

class Block {
	Block next;
	int value;

	public Block(int value) {
		super();
		this.value = value;
	}

	public Block getNext() {
		return next;
	}

	public void setNext(Block next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}