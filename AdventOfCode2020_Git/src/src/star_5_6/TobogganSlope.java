package src.star_5_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TobogganSlope {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(".\\Input\\input3.csv");
		Scanner sc = new Scanner(file);
		List<String[]> inputs = new ArrayList<>();
		while(sc.hasNextLine()) {
			String[] ip = sc.nextLine().split("");
			inputs.add(ip);
		}
		
		int totalRows = inputs.size();
		int totalColumns = inputs.get(0).length;
		
		int R3D1 = treesR3D1(inputs,totalRows,totalColumns);
		int R1D1 = treesR1D1(inputs,totalRows,totalColumns);
		int R5D1 = treesR5D1(inputs,totalRows,totalColumns);
		int R7D1 = treesR7D1(inputs,totalRows,totalColumns);
		int R1D2 = treesR1D2(inputs,totalRows,totalColumns);
		System.out.println(R3D1);
		System.out.println(R1D1);
		System.out.println(R5D1);
		System.out.println(R7D1);
		System.out.println(R1D2);
		System.out.println(R3D1*R1D1*R5D1*R7D1*R1D2);
	}
	
	public static int treesR3D1(List<String[]> inputs, int totalRows,int totalColumns) {
		int nextCol = 0;
		int col = 0;
		int totalTrees = 0;
		for(int row=1;row<totalRows;row++) {
			nextCol = col+3;
			if(nextCol>=totalColumns) {
				col = nextCol - totalColumns;
			} else {
				col = nextCol;
			}
			if(inputs.get(row)[col].equals("#")) {
				totalTrees++;
			}
		}
		return totalTrees;
	}
	
	public static int treesR1D1(List<String[]> inputs, int totalRows,int totalColumns) {
		int nextCol = 0;
		int col = 0;
		int totalTrees = 0;
		for(int row=1;row<totalRows;row++) {
			nextCol = col+1;
			if(nextCol>=totalColumns) {
				col = nextCol - totalColumns;
			} else {
				col = nextCol;
			}
			if(inputs.get(row)[col].equals("#")) {
				totalTrees++;
			}
		}
		return totalTrees;
	}
	
	public static int treesR5D1(List<String[]> inputs, int totalRows,int totalColumns) {
		int nextCol = 0;
		int col = 0;
		int totalTrees = 0;
		for(int row=1;row<totalRows;row++) {
			nextCol = col+5;
			if(nextCol>=totalColumns) {
				col = nextCol - totalColumns;
			} else {
				col = nextCol;
			}
			if(inputs.get(row)[col].equals("#")) {
				totalTrees++;
			}
		}
		return totalTrees;
	}
	
	public static int treesR7D1(List<String[]> inputs, int totalRows,int totalColumns) {
		int nextCol = 0;
		int col = 0;
		int totalTrees = 0;
		for(int row=1;row<totalRows;row++) {
			nextCol = col+7;
			if(nextCol>=totalColumns) {
				col = nextCol - totalColumns;
			} else {
				col = nextCol;
			}
			if(inputs.get(row)[col].equals("#")) {
				totalTrees++;
			}
		}
		return totalTrees;
	}
	
	public static int treesR1D2(List<String[]> inputs, int totalRows,int totalColumns) {
		int nextCol = 0;
		int col = 0;
		int totalTrees = 0;
		for(int row=2;row<totalRows;row=row+2) {
			nextCol = col+1;
			if(nextCol>=totalColumns) {
				col = nextCol - totalColumns;
			} else {
				col = nextCol;
			}
			if(inputs.get(row)[col].equals("#")) {
				totalTrees++;
			}
		}
		return totalTrees;
	}
}
