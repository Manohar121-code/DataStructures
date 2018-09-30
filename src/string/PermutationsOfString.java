package string;

public class PermutationsOfString {
	public static void main(String[] args) {
		PermutationsOfString obj = new PermutationsOfString();
		String s = "ABC";
		long startTime = System.nanoTime();
		obj.doOperation(s);
		System.out.println("\nTime taken " + (System.nanoTime() - startTime));
	}

	private void doOperation(String s) {
		String t = "";
		if (s.length() == 1) {
//			System.out.print(String.valueOf(s.charAt(0)));
		}
		for (int i = 0; i < s.length(); i++) {
			System.out.print(String.valueOf(s.charAt(i)));
			doOperation(s.substring(0, i)+s.substring(i+1, s.length()));
			System.out.print(" ");
		}
	}
}
