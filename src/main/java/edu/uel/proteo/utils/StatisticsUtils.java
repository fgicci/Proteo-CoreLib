 package edu.uel.proteo.utils;

public class StatisticsUtils {

	public static double mean(Double[] values) {
		double totalAmount = 0;
		if (values == null || values.length == 0) return totalAmount;
		int numOfElements = values.length;
		for (int i = 0; i < numOfElements; i++) {
			totalAmount += values[i];
		}
		return totalAmount / numOfElements;
	}
	
	/**
	 * Returns the distance between two values.
	 * 
	 * @param a protocol optimum value.
	 * @param b athlete activity value logged.
	 * @return power of the difference between a and b, if the b is greater then a it will be
	 * considered the minimum distance of zero.
	 */
	private static double distance(double a, double b) {
		return Math.pow (b > a ? 0 : (a - b), 2);
	}
	
	public static double euclidianDistance(Double a, Double b) {
		return Math.sqrt(distance(a, b));
	}
	
	public static double euclidianDistance(Double[] a, Double b[]) {
		double amount = 0;
		int size = a.length < b.length ? a.length : b.length;
		for (int index = 0; index < size; index++) {
			amount += distance(a[index], b[index]);
		}
		return Math.sqrt(amount);
	}
}
