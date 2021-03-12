package src.star_9_10;

import java.util.*;
import java.io.*;

public class BinaryBoarding {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(".\\Input\\input5.csv");
		Scanner sc = new Scanner(file);
		boolean[] occupied = new boolean[1024];
//		int maxId = 0;
		while(sc.hasNextLine()) {
			String ip = sc.nextLine();
			int row = getRow(ip);
			int col = getCol(ip);
			int id = row*8+col;
			occupied[id] = true;
			/* Star 1
			maxId = Math.max(maxId, id);
			System.out.println(ip+":"+maxId);*/
			
		}
		for(int i=0;i<1024;i++) {
			if(occupied[i]==false && i>0 && i<1023) {
				if(occupied[i-1]==true && occupied[i+1]==true) {
					System.out.println(i);
					break;
				}
			}
		}
//		System.out.println(maxId);
	}


	private static int getRow(String ip) {
		int min = 0;
		int max = 127;
		for(int i=0;i<6;i++) {
			int mid = (min+max)/2;
			if(ip.charAt(i) == 'F') {
				max = mid;
			} else if(ip.charAt(i) == 'B') {
				min = mid+1;
			}
		}
		return ip.charAt(6) == 'F'? min:max;
	}

	private static int getCol(String ip) {
		int min = 0;
		int max = 7;
		for(int i=7;i<9;i++) {
			int mid = (min+max)/2;
			if(ip.charAt(i) == 'L') {
				max = mid;
			} else if(ip.charAt(i) == 'R') {
				min = mid+1;
			}
		}
		return ip.charAt(9) == 'L'? min:max;
	}
}
