package com.baidya.generics.method;

import java.util.Arrays;
import java.util.List;

class Foo implements Comparable<Foo>{
	Integer val;
	public Foo(int val) {
		this.val = val;
	}
	
	@Override
	public int compareTo(Foo o) {
		return this.val.compareTo(o.val);
	}
	
	@Override
	public String toString() {
		return "foo: "+this.val;
	}
	
}

public class FeatureUtility {

	/**
	 * This will print the max : generic implementation works for Integer, Double, String, Character etc. In short all Comparable implementing classes will 
	 * work with this generic method definition.
	 * @param values
	 */
	public static <T extends Comparable<T>> void printMax(List<T> values) {
		T max = values.get(0);
		for(int i=1; i<values.size(); i++) {
			if(values.get(i).compareTo(max)>0) {
				max = values.get(i);
			}
		}
		System.out.printf("Max value: %s\n", max);		
	}
	
	/**
	 * This will print the min : generic implementation works for Integer, Double, String, Character etc. In short all Comparable implementing classes will 
	 * work with this generic method definition.
	 * @param values
	 */
	public static <T extends Comparable<T>> void printMin(List<T> values) {
		T min = values.get(0);
		for(int i=1; i<values.size(); i++) {
			if(values.get(i).compareTo(min)<0) {
				min = values.get(i);
			}
		}
		System.out.printf("Min value: %s\n", min);		
	}
	
	
	public static <T extends Comparable<T>> void printCount(List<T> values, T value) {
		int count = 0;
		for(T val : values) {
			if(val.compareTo(value)==0) count++; 
		}
		System.out.printf("Total count of %s: %d\n", value, count);
	}
	
	public static <T extends Comparable<T>, V extends T> boolean search(T[] values, V value) {
		boolean found = false;
		for(T val : values) {
			if(val.compareTo(value)==0) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public static void main(String[] args) {
		System.out.println("Printing maximum values :");
		printMax(Arrays.asList(21, 12, 4, 5, 87, 23, 24, 5, 76, 98));
		printMax(Arrays.asList(21.4, 12.2, 32.12, 12.0, 34.0));
		printMax(Arrays.asList("dog", "cat", "foo", "bar"));
		printMax(Arrays.asList('a', 'b', 'h', 'l', 'e', 'k'));
		printMax(Arrays.asList(new Foo(3), new Foo(6), new Foo(2)));
		
		System.out.println("\nPrinting minimum values :");
		printMin(Arrays.asList("dog", "cat", "foo", "bar"));
		printMin(Arrays.asList('a', 'b', 'h', 'l', 'e', 'k'));
		printMin(Arrays.asList(new Foo(3), new Foo(6), new Foo(2)));
		
		System.out.println("Finding count :");
		printCount(Arrays.asList(21, 12, 4, 7, 7, 5, 87, 23, 24, 5, 76, 98), 7);
		printCount(Arrays.asList(21.4, 12.2, 32.12, 12.0, 34.0), 12.2);
		printCount(Arrays.asList("dog", "cat", "foo", "bar", "foo"), "foo");
		
		System.out.println("Searching ....");
		boolean res = search(new Integer[] {4, 5, 2, 1, 9}, 25);
		System.out.println(res);
	}
}
