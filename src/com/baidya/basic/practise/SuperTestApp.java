package com.baidya.basic.practise;

class A{
	int x;
	public A(int x) {
		this.x = x;
	}
}

class B extends A{
	int y;
	public B(int x, int y) {
		super(x);
		this.y =  y;
	}
}

class C extends B{
	int z;
	public C(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
}

class D extends C{
	int p;
	public D(int x, int y, int z, int p) {
		super(x, y, z);
		this.p = p;
	}
}

class Capture<T>{
	T[] var;
	public Capture(T[] var) {
		this.var = var;
	}
}

class CaptureDisplay{
	/**
	 * Setting upper bound - this method should only accept class C & its implementing subclasses.
	 * @param variables
	 */
	public static void printC_subclasses(Capture<? extends C> variables) {
		for(int i=0; i<variables.var.length; i++) {
			System.out.printf("x: %d, y: %d, z: %d\n", variables.var[i].x, variables.var[i].y, variables.var[i].z);
		}
	}
	
	/**
	 * Setting a lower bound using super keyword - this method only accepts B & it's super classes. i.e B & A only.
	 * @param variables
	 */
	public static void printB_superclasses(Capture<? super B> variables) {
		for(int i=0; i<variables.var.length; i++) {
			System.out.printf("x: %d\n", ((A)variables.var[i]).x);
		}
	}
}

public class SuperTestApp {
	
	public static void main(String[] args) {
		//Capture<C> variables = new Capture<>(new C[] {new C(1, 2, 3), new C(0, -2, 3), new D(3, 3, 4, 8)});
		//CaptureDisplay.printC_subclasses(variables);
		
		Capture<A> data = new Capture<>(new A[] {new A(1), new A(2), new A(3), new B(5, 10)}); 
		CaptureDisplay.printB_superclasses(data);
	}
	
}

