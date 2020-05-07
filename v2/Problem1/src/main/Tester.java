package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		int[] arr = {1,2,5,3,4,3,5,7,5,8,5};
		int input = 5;
		
		int last = arr.length - 1;
		while(arr[last]==input && last>-1) {
			last--;
		}
		
		for(int i=0; i<last; i++) {
			if(arr[i]==input) {
				swap(arr, i, last);
				last--;
				while(arr[last]==input) {
					last--;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
		//ALTERNATE METHOD USING LIST DATASTRUCTURE, WITHOUT THE HELPER METHOD
		
//		List<Integer> output = new ArrayList<>();
//		int count = 0;
//		for (Integer i : arr) {
//			if(i == input) count++;
//			else output.add(i);
//		}
//		for(int i=0; i<count; i++) {
//			output.add(input);
//		}
//		System.out.println(Arrays.toString(output.toArray()));
		
		
		//SAME USING JAVA 8 FEATURES
		
//		List<Integer> output = new ArrayList<>();
//		List<Integer> temp = new ArrayList<>();
//		Integer count = null;
//		Arrays.stream(arr).forEach(i -> {
//			if(i == input) temp.add(i);
//			else output.add(i);
//			
//		});
//		output.addAll(temp);
//		System.out.println(Arrays.toString(output.toArray()));
	}
	
	public static void swap(int[] arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
}