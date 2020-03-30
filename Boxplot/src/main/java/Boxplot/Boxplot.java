package Boxplot;

import Boxplot.DTO.BoxplotDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Boxplot {

    private List<Double> dataPoints;
    private Double minimum;
    private Double firstQuartile;
    private Double median;
    private Double thirdQuartile;
    private Double maximum;

    private Integer medianIndex;
    private Boolean isMedianAnAverage;


    public Double getMinimum() {
        return minimum;
    }

    public Double getFirstQuartile() {
        return firstQuartile;
    }

    public Double getMedian() {
        return median;
    }

    public Double getThirdQuartile() {
        return thirdQuartile;
    }

    public Double getMaximum() {
        return maximum;
    }

    public void setDataPoints(List<Double> dataPoints) {
        this.dataPoints = dataPoints;
        resetFields();
        if (dataPoints.size() > 1) {
            runAlgorithm();
        }
        else {
            Double num = dataPoints.size() == 1 ? dataPoints.get(0) : 0D;
            this.minimum = num;
            this.firstQuartile = num;
            this.median = num;
            this.thirdQuartile = num;
            this.maximum = num;
        }
    }

    private void runAlgorithm() {
        sortDataPoints();
        this.median = findMedian(this.dataPoints);
        findFirstQuartile();
        findThirdQuartile();
        findMin();
        findMax();
    }

    private void resetFields() {
        this.minimum = null;
        this.firstQuartile = null;
        this.median = null;
        this.thirdQuartile = null;
        this.maximum = null;
        this.medianIndex = null;
        this.isMedianAnAverage = null;
    }

    public List<Double> getDataPoints() {
        return this.dataPoints;
    }

    private void sortDataPoints() {
        Collections.<Double>sort(dataPoints);
    }

    private Double findMedian(List<Double> dataPoints) {
        Double median;

        if (dataPoints.size() % 2 != 0) {
            int middleIndex = dataPoints.size() / 2;
            median = dataPoints.get(middleIndex);
            if (this.medianIndex == null) {
                this.medianIndex = middleIndex;
                this.isMedianAnAverage = false;
            }
        }
        else {
            int leftMiddleIndex = (dataPoints.size() / 2) -1;
            int rightMiddleIndex = leftMiddleIndex + 1;
            median = (dataPoints.get(leftMiddleIndex) + dataPoints.get(rightMiddleIndex)) / 2;
            if (this.medianIndex == null) {
                this.medianIndex = rightMiddleIndex;
                this.isMedianAnAverage = true;
            }
        }
        return median;
    }

    private void findFirstQuartile() {
        this.firstQuartile = findMedian(this.dataPoints.subList(0, this.medianIndex));
    }

    private void findThirdQuartile() {
        int medianIndex = (isMedianAnAverage ? 0 : 1) + this.medianIndex;
        this.thirdQuartile = findMedian(this.dataPoints.subList(medianIndex, this.dataPoints.size()));
    }

    private void findMin() {
        this.minimum = dataPoints.get(0);
    }

    private void findMax() {
        this.maximum = dataPoints.get(dataPoints.size() - 1);
    }
}
