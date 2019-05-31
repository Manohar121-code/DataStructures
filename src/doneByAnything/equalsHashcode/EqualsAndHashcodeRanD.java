package doneByAnything.equalsHashcode;

import java.util.HashMap;

public class EqualsAndHashcodeRanD {
	public static void main(String[] args) {
		HashMap<Employee, Integer> hMap = new HashMap<>();
		
		hMap.put(new Employee(1, "Giridhar"), 150);
		System.out.println("---------");
		hMap.put(new Employee(1, "Manohar"), 2222);
		System.out.println("---------");
		hMap.put(new Employee(2, "Manohar"), 3333);
		System.out.println("---------");
		Employee employee = new Employee(2, "Manohar");
		hMap.put(employee, 100);
		System.out.println("---------");
		hMap.put(employee, 200);
		System.out.println("---------");
		hMap.put(employee, 1234);
		System.out.println("---------");
		hMap.put(new Employee(3, "Sachin"), 1500);
		System.out.println("---------");
		hMap.put(new Employee(4, "Dravid"), 111);
		System.out.println("---------");
		hMap.put(new Employee(5, "Ganguly"), 183);
		System.out.println("---------");
		hMap.put(new Employee(6, "Sehwag"), 209);
		System.out.println("---------");
		hMap.put(new Employee(7, "Laxman"), 250);
		System.out.println("---------");
		hMap.put(new Employee(8, "Dhoni"), 199);
		System.out.println("---------");

		System.out.println();
		System.out.println("Size : "+ hMap.size());
		System.out.println("Manohar is there : "+ hMap.get(new Employee(1, "Sachin")));
	}
}

class Employee {
	private int id;
	private String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		System.out.println("in hashcode");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return id % 2 == 0 ? 2 : 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			System.out.println("eqdjfdjfhkdjfhglksdjfgksjdfgkljsdhflkgjshdlfkjghsldkjfghlskdjfhglksdjfhglksdjfhglksjdfhglksjdfhlkjsd");
			return true;
		}
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		System.out.println("IN EQUALS --> "+this.name+" ---> "+other.name);
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}