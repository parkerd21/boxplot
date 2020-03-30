package Boxplot.UnitTests;

import Boxplot.Boxplot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SortTests {

	@Autowired
    Boxplot boxplot;

	@Test
	void Test_sortDataPoints_empty() {
		// arrange
		List<Double> dataPoints = new ArrayList<>();

		// act
		boxplot.setDataPoints(dataPoints);
		List<Double> actualList = boxplot.getDataPoints();

		// assert
		assert actualList.equals(dataPoints);
	}

	@Test
	void Test_sortDataPoints_oneElement() {
		// arrange
		List<Double> dataPoints = new ArrayList<>();
		dataPoints.add(5D);

		// act
		boxplot.setDataPoints(dataPoints);
		List<Double> actualList = boxplot.getDataPoints();

		// assert
		assert actualList.equals(dataPoints);
	}

	@Test
	void Test_sortDataPoints_multiElement() {
		// arrange
		List<Double> dataPoints = new ArrayList<Double>(List.of(14D, 1D, 20D, 35D, 18D, 3D, 29D, 6D, 8D, 7D));
		List<Double> expectedList = new ArrayList<Double>(List.of(1D, 3D, 6D, 7D, 8D, 14D, 18D, 20D, 29D, 35D));


		// act
		boxplot.setDataPoints(dataPoints);
		List<Double> actualList = boxplot.getDataPoints();

		// assert
		assert actualList.equals(expectedList);
	}
}
