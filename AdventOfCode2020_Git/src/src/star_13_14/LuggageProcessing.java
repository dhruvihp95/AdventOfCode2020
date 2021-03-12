package src.star_13_14;

import java.util.*;
import java.io.*;

public class LuggageProcessing {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(".\\Input\\input7.csv");
		Scanner sc = new Scanner(file);
		Map<String,String> bagContainsMap = new HashMap<>();
		while(sc.hasNextLine()) {
			String input = sc.nextLine();
			String[] keyValues = input.split("s contain ");
			bagContainsMap.put(keyValues[0], keyValues[1]);
		}
		
		/*Set<String> finalSet = new HashSet<>();
		Queue<String> searchSet = new LinkedList<>();
		searchSet.add("shiny gold bag");
		while(!searchSet.isEmpty()) {
			String bag = searchSet.remove();
			bagContainsMap.entrySet().forEach(entry -> {
				if(entry.getValue().contains(bag)) {
					searchSet.add(entry.getKey());
					finalSet.add(entry.getKey());
				}
			});
		}
		System.out.println(finalSet.size());*/
		// Star 2
		int totalBagsWithin = getBagsWithin("shiny gold bag",bagContainsMap);
		System.out.println(totalBagsWithin-1);
	}

	private static int getBagsWithin(String key, Map<String, String> bagContainsMap) {
		String val = bagContainsMap.get(key);
		if(val == null) {
			return 0;
		}
		if(val !=null && val.contains("no other bags.")) {
			return 1;
		}
		String vals[] = val.split(", ");
		int totalCount = 1;
		int mulSum = 0;
		for(String v: vals) {
			int mul = Integer.parseInt(v.substring(0,v.indexOf(" ")));
			String k = v.substring(v.indexOf(" ")+1,v.lastIndexOf(" ")+4);
			int bagCount = getBagsWithin(k,bagContainsMap);
				totalCount = totalCount + (mul * bagCount);
			
		}
		return totalCount;
	}

}
