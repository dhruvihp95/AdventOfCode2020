package src.star_3_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TobogganRentalShop {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(".\\Input\\input2.csv");
		Scanner sc = new Scanner(file);
		List<String> inputs = new ArrayList<>();
		while(sc.hasNextLine()) {
			inputs.add(sc.nextLine());
		}
		Map<MinMaxChar,String> map = new HashMap<>();
		for(String s: inputs) {
			String[] arr = s.split(" ");
			MinMaxChar mmc = new MinMaxChar();
			String arr1[] = arr[0].split("-");
			mmc.setMin(Integer.parseInt(arr1[0]));
			mmc.setMax(Integer.parseInt(arr1[1]));
			mmc.setC(arr[1].charAt(0));
			map.put(mmc, arr[2]);
		}
		int count = 0;
		/*Star 1
		for(Entry<MinMaxChar,String> entry : map.entrySet()) {
			int countOfChar =  getCountOfChar(entry.getValue(),entry.getKey().getC());
			if(countOfChar>=entry.getKey().getMin() && countOfChar<=entry.getKey().getMax()) {
				count++;
			}
		} */
		for(Entry<MinMaxChar,String> entry : map.entrySet()) {
			String s = entry.getValue();
			char match = entry.getKey().getC();
			int min = entry.getKey().getMin()-1;
			int max = entry.getKey().getMax()-1;
			if((s.charAt(min)==match && s.charAt(max)!=match) || (s.charAt(max)==match && s.charAt(min)!=match)) {
				count++;
			}
		}
		
		System.out.println(count);
	}

	private static int getCountOfChar(String value, char c) {
		int count = 0;
		for(char ch : value.toCharArray()) {
			if(ch==c) {
				count++;
			}
		}
		return count;
	}

	private static class MinMaxChar {
		private int min;
		private int max;
		private char c;
		
		public MinMaxChar() {
			//Do Nothing
		}

		public int getMin() {
			return min;
		}

		public void setMin(int min) {
			this.min = min;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}

		public char getC() {
			return c;
		}

		public void setC(char c) {
			this.c = c;
		}
		
		
	}
}
