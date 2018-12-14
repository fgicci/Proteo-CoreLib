package edu.uel.proteo.utils;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class StatisticsUtilsTest {

	@Test
	public void shouldTest_EuclidianDistance() {
		double expect = 10;
		assertEquals(expect, StatisticsUtils.euclidianDistance(10, 20), 0);
	}
	
	@Test
	public void shouldTest_EuclidianDistanceSameDimension() {
		int expect = 11;
		double[] a = { 5.0, 10.0 };
		double[] b = { 10.0, 20.0 };
		assertEquals(expect, (int) StatisticsUtils.euclidianDistance(a, b));
	}
	
	@Test
	public void shouldTest_EuclidianDistanceWithADimension() {
		int expect = 11;
		double[] a = { 5.0, 10.0 };
		double[] b = { 10.0, 20.0, 30.0 };
		assertEquals(expect, (int) StatisticsUtils.euclidianDistance(a, b));
	}
	
	@Test
	public void shouldTest_EuclidianDistanceWithBDimension() {
		int expect = 11;
		double[] a = { 5.0, 10.0, 20.0 };
		double[] b = { 10.0, 20.0 };
		assertEquals(expect, (int) StatisticsUtils.euclidianDistance(a, b));
	}
}
