package src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Tester {

	public static void main(String[] args) {

		int[] arr1 = new int[] {1,6,7,8,9,9};
		int[] arr2 = new int[] {8,9,10};
		
		LinkedList<Integer> output = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		
		Arrays.stream(arr1).forEach(set::add);
		Arrays.stream(arr2).forEach(e -> {
			if(!set.add(e)) {
				set.remove(e);
				output.add(e);
				output.add(e);
			}
		});
		
		output.addAll(0, set);
		System.out.println(output);
	}

}