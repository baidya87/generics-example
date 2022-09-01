package com.baidya.basic.practice;
// using wild cards to understand extends keyword

class TwoDim{
	int x;
	int y;
	public TwoDim(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ThreeDim extends TwoDim{
	int z;
	public ThreeDim(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
}

class FourDim extends ThreeDim{
	int t;
	public FourDim(int x, int y, int z, int t) {
		super(x, y, z);
		this.t = t;
	}
}

class Cordinates<T extends TwoDim>{
	T[] cordinates = null;
	Cordinates(T[] cordinates) {
		this.cordinates = cordinates;
	}
}

class CordinatesPrinter{
	
	/**
	 * ? for unknown type 
	 * @param cordinates
	 */
	public static void printXY(Cordinates<?> cordinates) {
		for (int i=0; i<cordinates.cordinates.length; i++) {
			System.out.printf("x: %d, y: %d\n", cordinates.cordinates[i].x, cordinates.cordinates[i].y);
		}
	}
	
	/**
	 * ? for unknown type & restricted to ThreeDim inclusive
	 * @param cordinates
	 */
	public static void printXYZ(Cordinates<? extends ThreeDim> cordinates) {
		for (int i=0; i<cordinates.cordinates.length; i++) {
			System.out.printf("x: %d, y: %d, z: %d\n", cordinates.cordinates[i].x, cordinates.cordinates[i].y, cordinates.cordinates[i].z);
		}
	}
	
	/**
	 * ? for unknown type & restricted to ThreeDim inclusive
	 * @param cordinates
	 */
	public static void printAll(Cordinates<? extends FourDim> cordinates) {
		for (int i=0; i<cordinates.cordinates.length; i++) {
			System.out.printf("x: %d, y: %d, z: %d, t: %d\n", cordinates.cordinates[i].x, cordinates.cordinates[i].y, cordinates.cordinates[i].z, cordinates.cordinates[i].t);
		}
	}
	
}

public class WildCardsApp {
	public static void main(String[] args) {
		TwoDim dim1 = new TwoDim(2, 3);
		TwoDim dim2 = new TwoDim(5, 3);
		TwoDim dim3 = new TwoDim(4, -9);
		TwoDim dim4 = new TwoDim(5, 8);
		
		ThreeDim dim_3_1 = new ThreeDim(4, 3, -2);
		ThreeDim dim_3_2 = new ThreeDim(6, -9, 8);
		ThreeDim dim_3_3 = new ThreeDim(-4, -9, 7);
		ThreeDim dim_3_4 = new ThreeDim(8, -3, -1);
		
		FourDim dim_4_1 = new FourDim(5, 7, 11, 10);
		FourDim dim_4_2 = new FourDim(-8, -7, 8, 0);
		FourDim dim_4_3 = new FourDim(-5, 1, 9, 40);
		FourDim dim_4_4 = new FourDim(-9, 7, -8, 50);
		
		Cordinates<TwoDim> cordinates = new Cordinates<>(new TwoDim[] {dim1, dim2, dim_3_1, dim_3_2, dim_4_1, dim_4_2, dim3, dim4});
		CordinatesPrinter.printXY(cordinates);
		
		Cordinates<ThreeDim> cordinates_3d = new Cordinates<>(new ThreeDim[] {dim_3_1, dim_3_2, dim_4_1, dim_4_2, dim_3_3, dim_3_4});
		CordinatesPrinter.printXYZ(cordinates_3d);
		
		Cordinates<FourDim> cordinates_4d = new Cordinates<>(new FourDim[] {dim_4_1, dim_4_3, dim_4_4});
		CordinatesPrinter.printAll(cordinates_4d);
	}
}
