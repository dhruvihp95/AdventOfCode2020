package src.star_17_18;

import java.util.*;
import java.io.*;
import org.apache.commons.collections4.queue.CircularFifoQueue;

public class XMASEncoding {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(".\\Input\\input9.csv");
		Scanner sc = new Scanner(file);
		Queue<Integer> queue = new CircularFifoQueue<>(25);
//		Star 1
//		int i = 0;
//		while(sc.hasNextInt()) {
//			if(i<25) {
//				queue.add(sc.nextInt()); 
//				i++;
//			} else {
//				int num = sc.nextInt();
//				if(!checkPairExist(queue,num)) {
//					System.out.println(num);
//					break;
//				} else {
//					queue.add(num);
//				}
//			}
//			
//		}
		List<Integer> allNums = new ArrayList<>();
		int i = 0;
		int sum = 0;
		while(sc.hasNextInt()) {
			int num = sc.nextInt();
			allNums.add(num);
			if(i<25) {
				queue.add(num); 
				i++;
			} else {
				if(!checkPairExist(queue,num)) {
					sum = num;
					break;
				} else {
					queue.add(num);
				}
			}
		}
		int currentSum=allNums.get(0);
		int start = 0;
		for(int j=1;j<allNums.size();j++) {
			while(currentSum>sum) {
				currentSum = currentSum - allNums.get(start);
				start++;
			}
			if (currentSum == sum) {
				int min = findSmallest(start,j,allNums);
				int max = findLargest(start,j,allNums);
				System.out.println(min+max);
				break;
			}
			if(j<allNums.size()) {
				currentSum = currentSum + allNums.get(j);
			}
		}
	}

	private static int findLargest(int start, int j, List<Integer> allNums) {
		int max = Integer.MIN_VALUE;
		for(int i = start;i<=j;i++) {
			if(allNums.get(i)>max) {
				max = allNums.get(i);
			}
		}
		return max;
	}

	private static int findSmallest(int start, int j, List<Integer> allNums) {
		int min = Integer.MAX_VALUE;
		for(int i = start;i<=j;i++) {
			if(allNums.get(i)<min) {
				min = allNums.get(i);
			}
		}
		return min;
	}

	private static boolean checkPairExist(Queue<Integer> queue, int num) {
		Integer[] arr = queue.toArray(new Integer[0]);
		for(int i=0;i<24;i++) {
			for(int j=i;j<25;j++) {
				if(arr[i]+arr[j]==num) {
					return true;
				}
			}
		}
		return false;
	}

}
