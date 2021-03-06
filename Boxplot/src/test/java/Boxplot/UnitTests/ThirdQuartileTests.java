package Boxplot.UnitTests;

import Boxplot.Boxplot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ThirdQuartileTests {
    Boxplot boxplot = new Boxplot();

    @Test
    void Test_findThirdQuartile_empty() {
        // arrange
        List<Double> dataPoints = new ArrayList<>();
        Double expectedResult = 0D;

        // act
        boxplot.setDataPoints(dataPoints);
        Double actualResult = boxplot.getThirdQuartile();

        // assert
        assert actualResult.equals(expectedResult);
    }

    @Test
    void Test_findThirdQuartile_oneElement() {
        // arrange
        List<Double> dataPoints = new ArrayList<>();
        dataPoints.add(21D);
        Double expectedResult = 21D;

        // act
        boxplot.setDataPoints(dataPoints);
        Double actualResult = boxplot.getThirdQuartile();

        // assert
        assert actualResult.equals(expectedResult);
    }

    @Test
    void Test_findThirdQuartile_twoElements() {
        // arrange
        List<Double> dataPoints = new ArrayList<>();
        dataPoints.add(5D);
        dataPoints.add(8D);
        Double expectedResult = 8D;

        // act
        boxplot.setDataPoints(dataPoints);
        Double actualResult = boxplot.getThirdQuartile();

        // assert
        assert actualResult.equals(expectedResult);
    }

    @Test
    void Test_findThirdQuartile_threeElements() {
        // arrange
        List<Double> dataPoints = new ArrayList<>();
        dataPoints.add(5D);
        dataPoints.add(8D);
        dataPoints.add(3.14159);
        Double expectedResult = 8D;

        // act
        boxplot.setDataPoints(dataPoints);
        Double actualResult = boxplot.getThirdQuartile();

        // assert
        assert actualResult.equals(expectedResult);
    }

    @Test
    void Test_findThirdQuartile_multiElementsEven() {
        // arrange
        List<Double> dataPoints = new ArrayList<>();
        dataPoints = Arrays.asList(25D, 38D, 28D, 37D, 29D, 35D, 29D, 35D, 30D, 34D);
        Double expectedResult = 35D;

        // act
        boxplot.setDataPoints(dataPoints);
        Double actualResult = boxplot.getThirdQuartile();

        // assert
        assert actualResult.equals(expectedResult);
    }

    @Test
    void Test_findFirstQuartile_multiElementsOdd() {
        // arrange
        List<Double> dataPoints = new ArrayList<>();
        dataPoints = Arrays.asList(10D, 20D, 30D, 40D, 50D, 60D, 70D, 80D, 90D, 100D, 110D, 120D, 130D);
        Double expectedResult = 105D;

        // act
        boxplot.setDataPoints(dataPoints);
        Double actualResult = boxplot.getThirdQuartile();

        // assert
        assert actualResult.equals(expectedResult);
    }
}
