package string;

import java.util.Scanner;

public class LongestCommonSubString {
	public static void main(String[] args) {
//		String s1 = "xyzabcxdefqyu";
//		String s2 = "jhkabcxdefjabcddfh";
//		String s1 = "LRMQBHCDARZOWKKYHIDDQSCDXRJMOWFRXSJYBLDBEFSARCBYNECDYGGXXPKLORELLNMPAPQFWKHOPKMCO";
//		String s2 = "QHNWNKUEWHSQMGBBfaircUQCLJJIVSWMDKQTBXIXMVTRRBLJPTNSNFWZQFJMAFADRRWSOFSBCNUVQHFFB";
//		String s1 = "xyzabcxdefqyu";
//		String s2 = "jhkabcxdfefjabcabcxdefddfh";
		System.out.println("djfhjdf");
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
			int n = scr.nextInt();
			int m = scr.nextInt();
			String s1 = scr.next();
			String s2 = scr.next();
			int maxLen = Math.max(n, m);
			int minLen = Math.min(n, m);
			String maxLenStr = s1.length() == maxLen ? s1 : s2;
			String minLenStr = s1.equals(maxLenStr) ? s2 : s1;
			long startTime = System.nanoTime();
			findLCM(maxLenStr,minLenStr,maxLen,minLen);
			long endTime = System.nanoTime();
			System.out.println("Total time taken : "+ (endTime - startTime));
			
			long startTime2 = System.nanoTime();
			findLCSS2pointO(maxLenStr,minLenStr,maxLen,minLen);
			long endTime2 = System.nanoTime();
			System.out.println("Total time taken by 2.0 : "+ (endTime2 - startTime2));
		}
	}

	public static void findLCM(String maxLenStr, String minLenStr, int maxLen, int minLen) {
		StringBuilder resStr = new StringBuilder();
		for (int i = 0; i < minLen; i++) {
			for (int c = 0; c < maxLenStr.length(); c++) {
				if (minLenStr.charAt(i) == maxLenStr.charAt(c)) {
					int tempMinLenIndex = i;
					int tempMaxLenIndex = c;
					while (tempMinLenIndex < minLen && tempMaxLenIndex < maxLen && minLenStr.charAt(tempMinLenIndex) == maxLenStr.charAt(tempMaxLenIndex)) {
						tempMinLenIndex++;tempMaxLenIndex++;
					}
					StringBuilder tempRes = new StringBuilder(minLenStr.substring(i, tempMinLenIndex));
					if (tempRes.length() > resStr.length())
						resStr = tempRes;
				}
			}
		}
		System.out.println(resStr);
	}
/*
1
6 6
ABCDGH
QACDGH

1
15 39
adxyzabcxdefqyu
jhkabcxdfexyzfjabcabcxyzabcxdefqdefddfh
*/
//	String s1 = "xyzabcxdefqyu";
//	String s2 = "jhkabcxdfefjabcabcxdefddfh";
	
//	String s1 = "xyzabcxdefqyu";
//	String s2 = "jhkabcxdfefjabcabcxdefddfh";
	private static void findLCSS2pointO(String maxLenStr, String minLenStr, int maxLen, int minLen) {
		StringBuilder sbl = new StringBuilder(), resStr = new StringBuilder();
		for (int i = 0; i < minLen; i++) {
			if (i+resStr.length() < minLen) { //adding the length of resStr to current index bcoz need to find more length than that.
				sbl.setLength(0);
				sbl.append(minLenStr.substring(i, i+resStr.length()+1));//sbl = substr of i -> i+resStr.len()... +1 is for substr. By adding resStr length automatically taken next index.
				if (maxLenStr.indexOf(sbl.toString()) != -1) { //checking whether that sbl in maxLenStr
					int tempMinIndex = i + sbl.length(); //get end index of newly formed sbl
					StringBuilder tempSbl = new StringBuilder(sbl);// created new instance because sbl and resStr declared globally and if not created new instance in 86 line sbl is referred to resStr.
					while (tempMinIndex < minLenStr.length() && maxLenStr.indexOf(tempSbl.append(minLenStr.charAt(tempMinIndex)).toString()) != -1)//increased index one by one until not matched
						tempMinIndex++;
					if (tempMinIndex != minLenStr.length()) //above while is breaked bcoz of 'tempMinIndex < minLenStr.length()' then dont delete the last char otherwise delete it because tempMinIndex is ++.
						tempSbl.setLength(tempSbl.length() -1);
					if (tempSbl.length() > resStr.length())
						resStr = tempSbl;
				}
			}
		}
		System.out.println("by 2.0 : "+resStr);
	}

}
