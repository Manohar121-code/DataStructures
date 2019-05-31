package doneByAnything;

public class Calculator {
	private int var = 0;

	public Calculator(int var) {
		super();
		this.var = var;
	}

	private Calculator add(int i) {
		this.var += i ;
		return this;
	}

	private Calculator substract(int i) {
		this.var -= i ;
		return this;
	}

	private Calculator multiply(int i) {
		this.var *= i ;
		return this;
	}

	private Calculator getResult() {
		return this;
	}
	
	@Override
	public String toString() {
		return "Calculator [var=" + var + "]";
	}

	public static void main(String[] args) {
		Calculator cl = new Calculator(3).add(4).substract(5).multiply(6).getResult();
		System.out.println(cl);
	}
}
