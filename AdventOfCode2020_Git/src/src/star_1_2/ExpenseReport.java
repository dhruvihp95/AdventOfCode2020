package src.star_1_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpenseReport {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(".\\Input\\input1.csv");
		List<Integer> inputs = new ArrayList<>();
		Scanner sc = new Scanner(file);
		while(sc.hasNextInt()) {
			inputs.add(sc.nextInt());
		}
		/* Star 1
		HashSet<Integer> setOfNumbers = new HashSet<>();
		for(int i:inputs) {
			int find = 2020 - i;
			if(setOfNumbers.contains(find)) {
				System.out.println(i*find);
				break;
			} else {
				setOfNumbers.add(i);
			}
		}
		*/
		Map<Integer,List<Integer>> mapOfNumbers = new HashMap<>();
		for(int i:inputs) {
			int find = 2020 - i;
			if(mapOfNumbers.containsKey(find)) {
				if(mapOfNumbers.get(find).size() == 2) {
					int sol = 1;
					sol = sol * i;
					System.out.println(sol);
					List<Integer> vals = mapOfNumbers.get(find);
					sol = sol * vals.get(0);
					System.out.println(vals.get(0));
					sol = sol * vals.get(1);
					System.out.println(vals.get(1));
					System.out.println(sol);
				} else {
					Map<Integer,List<Integer>> tempMap = new HashMap<>();
					mapOfNumbers.forEach((k,v) -> {
						if(v.size() < 2 && !v.contains(i)) {
							List<Integer> l = new ArrayList<>();
							l.addAll(v);
							l.add(i);
							tempMap.put(k+i, l);
						}
					});
					mapOfNumbers.putAll(tempMap);
				}
			} else {
				List<Integer> l = new ArrayList<>();
				l.add(i);
				mapOfNumbers.put(i, l);
				Map<Integer,List<Integer>> tempMap = new HashMap<>();
				mapOfNumbers.forEach((k,v) -> {
					if(v.size() < 2 && !v.contains(i)) {
						List<Integer> li = new ArrayList<>();
						li.addAll(v);
						li.add(i);
						tempMap.put(k+i, li);
					}
				});
				mapOfNumbers.putAll(tempMap);
			}
		}
	}
}
