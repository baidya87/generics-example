package com.baidya.basic.practice;
// T will be upper bound to all classes that implements Comparable & hence the compareTo method is available for comparison. 
class Search<T extends Comparable<T>>{
	
	T val;
	public Search(T val) {
		this.val = val;
	}
	
	public int search(T[] values) {
		int count = 0;
		for (T value : values) {
			if(value.compareTo(val)==0) {
				System.out.println("found matching..");
				count++;
			}
		}
		return count;
	}
}

class CalculateAverage<T extends Number>{
	double average = 0.0;
	public double average(T[] values) {
		double sum = 0.0;
		for(T val : values) {
			sum+=val.doubleValue();
		}
		
		average = sum/values.length;
		return average;
	}
	// use of wild card to compare CalculateAverage of type double & integer.
	public boolean isSame(CalculateAverage<?> currAvg) {
		return this.average == currAvg.average;
	}
}

public class AverageApp {

	public static void main(String[] args) {
		Search<String> values = new Search<>("cat");
		int result = values.search(new String[] {"dog", "cat", "dog", "dog", "cow", "buffalo", "cat", "buffalo"});
		System.out.println(result);
		
		// Search for integer
		Search<Double> numbers = new Search<>(4.0);
		int count = numbers.search(new Double[] {2.0, 3.2, 4.0, 2.0, 2.0, 4.0, 5.1, 6.9, 5.1, 6.9, 7.7});
		System.out.println(count);
		
		// Finding average
		CalculateAverage<Integer> nums = new CalculateAverage<>();
		System.out.println("Average: "+nums.average(new Integer[] {3, 6, 7, 3, 2, 9, 4, 2}));
		
		CalculateAverage<Double> fNums = new CalculateAverage<>();
		System.out.println("Average: "+fNums.average(new Double[] {3.0, 6.0, 7.0, 3.0, 2.0, 9.0, 4.0, 2.0}));
		
		System.out.println(nums.isSame(fNums));
	}
}

