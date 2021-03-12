package src.star_19_20;

import java.util.*;
import java.io.*;

public class JoltAdapters {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(".\\Input\\input10.csv");
		Scanner sc = new Scanner(file);
		List<Integer> nums = new ArrayList<>();
		nums.add(0);
		while (sc.hasNextInt()) {
			nums.add(sc.nextInt());
		}
		Collections.sort(nums);
		nums.add(nums.get(nums.size()-1)+3);
		int JoltDiff_1 = 0;
		int JoltDiff_3 = 0;
		int i = 0;
		while (i < nums.size() - 1) {
			switch (nums.get(i + 1) - nums.get(i)) {
			case 1:
				JoltDiff_1++;
				break;
			case 3:
				JoltDiff_3++;
				break;
			}
			i++;
		}
		System.out.print(JoltDiff_1*JoltDiff_3);
	}
}
