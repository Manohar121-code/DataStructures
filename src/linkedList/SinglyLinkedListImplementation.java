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