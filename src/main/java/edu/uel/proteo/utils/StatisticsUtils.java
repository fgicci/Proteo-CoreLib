package edu.uel.proteo.utils;

public class StatisticsUtils {

	private static double distance(double a, double b) {
		return Math.pow((a - b), 2);
	}
	
	public static double euclidianDistance(double a, double b) {
		return Math.sqrt(distance(a, b));
	}
	
	public static double euclidianDistance(double[] a, double b[]) {
		int amount = 0;
		int size = a.length < b.length ? a.length : b.length;
		for (int index = 0; index < size; index++) {
			amount += distance(a[index], b[index]);
		}
		return Math.sqrt(amount);
	}
}
