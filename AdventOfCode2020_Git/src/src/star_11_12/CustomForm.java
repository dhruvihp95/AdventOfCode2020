package src.star_11_12;

import java.util.*;
import java.io.*;

public class CustomForm {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(".\\Input\\input6.csv");
		Scanner sc = new Scanner(file);
		int totalCount = 0;
		int count = 0;
		Set<String> yeses = new HashSet<>();
		while(sc.hasNextLine()) {
			String ip = sc.nextLine();
			if(!ip.isEmpty()) {
				String[] ans = ip.split("");
				if(count==0) {
					Collections.addAll(yeses,ans);
				} else {
					Set<String> temp = new HashSet<>();
					Collections.addAll(temp,ans);
					yeses.retainAll(temp);
				}
				count++;
			} else {
				totalCount += yeses.size();
				yeses=new HashSet<>();
				count = 0;
			}
		}
		/* Star 1
		 * while(sc.hasNextLine()) {
			String ip = sc.nextLine();
			if(!ip.isEmpty()) {
				String[] ans = ip.split("");
				Collections.addAll(yeses,ans);
			} else {
				System.out.println(count+":"+yeses.size());
				count++;
				totalCount += yeses.size();
				yeses=new HashSet<>();
			}
		}
		System.out.println(count+":"+yeses.size());
		totalCount += yeses.size();
		System.out.println(totalCount);*/
		totalCount += yeses.size();
		System.out.println(totalCount);
	}
}
