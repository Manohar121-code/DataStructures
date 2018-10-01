package string;

public class LongestCommonSubString {
	public static void main(String[] args) {
//		String s1 = "xyzabcxdefqyu";
//		String s2 = "jhkabcxdefjabcddfh";
//		String s1 = "LRMQBHCDARZOWKKYHIDDQSCDXRJMOWFRXSJYBLDBEFSARCBYNECDYGGXXPKLORELLNMPAPQFWKHOPKMCO";
//		String s2 = "QHNWNKUEWHSQMGBBfaircUQCLJJIVSWMDKQTBXIXMVTRRBLJPTNSNFWZQFJMAFADRRWSOFSBCNUVQHFFB";
		String s1 = "xyzabcxdefqyu";
		String s2 = "jhkabcxdfefjabcddfh";
		int n = s1.length();
		int m = s2.length();
		int maxLen = Math.max(n, m);
		int minLen = Math.min(n, m);
		String maxLenStr = s1.length() == maxLen ? s1 : s2;
		String minLenStr = s1.length() == minLen ? s1 : s2;
		long startTime = System.nanoTime();
		findLCM(maxLenStr,minLenStr,maxLen,minLen);
		System.out.println("Total time taken : "+ (System.nanoTime() - startTime));
	}

	public static void findLCM(String maxLenStr, String minLenStr, int maxLen, int minLen) {
		int maxCount = 0;
		int count = 0;
		for (int i = 0; i < minLen; i++) {
			for (int c = 0; c < maxLenStr.length(); c++) {
				if (minLenStr.charAt(i) == maxLenStr.charAt(c)) {
					int tempMinLenIndex = i;
					int tempMaxLenIndex = c;
					while (tempMinLenIndex < minLen && tempMaxLenIndex < maxLen && minLenStr.charAt(tempMinLenIndex++) == maxLenStr.charAt(tempMaxLenIndex++)) {
						count++;
					}
					maxCount = Math.max(maxCount, count);
					count = 0;
				}
			}
		}
		System.out.println(maxCount);
	}
}
