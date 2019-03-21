package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class PossibleWordsFromPhoneDigits {
	private static Set<String> finalNames = null;
	private static Set<String> combos = null;
	private static Map<Integer, String> mapObj = null;
	private static Set<String> names = null;
	static {
		 mapObj = new HashMap<Integer, String>();
		 mapObj.put(2, "ABC");
		 mapObj.put(3, "DEF");
		 mapObj.put(4, "GHI");
		 mapObj.put(5, "JKL");
		 mapObj.put(6, "MNO");
		 mapObj.put(7, "PQRS");
		 mapObj.put(8, "TUV");
		 mapObj.put(9, "WXYZ");
		 
		 names = new HashSet<String>();
		 names.add("Manohar");names.add("Brahmanandam");
		 names.add("Narasimha");names.add("LasithMalinga");
		 names.add("Jagan");names.add("RahulDravid");
		 names.add("Yokesh");names.add("MSDhoni");
		 names.add("Dipak");names.add("ViratKohli");
		 names.add("Suman");names.add("RohitSharma");
		 names.add("Harikesavulu");names.add("SachinTendulkar");
		 names.add("Pugazh");names.add("Madan");
		 names.add("Ranjit");names.add("MadanMohan");
		 names.add("Pawankalyan");names.add("HrithikRoshan");
		 names.add("Jaganmohanreddy");names.add("AmirKhan");
		 names.add("Chandrababunaidu");names.add("ShahrukhKhan");
		 names.add("Jayaprakashnarayana");names.add("SalmanKhan");
		 names.add("Prabhakar");names.add("Jagadeesh");
		 names.add("Modi");names.add("AlluArjun");
		 names.add("VenkatPrabhakaran");names.add("MaheshBabu");
		 names.add("Nithish");names.add("Mahesh");
		 names.add("Dinesh");names.add("Suresh");
		 names.add("Purna");names.add("Chanikya");
		 names.add("Rajasekhar");
	}
	
	public static void main(String[] args) {
		PossibleWordsFromPhoneDigits obj = new PossibleWordsFromPhoneDigits();
		System.out.println("Please enter testcases");
		Scanner scr = new Scanner(System.in);
		int testCases = scr.nextInt();
		while (testCases-- > 0) {
//			int n = scr.nextInt();
			List<String> list = new ArrayList<String>();
			while (true) {
				int number = scr.nextInt();
				if (number < 2 || number > 9) {
					System.out.println("Please enter number between 2 - 9");
				} else {					
					finalNames = new HashSet<String>();
					combos = new HashSet<String>();
					list.add(mapObj.get(number));
					obj.doOperation(list);
				}
			}
		}
	}

	private void printList() {
		System.out.println("----------- start -----------");
		if (finalNames.isEmpty())
			System.out.println("No results found!!!");
		else
			for (String name : finalNames)
				System.out.println(name);
		System.out.println("-----------  end  -----------");
	}
	
	private void doOperation(List<String> list) {
		doRecursion(list, 0, "");
		//***********************
		finalNames = names.stream().filter(name -> combos.stream().anyMatch(combo -> name.toLowerCase().contains(combo.toLowerCase()))).collect(Collectors.toSet());
		//***********************
		printList();
	}

	private void doRecursion(List<String> strArr, int index, String res) {
		if (index == strArr.size()) {
			combos.add(res);
			return;
		}
		String s = strArr.get(index);
		for (int i = 0; i < s.length(); i++)
			doRecursion(strArr, index+1, res+s.charAt(i));
		
	}
}
