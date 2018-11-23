package doneByAnything;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Peka {
	public static void main(String[] args) {
		String N = "Nithish", M = "Manohar", S = "Sandulu";
		int perGame = 20;
		Map<String, Integer> mapObj = new HashMap<String, Integer>();
		mapObj.put(N, 0);
		mapObj.put(M, 0);
		mapObj.put(S, 0);
		String[] list = {};
		Set<String> keySet = mapObj.keySet();
		for (String s : list) {
			for (String player : keySet) {
				if (s.equals(player)) {
					mapObj.put(player, mapObj.get(player) + (mapObj.size()-1) * perGame);
				} else {
					mapObj.put(player, mapObj.get(player) - perGame);
				}
			}
		}
		for (String string : keySet) {
			System.out.println(string+" -> "+mapObj.get(string));
		}
		
		/*System.out.println("----------------");
		Map<String, Integer> mm = new HashMap<>();
		for (String s : keySet) {
			if (mm.containsKey(s))
				mm.put(s, mm.get(s) + 1);
			else
				mm.put(s, 1);
		}*/
	}
}
