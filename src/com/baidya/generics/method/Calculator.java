package com.baidya.generics.method;

public class Calculator {

	public static <T extends Number> double sum(T x, T y) {
		return x.doubleValue()+y.doubleValue();
	}
	
	public static void main(String[] args) {
		System.out.println(Calculator.sum(3, 5));
		System.out.println(Calculator.sum(3.2, 5.2));
		System.out.println(Calculator.sum((byte)'a', (byte)'b'));
	}
	
}


