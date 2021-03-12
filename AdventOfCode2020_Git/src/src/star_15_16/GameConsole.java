package src.star_15_16;

import java.util.*;
import java.io.*;

public class GameConsole {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(".\\Input\\input8.csv");
		Scanner sc = new Scanner(file);
		List<String> instructions = new ArrayList<>();
		while(sc.hasNextLine()) {
			instructions.add(sc.nextLine());
		}
		//Star 1
//		getAccumlator(instructions);
		int i = 0;
		while(i<instructions.size()) {
			String modifiable = instructions.get(i);
			if(modifiable.contains("jmp") || modifiable.contains("nop") ) {
				if(modifiable.contains("jmp")) {
					modifiable = modifiable.replace("jmp", "nop");
				} else {
					modifiable = modifiable.replace("nop", "jmp");
				}
				instructions.set(i, modifiable);
				int ac = getAccumlator(instructions);
				if(ac == Integer.MIN_VALUE) {
					if(modifiable.contains("jmp")) {
						modifiable = modifiable.replace("jmp", "nop");
					} else {
						modifiable = modifiable.replace("nop", "jmp");
					}
					instructions.set(i, modifiable);
					i++;
				} else {
					System.out.print(ac);
					break;
				}
				
			} else {
				i++;
			}
		}
	}

	private static int getAccumlator(List<String> instructions) {
		int accumlator = 0;
		boolean reached[] = new boolean[instructions.size()];
		int i=0;
		while(i<instructions.size()) {
			if(reached[i]==true) {
				return Integer.MIN_VALUE;
			} else {
				reached[i]=true;
				String instruct = instructions.get(i);
				if(instruct.contains("acc") || instruct.contains("jmp")) {
					String[] insts = instruct.split(" +?");
					if(insts[0].equals("acc")) {
						accumlator += Integer.parseInt(insts[1]);
						i++;
					} else if(insts[0].equals("jmp")) {
						i += Integer.parseInt(insts[1]);
					}
				} else {
					i++;
				}
			}
		}
		return accumlator;
	}
}
