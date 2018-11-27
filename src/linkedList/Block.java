package linkedList;

public class Block {
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