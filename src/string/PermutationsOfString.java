package string;

public class PermutationsOfString {
	public static void main(String[] args) {
		PermutationsOfString obj = new PermutationsOfString();
		String s = "ABCD";
		long startTime = System.nanoTime();
		obj.doOperation("", s);
		long endTime = System.nanoTime();
		System.out.println("Time taken " + (endTime - startTime));
	}

	private void doOperation(String subStr, String s) {
		if (s.length() == 0) {
			System.out.println(subStr);
		}
		for (int i = 0; i < s.length(); i++) {
			doOperation(subStr + s.charAt(i), s.substring(0, i)+s.substring(i+1, s.length()));
		}
	}
	
	/*private void doOperation(String s) {
		String t = "";
		if (s.length() == 1) {
//			System.out.print(String.valueOf(s.charAt(0)));
		}
		for (int i = 0; i < s.length(); i++) {
			System.out.print(String.valueOf(s.charAt(i)));
			doOperation(s.substring(0, i)+s.substring(i+1, s.length()));
			System.out.print(" ");
		}
	}*/
}
