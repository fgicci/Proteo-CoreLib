package edu.uel.proteo.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StatisticsUtilsTest {

	public void shouldTest_MeanWithNullData() {
		double expectedValue = 0;
		assertEquals(expectedValue, StatisticsUtils.mean(null), 0);
	}
	
	@Test
	public void shouldTest_MeanWithEmptyData() {
		double expectedValue = 0;
		Double[] values = {};
		assertEquals(expectedValue, StatisticsUtils.mean(values), 0);
	}
	
	@Test
	public void shouldTest_MeanWithData() {
		double expectedValue = 7.625;
		Double[] values = {7.5, 8.0, 6.0, 9.0};
		assertEquals(expectedValue, StatisticsUtils.mean(values), 0);
	}
	
	@Test
	public void shouldTest_EuclidianDistance() {
		Double expect = 10.0;
		assertEquals(expect, StatisticsUtils.euclidianDistance(10.0, 20.0), 0);
	}
	
	@Test
	public void shouldTest_EuclidianDistanceSameDimension() {
		int expect = 11;
		Double[] a = { 5.0, 10.0 };
		Double[] b = { 10.0, 20.0 };
		assertEquals(expect, (int) StatisticsUtils.euclidianDistance(a, b));
	}
	
	@Test
	public void shouldTest_EuclidianDistanceWithADimension() {
		int expect = 11;
		Double[] a = { 5.0, 10.0 };
		Double[] b = { 10.0, 20.0, 30.0 };
		assertEquals(expect, (int) StatisticsUtils.euclidianDistance(a, b));
	}
	
	@Test
	public void shouldTest_EuclidianDistanceWithBDimension() {
		int expect = 11;
		Double[] a = { 5.0, 10.0, 20.0 };
		Double[] b = { 10.0, 20.0 };
		assertEquals(expect, (int) StatisticsUtils.euclidianDistance(a, b));
	}
	
	@Test
	public void shouldTest_EuclidianDistanceWithDifferentRange() {
		Double[] optimum = { 3.0, 4.0, 90.0, 90.0, 2.0};
		Double[] a = { 4.0, 4.0, 92.0, 85.0, 3.0};
		Double[] b = { 2.0, 3.0, 72.0, 51.0, 2.0};
		Double[] c = { 3.0, 4.0, 90.0, 90.0, 3.0};
		assertEquals(5, (int) StatisticsUtils.euclidianDistance(optimum, a));
		assertEquals(42, (int) StatisticsUtils.euclidianDistance(optimum, b));
		assertEquals(1, (int) StatisticsUtils.euclidianDistance(optimum, c));
	}
	
}
