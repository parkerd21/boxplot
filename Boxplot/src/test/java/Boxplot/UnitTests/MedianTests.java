package Boxplot.UnitTests;

import Boxplot.Boxplot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MedianTests {
	Boxplot boxplot = new Boxplot();

	@Test
	void Test_findMedian_empty() {
		// arrange
		List<Double> dataPoints = new ArrayList<>();
		Double expectedResult = 0D;

		// act
		boxplot.setDataPoints(dataPoints);
		Double actualResult = boxplot.getMedian();

		// assert
		assert actualResult.equals(expectedResult);
	}

	@Test
	void Test_findMedian_oneElement() {
		// arrange
		List<Double> dataPoints = new ArrayList<>();
		dataPoints.add(5D);
		Double expectedResult = 5D;

		// act
		boxplot.setDataPoints(dataPoints);
		Double actualResult = boxplot.getMedian();

		// assert
		assert actualResult.equals(expectedResult);
	}

	@Test
	void Test_findMedian_twoElements() {
		// arrange
		List<Double> dataPoints = new ArrayList<>();
		dataPoints.add(5D);
		dataPoints.add(8D);
		Double expectedResult = 6.5;

		// act
		boxplot.setDataPoints(dataPoints);
		Double actualResult = boxplot.getMedian();

		// assert
		assert actualResult.equals(expectedResult);
	}

	@Test
	void Test_findMedian_threeElements() {
		// arrange
		List<Double> dataPoints = new ArrayList<>();
		dataPoints.add(5D);
		dataPoints.add(8D);
		dataPoints.add(3.14159);
		Double expectedResult = 5D;

		// act
		boxplot.setDataPoints(dataPoints);
		Double actualResult = boxplot.getMedian();

		// assert
		assert actualResult.equals(expectedResult);
	}

	@Test
	void Test_findMedian_multiElementsEven() {
		// arrange
		List<Double> dataPoints = new ArrayList<>();
		dataPoints = Arrays.asList(25D, 38D, 28D, 37D, 29D, 35D, 29D, 35D, 30D, 34D);
		Double expectedResult = 32D;
		// first quartile 29
		// third quartile 36

		// act
		boxplot.setDataPoints(dataPoints);
		Double actualResult = boxplot.getMedian();

		// assert
		assert actualResult.equals(expectedResult);
	}

	@Test
	void Test_findMedian_multiElementsOdd() {
		// arrange
		List<Double> dataPoints = new ArrayList<>();
		dataPoints = Arrays.asList(10D, 20D, 30D, 40D, 50D, 60D, 70D, 80D, 90D, 100D, 110D, 120D, 130D);
		Double expectedResult = 70D;

		// act
		boxplot.setDataPoints(dataPoints);
		Double actualResult = boxplot.getMedian();

		// assert
		assert actualResult.equals(expectedResult);
	}

	@Test
	void Test_findMedian_sameMultiElements() {
		// arrange
		List<Double> dataPoints = new ArrayList<>();
		dataPoints = Arrays.asList(0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D);
		Double expectedResult = 0D;

		// act
		boxplot.setDataPoints(dataPoints);
		Double actualResult = boxplot.getMedian();

		// assert
		assert actualResult.equals(expectedResult);
	}

	@Test
	void Test_findMedian_multiElementsDecimals() {
		// arrange
		List<Double> dataPoints = new ArrayList<>();
		dataPoints = Arrays.asList(1D, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9);
		Double expectedResult = 1.45;

		// act
		boxplot.setDataPoints(dataPoints);
		Double actualResult = boxplot.getMedian();

		// assert
		assert actualResult.equals(expectedResult);
	}
}
