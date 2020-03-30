package Boxplot.IntegrationTests;

import Boxplot.DTO.BoxplotDTO;
import Boxplot.Services.BoxplotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class IntegrationTests {
    @Autowired
    private BoxplotService boxplotService;

    @Test
    void Test_emptyList() {
        // arrange
        List<Double> dataPoints = new ArrayList<>();
        String expectedResult = "0.0";

        // act
        boxplotService.runBoxplotService(dataPoints);

        // assert
        assert boxplotService.getBoxplotDTO().getMedian().equals(expectedResult);
        assert boxplotService.getBoxplotDTO().getFirstQuartile().equals(expectedResult);
        assert boxplotService.getBoxplotDTO().getThirdQuartile().equals(expectedResult);
        assert boxplotService.getBoxplotDTO().getMinimum().equals(expectedResult);
        assert boxplotService.getBoxplotDTO().getMaximum().equals(expectedResult);
    }

    @Test
    void Test_listSizeOne() {
        // arrange
        List<Double> dataPoints = new ArrayList<>();
        dataPoints.add(52.37);
        String expectedResult = "52.37";

        // act
        boxplotService.runBoxplotService(dataPoints);

        // assert
        assert boxplotService.getBoxplotDTO().getMedian().equals(expectedResult);
        assert boxplotService.getBoxplotDTO().getFirstQuartile().equals(expectedResult);
        assert boxplotService.getBoxplotDTO().getThirdQuartile().equals(expectedResult);
        assert boxplotService.getBoxplotDTO().getMinimum().equals(expectedResult);
        assert boxplotService.getBoxplotDTO().getMaximum().equals(expectedResult);
    }

    @Test
    void Test_listSizeTwo() {
        // arrange
        List<Double> dataPoints = new ArrayList<>();
        dataPoints.add(18D);
        dataPoints.add(12D);

        String expectedMinimum = "12.0";
        String expectedFirstQuartile = "12.0";
        String expectedMedian = "15.0";
        String expectedThirdQuartile = "18.0";
        String expectedMaximum = "18.0";

        // act
        boxplotService.runBoxplotService(dataPoints);

        // assert
        assert boxplotService.getBoxplotDTO().getMedian().equals(expectedMedian);
        assert boxplotService.getBoxplotDTO().getFirstQuartile().equals(expectedFirstQuartile);
        assert boxplotService.getBoxplotDTO().getThirdQuartile().equals(expectedThirdQuartile);
        assert boxplotService.getBoxplotDTO().getMinimum().equals(expectedMinimum);
        assert boxplotService.getBoxplotDTO().getMaximum().equals(expectedMaximum);
    }

    @Test
    void Test_listSizeThree() {
        // arrange
        List<Double> dataPoints = new ArrayList<>();
        dataPoints.add(18D);
        dataPoints.add(12D);
        dataPoints.add(1D);

        String expectedMinimum = "1.0";
        String expectedFirstQuartile = "1.0";
        String expectedMedian = "12.0";
        String expectedThirdQuartile = "18.0";
        String expectedMaximum = "18.0";

        // act
        boxplotService.runBoxplotService(dataPoints);

        // assert
        assert boxplotService.getBoxplotDTO().getMedian().equals(expectedMedian);
        assert boxplotService.getBoxplotDTO().getFirstQuartile().equals(expectedFirstQuartile);
        assert boxplotService.getBoxplotDTO().getThirdQuartile().equals(expectedThirdQuartile);
        assert boxplotService.getBoxplotDTO().getMinimum().equals(expectedMinimum);
        assert boxplotService.getBoxplotDTO().getMaximum().equals(expectedMaximum);
    }

    @Test
    void Test_listSizeTen() {
        // arrange
        List<Double> dataPoints = Arrays.asList(25D, 37D, 29D, 29D, 34D, 30D, 35D, 35D, 28D, 38D);

        String expectedMinimum = "25.0";
        String expectedFirstQuartile = "29.0";
        String expectedMedian = "32.0";
        String expectedThirdQuartile = "35.0";
        String expectedMaximum = "38.0";

        // act
        boxplotService.runBoxplotService(dataPoints);

        // assert
        assert boxplotService.getBoxplotDTO().getMedian().equals(expectedMedian);
        assert boxplotService.getBoxplotDTO().getFirstQuartile().equals(expectedFirstQuartile);
        assert boxplotService.getBoxplotDTO().getThirdQuartile().equals(expectedThirdQuartile);
        assert boxplotService.getBoxplotDTO().getMinimum().equals(expectedMinimum);
        assert boxplotService.getBoxplotDTO().getMaximum().equals(expectedMaximum);
    }

    @Test
    void Test_listSizeEleven() {
        // arrange
        List<Double> dataPoints = Arrays.asList(25D, 37D, 29D, 29D, 34D, 30D, 35D, 35D, 28D, 38D, 27D);

        String expectedMinimum = "25.0";
        String expectedFirstQuartile = "28.0";
        String expectedMedian = "30.0";
        String expectedThirdQuartile = "35.0";
        String expectedMaximum = "38.0";

        // act
        boxplotService.runBoxplotService(dataPoints);

        // assert
        assert boxplotService.getBoxplotDTO().getMedian().equals(expectedMedian);
        assert boxplotService.getBoxplotDTO().getFirstQuartile().equals(expectedFirstQuartile);
        assert boxplotService.getBoxplotDTO().getThirdQuartile().equals(expectedThirdQuartile);
        assert boxplotService.getBoxplotDTO().getMinimum().equals(expectedMinimum);
        assert boxplotService.getBoxplotDTO().getMaximum().equals(expectedMaximum);
    }

    @Test
    void Test_generateRandomDataPoints() {
        // arrange
        int numOfDataSets = 1;
        int numOfRandDataPoints = 10;

        // act
        List<BoxplotDTO> boxplotDTOList = boxplotService.getListOfBoxplotDTOs(numOfDataSets, numOfRandDataPoints);

        // assert
        assert boxplotDTOList.size()  == numOfDataSets;
    }

    @Test
    void Test_getListOfBoxplotDTOs() {
        // arrange
        int numOfDataSets = 10;
        int numOfRandDataPoints = 15;

        // act
        List<BoxplotDTO> boxplotDTOList = boxplotService.getListOfBoxplotDTOs(numOfDataSets, numOfRandDataPoints);

        // assert
        assert boxplotDTOList.size()  == numOfDataSets;
    }
}
