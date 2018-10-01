package string;

public class Atoi {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(doOperation("3242534"));
		long endTime = System.nanoTime();
		System.out.println("Total time taken : " + (endTime - startTime));
		long startTime2 = System.nanoTime();
		System.out.println(doOperationByArray("3242534"));
		long endTime2 = System.nanoTime();
		System.out.println("Total time taken : " + (endTime2 - startTime2));
	}

	public static int doOperation(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return -1;
		}
	}

	public static int doOperationByArray(String s) {
		char[] charArray = s.toCharArray();
		if (charArray[0] != '-' && !Character.isDigit(charArray[0])) {
			return -1;
		}
		for (int i = 1; i < charArray.length; i++) {
			if (!Character.isDigit(charArray[i])) {
				return -1;
			}
		}
		return Integer.parseInt(s);
	}
}
